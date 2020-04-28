package com.example.springboot.learning;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamLearning1 {

    public static Stream<String> stream;

    /** https://annimon.com/article/2778 */
    /*
    They are divided into intermediate operations (return Stream<T>) &
    terminal operations (return a result of definite type)
    */

    /** https://www.baeldung.com/java-8-streams-introduction */
    @Before
    public void stream_creation() {
        String[] arr = new String[]{"a", "b", "c"};
        stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");
    }

    @Test
    void distinct() {

     /*
     So, the distinct() method represents an intermediate operation, which
     creates a new stream of unique elements of the previous stream.

     And the count() method is a terminal operation, which returns stream's size.
     */
        assertEquals(3, stream.distinct().count());
    }

    @Test
    void filter() {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
        Stream<String> stream = list.stream().filter(element -> element.contains("d"));
    }

    @Test
    void mapping() {
    /*
    To convert elements of a Stream by applying a special function to them and
    to collect these new elements into a Stream, we can use the map() method
    */

        /**
         List<String> uris = new ArrayList<>();
         uris.add("C:\\My.txt");
         Stream<Path> stream = uris.stream().map(uri -> Paths.get(uri));
         */

    /*
    So, the code above converts Stream<String> to the Stream<Path>
    by applying a specific lambda expression to every element of the initial Stream.
    */

    /*
    If you have a stream where every element contains its own
    sequence of elements and you want to create a stream of these inner elements,
    you should use the flatMap() method:
    */

        /**
         * List<Detail> details = new ArrayList<>();
         * details.add(new Detail());
         * Stream<String> stream
         *   = details.stream().flatMap(detail -> detail.getParts().stream());
         */
    /*
    In this example, we have a list of elements of type Detail.
    The Detail class contains a field PARTS, which is a List<String>. With the help of the flatMap()
    method every element from field PARTS will be extracted and added to the new resulting stream.
    After that, the initial Stream<Detail> will be lost.
    */

    }

    @Test
    void matching() {
        assertTrue(stream.anyMatch(element -> element.contains("a"))); // true
        assertFalse(stream.allMatch(element -> element.contains("a"))); // false
        assertFalse(stream.noneMatch(element -> element.contains("a"))); // false
    }

    @Test
    void reduction() {
    /*
    Stream API allows reducing a sequence of elements to some value according
    to a specified function with the help of the reduce()
    method of the type Stream. This method takes two parameters:
    first – start value, second – an accumulator function.

    Imagine that you have a List<Integer> and you want to have a sum
    of all these elements and some initial Integer (in this example 23).
    So, you can run the following code and result will be 26 (23 + 1 + 1 + 1).
     */

        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);

        /* method reference*/
        List<Integer> integers1 = Arrays.asList(1, 1, 1);
        Integer reduced1 = integers.stream().reduce(23, Integer::sum);
    }

    @Test
    void collecting() {
       /*
       The reduction can also be provided by the collect() method of type Stream.
       This operation is very handy in case of converting a stream to a Collection or a Map
       and representing a stream in form of a single string. There is a utility
       class com.example.springboot.learning.Collectors which provide a solution for almost all typical collecting
       operations. For some, not trivial tasks, a custom Collector can be created.
       */

        List<String> resultList
                = stream.map(element -> element.toUpperCase()).collect(Collectors.toList());

        /* This code uses the terminal collect() operation to reduce a Stream<String> to the List<String>. */
    }

}
