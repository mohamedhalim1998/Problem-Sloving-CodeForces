package C;

import java.util.*;

public class CF416_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Group[] groups = new Group[n];
        for (int i = 0; i < n; i++) {
            groups[i] = new Group(i + 1, scanner.nextInt(), scanner.nextInt());
        }
        int m = scanner.nextInt();
        ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            tables.add(new Table(i + 1, x));
        }

        Arrays.sort(groups);
        Collections.sort(tables);
        int cost = 0;
        StringBuilder out = new StringBuilder();
        int removed = 0;
        for (Group g : groups) {
            if (tables.size() == 0) {
                break;
            }
            if (tables.get(tables.size() - 1).n >= g.p) {
                int table = findTable(tables, g.p);
                if(table != -1) {
                    Table t = tables.remove(table);
                    cost += g.c;
                    out.append(g.i).append(" ").append(t.i).append("\n");
                    removed++;
                }
            }
        }
        out.insert(0, removed + " " + cost + "\n");
        System.out.println(out);


    }

    private static int findTable(ArrayList<Table> tables, int p) {
        int l = 0;
        int r = tables.size();
        int m = l + (r - l) / 2;

        while (tables.get(m).n != p && m > l) {
            if (tables.get(m).n > p) {
                r = m;
                m = l + (r - l) / 2;
            } else {
                l = m;
                m = l + (r - l) / 2;
            }
        }
        if (tables.get(m).n < p && tables.size() > m + 1) {
            return m + 1;
        } else if (tables.get(m).n < p) {
            return -1;
        }
        return m;
    }

    public static class Group implements Comparable<Group> {
        int i;
        int p;
        int c;

        public Group(int i, int p, int c) {
            this.i = i;
            this.p = p;
            this.c = c;
        }


        @Override
        public int compareTo(Group group) {
            return Integer.compare(group.c, c);
        }
    }

    public static class Table implements Comparable<Table> {
        int i, n;

        public Table(int i, int n) {
            this.i = i;
            this.n = n;
        }


        @Override
        public int compareTo(Table table) {
            return Integer.compare(n, table.n);
        }
    }
}
