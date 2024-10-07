package com.pluralsight;

public class TestStatistics {
    public static void main(String[] args) {
        int[] scores = {6,7,8,8,9,10,8,7,8,8};
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        float median = 0f;
        float avg = 0f;

        for (int num : scores) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] sorted = sort(scores);
        if (sorted.length %2 != 0) {
            median = sorted[sorted.length/2];
        } else {
            median = (float)(sorted[sorted.length/2-1] + sorted[sorted.length/2])/2;
        }

        avg = (float) (sum/scores.length);
        System.out.println("Average Score: " + avg);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);
        System.out.println("Median Score: " + median);
    }

    public static int[] sort(int[] scores) {
        int[] sorted = scores.clone();
        int n = sorted.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i+1];
                    sorted[i+1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        return sorted;
    }
}
