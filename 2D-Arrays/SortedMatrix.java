public class SortedMatrix {
    public static boolean SearchKey(int matrix[][],int key){
        int row =0;
        int col = matrix[0].length;

        while (row <= matrix.length-1 && col >= 0) {
            if( key == matrix[row][col]){
                System.err.println("Found key at : (" + row +"," + col + ")");
                return true;
                
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println(" Key Present on Index: " + matrix[row][col]);
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50},
        };
        int key =33;
        SearchKey(matrix, key);
    }
}
