package com.spring.jdbc02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.products.CategoryDTO;
import com.spring.products.ProductsDAO;
import com.spring.products.ProductsDTO;

@Controller
public class ProductsController {

	@Autowired
	private ProductsDAO dao;
	
	//DB에서  전체리스트를 받아옴
	@RequestMapping("/products_list.do")
	public String products_list(Model model) {
		List<ProductsDTO> list =this.dao.getList();
		model.addAttribute("List", list);
		
		return "products_list";
	}//products_list() end;
	
	@RequestMapping("/products_cont.do")
	public String products_cont(@RequestParam("pnum") int pnum, Model model) {
		ProductsDTO dto =this.dao.getCont(pnum);
		model.addAttribute("dto", dto);
		
		return "products_cont";
	}//cont(); 
	
	@RequestMapping("/products_insert.do")
	public String insert(Model model) {
		
		//카테고리를 불러올 메서드
		List<CategoryDTO> list= dao.categoryList();
		
		model.addAttribute("list", list);
		return "products_insertForm";
	
		/*
		 * modelandview
		 * mav.addObject()
		 * 
		 */
		
		
	}//insert();
	
	
	@RequestMapping("/products_insertOk.do")
	public String insertOk(ProductsDTO dto) {
		
		int res =this.dao.insertProduct(dto);
		
		
		if(res==1) {
			return "redirect:products_list.do";
		}else {
			return "redirect:products_insert.do";
		}
	}//i인서트오케이 ㅇㅋ
	
	@RequestMapping("/products_update.do")
	public String update(@RequestParam("pnum") int pnum,Model model) {
		ProductsDTO dto=this.dao.getCont(pnum);
		model.addAttribute("dto", dto);
		return "products_updateFoam";
	}
	
	@RequestMapping("/products_updateOk.do")
	public String updateOk(ProductsDTO dto) {
		
		int res = this.dao.updateProduct(dto);
		if(res==1) {
			return "redirect:products_list.do";
		}else {
			return "redirect:products_update.do";
		}
	}//update();
	
	@RequestMapping("/products_delete.do")
	public void delete(@RequestParam("pnum") int pnum,HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8"); 
		
		int res =this.dao.deleteProduct(pnum);
		
		
		PrintWriter out = response.getWriter();
		
		if(res==1) {
			out.println("<script>");
			out.println("alert('성공')");
			out.println("location.href='products_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('실퐤')");
			out.println("location.href='products_cont.do?pnum="+pnum+"'");
			out.println("</script>");
		}
	}//delete();
	
}
