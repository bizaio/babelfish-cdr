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
package io.biza.babelfish.cdr.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.biza.babelfish.common.exceptions.LabelValueEnumValueNotSupportedException;
import io.biza.babelfish.common.interfaces.LabelValueEnumInterface;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Purpose for the Address", name = "PhysicalAddressPurpose", enumAsRef = true)
public enum AddressPurpose implements LabelValueEnumInterface {
  // @formatter:off
  REGISTERED("REGISTERED", "Registered Mail Address"),
  MAIL("MAIL", "Mailing Address"),
  PHYSICAL("PHYSICAL", "Physical Address"),
  WORK("WORK", "Work Address"),
  OTHER("OTHER", "Other Physical Address");
  // @formatter:on
  private String value;

  private String label;

  AddressPurpose(String value, String label) {
    this.value = value;
    this.label = label;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AddressPurpose fromValue(String text)
      throws LabelValueEnumValueNotSupportedException {
    for (AddressPurpose b : AddressPurpose.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new LabelValueEnumValueNotSupportedException(
        "Unable to identify value of AddressPurpose from " + text,
        AddressPurpose.class.getSimpleName(), AddressPurpose.values(), text);
  }

  @Override
  @JsonIgnore
  public String label() {
    return label;
  }
}
