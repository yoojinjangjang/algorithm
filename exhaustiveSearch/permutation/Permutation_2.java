package exhaustiveSearch.permutation;

public class Permutation_2 {

    // 순열: n에서 R개의 순서가 있는 열을 뽑음
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
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth+1);
                visited[i] = false;
            }
        }

    }

    static void print(){
        for(int i = 0;i<r;i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{1,2,3};
        n = 3;
        r = 2;
        output = new int[n];
        visited = new boolean[n];

        perm(0);
    }
}
