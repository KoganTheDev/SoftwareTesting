package testingCourse.lab2_currencyEditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyBagTest {
	private Money m12NIS;
	private Money m3NIS;
	private Money m12USD;
	private Money m1NISNegative;
	private Money m1NIS;
	private Money m4NIS; 
	private Money m7NIS;
	private Money m1USD;
	
	@BeforeEach
	void setUp() throws Exception {
		// (1) Setting up input and expected result. 
		m12NIS = new Money(12, "NIS");
		m3NIS = new Money(3, "NIS");
		m12USD = new Money(12, "USD");
		m1NISNegative = new Money(-1, "NIS");
		m1NIS = new Money(1, "NIS");
		m1USD = new Money(1, "USD");
		m4NIS = new Money(4, "NIS");
		m7NIS = new Money(7, "NIS");
	}
	
	@Test
	// Checking functionality: Adding the same type of money to a MoneyBag
	// Input data: Object Money amount 12, type NIS
	//			   Object Money amount 3, type NIS
	// Expected result: 15NIS (Object Money(15, "NIS"))
	public final void testAdd_Same_Currency() {
		// (1) Setting up input and expected result.
		Money expected = new Money(15, "NIS"); 

		// (2) Invoke method on result.
		Money result = (Money)m12NIS.addMoney(m3NIS);
		
		// (3) Check if the result is the same as the expected value.
		assertEquals(expected, result);	
	}
	
	@Test
	// Checking functionality: Adding the different type of money to a MoneyBag
	// Input data: Object Money amount 12, type NIS
	//			   Object Money amount 3, type USD
	// Expected result: 15NIS,3USD (Object MoneyBag(15, "NIS", 3, "USD"))
	public final void testAdd_Different_Currency() {
		MoneyBag expected = new MoneyBag(m12USD, m3NIS); 

		// (2) Invoke method on result.
		MoneyBag result = (MoneyBag)m12USD.addMoney(m3NIS);
		
		// (3) Check if the result is the same as the expected value.
		assertEquals(expected, result);		
	}
	
	@Test
	// Checking functionality: Adding the different type of money to a MoneyBag
	// Input data: Object Money amount 12, type NIS
	//			   Object Money amount -1, type NIS
	// Expected result: m11 (Object MoneyBag(11, "NIS"))
	public final void testAdd_Negative_Currency() {
		Money expected = new Money(11, "NIS"); 

		// (2) Invoke method on result.
		Money result =(Money)m12NIS.addMoney(m1NISNegative);
		
		// (3) Check if the result is the same as the expected value.
		assertEquals(expected, result);		
	}
	
	@Test
	// Checking functionality: Adding the different type of money to a MoneyBag
	// Input data: Object Money amount 1, type NIS
	//			   Object Money amount -1, type NIS
	// Expected result: m0 (Object Money())
	public final void testAdd_Close_Money_Bag() {
		MoneyBag expected = new MoneyBag(); 
		
		assertEquals(expected, m1NIS.addMoney(m1NISNegative));		
	}
	
	// Test cases for contains.
	
	@Test
	// Checking functionality: Checking if a MoneyBag contains a currency.
	// Input data: Object Money amount 3, type NIS.
	//			   Object Money amount 4, type NIS.
	// expected result: True
	public final void testContains() {
		MoneyBag expected = new MoneyBag(m3NIS, m4NIS);
		assertTrue(expected.contains(m7NIS));
	}
	
	@Test
	// Checking functionality: Checking if the amount of currency in the bag is the same as the amount looked for.
	// Input data: Object Money amount 3, type NIS.
	//			  Object Money amount 4, type NIS.
	// Expected result: True.
	public final void testContainsDifferentAmountOfMoney() {
		MoneyBag result = (MoneyBag) m1USD.addMoney(m1NIS);
		
		assertTrue(result.contains(m1NIS) && result.contains(m1USD));
	}
	
	@Test
	// Checking functionality: Checking if adding two different currencies will result in a a new MoneyBag that contains both currencies.
	// Input data: Object Money amount 1, type NIS.
	// 			   Object Money amount 1, type USD.
	// Expected result: True.
	public final void testAdding_Two_Different_Currencies() {
		// (1) Set-up done above.
		MoneyBag expected = new MoneyBag(m1USD, m1NIS);
		
		// (2) Invoke the tested method.
		MoneyBag result = (MoneyBag)m1NIS.addMoney(m1USD);
		
		// Check if the result is the same as the expected value.
		assertTrue(expected.equals(result));
	}
}
