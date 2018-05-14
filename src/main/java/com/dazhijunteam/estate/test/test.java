package com.dazhijunteam.estate.test;

import java.util.Scanner;

public class test {
   private static char[] color={'R','G','B'};
   public static void main(String[] args){
       Scanner scanner=new Scanner(System.in);
       String input=scanner.next();
       System.out.println(generate(input.toCharArray()));
   }

   public static char[] generate(char[] oldChar){
       for (int i=0;i<oldChar.length-1;i++){
           for (int j=0;j<oldChar.length-1;j++){
               if (index(oldChar[j])>index(oldChar[j+1])){
                   char replace=oldChar[j+1];
                   oldChar[j+1]=oldChar[j];
                   oldChar[j]=replace;
               }
           }
       }
       return oldChar;
   }

   public static int index(char c){
       for (int i=0;i<color.length;i++){
           if (color[i]==c){
               return i;
           }
       }
       return -1;
   }
}
