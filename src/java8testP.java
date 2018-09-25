import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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
//        numbersAfter.forEach(System.out::println);

        Optional<Integer> o = numbers.parallelStream().filter(n -> n>7).findAny();
//        o.ifPresent(System.out::println);

        //ArrayList after map
        List<Integer> numbersAfter2 = numbers.stream().map(n -> n*2).collect(Collectors.toList());
//        numbersAfter2.forEach(System.out::println);

        List<Integer> numbersAfter3 = numbers.stream().map(n -> someLogic(n)).collect(Collectors.toList());
//        numbersAfter3.forEach(System.out::println);

        List<userDetails> users = createUsers();
        users.stream().filter(isAdult()).collect(Collectors.toList()).forEach(u ->{
            System.out.println(u.getUserName());
        });

    }

    private static List<userDetails> createUsers(){
        List<userDetails> users = new ArrayList<>();
        userDetails user1 = new userDetails("wen",30);
        userDetails user2 = new userDetails("Lee",16);
        userDetails user3 = new userDetails("Anna",28);
        userDetails user4 = new userDetails("Lu",17);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return users;
    }

    private static Predicate<userDetails> isAdult(){
        return u ->u.getAge() >18;
    }
    private static int someLogic(int n) {
        return n + 10;
    }
}
