package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_1476 {

    static int E;
    static int S;
    static int M;

    static int year;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int e = 1;
        int s = 1;
        int m = 1;
        year = 1;

        while(true) {
            if (E == e && S == s && M == m) break;

            e = (e+1) % 16;
            if(e == 0) e = 1;
            s = (s+1) % 29;
            if (s == 0) s = 1;
            m = (m+1) % 20;
            if (m == 0) m = 1;

            year++;
        }

        System.out.println(year);


    }
}
