package com.pack1;



public class ClassA {

    static InterfaceA meth1(String s1, String s2, String s3) {

        System.out.println("Calling meth1()");

        return new InterfaceA() {

            public void msg() {

                System.out.println("java is awesome");
            }
        };
    }
}