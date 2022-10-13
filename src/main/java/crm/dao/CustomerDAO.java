package crm.dao;

import crm.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomerList();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(Customer customer);
}
