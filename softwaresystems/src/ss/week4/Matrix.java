package ss.week4;

import java.util.Arrays;

public class Matrix {
int[][] elements;
public static void main(String[] args) {
	Matrix m = new Matrix(3,3);	
	Matrix n = new Matrix(3,3);
	n.setRow(0, new int[] {1,2,3});
	n.setRow(1, new int[] {4,5,6});
	n.setRow(2, new int[] {7,8,9});
	m.setRow(0, new int[] {1,2,3});
	m.setRow(1, new int[] {4,5,6});
	m.setRow(2, new int[] {7,8,9});
	m.product(n).product(m).product(m);
	

	
}
/**
 * Constructs a Matrix object that consist out of a int[][]
 * @param row amount of rows of the element
 * @param col amount of colloms of the element
 */
	public Matrix(int row, int col) {
		elements = new int[row][col];
		for(int i = 0; i < elements.length; i++)
			for(int j = 0; j < elements[0].length; j++) {
				elements[i][j] = 2 - i;
			}
	}
	
	//Returns the int[][] object
	
	public int[][] getMatrix() {
		return elements;
	}
	
	//returns the size of the row
	public int getRowSize() {
		return elements[0].length;
	}
	
	//returns the size of the col
	public int getColSize() {
		return elements.length;
	}
	
	
	/**
	 * Returns a row according to row number given
	 * @param row int that indicates which row to return
	 * @return returns a int[] that is the desired row
	 */
	public int[] getRow(int row) {
		return elements[row];
	}
	
	/**
	 * Returns a col according to col number given
	 * @param row int that indicates which col to return
	 * @return returns a int[] that is the desired col
	 */
	
	public int[] getCol(int col) {
		int[] coll = new int[elements.length];
		for(int i = 0; i < elements.length; i++) {
			coll[i] = elements[i][col];
		}
		return coll;
	}
	
	/**
	 * replaces a desired row(i) with a desired int[]
	 * @param i row that needs to be changed
	 * @param row a int[] that replaces the current row;
	 */
	public void setRow(int i, int[] row) {
		if(getRowSize() != row.length || i >= getColSize()) {
			System.out.println("Checkagain!");
		}
		else {
		for(int j = 0; j < row.length; j++)
		elements[i][j] = row[j];
	}
	}
	
	public void setCel(int i, int row, int col) {
		elements[row][col] = i;
	}
	
	/**
	 * replaces a desired col(i) with a desired int[]
	 * @param i col that needs to be changed
	 * @param coll a int[] that replaces the current col;
	 */
	public void setCol(int i, int[] col) {
		if(getColSize() != col.length || i >= getRowSize()) {
			System.out.println("Checkagain!");
		}
		else {
		for(int j = 0; j < col.length; j++)
		elements[j][i] = col[j];
	}
	}
	
	
    /**
     * Returns the innerproduct of a int[] and int[]
     * @param col int[]
     * @param row int[]
     * @return returns int[]
     */
	public int innerProduct(int[] col, int[] row) {
	int sum = 0;
	for(int i = 0; i < col.length; i++) {
		sum += col[i] * row[i];
	}
	return sum;
	}
	
	/**
	 * Returns the product of two matrix objects. 
	 * @param matrix
	 * @return return a Matrix that represents the product of the two matrices. 
	 */
	
	public Matrix product(Matrix matrix){
		int n = this.getColSize();
		int m =  matrix.getRowSize();
		Matrix matr = new Matrix(n,m);
		for(int i = 0; i < n; i++)
			for(int j = 0; j<m; j++) {
				matr.setCel(innerProduct(this.getRow(i),matrix.getCol(j)), i, j);
			}
		matr.print();
		
		
	
		return matr;
	}

	// prints the matrix
	public void print(){
	for (int i = 0; i < elements.length; i++) {
	    for (int j = 0; j < elements[i].length; j++) {
	    	if(j == 0) {
	    		System.out.print("|" + elements[i][j] + "|");
	    	}
	    	else {
	    		System.out.print(elements[i][j] + "|");
	    	}
	    }
	    System.out.println("");

	}
	System.out.println("");
}
}
