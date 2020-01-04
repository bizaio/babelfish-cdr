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
package io.biza.cdr.babelfish.v1.model.banking;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

@Valid
public class BankingBillerPayee extends io.biza.cdr.babelfish.model.banking.BankingBillerPayee {
  @AssertTrue(message = "BPAY CRN of Card Format MUST be Masked")
  private boolean isCrnMasked() {
    if (crn().matches("(\\w{4} ){3}\\w{4}")) {
      if (crn().matches("(x{4} ){3}\\w{4}")) {
        return true;
      } else {
        return false;
      }
    } else {
      return true;
    }
  }
}
