/*******************************************************************************
 * Copyright (C) 2020 Biza Pty Ltd
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *******************************************************************************/
package io.biza.babelfish.cdr.tests.v1.model.response;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.biza.babelfish.cdr.models.responses.container.ResponseCommonDiscoveryOutagesListDataV1;
import io.biza.babelfish.cdr.tests.v1.model.ModelConstants;

@DisplayName("ResponseDiscoveryOutagesListData V1 Tests")
public class ResponseDiscoveryOutagesListDataV1Test {
  private Validator validator;

  @BeforeEach
  public void setup() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  @DisplayName("Create valid ResponseDiscoveryOutagesListData")
  void responseDiscoveryOutagesListData() {
    ResponseCommonDiscoveryOutagesListDataV1 data =
        ModelConstants.DEFAULT_RESPONSE_COMMON_DISCOVERY_OUTAGES_LIST_DATA.build();
    assertTrue(validator.validate(data).isEmpty(), validator.validate(data).toString());
  }

  @Test
  @DisplayName("ResponseDiscoveryOutagesListData Mandatory Fields")
  void responseDiscoveryOutagesListDataMandatoryFields() {

    ResponseCommonDiscoveryOutagesListDataV1 data = new ResponseCommonDiscoveryOutagesListDataV1();
    assertFalse(validator.validate(data).isEmpty(), validator.validate(data).toString());

    data.outages(List.of(ModelConstants.DEFAULT_COMMON_DISCOVERY_OUTAGE.build()));
    assertTrue(validator.validate(data).isEmpty(), validator.validate(data).toString());


  }

}
