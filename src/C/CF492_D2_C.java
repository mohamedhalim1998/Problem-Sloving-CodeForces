package C;

import java.util.Arrays;
import java.util.Scanner;

public class CF492_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long r = scanner.nextLong();
        long l = scanner.nextLong();
        Exam[] exams = new Exam[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long g = scanner.nextLong();
            long e = scanner.nextLong();
            exams[i] = new Exam(g, e);
            sum += g;
        }
        if (sum / n >= l) {
            System.out.println(0);
            return;
        }
        Arrays.sort(exams);
        int i = 0;
        long count = 0;
        long rem = n * l - sum;

        while (rem > 0) {
            long g = exams[i].g;
            long c = Math.min(rem, r - g);
            count += (c * exams[i].e);
            rem -= c;
            i++;
        }
        System.out.println(count);
    }

    public static class Exam implements Comparable<Exam> {
        long g, e;

        public Exam(long g, long e) {
            this.g = g;
            this.e = e;
        }

        @Override
        public int compareTo(Exam exam) {
            return Long.compare(e, exam.e);
        }
    }
}
