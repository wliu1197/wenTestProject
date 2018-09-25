import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class java8testP {
    public static void main(String [] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(8);

        //arrayList with filter
        List<Integer> numbersAfter = numbers.stream().filter(n -> n>2).collect(Collectors.<Integer>toList());
        numbersAfter.forEach(System.out::println);

        Optional<Integer> o = numbers.parallelStream().filter(n -> n>7).findAny();
        o.ifPresent(System.out::println);



    }
}
