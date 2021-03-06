package io.biza.babelfish.cdr.models.responses.register;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.biza.babelfish.cdr.models.payloads.LinksPaginatedV1;
import io.biza.babelfish.cdr.models.payloads.MetaPaginatedV1;
import io.biza.babelfish.cdr.models.payloads.register.holder.RegisterDataHolderBrandV1;
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
@Schema(description = "Response containing a list of Register Data Holder Brand objects")
public class ResponseRegisterDataHolderBrandListV1 {
  
  @JsonProperty("data")
  @Schema(
      description = "A list of Data Holder Brand Objects")
  @NotNull
  List<RegisterDataHolderBrandV1> data;
  
  @Schema(description = "The Links Object", required = true)
  @JsonProperty("links")
  @NotNull
  @Valid
  LinksPaginatedV1 links;

  @Schema(
      description = "The meta object is used to provide additional information such as second factor authorisation data, traffic management, pagination counts or other purposes that are complementary to the workings of the API.",
      required = true)
  @JsonProperty("meta")
  @NotNull
  @Valid
  MetaPaginatedV1 meta;

}
