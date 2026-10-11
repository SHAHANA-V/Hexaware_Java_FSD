package com.helpdesk.Repository;

import com.helpdesk.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomer() {
        String jpql = "select c from Customer c";  // we query the class Customer
        return entityManager.createQuery(jpql, Customer.class).getResultList();

        /*String hql = "from Customer c";  // no select statement
        String nativeSql = "select * from customer"; // u query the table

        return entityManager
                .createQuery(hql, Customer.class)
                .getResultList();


        return entityManager
                .createNativeQuery("select * from customer", Customer.class)
                .getResultList(); // List<Object> -- ClassCastException*/
    }


    public Optional<Customer> getCustomerById(int customerId) {
        return Optional.ofNullable(entityManager.find(Customer.class,customerId));
    }
}
