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
package io.biza.babelfish.cdr.model.banking;

import java.util.List;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Valid
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Banking Product Detailed Information", allOf = { BankingProduct.class })
public abstract class BankingProductDetail<T> extends BankingProduct<T> {

  @Schema(
      description = "An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also")
  List<BankingProductBundle<?>> bundles;

  @Schema(description = "Array of features available for the product")
  List<BankingProductFeature<?>> features;

  @Schema(
      description = "Constraints on the application for or operation of the product such as minimum balances or limit thresholds")
  List<BankingProductConstraint<?>> constraints;

  @Schema(description = "Eligibility criteria for the product")
  List<BankingProductEligibility<?>> eligibility;

  @Schema(description = "Fees applicable for the product")
  List<BankingProductFee<?>> fees;

  @Schema(description = "Interest rates available for deposits")
  List<BankingProductDepositRate<?>> depositRates;

  @Schema(description = "Interest rates charged against lending balances")
  List<BankingProductLendingRate<?>> lendingRates;
}