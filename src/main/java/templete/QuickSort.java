package templete;

import java.util.Arrays;

//https://www.geeksforgeeks.org/quick-sort/
public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {38, 27, 43, 3, 9, 82, 10};
    QuickSort sorter = new QuickSort();
    sorter.sort(arr, 0 , arr.length -1);
    System.out.println(Arrays.toString(arr));
  }

  public void sort(int[] arr, int h, int t) {
    if (h < t) {
      int partionIndex = partion(arr, h, t);
      sort(arr, h, partionIndex - 1);
      sort(arr, partionIndex + 1, t);
    }
  }

  private int partion(int[] arr, int h, int t) {
    int pivot = arr[t];
    int curt = h - 1;
    for (int i = h; i < t; i++) {
      if (arr[i] < pivot) {
        curt++;
        int temp = arr[i];
        arr[i] = arr[curt];
        arr[curt] = temp;
      }
    }

    int temp = arr[curt + 1];
    arr[curt + 1] = arr[t];
    arr[t] = temp;
    System.out.println(curt + 1);
    return curt + 1;
  }
}
