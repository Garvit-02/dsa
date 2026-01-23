class rotateImage {
    public int rotate(int[][] matrix) { // Changed rotate2 to rotate
        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // // Reverse each row
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix.length / 2; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][matrix.length - 1 - j];
        //         matrix[i][matrix.length - 1 - j] = temp;
        //     }
        // }
        return matrix;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };
        // new rotateImage().rotate(matrix);
        // // Optionally, print the rotated matrix to verify the result
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
    }
}
