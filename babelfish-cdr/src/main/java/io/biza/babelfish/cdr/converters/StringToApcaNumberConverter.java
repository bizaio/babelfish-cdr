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
package io.biza.babelfish.cdr.converters;

import com.fasterxml.jackson.databind.util.StdConverter;
import io.biza.babelfish.cdr.support.customtypes.ApcaNumberType;

/**
 * A Jackson StdConverter implementation for converting between CDR APCA String and Babelfish ApcaNumber
 */
public class StringToApcaNumberConverter extends StdConverter<String, ApcaNumberType> {
  @Override
  public ApcaNumberType convert(String value) {
    if (null == value || value == "")
      return null;
    return ApcaNumberType.fromValue(value);
  }
}
