package C;

import java.util.Arrays;
import java.util.Scanner;

public class CF515_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        /*
            4 -> 3 - 2 - 2
            6 -> 5 3
            8 -> 7 2 2 2
         */
        s = s.replaceAll("0", "");
        s = s.replaceAll("1", "");
        s = s.replaceAll("4", "322");
        s = s.replaceAll("6", "53");
        s = s.replaceAll("8", "7222");
        s = s.replaceAll("9", "7332");
        char[] out = s.toCharArray();
        out = sort(out);
        System.out.println(String.valueOf(out));
    }
    public static char[] sort(char[] a){
        if(a.length <= 1){
            return a;
        }
        int half = a.length / 2;
        char[] first = Arrays.copyOfRange(a,0, half);
        char[] second = Arrays.copyOfRange(a, half, a.length);

        return merge(sort(first), sort(second));
    }

    private static char[] merge(char[] first, char[] second) {
        char[] res = new char[first.length + second.length];
        for (int i = 0, j = 0 , k = 0; i < res.length; i++) {
            if(j < first.length && k < second.length){
                res[i] = first[j] > second[k]? first[j++] : second[k++];
            } else if(j < first.length){
                res[i] = first[j++];
            } else {
                res[i] = second[k++];
            }
        }
        return res;
    }

}
