package com.michael;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*

        IF
        FOR
        WHILE
        x = y <operator> a

         */

        ArrayList<Component> source_components = new ArrayList<>();

        source_components.add(new Component("if", "<="));

        System.out.println(source_components.get(0).generate_assembly());



    }
}
