package com.hamitmizrak.tutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Lambda Expression
//@FunctionalInterface
//Method Referans
//Optional
//Stream API
//Interface default ==> Gövdeli metot
//Base64 Decoder/Encoder
public class _043_Java8Stream {

    // streamMethod1
    public static void streamMethod1(){

        List<Integer> listem1=Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> listem2=new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listem2.add(i);
        }
        //1.YÖNTEM
        for (int i = 0; i <listem2.size(); i++) {
            System.out.print(listem2.get(i)+" ");
        }
        System.out.println("\n****************************");

        //2.YÖNTEM
        Iterator iterator=listem2.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println("\n****************************");

        //3.YÖNTEM
        listem2.forEach(System.out::print);
        System.out.println("\n****************************");
        listem2.stream().forEach(System.out::print);
        System.out.println("\n****************************");
        //NOT: forEach içerisine Lambda Expression yazabilirsiniz
        listem2.stream().forEach( temp-> System.out.print(temp+" ") );

        // JS   ==>   ()=>{}
        //Java ==>   ()->{}



        }

        //PSVM
    public static void main(String[] args) {
        streamMethod1();
    }
    }

