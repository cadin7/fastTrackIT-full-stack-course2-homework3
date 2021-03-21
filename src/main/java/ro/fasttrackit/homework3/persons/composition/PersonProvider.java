package ro.fasttrackit.homework3.persons.composition;

import ro.fasttrackit.homework3.persons.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPersons();
}