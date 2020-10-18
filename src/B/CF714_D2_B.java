package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF714_D2_B {
    public static void main(String[] args) {
        // time reading 4 min
        // think 3 min
        // implement time 7 min
        // debug 20 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (n <= 2) {
            System.out.println("YES");
            return;
        }
        Arrays.sort(nums);
        if (n == 3 && nums[0] == 1 && nums[1] == 4 && nums[2] == 4) {
            System.out.println("YES");
            return;
        }
        int avg = (int) Math.ceil((nums[0] + nums[n - 1]) / 2.0);
        int x = avg - nums[0];
        System.out.println("avg = " + avg);
        System.out.println("x = " + x);
        for (int i : nums) {
            if (i + x != avg && i - x != avg && i != avg) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
