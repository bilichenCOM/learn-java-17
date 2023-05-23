import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> listPeople = getPeople();
        sortName(listPeople);
        sortAge(listPeople);
        sortHeight(listPeople);
        listPeople.forEach(System.out::println);
    }

    private static void sortName(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getName, Comparator.naturalOrder()));
    }

    private static void sortAge(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getAge, Comparator.comparingInt(a -> a)));
    }

    private static void sortHeight(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getHeight, Comparator.comparingDouble(h -> h)));
    }

    private static List<Person> getPeople() {

        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));

        result.add(new Person("Mary", 25, 1.4));

        result.add(new Person("Alan", 34, 1.7));

        result.add(new Person("Zoe", 30, 1.5));

        return result;

    }

    static class Person {

        private String name;

        private int age;

        private double height;
        public Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
}
