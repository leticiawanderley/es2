package ex2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class BillFilterTest {

	private BillFilter filter;

	private Client clientInclusionDate2Months;
	private Client clientSouthSC;
	private Client clientSouthPR;
	private Client clientSouthRS;
	private Client clientNortheast; 
	private Date oneMonthAgo;
	private Date currentDate;
	
	@Before
	public void setUp() {
		currentDate = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(currentDate); 
		c.add(Calendar.MONTH, -1);
		oneMonthAgo = c.getTime();
		Calendar c2 = Calendar.getInstance(); 
		c2.setTime(currentDate);
		c2.add(Calendar.MONTH, -2);
		clientNortheast = new Client("Beltrano", currentDate, "AL");
		clientInclusionDate2Months = new Client("Sicrano", c2.getTime(), "PB");
		clientSouthSC = new Client("Fulano", currentDate, "SC");
		clientSouthPR = new Client("Chico", currentDate, "PR");
		clientSouthRS = new Client("Jacob", currentDate, "RS");
		
		filter = new BillFilter();
	}

	@Test
	public void emptyList() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		assertTrue(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}

	@Test
	public void firstCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(1, 600.0, currentDate, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void firstCriteriaMaxLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(17, 1999.0, currentDate, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void firstCriteriaMaxPlusLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(27, 2000.0, currentDate, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}

	@Test
	public void secondCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(2, 2250.0, oneMonthAgo, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void secondCriteriaMinLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(2, 2000.0, oneMonthAgo, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void secondCriteriaMaxLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(30, 2499.0, oneMonthAgo, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void secondCriteriaMaxPlusLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(31, 2500.0, oneMonthAgo, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
	
	@Test
	public void thirdCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(3, 2790.0, oneMonthAgo, clientInclusionDate2Months));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void thirdCriteriaMaxLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(76, 2990.0, oneMonthAgo, clientInclusionDate2Months));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void thirdCriteriaMaxPlusLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(77, 3000.0, oneMonthAgo, clientInclusionDate2Months));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
	
	@Test
	public void fourthCriteriaSC() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(4, 6000.0, currentDate, clientSouthSC));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void fourthCriteriaMinLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(49, 4001.0, currentDate, clientSouthSC));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void fourthCriteriaMinMinusLimit() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(48, 4000.0, currentDate, clientSouthSC));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
	
	@Test
	public void fourthCriteriaPR() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(10, 4010.0, currentDate, clientSouthPR));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void fourthCriteriaRS() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(11, 5005.0, currentDate, clientSouthRS));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test 
	public void notToBeFilteredFirstCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(5, 2010.0, currentDate, clientNortheast));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
	
	@Test 
	public void notToBeFilteredSecondCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(7, 2450.0, currentDate, clientSouthSC));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
	
	@Test 
	public void notToBeFilteredThirdCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(6, 2780.0, currentDate, clientSouthSC));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
	
	@Test 
	public void notToBeFilteredFourthCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(6, 5000.0, currentDate, clientInclusionDate2Months));
		assertFalse(bills.isEmpty());
		filter.filterBills(bills);
		assertFalse(bills.isEmpty());
	}
}
