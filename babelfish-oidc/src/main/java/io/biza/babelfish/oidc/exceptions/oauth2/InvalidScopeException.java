package io.biza.babelfish.oidc.exceptions.oauth2;

import lombok.Builder;

@Builder
public class InvalidScopeException extends Exception {
  private static final long serialVersionUID = 1L;
}
