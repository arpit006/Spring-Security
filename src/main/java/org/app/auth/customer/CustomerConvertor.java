package org.app.auth.customer;

import org.app.auth.authority.AuthorityConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerConvertor {

    @Autowired
    private AuthorityConvertor authorityConvertor;

    public CustomerVo convertEntityToVo(CustomerEntity entity) {
        return CustomerVo
                .builder()
                .uuid(entity.getUuid())
                .userName(entity.getUserName())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .active(entity.getActive())
                .authority(entity.getAuthority().stream().map(authorityConvertor::convertEntityToVo).collect(Collectors.toSet()))
                .build();
    }

    public CustomerEntity convertVoToEntity(CustomerVo vo) {
        CustomerEntity customer = new CustomerEntity();
        customer.setUuid(vo.getUuid());
        customer.setUserName(vo.getUserName());
        customer.setFirstName(vo.getFirstName());
        customer.setLastName(vo.getLastName());
        customer.setPassword(vo.getPassword());
        customer.setEmail(vo.getEmail());
        customer.setActive(vo.getActive());
        customer.setAuthority(vo.getAuthority().stream().map(authorityConvertor::convertVoToEntity).collect(Collectors.toSet()));
        return customer;
    }
}
