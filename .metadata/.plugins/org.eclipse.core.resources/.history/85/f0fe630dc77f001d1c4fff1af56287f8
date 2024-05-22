package com.example.demo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.Value;

@Controller
public class AppController {

	@Autowired
	private KhachhangService khservice; 
	@Autowired
	private AdminService adminservice;
	@Autowired
	private ProductService productservice;
	@Autowired
	private BillService billservice;
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String showLogin(Model model) {
		Khachhang khachhang  = new Khachhang();
		model.addAttribute("khachhang", khachhang);
		return "index";
	}
	
	@RequestMapping("/loginadmin")
	public String showLoginadmin(Model model) {
		Admin ad  = new Admin();
		model.addAttribute("admin", ad);
		return "loginadmin";
	}
	    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveKhachhang(@ModelAttribute("khachhang") Khachhang khachhang) {
		khservice.save(khachhang);
		return "index";
	}
	//Login khách hàng
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginKH(ModelMap model, @Valid @ModelAttribute("khachhang") Khachhang khachhang,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("index",model);
		}
		Khachhang kh = khservice.login(khachhang.getSodienthoai(),khachhang.getMatkhau());
		
		if(kh==null) {
			model.addAttribute("message", "INvalid sodienthoai or mat khau");
			return new ModelAndView("index",model);
		}
		session.setAttribute("sodienthoai", kh.getSodienthoai());
		List<Product> listProducts = productservice.listAll();
		model.addAttribute("listProducts", listProducts);
		return new ModelAndView("indexCustomer", model);
	}
	
	//Login admin vao trang admin quan ly hang hoa
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public ModelAndView loginAdmin(ModelMap model, @Valid @ModelAttribute("admin") Admin admin,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("index",model);
		}
		Admin ad = adminservice.login(admin.getTaikhoan(),admin.getMatkhau());
		
		if(ad==null) {
			model.addAttribute("message", "INvalid tai khoan or mat khau");
			return new ModelAndView("loginadmin",model);
		}
		session.setAttribute("taikhoan", ad.getTaikhoan());
		List<Product> listProducts = productservice.listAll();
		model.addAttribute("listProducts", listProducts);
		return new ModelAndView("indexAdmin",model);
	}
	
	//them product
	@RequestMapping("/newproduct")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	//luu product
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productservice.save(product);
		return "redirect:/indexPd";
	}
	
	//trang chu admin
	@RequestMapping("/indexPd")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productservice.listAll();
		model.addAttribute("listProducts", listProducts);
		return "indexAdmin";
	}
	//trang chu customer
	@RequestMapping("/indexHome")
	public String viewHomePage1(Model model) {
		List<Product> listProducts = productservice.listAll();
		model.addAttribute("listProducts", listProducts);
		return "indexCustomer";
	}
	
	//edit product
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = productservice.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	//delete product
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		productservice.delete(id);
		return "redirect:/indexPd";		
	}
	
	//add vao gio hang
	@RequestMapping("/add/{id}")
	public String AddGioHang(@PathVariable(name = "id") int id) {
		Product product = productservice.get(id);
		Bill bill = new Bill();
		bill.setName(product.getName());
		bill.setPrice(product.getPrice());
		bill.setImage(product.getImage());
		bill.setProduct_id(product.getId());
		billservice.save(bill);
		return "redirect:/indexHome";
	}
	
	//giao dien gio hang
	@RequestMapping("/giohang")
	public String viewGioHang(Model model) {
		List<Bill> listbills = billservice.listAll();
		model.addAttribute("listbills", listbills);
		model.addAttribute("sum",listbills.size());
		Long tongtien = 0L;
		for(Bill bill : listbills) {
			tongtien = tongtien + bill.getPrice();
		}
		model.addAttribute("tongtien",tongtien);
		return "giohang";
	}
	
	//delete product khoi gio hang
		@RequestMapping("/remove/{id}")
		public String removeProduct(@PathVariable(name = "id") int id) {
			billservice.delete(id);
			return "redirect:/giohang";		
		}
	//thanh toan
	@RequestMapping("/thanhtoan")	
	public String viewGioHang1(Model model) {
		billservice.clear();
//		model.addAttribute("listbills", listbills);
		model.addAttribute("sum",0);
		Long tongtien = 0L;
//		for(Bill bill : listbills) {
//			tongtien = tongtien + bill.getPrice();
//		}
		model.addAttribute("tongtien",tongtien);
		model.addAttribute("message", "THANH TOÁN THÀNH CÔNG!");
		return "giohang";
	}	
}
