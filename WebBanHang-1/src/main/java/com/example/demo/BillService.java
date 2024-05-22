package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BillService {

	@Autowired
	private BillRepository repo;
	
	public List<Bill> listAll() {
		return repo.findAll();
	}
	
	public void save(Bill bill) {
		repo.save(bill);
	}
	
	public Bill get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public void clear() {
		repo.deleteAll();
	}
}
