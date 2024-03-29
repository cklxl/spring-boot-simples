package org.cklxl.helloworld.interview;

/**
 * <p>
 * 分析数据入栈与赋值关系
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/10 16:35
 */
public class TestValueStack {
    public static void main(String[] args) {
        int i = 1;
        // 1(+1)
        i = i++;
        // 1(+1)
        int j = i++;
        // 11 = 2 + 3(2+1) * 3(3+1)
        int k = i + ++i * i++;
        // 4
        System.out.println("i = " + i);
        // 1
        System.out.println("j = " + j);
        // 11
        System.out.println("k = " + k);
    }
}
