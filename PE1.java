package PE1;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Armaanjeet Braich
Student Number: 218834630
Course Section: A
*/


public class PE1 {
	Maze dogMaze;

	/**
	 * This method sets up the maze using the given input argument
	 * @param maze is a maze that is used to construct the dogMaze
	 */
	public void setup(String[][] maze) {
		this.dogMaze = new Maze(maze);	// initialize the maze object into the dogMaze class variable
	}

	/**
	 * This method returns true if the number of 
	 * gates in dogMaze >= 2. 
	 * @return it returns true, if enough gate exists (at least 2), otherwise false.
	 */
	public boolean enoughGate () {
		if (enoughGateHelper(0, 0) >= 2) {	// checks if the enoughGateHelper finds 2 or more gates, and returns true if it does
			return true;
		}
		return false;	// returning false if there are less than 2 gates
	}

	/**
	 * This method returns the number of gates in the given maze
	 * @pre parameters row and column are 0
	 * @param row is the row index of where the recursion starts
	 * @param column is the column index of where the recursion starts
	 * @return returns the number of gates in the maze, to be used in the enoughGate method
	**/
	public int enoughGateHelper(int row, int column) {
		if (row == 1 && column == 0) {	// if the method reaches the last cell to check, return if it is a gate or not
			return gateChecker(dogMaze.getMaze()[row][column],row,column);
		} else if (dogMaze.getMaze().length == 1 && column == dogMaze.getMaze()[row].length-1) {	// if the maze is 1xn it ensures it stops checking the perimeter after the first row
			return gateChecker(dogMaze.getMaze()[row][column], row, column);
		} else if (row == 0 && column < dogMaze.getMaze()[row].length - 1) {	// if checking the first row, move over a column
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row, column + 1);
		} else if (row == 0 && column == dogMaze.getMaze()[row].length - 1) {	// if the corner is reached in the first row, move down a row
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row + 1, column);
		} else if (column == dogMaze.getMaze()[row].length - 1 && row < dogMaze.getMaze().length - 1) {	// if traversing the last column, move down a row
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row + 1, column);
		} else if (column == dogMaze.getMaze()[row].length - 1 && row == dogMaze.getMaze().length - 1) {	// if the bottom right corner is reached, begin moving left a column
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row, column - 1);
		} else if (row == dogMaze.getMaze().length - 1 && column > 0) {	// if on the bottom row, move left a column
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row, column - 1);
		} else if (row == dogMaze.getMaze().length - 1 && column == 0) { // if the bottom left corner is reached, begin moving up a row
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row - 1, column);
		} else if (column == 0 && row > 0) {	// if on the first column and not at the starting point, continue moving up a row
			return gateChecker(dogMaze.getMaze()[row][column], row, column) + enoughGateHelper(row - 1, column);
		} else {
			return 0;	// if none of the cells are gates, return 0
		}
	}

	/**
	 * This method checks if a string in the maze array is a gate
	 * @param gate is the string which will be checked for whether it is a gate or not
	 * @param row is the row at which this gate is located
	 * @param column is the column at which this gate is located
	 * @return this method returns an integer, 2 if the string a corner gate with 2 openings (2 gates), 1 if the string
	 * is a typical gate, and 0 if the string is not a gate
	 */
	public int gateChecker(String gate, int row, int column) {
		if (row == 0 && column == 0 && gate.charAt(0) == '0' && gate.charAt(1) == '0') {	// if checking the top left and the top and left is open, return 2 gates
			return 2;
		} else if (row == 0 && column == dogMaze.getMaze()[row].length-1 && gate.charAt(0) == '0' && gate.charAt(3) == '0') {	// if checking the top right and the top and right are open, return 2 gates
			return 2;
		} else if (column == dogMaze.getMaze()[row].length-1 && row == dogMaze.getMaze().length-1 && gate.charAt(2) == '0' && gate.charAt(3) == '0') {	// if checking the bottom right and the bottom and right are open, return 2 gates
			return 2;
		} else if (column == 0 && row == dogMaze.getMaze().length-1 && gate.charAt(1) == '0' && gate.charAt(2) == '0') {	// if checking the bottom left and the bottom and left gates are open, return 2 gates
			return 2;
		} else if (row == 0 && gate.charAt(0) == '0') {	// if checking a cell on first row and the top is open, return 1 gate
			return 1;
		} else if (column == dogMaze.getMaze()[0].length - 1 && gate.charAt(3) == '0') {	// if if checking a cell on the last column and the right is open, return 1 gate
			return 1;
		} else if (row == dogMaze.getMaze().length - 1 && gate.charAt(2) == '0') {	// if checking a cell on the last row and the bottom is open, return 1 gate
			return 1;
		} else if (column == 0 && gate.charAt(1) == '0') {	// if checking the first column and the left is open, return 1 gate
			return 1;
		} else {	// extra case to have a return (this should never be reached)
			return 0;
		}
	}

	/**
	 * This method finds a path from the entrance gate to 
	 * the exit gate. 
	 * @param row is the index of the row, where the entrance is.
	 * @param column is the index of the column, where the entrance is.
	 * @return it returns a string that contains the path from the start to the end. 
	 * The return value should have a pattern like this (i,j)(k,l),...
	 * The first pair of the output must show the entrance given as the 
	 * input parameter (i.e. (row,column)
	 * No whitespace is allowed in the output.  
	 */
	public String findPath (int row, int column) {
		String[] outString = {""};	// defining an array with 1 string to pass by reference into the helper findPath method, so it changes in the boolean method
		int[] nextCoords = nextCellFinder(row, column);	// using the nextCellFinder method to find the next cell to pass into the exit finder
		int[] exitCoords = exitFinder(nextCoords[0], nextCoords[1]);	// find the exit cell using the exitFinder method
		findPathUtil(row, column, exitCoords[0], exitCoords[1], outString);	// pass the row and column inputted into findPath, the exit coordinates, and the outString array
		return outString[0];	// return the final path stored into the 0 index of the outString from the findPathUtil method
	}

	/**
	 * This is a recursive helper method for the findPath method, which uses booleans to determine if a path is a viable
	 * solution recursively.
	 * @param row is the row index of the starting gate
	 * @param column is the column index of the starting gate
	 * @param exRow is the exit gates row index
	 * @param exCol is the column index of the exit gate
	 * @param out is an array which holds the output string so it can be passed by reference
	 * @return it returns true if a path is found and false if there is no path
	 */
	public boolean findPathUtil(int row, int column, int exRow, int exCol, String[] out) {
		if (row == exRow && column == exCol) {	// if the exit cell is reached, add it to the path and return true
			out[0] += stringBuilder(row, column);
			return true;
		}
		if (row >= 0 && row < dogMaze.getMaze().length && column >= 0 && column < dogMaze.getMaze()[0].length) {	// ensure the row and column are actually in the maze and not too large/small
			if (out[0].contains(stringBuilder(row, column))) {	// if the row and column as a formatted string are already in the path, return false
				return false;
			}
			out[0] += stringBuilder(row, column);	// concatenate the current row and column as a formatted string into the final path output

			if (dogMaze.getMaze()[row][column].charAt(3) == '0' && findPathUtil(row, column + 1, exRow, exCol, out)) {	// if the right of the current cell is open and the next column recursively returns true, return true
				return true;
			}
			if (dogMaze.getMaze()[row][column].charAt(2) == '0' && findPathUtil(row + 1, column, exRow, exCol, out)) {	// if the bottom of the current cell is open and the row below recursively returns true, return true
				return true;
			}
			if (dogMaze.getMaze()[row][column].charAt(1) == '0' && findPathUtil(row, column - 1, exRow, exCol, out)) {	// if the left of the current cell is open and the column on the left recursively returns true, return true
				return true;
			}
			if (dogMaze.getMaze()[row][column].charAt(0) == '0' && findPathUtil(row - 1, column, exRow, exCol, out)) {	// if the top of the current cell is open and the row above recursively returns true, return true
				return true;
			}
			out[0] = out[0].replace(stringBuilder(row, column), "");	// if none of the above directions return true from the current row/col, remove the current coordinates from the path
			return false;														// also return false
		}
		return false;	// if the row/col index is outside of the maze return false
	}

	/**
	 * This method finds the row and column index of the exit gate
	 * @param row is the row index of the starting point for the check (one cell clockwise from the starting gate)
	 * @param column is the column index of the starting point for the check (one cell clockwise from the starting gate)
	 * @return it returns an array containing the row and column of the next exit gate after the entrance
	 */
	public int[] exitFinder(int row, int column) {
		if (gateChecker(dogMaze.getMaze()[row][column], row, column) > 0) {	// if the current row and column is a gate, return the row and column as an exit
			return new int[]{row, column};
		} else if (row == 0 && column < dogMaze.getMaze()[row].length - 1) {	// all cases ensure that the function recursively moves through the perimeter only
			return exitFinder(row, column + 1);							// and if the row and column is not a gate it checks the next one
		} else if (row == 0 && column == dogMaze.getMaze()[row].length - 1) {
			return exitFinder(row + 1, column);
		} else if (column == dogMaze.getMaze()[row].length - 1 && row < dogMaze.getMaze().length - 1) {
			return exitFinder(row + 1, column);
		} else if (column == dogMaze.getMaze()[row].length - 1 && row == dogMaze.getMaze().length - 1) {
			return exitFinder(row, column - 1);
		} else if (row == dogMaze.getMaze().length - 1 && column > 0) {
			return exitFinder(row, column - 1);
		} else if (row == dogMaze.getMaze().length - 1 && column == 0) {
			return exitFinder(row - 1, column);
		} else if (column == 0 && row > 0) {
			return exitFinder(row - 1, column);
		} else {
			return null;
		}
	}

	/**
	 * This method takes a row and column value and returns a formatted string
	 * @param row is the row index to be put in the string
	 * @param col is the column index to be put in the string
	 * @return it returns a String of format (row,column) for use in output in the findPath method
	 */
	public String stringBuilder(int row, int col) {
		return "(" + row + "," + col + ")";	// takes the row and col and returns a string of form (row,col) for the final output
	}

	/**
	 * This method takes a row and column index (typically the entrance gate) and returns the index of the next cell
	 * moving clockwise
	 * @param row is the row index of the gate to be moved over from
	 * @param column is the column index of the gate to be moved over from
	 * @return it returns an integer array containing the row and column values in indexes 0 and 1 for the next cell
	 * over from the input
	 */
	public int[] nextCellFinder(int row, int column) {
		if (row == 0 && column == 0) {	// every case checks if it is the location of the current row and column and then when it finds the case it returns
			return new int[]{row, column+1};																						// the next cell over
		} else if (row == 0 && column == dogMaze.getMaze()[0].length-1) {
			return new int[]{row+1, column};
		} else if (row == dogMaze.getMaze().length-1 && column == dogMaze.getMaze()[0].length-1) {
			return new int[]{row, column-1};
		} else if (row == dogMaze.getMaze().length-1 && column == 0) {
			return new int[]{row-1, column};
		} else if (row == 0) {
			return new int[]{row, column+1};
		} else if (column == dogMaze.getMaze()[0].length-1) {
			return new int[]{row+1, column};
		} else if (row == dogMaze.getMaze().length-1) {
			return new int[]{row, column-1};
		} else {
			return new int[]{row-1, column};
		}
	}
}


