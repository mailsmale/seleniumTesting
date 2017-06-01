/*
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

*/
/**
 * Created by im going to use this on 3/20/2016.
 *//*

public class FirstTest {
    public static void main(String[] args) throws IOException {

*/
/*
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        String[] array = {"a1","a2","a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
        IntStream streamFromString = "123".chars();
        Stream.builder().add("a1").add("a2").add("a3").build();
        Stream<String> stream = collection.parallelStream();
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

*//*


        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Set<String> map1 = collection.stream().collect(Collectors.toSet());

        collection.stream().skip(collection.size() - 1).findFirst().orElse("1");
        collection.stream().distinct().collect(Collectors.toList());

        System.out.println(map1.getClass().toString() + map1);

        */
/*collection.stream().map(String::toUpperCase).peek(Object::toString).
                collect(Collectors.toList());*//*

        //////////////////////////////////////////////////////////////////////////////
        Collection<CustomObject> customObject = Arrays.asList(new CustomObject("Ivan"),
                new CustomObject("Serhii"),
                new CustomObject());

        int result = customObject.parallelStream().peek(x-> x.getName()).
                map(CustomObject::getCOName).peek(String::toUpperCase).
                findAny();
        mapToInt( x-> x.a).sum();
        //.reduce((s1, s2) -> s1+s2).orElse("");
        System.out.println(result);


        customObject.stream().findFirst().get();
                //.collect(Collectors.toMap(x->x.getName(), x-> x));

        */
/*Collection<String> ordered = Arrays.asList("a1", "a3", "a2", "a3", "a1");
        HashSet<String> nonordered = new HashSet<String>();
        ordered.stream().forEach(x -> nonordered.add(x.toString()));
        System.out.println(ordered.stream().distinct().collect(Collectors.toList()));
        System.out.println(nonordered.stream().distinct().collect(Collectors.toList()));
        //================MACHERS============================
        System.out.println(ordered.stream().noneMatch("*."::equals));*//*


        Collection<String> col1 = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<String> col2 = Arrays.asList("1,2,0", "4,5");
        System.out.println(col1.stream().map(x -> x + "_1").collect(Collectors.toList()));
        System.out.println(col1.stream().map( x-> Integer.parseInt(x.substring(1))).collect(Collectors.toList()));
        System.out.println(col2.stream().flatMapToInt((x) -> Arrays.asList(x.split(",")).stream().
                mapToInt(Integer::parseInt)).sum());
        List<Integer> test1 = Arrays.asList("1", "2", "3").stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(test1.stream().sorted((o1, o2)-> -o1.compareTo(o2)).collect(Collectors.toList()));






    }
}
*/
