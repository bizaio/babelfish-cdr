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
package io.biza.babelfish.cdr.tests.v1.model.banking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.biza.babelfish.cdr.models.payloads.banking.account.balance.BankingBalancePurseV1;
import io.biza.babelfish.cdr.tests.v1.model.ModelConstants;

@DisplayName("BankingBalancePurse V1 Tests")
public class BankingBalancePurseV1Test {
  private Validator validator;

  @BeforeEach
  public void setup() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  @DisplayName("Create valid BankingBalancePurse")
  void bankingBalancePurse() {
    assertTrue(validator.validate(ModelConstants.DEFAULT_BANKING_BALANCE_PURSE).isEmpty(),
        validator.validate(ModelConstants.DEFAULT_BANKING_BALANCE_PURSE).toString());
  }

  @Test
  @DisplayName("BankingBalancePurse Mandatory Fields")
  void bankingBalanceMandatoryFields() {
    BankingBalancePurseV1 data = new BankingBalancePurseV1();
    assertFalse(validator.validate(data).isEmpty(), validator.validate(data).toString());

    data.amount(new BigDecimal("100.00"));

    // Should now be a valid payload
    assertTrue(validator.validate(data).isEmpty(), validator.validate(data).toString());

  }

}
