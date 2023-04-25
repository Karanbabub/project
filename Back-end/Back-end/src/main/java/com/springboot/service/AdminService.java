package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Admin;
import com.springboot.repository.AdminRepository;

@Service
public class AdminService
{
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin)
	{
		System.out.println("Admin register service" + admin);
		return this.adminRepository.save(admin);

	}

	public Admin loginAdmin(Admin admin)
	{
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "Id",
						admin.adminEmailId + "and password" + admin.adminPassword));

	}

	public Admin updateAdmin(Admin admin, long adminId)
	{
		Admin existingAdmin = adminRepository.findById((int) adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
		existingAdmin.setFirstName(admin.getFirstName());
		existingAdmin.setLastName(admin.getLastName());
		existingAdmin.setAdminEmailId(admin.getAdminEmailId());
		existingAdmin.setAdminPassword(admin.getAdminPassword());
		adminRepository.save(existingAdmin);
		return existingAdmin;
	}

	public void deleteAdmin(long adminId)
	{
		adminRepository.findById((int) adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
		adminRepository.deleteById((int) adminId);
	}

	public List<Admin> getAllAdmin()
	{

		return adminRepository.findAll();
	}

	public Admin findByAdminEmailId(Admin admin)
	{

		return this.adminRepository.findByAdminEmailId(admin.adminEmailId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin ", "Id",
						admin.adminEmailId + "and password" + admin.adminPassword));
	}

	public Admin findByAdminId(long adminId)
	{

		return adminRepository.findById((int) adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
	}

}
