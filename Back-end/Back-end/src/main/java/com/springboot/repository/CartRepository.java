package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Cart;
import com.springboot.model.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>
{

	void deleteCartByCustomer(Customer customer);
}