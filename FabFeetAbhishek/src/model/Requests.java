package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import persistance.RequestsDAO;

public class Requests {
	@Override
	public String toString() {
		return "Requests [requestId=" + requestId + ", branchId=" + branchId + ", requestMsg=" + requestMsg + "]";
	}

	static BufferedReader br ;
	static {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			System.out.println("Error in Reviews, Buffer initialization");
		}
	}

	private int requestId;
	private int branchId;
	private String requestMsg;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getRequestMsg() {
		return requestMsg;
	}
	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}
	public void display(){
		System.out.println(this.toString());
	}
	
	public static void sendRequest(int bid){
		Requests req = new Requests();
		try {
					
			
//			System.out.println("Enter BrachID ");
//			req.setBranchId(Integer.parseInt(Requests.br.readLine()));
			req.setBranchId(bid);
			
			System.out.println("Enter Request Msg");
			req.setRequestMsg(Requests.br.readLine());

			RequestsDAO.insertToRequests(req);


		} catch (Exception e) {
			System.out.println("Error in addRequest");
		}
		
	}
	
	public static void displayRequest(){
		
	}
	
	public static void displayRequestByBranch(int bid){
		RequestsDAO.displayAllByBranchID(bid);
		
	}
}
