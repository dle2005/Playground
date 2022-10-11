package DataStructure;

public class BinarySearchRecursion {
    // 순환 알고리즘: 수행이 완료되기 전에 자기 자신을 다시 호출
    /* 직접 순환(direct recursion)
        함수가 그 수행이 완료되기 전에 자기 자신을 다시 호출 */
    /* 간접 순환(indirect recursion)
        호출 함수를 다시 호출하게 되어 있는 다른 함수를 호출 */

    int binarySearch(int[] a, final int x, final int left, final int right) {
        // 정렬된 배열 a[left],...,a[right]에서 x 탐색
        if (left <= right) {
            int middle = (left + right) / 2;
            if (x < a[middle]) return binarySearch(a, x, left, middle - 1);
            else if (x > a[middle]) return binarySearch(a, x, middle + 1, right);
            return middle;
        } // if의 끝

        return -1; // 발견되지 않음
    }

}
