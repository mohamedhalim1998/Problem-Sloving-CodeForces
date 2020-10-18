package C;

import java.util.Scanner;

public class CF225_D2_C {
    static long[][][] res;
    static int[] dots;
    static int m;
    private static int x;
    private static int y;
    private static int n;

    public static void main(String[] args) {/*
    .   #   #   #   #
    #   #   #   .   .
    #   #   .   #   #
    #   .   .   #   .
    .   #   .   .   .
    #   .   #   #   .
    .   #   #   .   .
    .   #   .   #   #
    #   .   #   .   .
    .   #   .   .   #

*/
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        dots = new int[m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '.')
                    dots[j]++;
            }
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(dots[i]);
//        }
        res = new long[m][y+1][3];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < y+1; k++) {
                for (int j = 0; j < 3; j++) {
                    res[i][k][j] = -1;
                }
            }
        }
        long r = countPixels(0, 0, 2);
        System.out.println(r);
    }

    private static long countPixels(int j, int width, int prev) {
        if (j == m && (width > y || width < x)) {
            return Integer.MAX_VALUE;
        }
        if (j == m) {
            return 0;
        }
        long c = res[j][width][prev];
        if (c != -1)
            return c;

        long dot = Integer.MAX_VALUE;
        if (j == 0 || (prev == 0 && width + 1 <= y) || (prev == 1 && width >= x)) {
            dot = n - dots[j] + countPixels(j + 1, (prev == 0) ? width + 1 : 1, 0);
        }
        long hash = Integer.MAX_VALUE;
        if (j == 0 || (prev == 1 && width + 1 <= y) || (prev == 0 && width >= x)) {
            hash = dots[j] + countPixels(j + 1, (prev == 1) ? width + 1 : 1, 1);
        }
        c = Math.min(hash, dot);
        res[j][width][prev] = c;
        return c;
    }


//    private static long countPixels(char[][] img, long[][] res, int m, int x, int y, int count, int i, int prev) {
//        if (i == m && count < x) {
//            return Integer.MAX_VALUE;
//        }
//        if (i == m) {
//            return 0;
//        }
//        long r = res[i][prev];
//        if (r != -1) {
//            return r;
//        }
//        r = Integer.MAX_VALUE;
//        if (count < x) {
//            if (prev != 1) {
//                char color = '.';
//                int pixelColored = getPixelColored(img, i, color);
//                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 0));
//            }
//            if (prev != 0) {
//                char color = '#';
//                int pixelColored = getPixelColored(img, i, color);
//                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 1));
//            }
//        } else if (count >= y) {
//            if (prev != 1) {
//                char color = '#';
//                int pixelColored = getPixelColored(img, i, color);
//                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 1));
//            }
//            if (prev != 0) {
//                char color = '.';
//                int pixelColored = getPixelColored(img, i, color);
//                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 0));
//            }
//        } else {
//            char color = '.';
//            int pixelColored = getPixelColored(img, i, color);
//            r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 0));
//            color = '#';
//            pixelColored = getPixelColored(img, i, color);
//            r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 1));
//        }
//        res[i][prev] = r;
//        return r;
//
////        if (prev != 0) {
////            if (count < x) {
////                char color = '.';
////                int pixelColored = 0;
////                for (int j = 0; j < img.length; j++) {
////                    char c = img[j][i];
////                    if (c != color) {
////                        pixelColored++;
////                    }
////                }
////                r = pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 0);
////            } else if (count == y) {
////                char color = '#';
////                int pixelColored = 0;
////                for (int j = 0; j < img.length; j++) {
////                    char c = img[j][i];
////                    if (c != color) {
////                        pixelColored++;
////                    }
////                }
////                r = pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 1);
////            }
////        }
////        if (prev != 1) {
////            if (count < y) {
////                char color = '#';
////                int pixelColored = 0;
////                for (int j = 0; j < img.length; j++) {
////                    char c = img[j][i];
////                    if (c != color) {
////                        pixelColored++;
////                    }
////                }
////                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 1));
////            } else if (count == y) {
////                char color = '.';
////                int pixelColored = 0;
////                for (int j = 0; j < img.length; j++) {
////                    char c = img[j][i];
////                    if (c != color) {
////                        pixelColored++;
////                    }
////                }
////                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 0));
////            }
////        }
////        res[i][prev] = r;
////        return r;
////        if (count < x) {
////            char color = prev == 0 ? '.' : '#';
////
////            int pixelColored = 0;
////            for (int j = 0; j < img.length; j++) {
////                char c = img[j][i];
////                if (c != color) {
////                    pixelColored++;
////                }
////            }
////            r = pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, prev);
////        } else if (count == y) {
////            if (prev == 0) {
////                char color = '#';
////                int pixelColored = 0;
////                for (int j = 0; j < img.length; j++) {
////                    char c = img[j][i];
////                    if (c != color) {
////                        pixelColored++;
////                    }
////                }
////                r = pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 1);
////            } else {
////                char color = '.';
////                int pixelColored = 0;
////                for (int j = 0; j < img.length; j++) {
////                    char c = img[j][i];
////                    if (c != color) {
////                        pixelColored++;
////                    }
////                }
////                r = pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 0);
////            }
////        } else {
////            char color = '.';
////            int pixelColored = 0;
////            for (int j = 0; j < img.length; j++) {
////                char c = img[j][i];
////                if (c != color) {
////                    pixelColored++;
////                }
////            }
////            if (prev == 0) {
////                r = pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 0);
////            } else {
////                r = pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 0);
////            }
////            color = '#';
////            pixelColored = 0;
////            for (int j = 0; j < img.length; j++) {
////                char c = img[j][i];
////                if (c != color) {
////                    pixelColored++;
////                }
////            }
////            if (prev == 0) {
////                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, 1, i + 1, 1));
////            } else {
////                r = Math.min(r, pixelColored + countPixels(img, res, m, x, y, count + 1, i + 1, 1));
////            }
////        }
////        res[i][prev] = r;
////        return r;
//    }
//
//    private static int getPixelColored(char[][] img, int i, char color) {
//        int pixelColored = 0;
//        for (int j = 0; j < img.length; j++) {
//            char c = img[j][i];
//            if (c != color) {
//                img[j][i] = color;
//                pixelColored++;
//            }
//        }
//        return pixelColored;
//    }
}
