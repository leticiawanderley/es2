package ex2;

import java.util.Date;

public class Bill {

	private int code;
	private double value;
	private Date date;
	private Client client;

	public Bill(int code, double value, Date date, Client client) {
		this.code = code;
		this.value = value;
		this.date = date;
		this.client = client;
	}

	public Bill() {
	}

	public int getCode() {
		return this.code;
	}

	public double getValue() {
		return this.value;
	}

	public Date getDate() {
		return this.date;
	}

	public Client getClient() {
		return this.client;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
