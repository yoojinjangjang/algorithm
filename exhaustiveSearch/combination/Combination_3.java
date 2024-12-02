package exhaustiveSearch.combination;

public class Combination_3 {
    static int[] arr;
    static int[] output;
    static int n;
    static int r;

    static void comb(int depth, int start) {
        if(depth == r) {
            print();
            return;
        }

        for(int i = start; i < n;i++) {
            output[depth] = arr[i];
            comb(depth + 1, i );
        }
    }

    static void print() {
        for(int i = 0;i < r; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{1,2,3};
        n = 3;
        r = 2;
        output = new int[n];

        comb(0, 0);
    }



}
