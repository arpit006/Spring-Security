package org.app.auth.customer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;
import org.app.auth.authority.AuthorityVo;

import java.util.Date;
import java.util.Set;

@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = CustomerVo.CustomerVoBuilder.class)
public class CustomerVo {

    private String uuid;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private int active;

    private Set<AuthorityVo> authority;
}

