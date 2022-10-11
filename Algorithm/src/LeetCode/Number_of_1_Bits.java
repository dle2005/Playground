package LeetCode;

public class Number_of_1_Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
    }

    public static int hammingWeight(int n) {
        int output = 0;

        while (n != 0) {
            n &= (n - 1);
            output++;
        }

        return output;
    }
}
