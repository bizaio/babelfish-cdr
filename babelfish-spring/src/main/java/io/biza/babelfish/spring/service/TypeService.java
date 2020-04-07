/*******************************************************************************
 * Copyright (C) 2020 Biza Pty Ltd
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *******************************************************************************/
package io.biza.babelfish.spring.service;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.biza.babelfish.cdr.orika.OrikaFactoryConfig;
import io.biza.babelfish.cdr.orika.OrikaFactoryConfigurer;
import io.biza.babelfish.cdr.support.LabelValueEnumInterface;
import io.biza.babelfish.spring.interfaces.LabelValueDerivedInterface;
import io.biza.babelfish.spring.payloads.BabelFieldLabelValue;
import io.biza.babelfish.spring.payloads.ResponseGetTypes;
import io.biza.babelfish.spring.util.LabelValueOpenApiUtil;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TypeService implements ApplicationContextAware {

  @Value("${babelfish.typeManager.packageBase:io.biza.babelfish.cdr.enumerations}")
  List<String> packageBase;

  private Map<String, Class<?>> classMap;

  @SuppressWarnings("unused")
  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
    init();
  }

  public void init() {
    classMap = new HashMap<String, Class<?>>();

    if (packageBase != null) {
      try (ScanResult mapperResult = new ClassGraph().enableAllInfo()
          .whitelistPackages(packageBase.toArray(new String[0])).scan()) {

        ClassInfoList configurerClasses = mapperResult.getAllClasses();

        for (Class<?> clazz : configurerClasses.loadClasses()) {
          classMap.put(clazz.getSimpleName(), clazz);
          LOG.debug("Registered Type Lookup for for {}", clazz.getSimpleName());
        }
      }
    }
  }

  public Map<String, List<BabelFieldLabelValue>> getEnumerationTypes(List<String> labelTypes) {
    Map<String, List<BabelFieldLabelValue>> formLabels = new HashMap<String, List<BabelFieldLabelValue>>();

    labelTypes.forEach(oneFieldType -> {
      if (classMap.containsKey(oneFieldType)) {
        Class<?> targetClass = classMap.get(oneFieldType);
        List<BabelFieldLabelValue> fieldValue = new ArrayList<BabelFieldLabelValue>();

        LOG.debug(
            "{} -> isEnum: {} LabelValueEnumInterface: {} LabelValueDerivedInterface: {} ApiModel: {}",
            targetClass, targetClass.isEnum(),
            LabelValueEnumInterface.class.isAssignableFrom(targetClass),
            LabelValueDerivedInterface.class.isAssignableFrom(targetClass),
            targetClass.isAnnotationPresent(Schema.class));
        if (targetClass.isEnum() && LabelValueEnumInterface.class.isAssignableFrom(targetClass)) {
          for (Object b : targetClass.getEnumConstants()) {
            LabelValueEnumInterface value = (LabelValueEnumInterface) b;
            fieldValue
                .add(BabelFieldLabelValue.builder().label(value.label()).value(value.toString()).build());
          }

          formLabels.put(oneFieldType, fieldValue);
        } else if (LabelValueDerivedInterface.class.isAssignableFrom(targetClass)) {
          try {
            LabelValueDerivedInterface value = LabelValueDerivedInterface.class
                .cast(targetClass.getDeclaredConstructor().newInstance());
            formLabels.put(oneFieldType, value.getFormLabels());
          } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
              | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            LOG.error(
                "Encountered an error when attempting to cast {} to a LabelValueDerivedInterface class with error: {}",
                targetClass.getSimpleName(), e.getMessage());
          }
        } else if (targetClass.isEnum()) {
          for (Object b : targetClass.getEnumConstants()) {
            fieldValue
                .add(BabelFieldLabelValue.builder().label(b.toString()).value(b.toString()).build());
          }
          formLabels.put(oneFieldType, fieldValue);
        } else if (targetClass.isAnnotationPresent(Schema.class)) {
          formLabels.put(oneFieldType, LabelValueOpenApiUtil.getFormLabels(targetClass));
        } else {
          LOG.error(
              "Unable to create type fields response, found object but unable to determine how to interogate it");
        }
      }
    });

    return formLabels;


  }
}
