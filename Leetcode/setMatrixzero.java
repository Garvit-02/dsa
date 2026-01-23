package Leetcode;

public class setMatrixzero {
    // brute force approch
    public void markRow(int matrix[][], int n, int m, int j) {
        for (int i = 0; i < m; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public void markCol(int matrix[][], int n, int m, int i) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[] row =new int[m], col =new int[n];

        // matrix[i][j] = 0 then mark it with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        //then -1 to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] ==-1 || col[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    // betterapproach
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[] row =new int[m], col =new int[n];

        // matrix[i][j] = 0 then mark it with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        //then -1 to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] ==-1 || col[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

