/*******************************************************************************
 * Copyright (C) 2020 Biza Pty Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *******************************************************************************/
package io.biza.babelfish.cdr.model.common;

import java.math.BigDecimal;
import java.util.Currency;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.biza.babelfish.cdr.converters.AmountStringToBigDecimalConverter;
import io.biza.babelfish.cdr.converters.BigDecimalToAmountStringConverter;
import io.biza.babelfish.cdr.converters.CurrencyToStringConverter;
import io.biza.babelfish.cdr.converters.StringToCurrencyConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Valid
@ToString
@EqualsAndHashCode

@Schema(description = "Currency Amount")
public abstract class CommonCurrencyAmount<T> {
  @Schema(
      description = "The current balance of the account at this time. Should align to the current balance available via other channels such as ATM balance enquiry or Internet Banking",
      required = true, type = "string")
  @JsonSerialize(converter = BigDecimalToAmountStringConverter.class)
  @JsonDeserialize(converter = AmountStringToBigDecimalConverter.class)
  @JsonProperty("amount")
  public BigDecimal amount;

  public BigDecimal amount() {
    return getAmount();
  }

  @SuppressWarnings("unchecked")
  public T amount(BigDecimal amount) {
    setAmount(amount);
    return (T) this;
  }

  @Schema(description = "Currency Amount Currency Code", required = false,
      type = "string")
  @JsonSerialize(converter = CurrencyToStringConverter.class)
  @JsonDeserialize(converter = StringToCurrencyConverter.class)
  @JsonProperty("currency")
  public Currency currency;

  public Currency currency() {
    return getCurrency();
  }

  @SuppressWarnings("unchecked")
  public T currency(Currency currency) {
    setCurrency(currency);
    return (T) this;
  }
}
