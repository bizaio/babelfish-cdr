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

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.biza.babelfish.cdr.abstracts.payloads.CDRResponsePaginated;
import io.biza.babelfish.cdr.abstracts.payloads.banking.product.BankingProduct;
import io.biza.babelfish.cdr.models.payloads.banking.product.BankingProductV2;
import io.biza.babelfish.cdr.models.responses.container.ResponseBankingProductV2ListData;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Valid
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseBankingProductV2List
    extends CDRResponsePaginated<ResponseBankingProductV2List> {

  @Schema(description = "Object containing a list of BankingProduct objects")
  @JsonProperty("data")
  @Valid
  ResponseBankingProductV2ListData data;

  public ResponseBankingProductV2ListData data() {
    return getData();
  }

  public ResponseBankingProductV2List data(ResponseBankingProductV2ListData data) {
    setData(data);
    return this;
  }
}
