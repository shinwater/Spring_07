package com.spring.products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class ProductsDAOImpl implements ProductsDAO{

	
	@Autowired
	private JdbcTemplate template;
	String sql=null;
	
	
	@Override // products 테이블에서 리스트를 바당오는 메서드
	public List<ProductsDTO> getList() {
		
		List<ProductsDTO> list = new ArrayList<ProductsDTO>();
		
		sql="select * from products";
		return list = template.query(sql, new RowMapper<ProductsDTO>() {
			@Override
			public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductsDTO dto = new ProductsDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProducts_name(rs.getString("products_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));
				dto.setStatus(rs.getString("status"));
				
				return dto;
			}
		});
	}//getList() end;

	@Override//products테이블에 제품을 추가하는 메서드
	public int insertProduct(final ProductsDTO dto) {
		// TODO Auto-generated method stub
		sql="insert into products values(products_seq.nextval,?,?,?,?,?,?,?,?,default)";
		int res = this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, dto.getCategory_fk());
				ps.setString(2, dto.getProducts_name());
				ps.setString(3, dto.getEp_code_fk());
				ps.setInt(4, dto.getInput_price());
				ps.setInt(5, dto.getOutput_price());
				ps.setInt(6, dto.getTrans_cost());
				ps.setInt(7, dto.getOutput_price()/100*5);
				ps.setString(8, dto.getCompany());
				
			}
		});
		
		return res;
	}

	@Override//products테이블에서 제품번호에 해당하는 상세내역을 가져오는 메서드
	public ProductsDTO getCont(int pnum) {
		// TODO Auto-generated method stub
		sql="select * from products where pnum="+pnum;
		return this.template.queryForObject(sql,new RowMapper<ProductsDTO>() {

			@Override
			public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ProductsDTO dto = new ProductsDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProducts_name(rs.getString("products_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));
				dto.setStatus(rs.getString("status"));
				
				return dto;
			}
		});
	}//getCOnt();

	@Override//products테이블에서 제품번호에 해당하는 제품을 수정하는 메서드
	public int updateProduct(final ProductsDTO dto) {
		// TODO Auto-generated method stub
		sql="update products set input_price=?, output_price=?,trans_cost=?,mileage=?  where pnum=?";
		int res =template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, dto.getInput_price());
				ps.setInt(2, dto.getOutput_price());
				ps.setInt(3, dto.getTrans_cost());
				ps.setInt(4, dto.getMileage());
				ps.setInt(5, dto.getPnum());
				
			}
		});
		return res;
	}

	@Override //products 테이블에서 제품번호에 핻아하는 테이블을 삭제하는 메서드
	public int deleteProduct(int pnum) {
		// TODO Auto-generated method stub
		
		sql="delete from products where pnum=?";
		int res=template.update(sql, pnum);
		
		return res;
	}// deleteProduct() end;

	@Override //CAtegory 테이블에서 재퓨무번호를 가져오는 메섣,
	public List<CategoryDTO> categoryList() {
		// TODO Auto-generated method stub

		List<CategoryDTO> list;
		
		sql="select * from category";
		return list = template.query(sql, new RowMapper<CategoryDTO>() {
			@Override
			public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryDTO dto = new CategoryDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setCategory_name(rs.getString("category_name"));
				dto.setDelete_chk(rs.getString("delete_chk"));
				return dto;
			}
		});
		
	}

}
