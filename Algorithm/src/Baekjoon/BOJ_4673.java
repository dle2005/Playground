package Baekjoon;

public class BOJ_4673 {
    private static int dn(int n) {
        int result = n;

        while(n != 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        boolean[] selfNumber = new boolean[10001];
        int temp;

        for(int i = 1; i < 10001; i++) {
            temp = dn(i);
            if(temp <= 10000) selfNumber[temp] = true;
        }

        for(int i = 1; i < 10001; i++)
            if(!selfNumber[i]) System.out.println(i);

    }
}
