import java.util.*;

public class creation {
    public static boolean Search(int matrix[][],int key){
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if( matrix[i][j] == key){
                    System.out.print("Key is at : ("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Key Not Found");
        return false;
    }

    public static void MaxMin(int matrix[][]){
        int minvalue = 0;
        int maxvalue = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if(matrix[i][j] > maxvalue){
                    matrix[i][j] = maxvalue;
                }
                if(matrix[i][j] < minvalue){
                    matrix[i][j] = minvalue;
                }
            }
        }
        System.out.println(minvalue);
        System.out.println(maxvalue);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int row =matrix.length;
        int column =matrix[0].length;

        // Input
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        //output
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        //Search in matrix
        MaxMin(matrix);
        
    }
}
