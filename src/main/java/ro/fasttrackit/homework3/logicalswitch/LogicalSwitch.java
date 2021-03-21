package ro.fasttrackit.homework3.logicalswitch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class LogicalSwitch {
    private final List<Predicate<Person>> personPredicateList;

    public LogicalSwitch() {
        personPredicateList = new ArrayList<>(
                List.of(person -> person.getAge() < 19,
                        person -> person.getAge() >= 19,
                        person -> person.getAddress()
                                .equalsIgnoreCase("Romania"),
                        p -> p.getName().startsWith("A")));
    }

    public Map<Person, List<String>> filterPeople(List<Person> persons) {
        return persons.stream()
                .collect(toMap(
                        person -> person,
                        person -> personPredicateList.stream()
                                .map(personPredicate ->
                                        String.valueOf(personPredicate.test(person)))
                                .collect(toList())));
    }
}
