package ex2;

import java.util.Date;

/**
 * Represents a client
 * 
 * @author leticiawanderley
 *
 */
public class Client {

	private String name;
	private Date inclusionDate;
	private String state;

	/**
	 * Client constructor
	 * 
	 * @param name
	 *            client name
	 * @param inclusionDate
	 *            date when the client joined the system
	 * @param state
	 *            client's Brazilian state two-letter code
	 */
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
