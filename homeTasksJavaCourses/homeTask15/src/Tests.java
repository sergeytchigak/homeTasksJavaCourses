
public class Tests {
	
	Massive massive;
	private int[] array;

	@BeforeMethod
	public void beforeMethod() {
		array = new int[] { 1, 2, 3, 4, 5 };
	}

	@AfterMethod
	public void afterMethod() {
		array = null;
	}

	@DataProvider(name = "testTestDataForIsEvenTest")
	public Object[][] dp() {
		return new Object[][] { { new int[] { 1, 2, 3, 4, 5 }, false }, { new int[] { 1, 2, 6, 4, 5 }, true },
				{ new int[] { -1, -2, 0, -4, -5 }, true }, { new int[] { -8, -2, -7, -4, -5 }, true }, };
	}

	@BeforeClass
	public void beforeClass() {
		massive = new Massive();
	}

	@AfterClass
	public void afterClass() {
		massive = null;
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	@Test
	public void testMax() {
		assertEquals(massive.max(array), 5);
	}

	@Test
	public void testMin() {
		assertEquals(massive.min(array), 1);
	}

	@Test
	public void testSum() {
		assertEquals(15, massive.sum(array));
	}


}
