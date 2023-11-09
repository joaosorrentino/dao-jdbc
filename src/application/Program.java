package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			SellerDao sellerDao = DaoFactory.createSellerDao();
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			
			while (true) {
				System.out.println("1 - Seller");
				System.out.println("2 - Department");
				System.out.println("3 - Sair");
				
				int opcao = sc.nextInt();
				System.out.println(" ");
				System.out.println("---------------------------------------");
				System.out.println(" ");
				switch(opcao) {
					case 1:
						System.out.println("1 - Inserir um seller");
						System.out.println("2 - Atualizar seller");
						System.out.println("3 - Deletar seller");
						System.out.println("4 - Listar todos os seller");
						System.out.println("5 - Listar um seller");
						System.out.println("6 - Listar pelo departamento");
						System.out.println("7 - Sair");
						
						int seller = sc.nextInt();
						switch(seller) {
							case 1:
								System.out.print("Digite o id: ");
								int id = sc.nextInt();
								System.out.print("Digite o nome: ");
								String name = sc.next();
								System.out.print("Digite o email: ");
								String email = sc.next();
								System.out.print("Digite o salário: ");
								Double sal = sc.nextDouble();
								System.out.println("Digite o departamento: ");
								int dep = sc.nextInt();
								Department department = new Department(dep, null);
								Seller newSeller = new Seller(id,name,email,new Date(),sal,department);
								sellerDao.insert(newSeller);
								System.out.println("Seller inserido !!");
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 2:
								System.out.print("Digite o id: ");
								int id2 = sc.nextInt();
								Seller seller2 = sellerDao.findById(id2);
								System.out.print("O que deseja alterar ");
								String opcaoSeller = sc.next();
								switch(opcaoSeller) {
									case "email":
										System.out.print("Coloque o email: ");
										String email2 = sc.next();
										seller2.setEmail(email2);
										sellerDao.update(seller2);
										System.out.println("Update feito !!");
										System.out.println(" ");
										System.out.println("---------------------------------------");
										System.out.println(" ");
										break;
									case "nome":
										System.out.print("Coloque o seu nome: ");
										String nome = sc.next();
										seller2.setName(nome);
										sellerDao.update(seller2);
										System.out.println("Update feito !!");
										System.out.println(" ");
										System.out.println("---------------------------------------");
										System.out.println(" ");
										break;
									case "salario":
										System.out.print("Coloque o salario: ");
										Double salario = sc.nextDouble();
										seller2.setBaseSalary(salario);
										sellerDao.update(seller2);
										System.out.println("Update feito !!");
										System.out.println(" ");
										System.out.println("---------------------------------------");
										System.out.println(" ");
										break;
								}
								break;
							case 3:
								System.out.print("Digite o id: ");
								int idDelete = sc.nextInt();
								sellerDao.deleteById(idDelete);
								System.out.println("Delete completed");
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 4:
								Department department2 = new Department();
								List<Seller> list = sellerDao.finByDepartment(department2);
								list = sellerDao.findAll();
								for(Seller obj : list) {
									System.out.println(obj);
								}
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 5:
								System.out.print("Digite o id: ");
								int idFindById = sc.nextInt();
								Seller sellerFindById = sellerDao.findById(idFindById);
								System.out.println(sellerFindById);
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
							case 6:
								System.out.println("Digite o id do departamento: ");
								int idDepartment = sc.nextInt();
								Department department3 = new Department(idDepartment, null);
								List<Seller> list2 = sellerDao.finByDepartment(department3);
								for (Seller obj : list2) {
									System.out.println(obj);
								}
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
							case 7:
								break;
						}
					case 2:
						System.out.println("1 - Inserir um Department");
						System.out.println("2 - Atualizar department");
						System.out.println("3 - Deletar department");
						System.out.println("4 - Listar todos os department");
						System.out.println("5 - Listar um department");
						System.out.println("6 - Sair");
						int departmentChoose = sc.nextInt();
						System.out.println(" ");
						System.out.println("---------------------------------------");
						System.out.println(" ");
						switch(departmentChoose) {
							case 1:
								System.out.print("Digite o id: ");
								int id = sc.nextInt();
								System.out.print("Digite o nome: ");
								String name = sc.next();
								Department departmentInsert = new Department(id,name);
								departmentDao.insert(departmentInsert);
								System.out.println("Departamento Inserido !!!");
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 2:
								System.out.print("Digite o id: ");
								int id2 = sc.nextInt();
								Department departmentUpdate = departmentDao.findById(id2);
								System.out.print("O que deseja alterar ");
								String opcaoSeller = sc.next();
								switch(opcaoSeller) {
									case "nome":
										System.out.print("Coloque o nome: ");
										String nome = sc.next();
										departmentUpdate.setName(nome);
										departmentDao.update(departmentUpdate);
										System.out.println("Update feito !!");
										break;
								}
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 3:
								System.out.print("Digite o id: ");
								int idDelete = sc.nextInt();
								departmentDao.deleteById(idDelete);
								System.out.println("Delete completed");
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 4:
								List<Department> list = departmentDao.findAll();
								for(Department obj : list) {
									System.out.println(obj);
								}
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
								break;
							case 5:
								System.out.print("Digite o id: ");
								int idFindById = sc.nextInt();
								Department departmentFindById = departmentDao.findById(idFindById);
								System.out.println(departmentFindById);
								System.out.println(" ");
								System.out.println("---------------------------------------");
								System.out.println(" ");
							case 6:
								break;
						
						}
					case 3:
						break;
				}
			}
		}
	}
	
}
