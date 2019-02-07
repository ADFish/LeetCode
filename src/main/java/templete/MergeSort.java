package templete;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {38, 27, 43, 3, 9, 82, 10};
    MergeSort mergeSorter = new MergeSort();
    mergeSorter.sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public void sort(int[] arr, int h, int t) {
    if (h < t) {
      int m = (h + t) / 2;
      sort(arr, h, m);
      sort(arr, m + 1, t);
      merge(arr, h, m, t);
    }
  }

  private static void merge(int[] arr, int h, int m, int t) {
    int leftSize = m - h + 1;
    int rightSize = t - m;
    int[] left = new int[leftSize];
    int[] right = new int[rightSize];

    for (int i = 0; i < leftSize; i++) {
      left[i] = arr[i + h];
    }
    for (int j = 0; j < rightSize; j++) {
      right[j] = arr[m + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = h;

    while (i < leftSize && j < rightSize) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }

    while (i < leftSize) {
      arr[k] = left[i];
      i++;
      k++;
    }

    while (j < rightSize) {
      arr[k] = right[j];
      j++;
      k++;
    }

  }
}
