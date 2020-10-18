package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CF376_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Dept> depts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            depts.add(new Dept());
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int index = scanner.nextInt() - 1;
            int o = scanner.nextInt() - 1;
            int a = scanner.nextInt();
            depts.get(index).hasDept += a;
            depts.get(o).gotDept += a;
        }
        System.out.println(Arrays.toString(depts.toArray()));
        int sum = 0;
        for (Dept dept : depts) {
            if (dept.hasDept - dept.gotDept > 0)
                sum += dept.hasDept - dept.gotDept;
        }
    }

    static class Dept {
        int hasDept = 0;
        int gotDept = 0;

        @Override
        public String toString() {
            return "Dept{" +
                    "hasDept=" + hasDept +
                    ", gotDept=" + gotDept +
                    '}';
        }
    }
}
