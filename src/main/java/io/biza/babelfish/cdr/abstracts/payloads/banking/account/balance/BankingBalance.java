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
package io.biza.babelfish.cdr.abstracts.payloads.banking.account.balance;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.biza.babelfish.cdr.converters.AmountStringToBigDecimalConverter;
import io.biza.babelfish.cdr.converters.BigDecimalToAmountStringConverter;
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

@Schema(description = "A Representation of a Banking Account Balance")
public abstract class BankingBalance<T> {
  @Schema(description = "A unique ID of the account adhering to the standards for ID permanence",
      required = true)
  @NotNull
  @JsonProperty("accountId")
  String accountId;

  public String accountId() {
    return getAccountId();
  }

  @SuppressWarnings("unchecked")
  public T accountId(String accountId) {
    setAccountId(accountId);
    return (T) this;
  }

  @Schema(
      description = "The balance of the account at this time. Should align to the balance available via other channels such as Internet Banking. Assumed to be negative if the customer has money owing",
      required = true, type = "string")
  @NotNull
  @JsonSerialize(converter = BigDecimalToAmountStringConverter.class)
  @JsonProperty("currentBalance")
  BigDecimal currentBalance;

  public BigDecimal currentBalance() {
    return getCurrentBalance();
  }

  @SuppressWarnings("unchecked")
  public T currentBalance(BigDecimal currentBalance) {
    setCurrentBalance(currentBalance);
    return (T) this;
  }

  @Schema(
      description = "Balance representing the amount of funds available for transfer. Assumed to be zero or positive",
      required = true, type = "string")
  @NotNull
  @JsonSerialize(converter = BigDecimalToAmountStringConverter.class)
  @JsonDeserialize(converter = AmountStringToBigDecimalConverter.class)
  @JsonProperty("availableBalance")
  BigDecimal availableBalance;

  public BigDecimal availableBalance() {
    return getAvailableBalance();
  }

  @SuppressWarnings("unchecked")
  public T availableBalance(BigDecimal availableBalance) {
    setAvailableBalance(availableBalance);
    return (T) this;
  }

  @Schema(
      description = "Object representing the maximum amount of credit that is available for this account. Assumed to be zero if absent",
      type = "string")
  @JsonSerialize(converter = BigDecimalToAmountStringConverter.class)
  @JsonDeserialize(converter = AmountStringToBigDecimalConverter.class)
  @JsonProperty("creditLimit")
  BigDecimal creditLimit;

  public BigDecimal creditLimit() {
    return getCreditLimit();
  }

  @SuppressWarnings("unchecked")
  public T creditLimit(BigDecimal creditLimit) {
    setCreditLimit(creditLimit);
    return (T) this;
  }

  @Schema(
      description = "Object representing the available limit amortised according to payment schedule. Assumed to be zero if absent",
      type = "string")
  @JsonSerialize(converter = BigDecimalToAmountStringConverter.class)
  @JsonDeserialize(converter = AmountStringToBigDecimalConverter.class)
  @JsonProperty("amortisedLimit")
  BigDecimal amortisedLimit = BigDecimal.ZERO;

  public BigDecimal amortisedLimit() {
    return getAmortisedLimit();
  }

  @SuppressWarnings("unchecked")
  public T amortisedLimit(BigDecimal amortisedLimit) {
    setAmortisedLimit(amortisedLimit);
    return (T) this;
  }

  @Schema(description = "The currency for the balance amounts. If absent assumed to be AUD",
      type = "string")
  @JsonSerialize(converter = BigDecimalToAmountStringConverter.class)
  @JsonDeserialize(converter = AmountStringToBigDecimalConverter.class)
  @JsonProperty("currency")
  Currency currency;

  public Currency currency() {
    return getCurrency();
  }

  @SuppressWarnings("unchecked")
  public T currency(Currency currency) {
    setCurrency(currency);
    return (T) this;
  }

  @Schema(
      description = "Optional array of balances for the account in other currencies. Included to support accounts that support multi-currency purses such as Travel Cards")
  @JsonProperty("purses")
  @Valid
  List<BankingBalancePurse<?>> purses;
}