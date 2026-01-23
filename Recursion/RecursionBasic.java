package Recursion;

public class RecursionBasic {
    // print(n-1)
    public static void printDec(int n){
        if(n == 1){
            System.out.print(n);
            return;
        }
        System.out.print(n +" ");
        printDec(n-1);
    }

    // print(1-n)
    public static void printInc(int n){
        if(n ==1 ){
            System.out.print(1+ " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    // print factorial(n)
    public static int Factorial(int n){
        if( n == 0){
            return 1;
        }
        int fnm1 = Factorial(n-1);
        int fn = n*Factorial(n-1);
        return fn;

    }

    // print sum of N natural no
    public static int Sum(int n){
        if( n == 1){
            return 1;
        }
        int Snm1 = Sum(n-1);
        int Sn = n + Sum(n-1);
        return Sn;

    }

    // print nth fibonacci no
    public static int fib(int n){
        if( n==0 || n==1 ){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);

        return (fnm1 + fnm2);
    }

    // check array is sorted 
    public static boolean isSorted(int arr[],int i){
        if( i == arr.length -1){
            return true;
        }
        if( arr[i]>arr[i+1]){
            return false;
        }

        return isSorted(arr, i+1);
    }
    public static void main(String[] args) {
        int arr[] ={1,2,3,4};
        System.out.println(isSorted(arr, 0));
    }
}
