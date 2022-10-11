package LeetCode;

public class Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i1 = 0, i2 = 0;
        int[] sum = new int[(n + m) / 2 + 1];

        while (i1 + i2 != sum.length) {
            if (i1 == n) {
                sum[i1 + i2] = nums2[i2++];
            } else if (i2 == m) {
                sum[i1 + i2] = nums1[i1++];
            } else {
                sum[i1 + i2] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
            }
        }

        return (sum[(n + m) / 2] + sum[(n + m - 1) / 2]) / 2.0;
    }
}
