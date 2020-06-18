package com.codegym.service;

import com.codegym.models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private static Map<Integer, Customer> customerList;

    static {
        customerList = new HashMap<>();
        customerList.put(1, new Customer(1, "Bưởi", "trung1@gmail.com", "Vietnam"));
        customerList.put(2, new Customer(2, "Chuối", "trung2@gmail.com", "UK"));
        customerList.put(3, new Customer(3, "Trung3", "trung3@gmail.com", "America"));
        customerList.put(4, new Customer(4, "Trung4", "trung4@gmail.com", "Japan"));
        customerList.put(5, new Customer(5, "Trung5", "trung5@gmail.com", "Australia"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
