import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        1.
        System.out.println(IntStream.range(0, 5).average().orElseThrow());
//        2.
        List<Item> items = List
                .of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"));
        items.stream()
                .sorted(Comparator.comparing(Item::getName, Comparator.naturalOrder()))
                .forEach(System.out::println);
//        3.
        Stream<List<String>> stringListStream = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        stringListStream.filter(l -> l.contains("c"))
                .flatMap(List::stream)
                .forEach(System.out::println);
//        4.
        List<Integer> nums = List.of(1, 2, 3);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        int max = nums.stream().mapToInt(n -> n).max().getAsInt();
        List<Person> persons = List.of(new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29));
        Person oldest = persons.stream()
                .max(Comparator.comparing(Person::getAge, Comparator.naturalOrder())).get();
        List<Integer> nums2 = List.of(10, 47, 23);
        int maxOpt = nums2.stream()
                .reduce(Integer::sum).get();
        int maxSeed = nums2.stream()
                .reduce(0, Integer::sum);
//        5.
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade2.orElse("UNKNOWN"));
        if (grade2.isPresent()) {
            grade2.ifPresent(System.out::println);
        } else {
            System.out.println(grade2.orElse("Empty"));
        }
//        6.
        List<Book> books = List.of(
                new Book("Thinking in Java",30.0),
                new Book("Java in 24 hrs", 20),
                new Book("Java Recipes", 10));
        double conditionalAverage = books.stream()
                .filter(b -> b.getPrice() > 90)
                .mapToDouble(Book::getPrice)
                .average().orElse(0);
//        7.
        List<Book> books2 = List.of(new Book("Atlas Shrugged", 10),
                new Book("Freedom at Midnight", 5),
                new Book("Gone with the wind", 5));
        books2.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice))
                .entrySet().stream()
                .filter(e -> e.getKey().startsWith("A"))
                .forEach(e -> System.out.println(e.getValue()));
//        8.
        List<Book> books3 = List.of(new Book("Gone with the wind", 5),
                new Book("Gone with the wind", 10),
                new Book("Atlas shrugged", 15));
        books3.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, Double::sum))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
//        9.
        List<Person> personList = List.of(new Person("Bob", null, 31),
                new Person("Paul", null, 32),
                new Person("John", null, 33));
        double average = personList.stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(Person::getAge)
                .average().orElse(0);
//        10.
        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(System.out::println);
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));
        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println(price2);
        if (price2.isEmpty()) {
            System.out.println("empty");
        }
        price2.ifPresent(System.out::println);
        Double x = price2.orElse(44.0);
        System.out.println(x);
        Optional<Double> price3 = Optional.ofNullable(null);
//        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
//        11.
        List<AnotherBook> anotherBooks = List.of(new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller"));
        List<String> genreList = new ArrayList<>();
        anotherBooks.stream()
                .map(AnotherBook::getGenre)
                .forEach(genreList::add);
//        12.
        DoubleStream numbers = DoubleStream.of(0, 2, 4);
        double sumOfOdds = numbers.filter(n -> n % 2 == 1).sum();
        System.out.println(sumOfOdds);
        double average2 = Stream.of(1.0, 3.0)
                .mapToDouble(Double::doubleValue)
                .filter(n -> n % 2 == 0)
                .average().orElse(0);
        System.out.println(average2);
//        13.
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        boolean anyMatch11 = ls.stream()
                .distinct()
                .anyMatch(n -> n == 11);
        System.out.println(anyMatch11);
        boolean noneMatchExp = ls.stream()
                .distinct()
                .noneMatch(n -> n % 11 > 0);
        System.out.println(noneMatchExp);
//        14.
//        Because terminal operation on the stream was never called thus the operations were not executed.
//        15.
        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
        stream.filter(e -> {
            ai.incrementAndGet();
            return e % 2 == 0;
        })
                .forEach(System.out::println);
        System.out.println(ai);
    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }
}
