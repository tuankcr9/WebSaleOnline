package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository repo;
	
	public Admin login(String taikhoan, String matkhau) {
		List<Admin> op = listAll();
		for(Admin ad:op) {
			if(ad.getTaikhoan().equals(taikhoan) && ad.getMatkhau().equals(matkhau)) {
				return ad;
			}
		}
		return null;
	}
	
	public List<Admin> listAll() {
		return repo.findAll();
	}
	
}
