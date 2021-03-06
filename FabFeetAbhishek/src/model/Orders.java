package model;

import java.sql.Date;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import persistance.OrdersDAO;

public class Orders {

	private int orderId;
	private int customerId;
	private int productId;
	private int branchId;
	private int size;
	private int quantity;
	private double amount;
	private String orderDate;
	static BufferedReader br;
	static {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getbranchId() {
		return branchId;
	}

	public void setbranchId(int branchId) {
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId
				+ ", productId=" + productId + ", branchId=" + branchId
				+ ", size=" + size + ", quantity=" + quantity + ", amount="
				+ amount + ", orderDate=" + orderDate + "]";
	}

	static int getValidSize(Map<Integer, ArrayList<Double>> OrdSizeMap) {
		int size;

		try {
			System.out.println("\nEnter Product Size");
			size = Integer.parseInt(br.readLine());
			if (OrdSizeMap.containsKey(size)) {
				return size;
			} else {
				System.out.println("\ninvalid Size " + size);
				System.out
						.println("Available Sizes are " + OrdSizeMap.keySet());
				System.out.println("1. Retry and 2. Cancel");
				int choice;
				choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					return getValidSize(OrdSizeMap);
				}
				return -1;
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	static int getValidQuantity(double inventoryQuantity) {
		int quantity;

		try {
			System.out.println("\nEnter Product Quantity");
			quantity = Integer.parseInt(br.readLine());
			if (inventoryQuantity >= quantity) {
				return quantity;
			} else {
				System.out.println("\nInvalid Quantity");
				System.out
						.println("Available quantity is " + inventoryQuantity);
				System.out.println("1. Retry and 2. Cancel");
				int choice;
				choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					return getValidQuantity(inventoryQuantity);
				}
				return -1;
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static void placeOrder(int bid) {

		int orderId = 0;
		int customerId;
		int productId;
		int branchId;
		int size;
		int quantity;
		double amount;
		String orderDate;

		try {
			Orders order = new Orders();

			System.out.println("Enter Customer Id");
			customerId = Integer.parseInt(br.readLine());
			if (Customers.customerExists(customerId) != true) {
				System.out.println("Customer Not Registered");
				return;
			}

			System.out.println("Enter Product Id");
			productId = Integer.parseInt(br.readLine());

			// System.out.println("Enter Branch Id");
			// branchId = Integer.parseInt(scan.readLine());
			branchId = bid;

			System.out.println("");
			Map<Integer, ArrayList<Double>> OrdSizeMap = Inventory
					.getProductbyIdAndBid(productId, bid);
			if (OrdSizeMap != null) {

				// System.out.println("\nEnter Product Size");
				size = getValidSize(OrdSizeMap);
				if (size == -1) {
					return;
				}
				ArrayList<Double> data = OrdSizeMap.get(size);
				double inventoryQuantity = data.get(0);
				double InventoryPrice = data.get(1);

				// System.out.println("Enter Product Quantity");
				quantity = getValidQuantity(inventoryQuantity);

				if (quantity == -1) {
					return;
				}
				// System.out.println("Enter Product Cost");
				// amount = Integer.parseInt(br.readLine());
				amount = InventoryPrice;

				// System.out.println("Enter Date");
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String ts = sdf.format(timestamp);
				orderDate = ts;

				order.setOrderId(orderId);
				order.setCustomerId(customerId);
				order.setProductId(productId);
				order.setbranchId(branchId);
				order.setSize(size);
				order.setQuantity(quantity);
				order.setAmount(amount);
				order.setOrderDate(orderDate);

				OrdersDAO.placeOrder(order);

			} else {
				System.out.println("Product not available");
			}
			// order.display();

		} catch (Exception e) {
			System.out.println("Unable to place order");
			e.printStackTrace();

		}

	}

	public static void displayAllOrders() {
		OrdersDAO.displayAllOrdersD();
		return;
	}

	public static void displayBranchOrders(int bid) {
		OrdersDAO.displayByBranch(bid);

		return;
	}
	// public static void main(String[] args) {
	// placeOrder(1);
	//
	// }

}
