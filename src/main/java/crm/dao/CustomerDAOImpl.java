package crm.dao;

import crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomerList() {
        //Get current session
        Session session = sessionFactory.getCurrentSession();
        //Query
        Query<Customer> customerQuery = session.createQuery("from Customer",Customer.class);
        //Execute
        return customerQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        //Get current session
        Session session = sessionFactory.getCurrentSession();
        System.out.println(customer);
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
