package A;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF1251_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        char[] ch = scanner.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];

        int n = ch.length;
        for(int i = 0 ; i < ch.length ;i++){
            int len = 1;
            while((i != n-1) && (ch[i] == ch[i+1])){
                len += 1;
                i += 1;
            }
            if(len%2 == 1)
                count[ch[i]-'a'] = 1;
        }

        for(int i = 0; i < 26 ; i++){
            if(count[i] == 1)
                sb.append((char)('a'+i));
        }
        System.out.println(sb);


    }
}