package rocketBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.RateException;

public class rate_test {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	@Test(expected = RateException.class)
	public void Rateexceptiontest() throws RateException {
		RateBLL.getRate(400);
	}

}
