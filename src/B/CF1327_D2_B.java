package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF1327_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Daughter[] daughters = new Daughter[n];
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            int[] a = nextArray(scanner, k);
            Arrays.sort(a);
            daughters[i] = new Daughter(i + 1, a);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        ArrayList<Daughter> not = new ArrayList<>();
        for (Daughter daughter : daughters) {
            boolean married = false;
            for (int i = 0; i < daughter.a.length; i++) {
                if (set.contains(daughter.a[i])) {
                    set.remove(daughter.a[i]);
                    married = true;
                    break;
                }
            }
            if (!married) {
                not.add(daughter);
            }
        }
        if (set.size() == 0) {
            System.out.println("OPTIMAL");
        } else {
            System.out.println("IMPROVE");

            for (int i : set) {
                System.out.println(not.get(0).index + " " + i);
                break;
            }
        }


    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static class Daughter {
        int index;
        int[] a;

        public Daughter(int index, int[] a) {
            this.index = index;
            this.a = a;
        }
    }
}
