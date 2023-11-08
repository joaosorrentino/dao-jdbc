package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		Department department = new Department(2,null);
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("");
		
		List<Seller> list = sellerDao.finByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
	}
}
