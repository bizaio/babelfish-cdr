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
package io.biza.babelfish.cdr.models.payloads.common;

import java.util.Locale;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.biza.babelfish.cdr.Constants;
import io.biza.babelfish.cdr.converters.CountryStringToLocaleConverter;
import io.biza.babelfish.cdr.converters.LocaleToCountryStringConverter;
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
@Schema(description = "Simple Address Detail", name = "CommonSimpleAddressV1")
public class CommonSimpleAddressV1
    extends io.biza.babelfish.cdr.abstracts.payloads.common.CommonSimpleAddressV1 {
  @Schema(
      description = "Name of the individual or business formatted for inclusion in an address used for physical mail")
  @JsonProperty("mailingName")
  String mailingName;

  @Schema(description = "First line of the standard address object", required = true)
  @JsonProperty("addressLine1")
  @NotEmpty(message = "First line of Address must be specified")
  String addressLine1;

  @Schema(description = "Second line of the standard address object")
  @JsonProperty("addressLine2")
  String addressLine2;

  @Schema(description = "Third line of the standard address object")
  @JsonProperty("addressLine3")
  String addressLine3;

  @Schema(description = "Mandatory for Australian addresses")
  @JsonProperty("postcode")
  String postcode;

  @Schema(description = "Name of the city or locality", required = true)
  @JsonProperty("city")
  @NotEmpty(message = "City must be populated")
  String city;

  @Schema(
      description = "Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT",
      required = true)
  @NotNull
  @JsonProperty("state")
  String state;

  @Schema(
      description = "A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present.")
  @JsonSerialize(converter = LocaleToCountryStringConverter.class)
  @JsonDeserialize(converter = CountryStringToLocaleConverter.class)
  @JsonProperty("country")
  @Builder.Default
  Locale country = new Locale(Constants.DEFAULT_LOCALE, "AU");


}
