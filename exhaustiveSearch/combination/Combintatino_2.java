package exhaustiveSearch.combination;

public class Combintatino_2 {
    // 조합: n개에서 r개를 순서없이 뽑은 열
    static int[] arr;
    static boolean[] visited;
    static int n;

    static void comb(int start, int r) {
        if(r == 0) {
            print();
            return;
        }

        for(int i = start;i<n;i++){
            visited[i] = true;
            comb(i+1, r-1);
            visited[i] = false;
        }
    }

    static void print() {
        for(int i = 0;i<n;i++) {
            if(visited[i])
                System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{1,2,3};
        n = 3;
        visited = new boolean[n];

        comb(0, 2);
    }

}
