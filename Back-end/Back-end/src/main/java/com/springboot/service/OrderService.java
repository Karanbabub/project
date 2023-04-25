package com.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Cart;
import com.springboot.model.Customer;
import com.springboot.model.Order;
import com.springboot.repository.CartRepository;
import com.springboot.repository.OrderRepository;

@Transactional
@Service
public class OrderService
{
	@Autowired
	public OrderRepository orderRepository;

	@Autowired
	public ProductService productService;

	@Autowired
	public CartService cartService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartRepository cartRepository;

	public Order addOrder(Order order, long customerId, long cartId)
	{
		Cart cart = cartService.getCartById(cartId);

		Customer customer = customerService.getCustomerById(customerId);

		order.setTotalPrice(order.getMrpPrice() * cart.getQuantity());
		order.setPaymentStatus(order.getPaymentStatus());
		order.setOrderStatus(order.getOrderStatus());
		order.setOrderedDate(order.getOrderedDate());
		order.setMrpPrice(cart.getMrpPrice());
		order.setQuantity(cart.getQuantity());
		order.setCustomer(customer);

//		cartRepository.deleteById(cartId);
		return orderRepository.save(order);

	}

	@SuppressWarnings("deprecation")
	public List<Order> getAllOrders()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		String[] array = currentDate.split("/");
		int month = Integer.parseInt(array[0]);
		int day = Integer.parseInt(array[1]);
		int year = Integer.parseInt(array[2]);
		Date d = new Date(month, day, year);
		System.out.println(d);
		List<Order> orders = orderRepository.findAll();
		System.out.println(orders);
		return orderRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	public List<Order> getOrderByCustomerId(long customerId)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		String[] array = currentDate.split("/");
		int month = Integer.parseInt(array[0]);
		int day = Integer.parseInt(array[1]);
		int year = Integer.parseInt(array[2]);
		Date d = new Date(month, day, year);
		System.out.println(d);
		List<Order> orders = orderRepository.findByCustomerCustomerId(customerId);
		System.out.println(orders);
		return orderRepository.findByCustomerCustomerId(customerId);
	}

	public Order updateOrder(Order order, long orderId)
	{
		Order existingOrder = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
		existingOrder.setTotalPrice(order.getMrpPrice());
		existingOrder.setPaymentStatus(order.getPaymentStatus());
		existingOrder.setMrpPrice(order.getMrpPrice());
		existingOrder.setOrderStatus(order.getOrderStatus());
		existingOrder.setCustomer(order.getCustomer());
		existingOrder.setOrderedDate(order.getOrderedDate());
		orderRepository.save(existingOrder);
		return existingOrder;
	}

	public void deleteOrder(long orderId)
	{
		orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
		orderRepository.deleteById(orderId);

	}

	public Order getOrderById(long orderId)
	{

		return orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));

	}

}
