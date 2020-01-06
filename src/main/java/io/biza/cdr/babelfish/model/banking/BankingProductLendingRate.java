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
package io.biza.cdr.babelfish.model.banking;

import java.math.BigDecimal;
import java.net.URI;
import java.time.Period;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.biza.cdr.babelfish.support.BabelFishModelProperty;
import io.biza.cdr.babelfish.v1.enumerations.BankingProductLendingRateType;
import io.biza.cdr.babelfish.converters.BigDecimalToRateStringConverter;
import io.biza.cdr.babelfish.converters.PeriodToStringConverter;
import io.biza.cdr.babelfish.converters.RateStringToBigDecimalConverter;
import io.biza.cdr.babelfish.converters.StringToPeriodConverter;
import io.biza.cdr.babelfish.converters.UriToUriStringConverter;
import io.biza.cdr.babelfish.support.BabelFishModel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Valid
@BabelFishModel(description = "Banking Product Lending Rate Definition")
public abstract class BankingProductLendingRate<T> {
  @BabelFishModelProperty(
      description = "The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning",
      required = true)
  @NonNull
  @NotNull
  BankingProductLendingRateType lendingRateType;

  public BankingProductLendingRateType lendingRateType() {
    return getLendingRateType();
  }

  @SuppressWarnings("unchecked")
  public T lendingRateType(BankingProductLendingRateType lendingRateType) {
    setLendingRateType(lendingRateType);
    return (T) this;
  }

  @BabelFishModelProperty(description = "The rate to be applied", required = true)
  @NonNull
  @NotNull
  @JsonSerialize(converter = BigDecimalToRateStringConverter.class)
  @JsonDeserialize(converter = RateStringToBigDecimalConverter.class)
  BigDecimal rate;

  public BigDecimal rate() {
    return getRate();
  }

  @SuppressWarnings("unchecked")
  public T rate(BigDecimal rate) {
    setRate(rate);
    return (T) this;
  }

  @BabelFishModelProperty(description = "A comparison rate equivalent for this rate")
  @JsonSerialize(converter = BigDecimalToRateStringConverter.class)
  @JsonDeserialize(converter = RateStringToBigDecimalConverter.class)
  BigDecimal comparisonRate;

  public BigDecimal comparisonRate() {
    return getComparisonRate();
  }

  @SuppressWarnings("unchecked")
  public T comparisonRate(BigDecimal comparisonRate) {
    setComparisonRate(comparisonRate);
    return (T) this;
  }

  @BabelFishModelProperty(
      description = "The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)",
      dataType = "java.lang.String")
  @JsonSerialize(converter = PeriodToStringConverter.class)
  @JsonDeserialize(converter = StringToPeriodConverter.class)
  Period calculationFrequency;

  public Period calculationFrequency() {
    return getCalculationFrequency();
  }

  @SuppressWarnings("unchecked")
  public T calculationFrequency(Period calculationFrequency) {
    setCalculationFrequency(calculationFrequency);
    return (T) this;
  }

  @BabelFishModelProperty(
      description = "The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)",
      dataType = "java.lang.String")
  @JsonSerialize(converter = PeriodToStringConverter.class)
  @JsonDeserialize(converter = StringToPeriodConverter.class)
  Period applicationFrequency;

  public Period applicationFrequency() {
    return getApplicationFrequency();
  }

  @SuppressWarnings("unchecked")
  public T applicationFrequency(Period applicationFrequency) {
    setApplicationFrequency(applicationFrequency);
    return (T) this;
  }

  @BabelFishModelProperty(
      description = "When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered")
  BankingProductLendingRateType interestPaymentDue;

  public BankingProductLendingRateType interestPaymentDue() {
    return getInterestPaymentDue();
  }

  @SuppressWarnings("unchecked")
  public T interestPaymentDue(BankingProductLendingRateType interestPaymentDue) {
    setInterestPaymentDue(interestPaymentDue);
    return (T) this;
  }

  @BabelFishModelProperty(description = "Rate tiers applicable for this rate")
  List<BankingProductRateTier<?>> tiers;

  @BabelFishModelProperty(
      description = "Generic field containing additional information relevant to the [lendingRateType](#tocSproductlendingratetypedoc) specified. Whether mandatory or not is dependent on the value of [lendingRateType](#tocSproductlendingratetypedoc)")
  String additionalValue;

  public String additionalValue() {
    return getAdditionalValue();
  }

  @SuppressWarnings("unchecked")
  public T additionalValue(String additionalValue) {
    setAdditionalValue(additionalValue);
    return (T) this;
  }

  @BabelFishModelProperty(description = "Display text providing more information on the rate.")
  String additionalInfo;

  public String additionalInfo() {
    return getAdditionalInfo();
  }

  @SuppressWarnings("unchecked")
  public T additionalInfo(String additionalInfo) {
    setAdditionalInfo(additionalInfo);
    return (T) this;
  }

  @BabelFishModelProperty(description = "Link to a web page with more information on this rate",
      dataType = "java.lang.String")
  @JsonSerialize(converter = UriToUriStringConverter.class)
  URI additionalInfoUri;

  public URI additionalInfoUri() {
    return getAdditionalInfoUri();
  }

  @SuppressWarnings("unchecked")
  public T additionalInfoUri(URI additionalInfoUri) {
    setAdditionalInfoUri(additionalInfoUri);
    return (T) this;
  }
}
