package exhaustiveSearch.permutation;

public class Permutation {

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        // n개의 arr에서 r개를 뽑아 순열을 output 에 담아서 출력
        if(depth == r) {
            print(output, r);
        }
        for(int i = 0;i<n;i++) {
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        for(int i = 0;i< r;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 3;
        int r = 2;
        int[] arr = {1,2,3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        permutation(arr,output,visited,0,n,r);
    }
}

