/*******************************************************************************
 * Copyright (C) 2020 Biza Pty Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *******************************************************************************/
package io.biza.cdr.babelfish.v1.response;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.biza.cdr.babelfish.support.BabelFishModelProperty;
import io.biza.cdr.babelfish.v1.model.CDRResponse;
import io.biza.cdr.babelfish.v1.model.banking.BankingPayeeDetail;
import io.biza.cdr.babelfish.v1.model.common.Links;
import io.biza.cdr.babelfish.v1.model.common.Meta;
import lombok.NonNull;

@Valid
public class ResponseBankingPayeeById extends io.biza.cdr.babelfish.response.ResponseBankingPayeeById {

  public ResponseBankingPayeeById(@NonNull BankingPayeeDetail data,
      @NonNull CDRResponse<Links, Meta> metadata) {
    super(data, metadata);
  }

}