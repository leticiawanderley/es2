package ex2;

import java.util.Date;

public class Client {
	
	private String name;
	private Date inclusionDate;
	private String state;

	public Client(String name, Date inclusionDate, String state) {
		this.name = name;
		this.inclusionDate = inclusionDate;
		this.state = state;
	}

	public Client() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInclusionDate(Date inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public Date getInclusionDate() {
		return inclusionDate;
	}

	public String getState() {
		return state;
	}
}
