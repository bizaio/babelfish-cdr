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
package io.biza.babelfish.common.jackson;

import java.time.Period;
import com.fasterxml.jackson.databind.util.StdConverter;

/**
 * A Jackson StdConverter implementation for converting between CDR DurationString and Java Period
 * 
 * @since 0.9.6
 */
public class StringToPeriodConverter extends StdConverter<String, Period> {
  @Override
  public Period convert(String value) {
    if (null == value || value == "")
      return null;
    return Period.parse(value);
  }
}
