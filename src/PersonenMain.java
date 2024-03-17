import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PersonenMain {

    public static void main(String[] args) {

        Map<String, Person> personen = new PM2Map();

        Person[] persons = {
                new Person("Anna", "Schmidt", LocalDate.of(1970, 12, 15), 2),
                new Person("Michael", "Wagner", LocalDate.of(1950, 6, 28), 4),
                new Person("Laura", "Müller", LocalDate.of(2001, 4, 3), 1),
                new Person("Julia", "Hoffmann", LocalDate.of(1988, 9, 20), 2),
                new Person("Simon", "Keller", LocalDate.of(2004, 3, 10), 0),
                new Person("Sophie", "Lehmann", LocalDate.of(1997, 7, 5), 4),
                new Person("Felix", "Schulz", LocalDate.of(1983, 11, 18), 1),
                new Person("Hannah", "Fischer", LocalDate.of(1994, 8, 25), 1),
                new Person("David", "Becker", LocalDate.of(1999, 1, 30), 3),
                new Person("Lena", "Hermann", LocalDate.of(1961, 5, 12), 5)
        };

        for (Person person : persons) {
            personen.put(person.getVorname() + " " + person.getNachname(), person);
        }

        //Nutzen Sie nun die Streams-Konzepte der Map, um alle Personen zu filtern, die vor 1984
        //geboren wurden und diese dann absteigend nach der Anzahl von Kindern zu sortieren.
        //Geben Sie die sortierte Liste auf der Konsole aus.
        List<PM2Map.Entry<String, Person>> filtered = personen.entrySet().stream()
                .filter(p -> p.getValue().getBirthday().isBefore(LocalDate.of(1984, 1, 1)))
                .sorted(Comparator.comparingInt((PM2Map.Entry<String, Person> e) -> e.getValue().getKinder()).reversed())
                .collect(Collectors.toList());

        filtered.forEach(e -> System.out.println(e.getValue().toString()));
    }

}
