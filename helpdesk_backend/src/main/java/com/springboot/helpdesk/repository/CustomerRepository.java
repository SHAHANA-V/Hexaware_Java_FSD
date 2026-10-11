package com.springboot.helpdesk.repository;


import com.springboot.helpdesk.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
/*
    JpaRepository <Interface>
    save(T) : T
    findAll() : List<T>
    findById(id) : Optional<T>
    delete(T) : void
    deleteById(id) : void
    * */
// JpaRepository : spring data jpa

// class CustomerRepository implements JpaRepository : implement all these methods
// interface CustomerRepository extends JpaRepository : i get all pre created methods