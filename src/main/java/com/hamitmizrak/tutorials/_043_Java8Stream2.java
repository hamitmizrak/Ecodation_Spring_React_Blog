package com.hamitmizrak.tutorials;

import java.util.*;
import java.util.stream.Collectors;

//Lambda Expression
//@FunctionalInterface
//Method Referans
//Optional
//Stream API
//Interface default ==> Gövdeli metot
//Base64 Decoder/Encoder
public class _043_Java8Stream2 {

    // streamMethod1
    public static void streamMethod1(){
        List<String> listem1=Arrays.asList("malatya","istanbul","ankara","malatya","elazıg","bursa");
       // listem1.forEach((data)->System.out.print(data+" "););
       // listem1.forEach((data)->{System.out.print(data+" ");});
//NOT: forEach() veya filter() veya    ==>Lambda Expression kullanabiliriz
       // List<String> listem2=listem1.stream(). sorted() . limit(5)        .collect(Collectors.toList());
        List<String> listem2=listem1.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .distinct()
                .filter((temp)->!temp.equals("malatya"))
                .map((temp)->temp.concat(".INC"))
                .collect(Collectors.toList());
        listem2.forEach((data)->{System.out.print(data.toUpperCase()+" ");});

        //long counter=listem1.stream().sorted(Comparator.reverseOrder()).limit(5). distinct().count();
        //System.out.println(counter);
        }
        //PSVM
    public static void main(String[] args) {
        streamMethod1();
    }
    }

