package exhaustiveSearch.bruteForcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_s5_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int title = 1;
        String strTitle = null;
        while(true) {
            strTitle = String.valueOf(title);

            if(strTitle.contains("666")) {
                n--;
            }

            if(n == 0) break;

            title++;
        }

        System.out.println(strTitle);
    }
}
