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
package io.biza.babelfish.cdr.abstracts.payloads.banking.account.transaction;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@Schema(description = "Banking Transaction Detail X2P101 Payload")
public abstract class BankingTransactionDetailExtendedDataX2p101Payload<T> {
  @Schema(
      description = "An extended string description. Only present if specified by the extensionUType field",
      required = true)
  @NotNull
  @JsonProperty("extendedDescription")
  String extendedDescription;

  public String extendedDescription() {
    return getExtendedDescription();
  }

  @SuppressWarnings("unchecked")
  public T extendedDescription(String extendedDescription) {
    setExtendedDescription(extendedDescription);
    return (T) this;
  }

  @Schema(description = "An end to end ID for the payment created at initiation")
  @JsonProperty("endToEndId")
  String endToEndId;

  public String endToEndId() {
    return getEndToEndId();
  }

  @SuppressWarnings("unchecked")
  public T endToEndId(String endToEndId) {
    setEndToEndId(endToEndId);
    return (T) this;
  }

  @Schema(
      description = "Purpose of the payment.  Format is defined by NPP standards for the x2p1.01 overlay service")
  @JsonProperty("purposeCode")
  String purposeCode;

  public String purposeCode() {
    return getPurposeCode();
  }

  @SuppressWarnings("unchecked")
  public T purposeCode(String purposeCode) {
    setPurposeCode(purposeCode);
    return (T) this;
  }
}