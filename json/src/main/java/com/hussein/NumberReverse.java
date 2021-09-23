package com.hussein;

/**
 * <p>Title: NumberReverse</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/9/17 3:44 PM
 */
public class NumberReverse {

    public static void main(String[] args) {
        //int a =123456789; 输出结果b = 987654321
        int num = 123456789;
        int result = 0;
        while (num > 0) {
            result *= 10;
            result += num % 10;
            num = num / 10;
        }
        System.out.println(result);
    }
}
