import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class GradeBookTester {

	private GradeBook gradebookOne;
	private GradeBook gradebookTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		Random rand = new Random();
		gradebookOne = new GradeBook(5);
		gradebookTwo = new GradeBook(5);
		
		//Using object gradebookOne calls addScore method, passes in doubles
		gradebookOne.addScore(34); 
		gradebookOne.addScore(82); 
		gradebookOne.addScore(90);

		//Using object gradebookTwo calls addScore method, passes in doubles
		gradebookTwo.addScore(98);
		gradebookTwo.addScore(74);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebookOne = null;
		gradebookTwo = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradebookOne.toString().equals("34.0 82.0 90.0 ")); //Checks if toString returns correct String
		assertTrue(gradebookTwo.toString().equals("98.0 74.0 ")); //Checks if toString returns correct String
	}

	@Test
	void testSum() {
		assertEquals(206, gradebookOne.sum(), 0.0001); //Tests the sum of gradebookOne's scores
		assertEquals(172, gradebookTwo.sum(), 0.0001); //Tests the sum of gradebookTwo's scores
	}

	@Test
	void testMinimum() {
		assertEquals(34, gradebookOne.minimum(), 0.001); //Checks if minimum is 34
		assertEquals(74, gradebookTwo.minimum(), 0.001); //Checks if minimum is 74
	}

	@Test
	void testFinalScore() {
		assertEquals(172, gradebookOne.finalScore()); //Checks if the final score for gradebookOne is 172
		assertEquals(98, gradebookTwo.finalScore()); //Checks if the final score for gradebookTwo is 98
	}
}
