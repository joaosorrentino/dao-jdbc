package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		Department department = new Department(2,null);
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		
		List<Seller> list = sellerDao.finByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		Seller newSeller = new Seller(10, "Joao", "j.pedrosorrentino@gmail.com", new Date(), 2000, department);
		sellerDao.insert(newSeller);
		
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		seller = sellerDao.findById(1);
		seller.setName("Amanda");
		sellerDao.update(seller);
		
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		System.out.println("Coloque o id para ser deletado: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		sc.close();
		
		
	}
}
