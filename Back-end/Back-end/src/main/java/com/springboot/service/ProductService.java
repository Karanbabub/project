package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Category;
import com.springboot.model.Product;
import com.springboot.model.ProductPaging;
import com.springboot.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product)
	{
		System.out.println("Product added Succesfully " + product);
		product.setProductname(product.getProductname());
		product.setQuantity(product.getQuantity());
		product.setMrpPrice(product.getMrpPrice());
		product.setDescription(product.getDescription());
		return productRepository.save(product);
	}

	public Product updateProduct(Product product, long productId)
	{

		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
		existingProduct.setProductname(product.getProductname());
		existingProduct.setMrpPrice(product.getMrpPrice());
		existingProduct.setImage(product.getImage());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());

		productRepository.save(existingProduct);

		return existingProduct;

	}

	public void deleteProduct(long productId)
	{
		productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "Id", productId));
		productRepository.deleteById(productId);

	}

	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	public Product getProductByProductId(long productId)
	{
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
	}

	public List<Product> findByCategory(Category catgory)
	{
		return productRepository.findByCategory(catgory);
	}

	public ProductPaging findByCategory(Category catgory, Integer pageNo, Integer pageSize)
	{
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findByCategory(catgory, paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		if (pageResult.hasContent())
		{
			pr.setProduct(pageResult.getContent());
		} else
		{
			pr.setProduct(new ArrayList<Product>());
		}
		return pr;
	}

	public ProductPaging getAllProducts(Integer pageNo, Integer pageSize)
	{
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findAll(paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		System.out.println(">>>>>" + pageResult.getTotalPages());
		if (pageResult.hasContent())
		{
			pr.setProduct(pageResult.getContent());
		} else
		{
			pr.setProduct(new ArrayList<Product>());
		}
		return pr;
	}
}
