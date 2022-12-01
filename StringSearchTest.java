import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class StringSearchTest {

	private StringSearch testObj;
	private ByteArrayOutputStream outContent;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testObj = new StringSearch();
		
	}

	@After
	public void tearDown() throws Exception {

	}
	
    /*
     * test Run method with invalid input
     * @result method should print "Invalid input"
     */
	@Test
	public void testRun() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		String[] testArray = new String[1];
		testArray[0] = "test";
	    testObj.run(testArray);
		assertEquals("Invalid input", outContent.toString().trim());
	}
	
	/*
     * test for readFile method with valid input
     * @result Should print the valid lines in the file
     */
	@Test
	public void testReadFileValid() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		testObj.readFile("test.txt", "tim");
		assertEquals("hello my name is tim", outContent.toString().trim());
	}
	
	/*
     * test for readFile method with invalid input
     * @result Should print "File not found."
     */
	@Test
	public void testReadFileInvalid() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		testObj.readFile("test1.txt", "tim");
		assertEquals("File not found.", outContent.toString().trim());
	}
	
	/*
     * test SearchLine with input that should generate a print
     * @result should print the line if it contains the string
     */
	@Test
	public void testSearchLine() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		testObj.searchLine("Hi my name is tim", "name");
		assertEquals("Hi my name is tim", outContent.toString().trim());
	}
	
	
	/*
     * test SearchLine with input not generating a print
     * @result should print nothing
     */
	@Test
	public void testSearchLine2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		testObj.searchLine("Hi my name is tim", "Hello");
		assertEquals("", outContent.toString().trim());
	}
	
	

}
