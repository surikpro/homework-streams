import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println(Arrays.toString(RAW_DATA));

//        for (Person person : RAW_DATA) {
//            System.out.println(person.id + " - " + person.name);
//        }

        System.out.println("Duplicate filtered:");
        List<Person> list = Arrays.stream(RAW_DATA)
                .filter(Objects::nonNull)
                .distinct().toList();
        list.forEach(System.out::println);
        System.out.println("Duplicate filtered, sorted by id:");
        List<Person> sortedById = list.stream().sorted(Comparator.comparingInt(Person::getId)).toList();
        sortedById.forEach(System.out::println);
        List<Person> sortedByName = sortedById.stream().sorted(Comparator.comparing(Person::getName)).toList();
        System.out.println("Duplicate filtered, sorted by name and id:");
        sortedByName.forEach(System.out::println);
        System.out.println("**************************************************");
        System.out.println("Grouped by name:");
        sortedByName.stream()
                .map(Person::getName)
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
}
