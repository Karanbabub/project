package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Admin;
import com.springboot.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin")
public class AdminController
{

	@Autowired
	private AdminService adminService;

//	Register
	@PostMapping("/register")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin)
	{
		System.out.println("admin register " + admin);
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
	}

//	Login
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin)
	{
		System.out.println("admin login " + admin);
		return new ResponseEntity<Admin>(adminService.loginAdmin(admin), HttpStatus.CREATED);
	}
//
////	Update
//	@PutMapping("/upadte/admin/{id}")
//	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long adminId, @RequestBody Admin admin)
//	{
//		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, adminId), HttpStatus.OK);
//	}
//
////	Get All Admin
//	@GetMapping("/admin")
//	public List<Admin> getAllAdmin()
//	{
//		return adminService.getAllAdmin();
//	}
//
////	ForgotPassword
//	@PostMapping("/forgotpassword")
//	public Admin findByAdminEmailId(@RequestBody Admin admin)
//	{
//		return adminService.findByAdminEmailId(admin);
//	}
//
////	Get Id
//	@GetMapping("/admin/{id}")
//	public ResponseEntity<Admin> findByAdminId(@PathVariable("id") long adminId)
//	{
//		return new ResponseEntity<Admin>(adminService.findByAdminId(adminId), HttpStatus.OK);
//
//	}
//
////	Delete Admin
//	@DeleteMapping("delete/{id}")
//	public ResponseEntity<Boolean> deleteAdmin(@PathVariable("id") long adminId)
//	{
//		adminService.deleteAdmin(adminId);
//		boolean flag = true;
//		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
//
//	}
}
