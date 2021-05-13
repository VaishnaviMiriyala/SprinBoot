package com.capg.msc.myShoppingCart.exception;

public class InvalidCostException extends Exception{
	private int cost;

	public InvalidCostException() {
		super();
	}
	

	public InvalidCostException(int cost) {
		super();
		this.cost = cost;
	}


	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public InvalidCostException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
