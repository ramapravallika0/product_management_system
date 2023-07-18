package pjdbc;

import java.util.List;

public class ProductServiceImp implements IProductService {

	
private	ProductDAO  dao = new ProductDAO();
	
	@Override
	public int addProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.addProd(prod);
	}

	@Override
	public int updateProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.updateProd(prod);
	}

	@Override
	public int deleteProdById(int pid) {
		// TODO Auto-generated method stub
		return dao.deleteProdById(pid);
	}

	@Override
	public Product getProdById(int pid) {
		// TODO Auto-generated method stub
		return dao.getProdById(pid);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	
	
	public static boolean  dataValidation(Product prod) {
		
		boolean flag = false;
		
		if(prod.getPid() > 99 
		&& prod.getPname().length() >= 0
		&& prod.getPrice()>0) {
			
				flag = true;
		}
		
		return flag;
	}
	
	
	
	

}
