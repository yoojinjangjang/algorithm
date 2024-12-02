package exhaustiveSearch.permutation;

public class Permutation_3 {
    static int[] arr;
    static int[] output;
    static int n;
    static int r;

    static void perm(int depth) {
        if(depth == r) {
            print();
            return;
        }

        for(int i =0;i<n;i++) {
            output[depth] = arr[i];
            perm(depth + 1);
        }
    }

    static void print() {
        for(int i =0;i<r;i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{1,2,3};
        n = 3;
        output = new int[n];
        r = 2;

        perm(0);
    }
}
