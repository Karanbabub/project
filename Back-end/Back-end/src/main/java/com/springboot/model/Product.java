package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "product_table")
@SequenceGenerator(name = "generator2", sequenceName = "gen2", initialValue = 2000)
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator2")
	@Column(name = "product_id")
	private long productId;

	@NotEmpty(message = "Product name is required.")
	@Column(name = "productname", nullable = false, length = 20)
	private String productname;

	@Column(name = "product_image")
//	@NotEmpty
	private String image;

	@NotEmpty(message = "Product description is required.")
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "mrp_price", nullable = false, precision = 10, scale = 2)
	private double mrpPrice;

	@Column(name = "quantity")
	private long quantity;

	private Category category;

	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	
}