package org.app.auth.authority;

import org.app.auth.customer.CustomerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityConvertor {

    @Autowired
    private CustomerConvertor customerConvertor;

    public AuthorityVo convertEntityToVo(Authority authority) {
        return AuthorityVo
                .builder()
                .uuid(authority.getUuid())
                .authority(authority.getAuthority())
                .build();
    }

    public Authority convertVoToEntity(AuthorityVo vo) {
        Authority authority = new Authority();
        authority.setUuid(vo.getUuid());
        authority.setAuthority(vo.getAuthority());
        return authority;
    }
}
