package exhaustiveSearch.permutation;

public class CombPerm {
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static int n;
    static int r;

    // 순열
    static void perm(int depth) {
        if(depth == r) {
            print();
            return;
        }

        for(int i =0;i<n;i++) {
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }

    }

    // 중복 순열
    static  void dupPerm(int depth) {
        if(depth == r) {
            print();
            return;
        }

        for(int i =0;i<n;i++) {
            output[depth] = arr[i];
            perm(depth + 1);
        }

    }

    // 조합
    static void comb(int depth, int start) {
        if(depth == r) {
            print();
            return;
        }

        for(int i = start; i< n;i++) {
            output[depth] = arr[i];
            comb(depth + 1, i + 1);
        }
    }

    // 중복 조합
    static void dupComb(int depth, int start) {
        if(depth == r) {
            print();
            return;
        }

        for(int i =start;i<n;i++) {
            output[depth] = arr[i];
            comb(depth+1, i);
        }
    }



    // 출력
    static void print() {
        for(int i =0;i<r;i++) {
            System.out.print(output[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{1,2,3};
        n = 3;
        r = 2;

        // 순열
        output = new int[n];
        visited = new boolean[n];
        System.out.println("순열");
        perm(0);

        // 중복순열
        System.out.println("중복순열");
        dupPerm(0);

        // 조합
        System.out.println("조합");
        comb(0,0);

        // 중복조합
        System.out.println("중복조합");
        dupComb(0,0);
    }



}

