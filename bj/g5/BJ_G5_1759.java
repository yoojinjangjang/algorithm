package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1759 {
    static int L;
    static int C;
    static String[] arr;
    static String[] output;
    static boolean[] visited;
    static String aeiou = "aeiou";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        visited = new boolean[C];
        output = new String[C];

        perm(0,0);
    }

    static void perm(int depth, int start) {
        if(depth == L) {
            String ans = "";
            int aeioutCnt = 0;
            int cnt = 0;
            for(int i =0;i<L;i++) {
                if(aeiou.contains(output[i])) {
                    aeioutCnt++;
                } else {
                    cnt++;
                }
                ans += output[i];
            }

            if(aeioutCnt >= 1 && cnt >= 2) System.out.println(ans);
            return;
        }

        for(int i = start;i<C;i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
