package A;

import java.util.ArrayList;
import java.util.Scanner;

public class CF490_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> twos = new ArrayList<>();
        ArrayList<Integer> threes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            if (d == 1) {
                ones.add(i + 1);
            } else if (d == 2) {
                twos.add(i + 1);
            } else {
                threes.add(i + 1);
            }
        }
        int size = Math.min(Math.min(ones.size(), twos.size()), threes.size());
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(ones.get(i) + " " + twos.get(i) + " " + threes.get(i));
        }
    }
}
