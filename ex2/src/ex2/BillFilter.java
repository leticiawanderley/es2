package ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Filter class for bills
 * 
 * @author leticiawanderley
 *
 */
public class BillFilter {

	/**
	 * Removes bills from list following specific criteria
	 * 
	 * @param bills
	 *            collection of bills
	 */
	public void filterBills(ArrayList<Bill> bills) {
		Date currentDate = new Date();
		Iterator<Bill> i = bills.iterator();
		while (i.hasNext()) {
			Bill bill = i.next();
			if (firstCriteria(bill)) {
				i.remove();
			} else if (secondCriteria(currentDate, bill)) {
				i.remove();
			} else if (thirdCriteria(currentDate, bill)) {
				i.remove();
			} else if (fourthCriteria(bill)) {
				i.remove();
			}

		}
	}

	/**
	 * Specification first criteria: checks if bill's value is lower than 2000
	 * 
	 * @param bill
	 *            client bill
	 * @return true if value is lower than 2000, false otherwise
	 */
	private boolean firstCriteria(Bill bill) {
		return bill.getValue() < 2000;
	}

	/**
	 * Specification second criteria: checks if bill's value is between 2000 and
	 * 2500, and if bill was installed more than 1 month before
	 * 
	 * @param currentDate
	 *            present-day date
	 * @param bill
	 *            client bill
	 * @return true if bill passes the second criteria, false otherwise
	 */
	private boolean secondCriteria(Date currentDate, Bill bill) {
		return bill.getValue() >= 2000 && bill.getValue() < 2500
				&& getDateOneMonthAgo(currentDate).after(bill.getDate());
	}

	/**
	 * Specification third criteria: checks if bill's value is between 2500 and
	 * 3000, and if bill's client was included more than 2 months ago
	 * 
	 * @param currentDate
	 *            present-day date
	 * @param bill
	 *            client bill
	 * @return true if bill passes the third criteria, false otherwise
	 */
	private boolean thirdCriteria(Date currentDate, Bill bill) {
		return bill.getValue() >= 2500 && bill.getValue() < 3000
				&& getDateTwoMonthsAgo(currentDate).after(bill.getClient().getInclusionDate());
	}

	/**
	 * Specification fourth criteria: checks if bill's value is higher than 4000
	 * and if bill's client lives on south Brazil
	 * 
	 * @param currentDate
	 *            present-day date
	 * @param bill
	 *            client bill
	 * @return true if bill passes the fourth criteria, false otherwise
	 */
	private boolean fourthCriteria(Bill bill) {
		String[] southRegion = new String[] { "SC", "RS", "PR" };
		return bill.getValue() > 4000 && Arrays.asList(southRegion).contains(bill.getClient().getState());
	}

	/**
	 * Calculates date one month past the current date
	 * 
	 * @param currentDate
	 *            present-day date
	 * @return date one month before current
	 */
	private Date getDateOneMonthAgo(Date currentDate) {
		Calendar oneMonthAgo = Calendar.getInstance();
		oneMonthAgo.setTime(currentDate);
		oneMonthAgo.add(Calendar.MONTH, -1);
		oneMonthAgo.add(Calendar.DAY_OF_MONTH, 1);
		return oneMonthAgo.getTime();
	}

	/**
	 * Calculates date two months past the current date
	 * 
	 * @param currentDate
	 *            present-day date
	 * @return date two months before current
	 */
	private Date getDateTwoMonthsAgo(Date currentDate) {
		Calendar twoMonthsAgo = Calendar.getInstance();
		twoMonthsAgo.setTime(currentDate);
		twoMonthsAgo.add(Calendar.MONTH, -2);
		twoMonthsAgo.add(Calendar.DAY_OF_MONTH, 1);
		return twoMonthsAgo.getTime();
	}
}
