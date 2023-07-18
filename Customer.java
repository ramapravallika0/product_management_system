package pjdbc;

import java.util.List;
import java.util.Scanner;

public class Customer {

	public static void main(String[] args) {

		boolean flag = true;

		Scanner scanner = new Scanner(System.in);

		IProductService service = new ProductServiceImp();

		while (flag) {

			System.out.println("WELCOME TO PMS");
			System.out.println("1. ADD Product");
			System.out.println("2. UPDATE Product");
			System.out.println("3. DELETE Product");
			System.out.println("4. SELECT Product");
			System.out.println("5. SELECT ALL");
			System.out.println("0. EXIT");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter Prod No.");
				int pid1 = scanner.nextInt();
				System.out.println("Enter Prod Name");
				String pname1 = scanner.next();
				System.out.println("Enter Location");
				String price1 = scanner.next();

				Product prod1 = new Product();

				prod1.setPid(pid1);
				prod1.setPname(pname1);
				prod1.setPrice(price1);

				boolean isValid = ProductServiceImp.dataValidation(prod1);

				if (isValid == true) {

					int count = service.addProd(prod1);

					System.out.println(count + " records inserted");
				} else {

		System.err.println("Invalid Inputs , Please Enter Correct Data");

				}

				break;
			case 2:

				System.out.println("Enter Prod No.");
				int pid2 = scanner.nextInt();
				System.out.println("Enter Prod Name");
				String pname2 = scanner.next();
				System.out.println("Enter price");
				String price2 = scanner.next();

				Product prod2 = new Product();

				prod2.setPid(pid2);
				prod2.setPname(pname2);
				prod2.setPrice(price2);
				int count2 = service.updateProd(prod2);

				System.out.println(count2 + " records updated");

				break;
			case 3:

				System.out.println("Enter Pid to delete one record");

				int pid3 = scanner.nextInt();

				int count3 = service.deleteProdById(pid3);

				System.out.println(count3 + " record deleted");

				if(count3 == 0) {
					
					try {
					throw new ProdNotFoundException();
					}
					catch (Exception e) {

					System.err.println("Prod Not Found , Cant delete record");
					}
				}
				
				
				break;
			case 4:

				System.out.println("Enter pid to select record");
				int dno4 = scanner.nextInt();

				Product prodObj = service.getProdById(dno4);

				System.out.println(prodObj);

					if(prodObj  == null) {
					
					try {
					throw new ProdNotFoundException();
					}
					catch (Exception e) {

						System.err.println("Prod Not Found , Can't search record");
					}
				
					}
				break;

			case 5:

				List<Product> list = service.getAll();

				for (Product product : list) {
					System.out.println(product);

				}

				break;

			case 0:

				flag = false;
				
				DBUtil.closeConncetion();
				System.out.println("Thank you visit again..");

				break;

			default:
				System.err.println("Invalid input");
				break;
			}

		}

	}

}
