package org.app.auth.authority;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;
import org.app.auth.customer.CustomerVo;

@Value
@Wither
@JsonDeserialize(builder = AuthorityVo.AuthorityVoBuilder.class)
@Builder(toBuilder = true)
public class AuthorityVo {

    private String uuid;

    private String authority;


}
