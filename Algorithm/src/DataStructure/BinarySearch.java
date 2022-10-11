package DataStructure;

public class BinarySearch {
    // 이미 정렬된 배열 a[0]...a[n-1]에서 x = a[j]인 j를 반환
    // left, right: 탐색하고자 하는 리스트의 왼쪽, 오른쪽 끝
    // 초기값으로 left = 0, right = n-1
    // 리스트의 중간 위치 middle = (left + right) / 2로 설정
    // a[middle]과 x 비교

    // int BinarySearch (int *a, const int x, const int n)
    int binarySearch(int[] a, final int x, final int n) {
        // Search the sorted array a[0],...,a[n-1] for x
        int left = 0, right = n-1;
        while (left <= right) { // there are more elements
            int middle = (left + right) / 2;
            if (x < a[middle]) right = middle - 1;
            else if (x > a[middle]) left = middle + 1;
            else return middle;
        } // end of while
        return -1; // not found
    }
}
