package app;

import java.util.Scanner;

import model.Branches;
import model.Customers;
import model.Owner;
import model.Products;
import persistance.ConnectToDB;
import persistance.BranchesDAO;
import persistance.OwnerDAO;

public class FabFeetManager {

	static Scanner scan = new Scanner(System.in);

	static void menu() {
		while (true) {
			System.out.println("*********FAB FEET MANAGER ************* ");
			System.out.println();
			System.out.println("1 for login as Owner");
			System.out.println("2 for login as Manager");
			System.out.println("3 for customer");
			System.out.println("4 Show Table details (For testing Only)");
			System.out.println("5 for Exit\n\n\n");
			
			System.out.println("Enter Choice");
			int i = scan.nextInt();
			System.out.println("\n");
			switch (i) {
			case 1:
				System.out.println("enter the owner ID ");
				int id = scan.nextInt();
				System.out.println("enter the owner password");
				String pass = scan.next();
				boolean flag = Owner.validate(id, pass);
				if (flag)
					ownerLogin(id);
				else
					System.out.println("Id password does not match");
				break;
			case 2:
				System.out.println(" enter the branch ID");
				int bid = scan.nextInt();
				System.out.println("enter the owner password");
				pass = scan.next();
				flag = new BranchesDAO().validate(bid, pass);
				if (flag)
					managerLogin(bid);
				else
					System.out.println("Id password does not match");
				break;
			case 3:
				System.out.println(" Welcome Customer ");
				customerLogin();
				break;
			case 4:
				System.out.println(" Testing Mode Enabled");
				TestLogin();
				break;
			default:
				System.out.println("\n\n*************END*****************");
				return;
			}

		}
	}

	static void ownerLogin(int id) {
		System.out.println("\n\n\n\n*******************");
		System.out.println(" Welcome  ~~~ Owner logged in Successfully");
		while (true) {
			System.out.println("\n\n\n\n------------------------------------");
			System.out.println("|    Press Enter to see options     |");
			System.out.println("------------------------------------\n\n\n\n");
			scan.nextLine();
			scan.nextLine();
			System.out.println();
			System.out.println("You are Logged in as Owner\n");
			System.out.println(" 1 for view Orders of all branches\n");
			System.out.println(" 2 for view orders of a particular branch\n");
			System.out.println(" 3 for the view of the stock of all branches \n");
			System.out
					.println(" 4 for the view of the stock of particular branches\n");
			System.out.println(" 5 for the detaisl of the employeen\n");
			System.out
					.println(" 6 for the detaisl of the employee of particular branches\n");
			System.out.println(" 7  for customers review\n");
			System.out.println(" 8  for customers review by name\n");
			System.out
					.println(" 9 for reviewing the request from the managers\n");
			System.out.println(" 10 to logout as owner\n\n\n\n");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			System.out.println("\n");
			switch (choice) {
			case 1:
				System.out
						.println("Displaying all the orders from the branches");
				Owner.displayAllOrders();
				break;
			case 2:
				System.out
						.println(" Enter the branch code to display the orders of that branch");
				int bid = scan.nextInt();
				Owner.displayBranchOrders(bid);
				break;
			case 3:
				System.out
						.println(" Displaying the stock of all the branches ");
				Owner.displayAllStock();
				break;
			case 4:
				System.out
						.println(" Enter the branch code to diplay the stocks of that branch");
				bid = scan.nextInt();
				Owner.displayBranchStock(bid);
				break;
			case 5:
				System.out.println(" Displaying the details of the employee");
				Owner.displayEmployee();
				break;

			case 6:
				System.out.println("Enter the branch code to diplay the employee of that branch");
				bid = scan.nextInt();
				Owner.displayAllByBranchID(bid);
				break;

			case 7:
				System.out.println(" Displaying all the customers Review");
				Owner.displayAllReview();
				break;
				
			case 8:
//				System.out.println(" Displaying all the customers Review");
				Owner.checkReviewbyName();
				break;
				
			case 9:
				System.out
						.println(" Enter the branch id to display the requests from the manager");
				bid = scan.nextInt();
				Owner.displayRequest(bid);
				break;
			default:
				System.out.println(" Logging out the Owner");
				return;

			}
		}
	}

