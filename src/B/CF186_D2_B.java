package B;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CF186_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        double k = (100 - scanner.nextInt()) / 100.0;
        HashMap<Integer, Double> map = new HashMap<>();
        Score[] scores = new Score[n];
        for (int i = 0; i < n; i++) {
            int speed1 = scanner.nextInt();
            int speed2 = scanner.nextInt();
            double len = Math.max(speed1 * k * t1 + speed2 * t2, speed2 * k * t1 + speed1 * t2);
            scores[i] = new Score(len, i);
            map.put(i, len);
        }
        Arrays.sort(scores);
        for (int i = 0; i < n; i++) {
            System.out.println(String.format("%d %.2f", ++scores[i].index, scores[i].score));
        }
    }

    static class Score implements Comparable<Score> {
        double score;
        int index;

        public Score(double score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Score o) {
            return Double.compare(o.score, this.score);
        }
    }

}
