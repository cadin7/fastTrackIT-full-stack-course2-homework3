package ro.fasttrackit.homework3.persons.composition;

import ro.fasttrackit.homework3.persons.Person;

import java.util.List;

public class FromMemoryPersonReader implements PersonProvider {
    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Han", "Solo", 33),
                new Person("Hun", "Cute", 53),
                new Person("Kan", "Nibal", 99),
                new Person("Tet", "Ris", 13),
                new Person("Teen", "AgeR", 23),
                new Person("Ben", "Ten", 2)
        );
    }
}
