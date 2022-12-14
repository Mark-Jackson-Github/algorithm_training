package com.mark.zuoshen.stack_queue;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 *
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 *
 * 思路：
 *
 *
 */
public class getAndRemoveLastElement {
    public static int getAndRemoveLastElements(Stack<Integer> stack){

        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElements(stack);
            stack.push(result);
            return last;
        }
    }


    //逆序一个栈
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElements(stack);
        reverse(stack);
        stack.push(i);
    }
}
