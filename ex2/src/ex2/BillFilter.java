package ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class BillFilter {

	public void filterBills(ArrayList<Bill> bills) {
		Date currentDate = new Date();
		Calendar oneMonthAgo = Calendar.getInstance();
		oneMonthAgo.setTime(currentDate);
		oneMonthAgo.add(Calendar.MONTH, -1);
		oneMonthAgo.add(Calendar.DAY_OF_MONTH, 1);

		Calendar twoMonthsAgo = Calendar.getInstance();
		twoMonthsAgo.setTime(currentDate);
		twoMonthsAgo.add(Calendar.MONTH, -2);
		twoMonthsAgo.add(Calendar.DAY_OF_MONTH, 1);
		Iterator<Bill> i = bills.iterator();

		String[] southRegion = new String[] { "SC", "RS", "PR" };
		while (i.hasNext()) {
			Bill bill = i.next();
			if (bill.getValue() < 2000) {
				i.remove();
			} else if (bill.getValue() >= 2000 && bill.getValue() < 2500
					&& bill.getDate().before(oneMonthAgo.getTime())) {
				i.remove();
			} else if (bill.getValue() >= 2500 && bill.getValue() < 3000
					&& bill.getClient().getInclusionDate().before(twoMonthsAgo.getTime())) {
				i.remove();
			} else if (bill.getValue() > 4000 && Arrays.asList(southRegion).contains(bill.getClient().getState())) {
				i.remove();
			}

		}
	}
}
