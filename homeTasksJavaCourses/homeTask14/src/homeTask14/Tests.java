package homeTask14;

public class Tests {
	
	Massive massive;
	static int[] array;

	@BeforeClass
	public static void setUpOnce() {
		array = new int[] { 1, 2, 3, 4, 5 };
	}

	@AfterClass
	public static void tearDownOnce() {
		array = null;
	}

	@Before
	public void setUp() {
		massive = new Massive();
	}

	@After
	public void tearDown() {
		massive = null;
	}

	@Test
	public void testMax() {
		assertEquals(5, massive.max(array));
	}

	@Test
	public void testMin() {
		assertEquals(1, massive.min(array));
	}

	@Test
	public void testSum() {
		assertEquals(15, massive.sum(array));
	}

}
