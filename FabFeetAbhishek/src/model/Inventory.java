package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import persistance.EmployeesDAO;
import persistance.InventoryDAO;

public class Inventory {
	private int productId;
	private int branchId;
	private int size;
	private int quantity;
	private double price;
	
	static BufferedReader br;
	static {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", branchId=" + branchId
				+ ", size=" + size + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	public void display(){
		System.out.println(this.toString());
	}
	
	
	public static void displayBranchStock(int bid) {
		// call the dislayBrnachStockdao
		InventoryDAO.displayStockById(bid);
		return;
	}
	
	public static void displayAllStock() {

		InventoryDAO.displayAllStock();
		return;
	}
	
	public static void productSearch()
	{
		System.out.println(" enter the product name to search");
		try {
			String name= br.readLine();
			InventoryDAO.getProductbyName(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void updateInventory(int pid,int bid,int size,int quantity){
		InventoryDAO.updateInventory(pid, bid, size, quantity);
	}
	
	public static  Map<Integer, ArrayList<Double>>  getProductbyIdAndBid(int pid,int bid){
		return InventoryDAO.getProductbyIdAndBid(pid, bid);
	}
	
}
