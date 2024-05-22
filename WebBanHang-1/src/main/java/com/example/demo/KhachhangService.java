package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KhachhangService {

	@Autowired
	private KhachhangRepository repo;
	
	public Khachhang login(Long sodienthoai, String matkhau) {
		List<Khachhang> op = listAll();
		for(Khachhang kh:op) {
			if(kh.getSodienthoai().equals(sodienthoai) && kh.getMatkhau().equals(matkhau)) {
				return kh;
			}
		}
		return null;
	}
	
	public List<Khachhang> listAll() {
		return repo.findAll();
	}
	
	public void save(Khachhang khachhang) {
		repo.save(khachhang);
	}
	
	public Khachhang get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
//	public void getUser(User user) {
//		repo.findAll(user)
//	}
}
