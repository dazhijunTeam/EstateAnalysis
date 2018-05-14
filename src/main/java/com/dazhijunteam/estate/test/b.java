package com.dazhijunteam.estate.test;

public class b {
    public static void main(String[] args){
        stu s1=(new b()).new stu(3,3);
        stu s2=s1;
        s1.a=8;
        System.out.println(s2.a);

    }
    private   class stu{
         int a;
         int b;
        stu(int a,int b){
            this.a=a;
            this.b=b;
        }

    }
}
