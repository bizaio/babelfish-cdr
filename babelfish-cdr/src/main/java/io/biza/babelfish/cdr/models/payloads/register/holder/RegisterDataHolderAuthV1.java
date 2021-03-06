package io.biza.babelfish.cdr.models.payloads.register.holder;

import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.biza.babelfish.cdr.enumerations.register.RegisterAuthType;
import io.biza.babelfish.common.jackson.UriStringToUriConverter;
import io.biza.babelfish.common.jackson.UriToUriStringConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Valid
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "A Single Data Holder Brand")
public class RegisterDataHolderAuthV1 {
  
  @JsonProperty("registerUType")
  @NotNull
  @Schema(
      description = "The type of authentication and authorisation in use")
  RegisterAuthType registerUType;
  
  @JsonProperty("jwksEndpoint")
  @NotNull
  @Schema(
      description = "JWKS endpoint for private_key_jwt client auth with Data Recipient")
  @JsonSerialize(converter = UriToUriStringConverter.class)
  @JsonDeserialize(converter = UriStringToUriConverter.class)
  URI jwksEndpoint;

}
