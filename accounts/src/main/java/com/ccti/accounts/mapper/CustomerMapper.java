package com.ccti.accounts.mapper;

import com.ccti.accounts.dto.CustomerDto;
import com.ccti.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapCustomerToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();

        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }

    public static Customer mapCustomerDtoToCustomer(CustomerDto customerDto){
        Customer customer = new Customer();

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }

    public static Customer mapUpdatingToCustomer(CustomerDto customerDto, Customer customer) {

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }
}
