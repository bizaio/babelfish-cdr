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

@Schema(description = "Banking Payee Type with All", enumAsRef = true)
public enum BankingPayeeTypeWithAll implements LabelValueEnumInterface {
  // @formatter:off
  ALL("ALL", "All Payee Types"),
  DOMESTIC("DOMESTIC", "Domestic Payee Type"),
  INTERNATIONAL("INTERNATIONAL", "International Payee Type"),
  BILLER("BILLER", "BPay Biller Type");
  // @formatter:on
  private String value;

  private String label;

  BankingPayeeTypeWithAll(String value, String label) {
    this.value = value;
    this.label = label;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BankingPayeeTypeWithAll fromValue(String text)
      throws LabelValueEnumValueNotSupportedException {
    for (BankingPayeeTypeWithAll b : BankingPayeeTypeWithAll.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new LabelValueEnumValueNotSupportedException(
        "Unable to identify value of BankingPayeeTypeWithAll from " + text,
        BankingPayeeTypeWithAll.class.getSimpleName(), BankingPayeeTypeWithAll.values(), text);
  }

  @Override
  @JsonIgnore
  public String label() {
    return label;
  }
}
