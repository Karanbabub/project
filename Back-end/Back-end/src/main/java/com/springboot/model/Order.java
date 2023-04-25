package com.springboot.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "order_table")
@SequenceGenerator(name = "generator4", sequenceName = "gen4", initialValue = 4000)
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator4")
	@Column(name = "order_id")
	private long orderId;

	@Column(name = "mrp_price")
	private double mrpPrice;

	@Column(name = "quantity")
	private long quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "ordered_date")
	private Date orderedDate;

	@NotEmpty(message = "Product name is required.")
	@Column(name = "productname", nullable = false, length = 20)
	private String productname;

	@Column(name = "product_image")
	@NotEmpty
	private String image;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}

	public double getMrpPrice()
	{
		return mrpPrice;
	}

	public void setMrpPrice(double mrpPrice)
	{
		this.mrpPrice = mrpPrice;
	}

	public long getQuantity()
	{
		return quantity;
	}

	public void setQuantity(long quantity)
	{
		this.quantity = quantity;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus()
	{
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus = paymentStatus;
	}

	public Date getOrderedDate()
	{
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate)
	{
		this.orderedDate = orderedDate;
	}

	public String getProductname()
	{
		return productname;
	}

	public void setProductname(String productname)
	{
		this.productname = productname;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", mrpPrice=" + mrpPrice + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + ", orderedDate="
				+ orderedDate + ", productname=" + productname + ", image=" + image + ", customer=" + customer + "]";
	}

	

}