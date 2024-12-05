package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_14889 {
    static int[][] scoreMap;
    static int N;

     static int[] output;

     static int minScore = Integer.MAX_VALUE;
     static int[] startMem;
     static int[] linkMem;
     static int startScore;
     static int linkScore;

     static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        scoreMap = new int[N][N];

        for(int i =0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++) {
                scoreMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        output = new int[N];

        startMem = new int[N/2];
        linkMem = new int[N/2];
        startScore = 0;
        linkScore = 0;

        comb(0, 0);

        System.out.println(minScore);
    }

    static void comb(int depth, int start) {
        if(depth == N/2) {
            // 스타트 링크 점수 구하기
            getScoreDiff();
            return;
        }

        for(int i = start; i < N;i++) {
            output[depth] = i;
            if(minScore == 0) return;
            comb(depth + 1, i + 1);
        }
    }

    static void comb2(int[] arr, int[] output, int depth, int start) {
        if(depth == 2) {
            // 점수 합하기
            score += (scoreMap[output[0]][output[1]] + scoreMap[output[1]][output[0]]);
            return;
        }

        for(int i = start;i<N/2;i++) {
            output[depth] = arr[i];
            comb2(arr, output, depth + 1, i + 1);
        }
    }
    static void getScoreDiff() {
        // 1. 스타트 / 링크 직원 배열 구하기
        int startIdx = 0 ;
        int linkIdx = 0;
        for(int i =0;i<N;i++) {
            if(output[startIdx] == i) {
                startMem[startIdx++] = i;
            } else {
                linkMem[linkIdx++] = i;
            }
        }

        // 2. 스타트 직원 점수 합 구하기
        score = 0;
        comb2(startMem, new int[2], 0, 0);
        startScore = score;

        // 3. 링크 직원 점수 합 구하기
        score = 0;
        comb2(linkMem, new int[2], 0, 0);
        linkScore = score;

        // 4. 차이 구하기
        minScore = Math.min(minScore, Math.abs(startScore - linkScore));
    }
}
