package com.example.springboot.learning;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

public class Collectors {
    static List<String> givenList;


    /** https://www.baeldung.com/java-8-collectors */
    @Before
    public static void before(){
         givenList = Arrays.asList("a", "bb", "ccc", "dd");
    }

    @Test
    public void collectors_toCollection() {
        givenList.stream().collect(toList());
        givenList.stream().collect(toSet());

    /*
    As you probably already noticed, when using toSet and toList collectors,
    you can't make any assumptions of their implementations.
    If you want to use a custom implementation, you will need to use the toCollection collector
     with a provided collection of your choice.
    Let's create a Stream instance representing a sequence of elements and collect them into a LinkedList instance:
     */
        givenList.stream().collect(toCollection(LinkedList::new));

    /*
    Notice that this will not work with any immutable collections.
    In such case, you would need to either write a custom Collector
    implementation or use //collectingAndThen//
     */
    
    }

}
