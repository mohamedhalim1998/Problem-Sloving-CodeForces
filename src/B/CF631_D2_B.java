package B;

import java.util.*;

public class CF631_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] page = new int[n][m];
        ArrayList<Operation> operations = new ArrayList<>();
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int s = scanner.nextInt();
            int l = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            Operation operation = new Operation(s, l, c);
            operations.add(operation);
            if (s == 2) {
                rows.put(l, rows.getOrDefault(l, 0) + 1);
            } else {
                cols.put(l, cols.getOrDefault(l, 0) + 1);
            }


        }

        for (Operation operation : operations) {
            if (operation.s == 2) {
                if (rows.get(operation.l) > 1) {
                    rows.put(operation.l, rows.get(operation.l) - 1);
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    page[j][operation.l] = operation.c;
                }
            } else {
                if (cols.get(operation.l) > 1) {
                    cols.put(operation.l, cols.get(operation.l) - 1);
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    page[operation.l][j] = operation.c;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(page[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class Operation {
        int s, l, c;

        public Operation(int s, int l, int c) {
            this.s = s;
            this.l = l;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Operation operation = (Operation) o;
            return s == operation.s &&
                    l == operation.l;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, l, c);
        }
    }

}
