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
package io.biza.babelfish.cdr.models.responses.container;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.biza.babelfish.cdr.models.payloads.banking.account.BankingAccountV1;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Valid
@ToString
@EqualsAndHashCode
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response containing a list of Banking Accounts",
    name = "ResponseBankingAccountListDataV1")
public class ResponseBankingAccountListDataV1 {
  @Schema(
      description = "The list of accounts returned. If the filter results in an empty set then this array may have no records",
      required = true)
  @JsonProperty("accounts")
  @NotNull
  @Valid
  List<BankingAccountV1> accounts;

}
