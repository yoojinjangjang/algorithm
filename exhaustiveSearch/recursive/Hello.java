package exhaustiveSearch.recursive;

public class Hello {
    static void hello(int count) {
        if (count == 0) {
            return;
        }
        System.out.println("Hello, World!");

        hello(--count);
    }

    public static void main(String[] args) {
        int count = 2;
        hello(count);
    }

}