	static void managerLogin(int bid) {
		System.out.println("\n\n\n\n************************");
		System.out.println("manager logged in successfully");
		System.out.println("");
		// TODO --get manger object with given id
		while (true) {
			System.out.println("\n\n\n\n------------------------------------");
			System.out.println("|    Press Enter to see options     |");
			System.out.println("------------------------------------\n\n\n\n");
			scan.nextLine();
			scan.nextLine();
			System.out.println();
			System.out.println("You are Logged in as manager\n");
			System.out.println(" 1 to Enter the product into the inventory\n");
			System.out.println(" 2 to view the stock of the store\n");
			System.out
					.println(" 3 to send the request for the product to owner\n");
			System.out.println(" 4 to view the employee details of the store\n");
			System.out.println(" 5 to create customer profile\n");
			System.out.println(" 6 to place order\n");
			System.out.println(" 7 to logout as Manager\n\n\n\n");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			System.out.println("\n");
			switch (choice) {
			case 1:
				System.out.println(" enter the details of the product");
				Branches.addProduct(bid);
				break;
			case 2:
				System.out.println(" diplaying the store details");
				Branches.displayBranchStock(bid);
				break;
			case 3:
				System.out.println(" enter the request details to the owner");
				Branches.sendRequest(bid);
				break;
			case 4:
				System.out
						.println(" displaying the employee details of brnach "
								+ bid);
				Branches.displayEmployees(bid);
				break;
			case 5:
				System.out
						.println(" enter the details of the customer to enter ");
				Branches.addCustomer();
				break;
			case 6:
				System.out.println(" enter the details to place the order");
				Branches.placeOrder(bid);
				break;
			default:
				System.out.println(" logging out the manager");
				System.out.println("************************");
				return;
			}
		}

	}

	static void customerLogin() {
		System.out.println("\n\n\n\n***************************");
		while (true) {
			System.out.println("\n\n\n\n------------------------------------");
			System.out.println("|    Press Enter to see options     |");
			System.out.println("------------------------------------\n\n\n\n");
			scan.nextLine();
			scan.nextLine();
			System.out.println();
			System.out.println("You are Logged in as Customer\n");
			System.out.println("Welcome to the Fab Feet");
			System.out.println(" 1 to search the product\n");
			System.out.println(" 2 to check the review\n");
			System.out.println(" 3 to write the review\n");
			System.out.println(" 4 to logout as Customer\n\n\n\n");
			
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			
			System.out.println("\n");
			switch (choice) {
			case 1:
				Customers.productSearch();
				break;
			case 2:
				Customers.checkReviewbyName();
				break;
			case 3:
				System.out
						.println(" enter your product name you want to review");
				Customers.writeReview();
				break;
			default:
				System.out.println(" logging out from the Fab Feet");
				System.out.println("********************");
				return;
			}
		}
	}
	
	static void TestLogin(){
		System.out.println("\n\n\n\n***************************");
		while (true) {
			System.out.println("\n\n\n\n------------------------------------");
			System.out.println("|    Press Enter to see options     |");
			System.out.println("------------------------------------\n\n\n\n");
			scan.nextLine();
			scan.nextLine();
			System.out.println();
			System.out.println("You are Logged in as Tester\n");
			System.out.println(" Choose Table to display details of\n");
			System.out.println(" 1 Product\n");
			System.out.println(" 2 Branch\n");
			System.out.println(" 3 Customer\n");
			System.out.println(" 4 to logout from Test Mode\n\n\n\n");
			
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			
			System.out.println("\n");
			switch (choice) {
			case 1:
				Products.displayAll();
				break;
			case 2:
				Branches.ShowBranchDetails();
				break;
			case 3:
				Customers.displayAll();
				break;
			default:
				System.out.println(" logging out from the Test Mode");
				System.out.println("********************");
				return;
			}
		}
	}

	
	
	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			System.out.println("\nInvalid input valid input is [1-10]");
			System.out.println("Please enter only digits");
			System.out.println("please Restart the Application......\n\n");
		}
	}

}
