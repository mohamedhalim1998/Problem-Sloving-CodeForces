package B;

import java.util.Arrays;
        import java.util.Scanner;

public class CF492_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 2 min
        // implement time 5 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[] lights = new int[n];
        for (int i = 0; i < n; i++) {
            lights[i] = scanner.nextInt();
        }
        Arrays.sort(lights);
        int maxDiff = 0;
        if (lights[0] != 0) {
            maxDiff = lights[0] * 2;
        }
        for (int i = 0; i < n - 1; i++) {
            if (lights[i + 1] - lights[i] > maxDiff) {
                maxDiff = lights[i + 1] - lights[i];
            }
        }
        if (lights[n - 1] != l) {
            if ((l - lights[n - 1]) * 2 > maxDiff) {
                maxDiff = (l - lights[n - 1]) * 2;
            }
        }
        System.out.println(maxDiff / 2.0);
    }
}
