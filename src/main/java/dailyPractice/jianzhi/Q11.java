package dailyPractice.jianzhi;

public class Q11 {
    public int minArray1(int[] numbers) {
        int size = numbers.length;
        if (size == 1) return numbers[0];

        for (int i = 0; i + 1 < size; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    // binary search
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int m = left + (right - left) / 2;
            if (numbers[m] > numbers[right])  left = m + 1;
            else if (numbers[m] < numbers[right]) right = m;
            else right--;
        }
        return numbers[left];
    }
}
