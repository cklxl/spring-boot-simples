package org.cklxl.helloworld.interview.classinit;

/**
 * <p>
 * 分析类加载
 * </p>
 */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }

    Son() {
//        super(); // 写不写都存在
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }

    public int test() {
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
//        Son s1 = new Son();
//        System.out.println();
//        Son s2 = new Son();
        /**
         * (5)(1)(10)(6)(9)(3)(2)(9)(8)(7)
         * (9)(3)(2)(9)(8)(7)
         */
    }
}



