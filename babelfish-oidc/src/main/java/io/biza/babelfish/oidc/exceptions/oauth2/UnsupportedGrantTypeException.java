package io.biza.babelfish.oidc.exceptions.oauth2;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class UnsupportedGrantTypeException extends Exception {
  private static final long serialVersionUID = 1L;
}
