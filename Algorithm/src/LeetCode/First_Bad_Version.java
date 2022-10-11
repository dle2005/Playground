package LeetCode;

public class First_Bad_Version {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(5));
        System.out.println(solution.firstBadVersion(1));
    }

    public static class VersionControl {
        boolean isBadVersion(int version) {
            return version == 4 || version == 1;
        }
    }

    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
