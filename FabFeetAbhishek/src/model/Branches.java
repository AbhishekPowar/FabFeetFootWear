package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedOutputStream;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;
import persistance.*;

import persistance.OrdersDAO;

import java.io.InputStreamReader;

public class Branches {
	 String branchName;
	 int branchId;
	 int managerId;
	 String managerPassword;
	
	static Scanner scanner = new Scanner(System.in);
	static BufferedReader scan;
	static {
		try {
			scan = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
   
	public  static void addProduct(int bid){
			InventoryDAO.insertIntoInventory(bid);
		}
	public static  void displayBranchStock(int bid)
	{
		Inventory.displayBranchStock(bid);
		return;
		
	}
	
	public static  void sendRequest(int bid) {
		Requests.sendRequest(bid);
		
		
	}
	public static void addCustomer(){
		Customers.addCustomer();
		
	}


	public static void placeOrder(int bid){
		Orders.placeOrder(bid);
	}
	
	public static void displayEmployees(int bid) {
		Employees.displayAllByBranchID(bid);
		return;
	}

	public static void ShowBranchDetails(){
		BranchesDAO.ShowBranchDetails();
	}
	@Override
	public String toString() {
		return "Branches [branchName=" + branchName + ", branchId=" + branchId
				+ ", managerId=" + managerId + ", managerPassword="
				+ managerPassword + "]";
	}

	public void display(){
		System.out.println(this.toString());
	}
//	public static void main(String[] args) {
//		Branches manager = new Branches();	
//		
//		manager.displayEmployees(1);
//		
//		
//		
//		
//	}

}
