package Recursion;

public class tilingProblem {
    public static int TilingProblem(int n){
        //basecase
        if ( n==0 || n==1 ){
            return 1;
        }
        
        //vertical
        int fnm1 = TilingProblem(n-1);
        //horizontal
        int fnm2 = TilingProblem(n-2);

        //total ways
        int totWays = fnm1+fnm2;

        return totWays;
    }
    public static void main(String[] args) {
        System.out.println(TilingProblem(4));
    }
}
