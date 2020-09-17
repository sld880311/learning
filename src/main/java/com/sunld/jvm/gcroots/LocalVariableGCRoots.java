package com.sunld.jvm.gcroots;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 验证虚拟机栈（栈帧中的局部变量表）中的对象引用作为GC Roots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 * @date : 2020/9/16 9:12
 */
public class LocalVariableGCRoots {

    private static final int MB_10 = 10 * 1024 * 1024;

    private byte[] memory = new byte[8 * MB_10];

    public static void main(String[] args) {
        firstGC();
        System.out.print("return main");
        System.gc();
        System.out.println(" second gc ");
    }

    private static void firstGC(){
        LocalVariableGCRoots localVariableGCRoots = new LocalVariableGCRoots();
        System.gc();
        System.out.println(" first gc ");
    }
}
