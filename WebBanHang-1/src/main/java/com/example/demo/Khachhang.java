package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Khachhang {
	private Long id;
	private String email;
	private String name;
	private Long sodienthoai;
	private String matkhau;

	protected Khachhang() {
	}

	protected Khachhang(Long id, String email, String name, Long sodienthoai,String matkhau) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.sodienthoai = sodienthoai;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Long getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(Long sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

}
