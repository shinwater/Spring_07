package com.spring.products;

import java.util.List;

public interface ProductsDAO {

	List<ProductsDTO> getList();
	
	List<CategoryDTO> categoryList(); //카테고리 리스트를 가져오는 추상 메서드
	int insertProduct(ProductsDTO dto);
	
	ProductsDTO getCont(int pnum);
	int updateProduct(ProductsDTO dto);

	int deleteProduct(int pnum);
	
	
}
