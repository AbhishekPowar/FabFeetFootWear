package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import persistance.ProductsDAO;
import sun.awt.DisplayChangedListener;

public class Products {
	private int productId;
	private String productName;
	static BufferedReader scan;
	static {
		try {
			scan = new BufferedReader(new InputStreamReader(System.in));

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName="
				+ productName + "]";
	}

	public static void addProduct() {
		try {
			Products prod = new Products();
			System.out.println("Enter Product ID");
			prod.setProductId(Integer.parseInt(scan.readLine()));

			System.out.println("Enter Product Name");
			prod.setProductName(scan.readLine());

		} catch (Exception e) {
			System.out.println("Buffer Read error");
			e.printStackTrace();
		}
	}
	
	public static void displayAll(){
		ProductsDAO.displayAll();
	}
	
	public static void main(String[] args) {
		displayAll();
	}

}
