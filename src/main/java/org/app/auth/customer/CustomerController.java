package org.app.auth.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/show")
    public String showMessage() {
        return "Welcome to the Application!";
    }

    @PostMapping("/signup")
    public CustomerVo register(@RequestBody CustomerVo customerVo) {
        return customerService.register(customerVo);
    }

    @GetMapping("info/{username}")
    public CustomerVo getInformation(@PathVariable String username) {
        return customerService.getInformation(username);
    }

    @GetMapping("/unsecured")
    public String showUnsecured() {
        return "Welcome to the unauthenticated app page";
    }
}
