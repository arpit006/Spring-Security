package org.app.auth.customer;

import org.app.auth.authority.AuthorityConvertor;
import org.app.auth.authority.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private CustomerConvertor customerConvertor;

    @Autowired
    private AuthorityConvertor authorityConvertor;

    public CustomerVo register(CustomerVo customerVo) {

        return customerConvertor.convertEntityToVo(customerRepository.save(customerConvertor.convertVoToEntity(customerVo)));
    }

    public CustomerVo getInformation(String username) {
        return customerConvertor.convertEntityToVo(customerRepository.findByUserName(username));
    }
}
