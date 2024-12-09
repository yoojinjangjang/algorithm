package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_16562 {
    static int[] arr;
    static int[] output;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        output = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = i+1;
        }

        dupPerm(0, 0);

    }

    static void dupPerm(int depth, int start) {
        if(depth == M) {
            print();
            return;
        }

        for(int i =start;i<N;i++) {
            output[depth] = arr[i];
            dupPerm(depth + 1, i );
        }
    }

    static void print() {
        for(int i =0;i<M;i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

}
