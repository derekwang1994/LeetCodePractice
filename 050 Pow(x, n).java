// Implement pow(x, n).

public class Solution {
    public double myPow(double x, int n) {
        // 解決 overflow //
        if (Double.isInfinite(x) || x==0) return 0;

        // 當 n 是負數的處理 //
        if(n<0){
            n = n * (-1);
            x = 1/x;
        }

        if(n==0) return 1;
        if(n==2) return x*x;

        // 基數和偶數差一個 x //
        if(n%2==0){
            return myPow( myPow(x,n/2) , 2 );
        }else{
            return x * myPow( myPow(x,n/2) , 2 );
        }

    }
}