/**
 * This class defines a <code> maze </code> using a 2D array. 
 * To complete the code, you should not change the method 
 * signatures (header). 
 *
 */

class Maze{
	private String [][] maze; 
	
	/**
	 * This constructor makes the maze. 
	 * @param maze is a 2D array that contains information 
	 * on how each cell of the array looks like. 
	 */
	public Maze(String[][] maze) {
		String[][] tempMaze = new String[maze.length][maze[0].length];	// variable to hold a deep copy of the inputted maze 2d array
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				tempMaze[i][j] = maze[i][j];	// copying the values of the inputted 2d array into the deep copy (dont need to make new String objects as it is immutable)
			}
		}
		this.maze = tempMaze;	// set the class variable to the new deep copy of the input 2d array
	}

	/**
	 * This accessor (getter) method returns a 2D array that
	 * represents the maze
	 * @return it returns a reference to the maze
	 */
	public String[][] getMaze(){
		return this.maze;	// returns the maze array object
	}

	/**
	 * turns the Maze object into a printable String
	 * @return it returns the String format of the Maze class object
	 */
	@Override 
	public String toString() {
		String outputStr = "";	// String variable to hold the output
		for (int i = 0; i < this.maze.length; i++) {
			outputStr += "[";	// adding a square bracket at the start of each row
			for (int j = 0; j < this.maze[i].length; j++) {
				outputStr += this.maze[i][j];	// adding the current index of the array into the output
				if (j != this.maze[i].length - 1) {
					outputStr += " ";	// adding a space between each cell if it is not the last cell
				}
			}
			outputStr += "]\n";	// at the end of each row, adding a square bracket and skipping to the next line
		}
		return outputStr;	// returning the desired string version of the 2d maze array
	}
	
}// end of class Maze
