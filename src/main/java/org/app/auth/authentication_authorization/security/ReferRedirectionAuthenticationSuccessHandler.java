package org.app.auth.authentication_authorization.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class ReferRedirectionAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    public ReferRedirectionAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }
}