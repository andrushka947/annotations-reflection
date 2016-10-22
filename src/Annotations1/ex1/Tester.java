package Annotations1.ex1;


public class Tester {
    @Test(/*a = 2, b = 4*/)
    public void test(int a, int b) {
        System.out.println(Math.pow((double) a,(double) b));
    }
}
