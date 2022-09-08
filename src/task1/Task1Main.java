package task1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1Main {
    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println(Arrays.toString(RAW_DATA));

//        for (Person person : RAW_DATA) {
//            System.out.println(person.id + " - " + person.name);
//        }

        System.out.println("**************************************************");
        System.out.println("Duplicate filtered, sorted by id:");
        List<Person> list = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println("**************************************************");
        System.out.println("Duplicate filtered, sorted by id and name:");
        List<Person> sortedByIdAndNameList = list.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        System.out.println(sortedByIdAndNameList);
        System.out.println("**************************************************");
        System.out.println("Duplicate filtered, sorted by id, name and grouped by name:");
        Map<String, Long> unOrderedMap = sortedByIdAndNameList.stream()
                .map(Person::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> orderedMap = new TreeMap<>(unOrderedMap);
        for (Map.Entry<String, Long> entry : orderedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
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
