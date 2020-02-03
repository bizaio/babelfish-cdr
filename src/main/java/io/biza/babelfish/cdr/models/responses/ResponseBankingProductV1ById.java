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
package io.biza.babelfish.cdr.models.responses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.biza.babelfish.cdr.abstracts.payloads.CDRResponse;
import io.biza.babelfish.cdr.models.payloads.banking.product.BankingProductDetailV1;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Valid
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseBankingProductV1ById extends CDRResponse<ResponseBankingProductV1ById> {

  @Schema(required = true)
  @JsonProperty("data")
  @NotNull
  @Valid
  BankingProductDetailV1 data;

  public BankingProductDetailV1 data() {
    return getData();
  }

  public ResponseBankingProductV1ById data(BankingProductDetailV1 data) {
    setData(data);
    return this;
  }
}
