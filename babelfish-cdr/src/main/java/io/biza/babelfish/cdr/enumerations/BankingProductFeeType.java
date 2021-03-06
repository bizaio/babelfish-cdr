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

@Schema(description = "Banking Product Fee Type", enumAsRef = true)
public enum BankingProductFeeType implements LabelValueEnumInterface {
  // @formatter:off
  PERIODIC("PERIODIC", "A periodic fee such as a monthly account servicing fee"),
  TRANSACTION("TRANSACTION", "A fee associated with any transaction"),
  WITHDRAWAL("WITHDRAWAL", "A fee associated with making a withdrawal"),
  DEPOSIT("DEPOSIT", "A fee associated with making a deposit"),
  PAYMENT("PAYMENT", "A fee associated with making a payment"),
  PURCHASE("PURCHASE", "A fee associated with making a purchase at a merchant"),
  EVENT("EVENT", "A fee in relation to a particular event, for example ordering a new card, viewing a balance or stopping a cheque"),
  UPFRONT("UPFRONT", "A fee paid at the beginning of the product lifecycle, for example an establishment fee, loyalty program fee or application fee"),
  EXIT("EXIT", "A fee for closing the product");
  // @formatter:on
  private String value;

  private String label;

  BankingProductFeeType(String value, String label) {
    this.value = value;
    this.label = label;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BankingProductFeeType fromValue(String text)
      throws LabelValueEnumValueNotSupportedException {
    for (BankingProductFeeType b : BankingProductFeeType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new LabelValueEnumValueNotSupportedException(
        "Unable to identify value of BankingProductFeeType from " + text,
        BankingProductFeeType.class.getSimpleName(), BankingProductFeeType.values(), text);
  }

  @Override
  @JsonIgnore
  public String label() {
    return label;
  }
}
