package pjdbc;

import java.util.List;

import pjdbc.Product;

public interface IProductService {
	
	
	public int addProd(Product prod);
	public int updateProd(Product prod);
	public int deleteProdById(int pid);
	public Product getProdById(int deptNo);
	public List<Product>  getAll();

}
