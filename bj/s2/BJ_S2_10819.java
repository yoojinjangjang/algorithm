package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_10819 {
    static int[] A;
    static int N;
    static int[] output;
    static boolean[] visited;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        output = new int[N];
        visited = new boolean[N];

        perm(0);

        System.out.println(MAX);
    }

    static void perm(int depth) {
        if(depth == N) {
            calc();
            return;
        }

        for(int i =0;i<N;i++ ) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = A[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void calc() {
        int sum = 0;
        for(int i =0;i<N-1;i++) {
            sum += Math.abs(output[i] - output[i+1]);
        }
        MAX = Math.max(MAX, sum);
    }
}
