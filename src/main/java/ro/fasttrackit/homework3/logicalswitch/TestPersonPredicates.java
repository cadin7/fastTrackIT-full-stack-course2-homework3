package ro.fasttrackit.homework3.logicalswitch;

import java.util.List;

public class TestPersonPredicates {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Horvath Viktor", 55, "Hungary"),
                new Person("Normal Bela", 24, "Hungary"),
                new Person("Bolond Bela", 13, "Hungary"),
                new Person("Calin Daniel", 9, "Romania"),
                new Person("Alin Marin", 19, "Romania"),
                new Person("Sinko Belo", 37, "Romania"),
                new Person("AJonas Budin", 29, "Murica"),
                new Person("Don Kihote", 23, "Murica")
        );

        new LogicalSwitch().filterPeople(people)
                .forEach((person, strings) ->
                        System.out.println(
                                person.toString() + ": " +
                                        strings.toString()));
    }
}
