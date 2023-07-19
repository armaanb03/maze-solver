package PE1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
// MethodOrderer.OrderAnnotation.class

@TestMethodOrder(OrderAnnotation.class)

class PE1Tester {

	/************** Task 1: 3 points ******************/
	@Test
	@Order(1)
	void test_mazeRows() {
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
				{"1010", "1000", "1001", "0101", "1100", "1001"},
				{"1100", "0011", "0101", "0110", "0011", "0101"},
				{"0101", "1101", "0110", "1001", "1110", "0000"},
				{"0110", "0011", "1110", "0010", "1010", "0011"}
		};
		Maze maze = new Maze(sample);
		assertEquals(sample.length, maze.getMaze().length, "The # of rows in the maze is not correct. Either the problem is in the constructor od in the getetr method.");
	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(2)
	void test_mazeColumns() {
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
				{"1010", "1000", "1001", "0101", "1100", "1001"},
				{"1100", "0011", "0101", "0110", "0011", "0101"},
				{"0101", "1101", "0110", "1001", "1110", "0000"},
				{"0110", "0011", "1110", "0010", "1010", "0011"}
		};
		Maze maze = new Maze(sample);
		assertEquals(sample[0].length, maze.getMaze()[0].length, "The # of columns in the maze is not correct. Either the problem is in the constructor od in the getetr method.");

	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(3)
	void test_maze_ref() {
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
				{"1010", "1000", "1001", "0101", "1100", "1001"},
				{"1100", "0011", "0101", "0110", "0011", "0101"},
				{"0101", "1101", "0110", "1001", "1110", "0000"},
				{"0110", "0011", "1110", "0010", "1010", "0011"}
		};
		Maze maze = new Maze(sample);
		assertNotSame(sample, maze.getMaze(), "Deep copy in the constructor is not correct.");
	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(4)
	void test_maze_obj1() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
				{"1010", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0110"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0010"}
		};
		Maze maze = new Maze(sample);
		assertEquals(sample[0][0], maze.getMaze()[0][0], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[1][1], maze.getMaze()[1][1], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[2][2], maze.getMaze()[2][2], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[3][3], maze.getMaze()[3][3], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[4][3], maze.getMaze()[4][3], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
	}

	/************** Task 1: 3 points ******************/
	@Test
	@Order(5)
	void test_maze_obj2() {
		String [][] sample = {{"1", "1", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "0", "0"},
				{"1", "0", "1", "0", "1", "0", "0", "0", "1", "0", "0", "1", "0", "1", "0", "1"},
				{"1", "1", "0", "0", "0", "0", "1", "1", "0", "1", "0", "1", "0", "1", "1", "0"},
				{"0", "1", "0", "1", "1", "1", "0", "1", "0", "1", "1", "0", "1", "0", "0", "1"}
		};
		Maze maze = new Maze(sample);
		assertEquals(sample[0][0], maze.getMaze()[0][0], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[1][1], maze.getMaze()[1][1], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[2][2], maze.getMaze()[2][2], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[3][3], maze.getMaze()[3][3], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[3][15], maze.getMaze()[3][15], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
	}

	/************** Task 2: 3 points ******************/
	@Test
	@Order(6)
	void test_maze_toString1() {
		String [][] sample = {{"1", "1", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "0", "0"},
				{"1", "0", "1", "0", "1", "0", "0", "0", "1", "0", "0", "1", "0", "1", "0", "1"},
				{"1", "1", "0", "0", "0", "0", "1", "1", "0", "1", "0", "1", "0", "1", "1", "0"},
				{"0", "1", "0", "1", "1", "1", "0", "1", "0", "1", "1", "0", "1", "0", "0", "1"}
		};
		Maze maze = new Maze(sample);
		String str = "[1 1 1 0 1 0 1 0 1 0 1 0 1 0 0 0]\n"
				+ "[1 0 1 0 1 0 0 0 1 0 0 1 0 1 0 1]\n"
				+ "[1 1 0 0 0 0 1 1 0 1 0 1 0 1 1 0]\n"
				+ "[0 1 0 1 1 1 0 1 0 1 1 0 1 0 0 1]";

		assertTrue(maze.toString().compareToIgnoreCase(str) == 0, " toString() does not work properly.");
	}

	/************** Task 2: 2 points ******************/
	@Test
	@Order(7)
	void test_maze_toString2() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
				{"1010", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0110"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0010"}};
		Maze maze = new Maze(sample);
		String str = "[1110 1010 1010 1000]\n"
				+ "[1010 1000 1001 0101]\n"
				+ "[1100 0011 0101 0110]\n"
				+ "[0101 1101 0110 1001]\n"
				+ "[0110 0011 1110 0010]";
		System.out.println(maze.toString());
		System.out.println(str);

		assertTrue(maze.toString().compareToIgnoreCase(str) == 0, " toString() does not work properly.");
	}

	/************** Task 3: 3 points ******************/
	@Test
	@Order(8)
	void test_maze_setUp1() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
				{"1010", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0110"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0010"}};
		Maze maze = new Maze(sample);
		PE1 pe = new PE1();
		pe.setup(sample);
		assertEquals(sample[0][0], pe.dogMaze.getMaze()[0][0], "The Setup method is nto correct");
		assertEquals(sample[1][1], pe.dogMaze.getMaze()[1][1], "The Setup method is nto correct");
		assertEquals(sample[2][2], pe.dogMaze.getMaze()[2][2], "The Setup method is nto correct");
		assertEquals(sample[3][3], pe.dogMaze.getMaze()[3][3], "The Setup method is nto correct");
		assertEquals(sample[4][3], pe.dogMaze.getMaze()[4][3], "The Setup method is nto correct");
	}
	/************** Task 3: 2 points ******************/
	@Test
	@Order(9)
	void test_maze_setUp2() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
				{"1010", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0110"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0010"}};
		Maze maze = new Maze(sample);
		PE1 pe = new PE1();
		pe.setup(sample);
		assertNotSame(sample, pe.dogMaze, "The setup method is not correct. The dogMaze shoudl be stored in different place in memory.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(10)
	void test_maze_enoughGate1() {
		String [][] sample = {{"1110", "1010", "1010", "1001"},
				{"1110", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);

		assertFalse(pe.enoughGate(), "The maze has no entrance and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(11)
	void test_maze_enoughGate2() {
		String [][] sample = {{"0110", "1010", "1010", "1001"},
				{"1110", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		assertFalse(pe.enoughGate(), "The maze has one entrance on top and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(12)
	void test_maze_enoughGate3() {
		String [][] sample = {{"0110", "0010", "0010", "0001"},
				{"1010", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0001", "1110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		assertTrue(pe.enoughGate(), "The maze has one entrance at left  and 4 at top, and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(13)
	void test_maze_enoughGate4() {
		String [][] sample = {{"0110", "1010", "1010", "1001"},
				{"1010", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);

		assertTrue(pe.enoughGate(), "The maze has exactly two entrances (top and left) entrance and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(14)
	void test_maze_enoughGate5() {
		String [][] sample = {{"1110", "1010", "1010", "1001"},
				{"1110", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0001"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		assertFalse(pe.enoughGate(), "The maze has one entrance at the bottom and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(15)
	void test_maze_enoughGate6() {
		String [][] sample = {{"1110", "1010", "1010", "1001"},
				{"1110", "1000", "1001", "0100"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0010"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		System.out.println(pe.enoughGateHelper(0,0));
		assertFalse(pe.enoughGate(), "The maze has one entrance at left and the method does not work for this example.");
	}
	/************** Task 4: 2 points ******************/
	@Test
	@Order(16)
	void test_maze_enoughGate7() {
		String [][] sample = {{"0000", "1010", "1010", "1001"},
				{"1110", "1000", "1001", "0101"},
				{"1100", "0011", "0101", "0111"},
				{"0101", "1101", "0110", "1001"},
				{"0110", "0011", "1110", "0000"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		assertTrue(pe.enoughGate(), "The maze has 4 entrance at left top corner and right bottom corner and the method does not work for this example.");
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(17)
	public void testFindPath1() {
		String path = "(0,0)(1,0)(1,1)";
		String [][] sample = {{"1001", "1101"},
				{"0110", "0010"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(0, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 2x2");
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(18)
	public void testFindPath2() {
		String path = "(0,0)(0,0)";
		String [][] sample = {{"0001", "1101"},
				{"0110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		System.out.println(pe.findPath(0, 0));
		boolean result = (pe.findPath(0, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 2x2, where the gates are perpendicular.");
	}

	/************** Task 5: 5 points ******************/
	@Test
	@Order(19)
	public void testFindPath3() {
		String path = "(0,0)(1,0)(2,0)(2,1)(2,2)(1,2)(0,2)";
		String [][] sample = {{"1000", "1001", "1100"},
				{"0101", "0111", "0101"},
				{"0110", "1010", "0011"},
		};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(0, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 3x3, where one gate is (0, 0) and another at (0,2)");
	}

	/************** Task 5: 5 points ******************/
	@Test
	@Order(20)
	public void testFindPath4() {
		String path1 = "(3,0)(3,1)(2,1)(2,2)(1,2)(0,2)(0,3)";
		String path2 = "(3,0)(3,1)(3,2)(3,3)(2,3)(1,3)(0,3)";
		String [][] sample = {{"1100", "1001", "1100", "0001"},
				{"0100", "0011", "0101", "0101"},
				{"0111", "1100", "0011", "0101"},
				{"1010", "0010", "1010", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		String res = pe.findPath(3, 0);
		boolean result = (res.compareTo(path1) == 0 || res.compareTo(path2) == 0)? true: false;
		assertTrue(result, "findPath is not correct for a maze of 4x4, where two paths are possible. The gates are at (3, 0)and (0,3)");
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(21)
	public void testFindPath5() {
		String path = "(3,1)(2,1)(1,1)(1,2)(2,2)(3,2)(3,3)(2,3)(1,3)(0,3)(0,2)";
		String [][] sample = {{"1101", "1110", "0010", "1001"},
				{"0101", "1100", "1001", "0101"},
				{"0100", "0001", "0101", "0101"},
				{"0111", "0101", "0110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(3, 1)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 4x4, where one gate is (3, 1) and another at (0,2)");
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(22)
	public void testFindPath6() {
		String path = "(1,0)(1,1)(1,2)(2,2)(3,2)(3,3)(4,3)(4,4)(4,5)(3,5)";
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
				{"1010", "1000", "1001", "0101", "1100", "1001"},
				{"1100", "0011", "0101", "0110", "0011", "0101"},
				{"0101", "1101", "0110", "1001", "1110", "0000"},
				{"0110", "0011", "1110", "0010", "1010", "0011"}
		};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(1, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 5x6, where one gate is (1, 0) and another at (3,5)");
	}



}
