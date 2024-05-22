package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	private Long id;
	private String taikhoan;
	private String matkhau;

	protected Admin() {
	}

	protected Admin(Long id, String taikhoan,String matkhau) {
		super();
		this.id = id;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
}
