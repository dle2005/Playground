package DataStructure;

public class SelectionSort {
    // 정렬되지 않은 정수들 중에서 가장 작은 값을 찾아서 정렬된 리스트 다음 자리에 놓는다.

    // void SelectionSort(int *a, const int n)
    void selectionSort(int[] a, final int n) {
        // n개의 정수 a[0]부터 a[n-1]까지 비감소 순으로 정렬한다.
        for (int i = 0; i < n; i++) {
            int j = i;
            // a[i]와 a[n-1] 사이에 가장 작은 정수를 찾는다.
            for (int k = i + 1; k < n; k++)
                if (a[k] < a[j]) j = k;
            // a[i] 에서부터 a[n-1]까지의 정수 값을 검사한 결과 a[j]가 가장 작은 값
            // a[i]와 a[j]를 서로 교환
            swap(i, j, a); // swap(a[i], a[j])
        }
    }

    void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
