package com.springboot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Customer;
import com.springboot.model.Order;
import com.springboot.model.Payment;
import com.springboot.repository.OrderRepository;
import com.springboot.repository.PaymentRepository;

@Service
public class PaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerService customerService;

	public Payment addPayment(Payment payment, long orderId, long customerId)
	{

		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
		
		payment.setOrderId(orderId);
		payment.setTotalPrice(order.getTotalPrice());
		payment.setPaidDate(LocalDate.now());
		payment.setPaidAmount(order.getTotalPrice());
		
		if (payment.getTotalPrice() == payment.getPaidAmount())
		{
			order.setPaymentStatus("PAID");
			order.setOrderStatus("Delivered");
		} else
		{

			order.setPaymentStatus("NOT-PAID");
			order.setOrderStatus("payment pending");
		}
		Customer customer = customerService.getCustomerById(customerId);

		payment.setCustomer(customer);

		return paymentRepository.save(payment);

	}

	public List<Payment> getAllPayments()
	{
		return paymentRepository.findAll();
	}

	public List<Payment> getAllPaymentsByCustomerId(long customerId)
	{
		return paymentRepository.findByOrderId(customerId);
	}

	public Payment getPaymentById(long paymentId)
	{

		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payement", "Id", paymentId));
	}

	public void deletePayment(long paymentId)
	{
		paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payement", "Id", paymentId));
		paymentRepository.deleteById(paymentId);

	}

}
