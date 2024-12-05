package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_10974 {
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static int n;
    static int r;

    static void perm(int depth) {
        if(depth == r) {
            print();
            return;
        }

        for(int i =0;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void print() {
        for(int i =0;i<r;i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        output = new int[n];
        visited = new boolean[n];
        r = n;

        for(int i =0;i<n;i++) {
            arr[i] = i+1;
        }

        perm(0);
    }
}
