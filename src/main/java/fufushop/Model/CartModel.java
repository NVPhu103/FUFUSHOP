package fufushop.Model;

import java.util.List;

public class CartModel {
	private int quantity;
	private double totalMoney;
	private int userID;
	private List<CartDetailModel> listCartDetail;
	
	
	public CartModel() {
		super();
	}
	public CartModel(int quantity, double totalMoney, int userID) {
		super();
		this.quantity = quantity;
		this.totalMoney = totalMoney;
		this.userID = userID;
	}
	public List<CartDetailModel> getListCartDetail() {
		return listCartDetail;
	}
	public void setListCartDetail(List<CartDetailModel> listCartDetail) {
		this.listCartDetail = listCartDetail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
