//MatrixFinder.java

/*
  Team Bop-It
  Brian Lin, Isaac Jon, Aleksandra Koroza
  APCS2 pd2
  HW #03: I Am Still Searching
  2018-02-01  
*/

/*
  Summary:
  Search starts at the bottom left corner.
  If this value is equal to target, return the location. 
  If this value is greater than the target, the search moves up (previous row). 
  If the value is less than the target, search moves right (next column).
  If target is not present in the matrix, returns (-1,1). 
  Best Case: target is to the right of the bottom left corner
  Worst Case: target is on the last row, last column (top right)
*/

import java.util.Arrays;

public class MatrixFinder {

    public static String matrixSearch(int[][] matrix, int target) {
        
        //tracking location
        int r = matrix.length - 1;
        int c = 0;
        //
        int x = -1;
        int y = -1;
        while (c < matrix.length && r >= 0) {
            int val = matrix[r][c];
            System.out.print(String.format("(%s,%s) (%s,%s)", r, c, x, y));
            if (target == matrix[r][c]) {
                x = c;
                y = r;
                break;
            } else if (val < target) {
                c++;
                System.out.print(" go left ");
            } else if (val > target) {
                r--;
                System.out.print(" go up ");
            }
            System.out.println();
        }
        System.out.println();
        return String.format("(row: %s, col: %s)", y, x);
    }

    public static void main(String[] args) {
        // ========== Worst Case Scenario Test Case ==========
        // Requires 4 runs
        int[][] worst = {
                {1, 2, 16},
                {3, 4, 17},
                {4, 5, 26}
        };
    /* Visual Diagram
       | 1 2 16 |
	   | 3 4 17 |
	   | 4 5 26 |
	*/
        System.out.println(matrixSearch(worst, 16)); // Should return (1, 3)

        // ========== Best Case Scenario Test Case ==========
        // Requires 1 run
        int[][] best = {
                {3, 7, 8, 9},
                {10, 11, 14, 17},
                {16, 18, 20, 22},
                {25, 28, 30, 35}
        };
	/* Visual Diagram
	   |  3  7  8  9  |
	   | 10 11 14 17  |
	   | 16 18 20 22  |
	   | 25 28 30 35  |
	*/
        System.out.println(matrixSearch(best, 25));

        // ========== Middle Case Scenario Test Case ==========
        // Requires 2 runs
        int[][] mid = {
                {1, 2, 3},
                {4, 6, 7},
                {5, 7, 8}
        };
	/* Visual Diagram
	   | 1 2 3 |
	   | 4 6 7 |
	   | 5 7 8 |
	*/
        System.out.println(matrixSearch(mid, 6));
    }
}









			 



