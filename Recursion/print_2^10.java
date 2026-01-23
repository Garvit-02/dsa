package Recursion;

class print{
    public static int power(int x,int n){
        if( n==0 ){
            return 1;
        }
        int xnm1 = power(x, n-1);
        int xn = x*xnm1;
        return xn;
    }
    public static int optimizedPower(int x, int n){
        if( n==0 ){
            return 1;
        }
        int halfPower = optimizedPower(x, n/2);
        int halfPowerSq = halfPower*halfPower;

        //check even or odd
        if( n%2 != 0 ){
            halfPowerSq = x*halfPowerSq;
        }

        return halfPowerSq;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(power(x, n));
        System.out.println(optimizedPower(x, n));
    }
}
