import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testEquals() {
        Person person1 = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);
        Person person2 = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);
        Person person3 = new Person("Bob", "Johnson", LocalDate.of(1985, 10, 20), 1);

        assertTrue(person1.equals(person2));
        assertFalse(person1.equals(person3));
    }

    @Test
    public void testHashCode() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        int expectedHashCode = (person.getVorname() + person.getNachname() + person.getKinder() + person.getBirthday()).hashCode();
        assertEquals(expectedHashCode, person.hashCode());
    }

    @Test
    public void testSetNachname() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        assertThrows(IllegalArgumentException.class, () -> person.setNachname(null));
    }

    @Test
    public void testSetKinder() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        assertThrows(IllegalArgumentException.class, () -> person.setKinder(-1));
    }

    @Test
    public void testToString() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        String expectedToString = "Person{vorname='Alice', nachname='Smith', birthday=1990-05-15, kinder=2}";
        assertEquals(expectedToString, person.toString());
    }

    @Test
    public void testCompareTo() {
        Person person1 = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);
        Person person2 = new Person("Bob", "Johnson", LocalDate.of(1985, 10, 20), 1);

        assertTrue(person1.compareTo(person2) > 0);
        assertTrue(person2.compareTo(person1) < 0);
        assertEquals(0, person1.compareTo(person1));
    }

    @Test
    public void testModifyKinder() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        person.setKinder(3);
        assertEquals(3, person.getKinder());

        assertThrows(IllegalArgumentException.class, () -> person.setKinder(-1));
    }

    @Test
    public void testModifyNachname() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        person.setNachname("Johnson");
        assertEquals("Johnson", person.getNachname());

        assertThrows(IllegalArgumentException.class, () -> person.setNachname(null));
    }

    @Test
    public void testGetVorname() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);
        assertEquals("Alice", person.getVorname());
    }

    @Test
    public void testGetNachname() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);
        assertEquals("Smith", person.getNachname());
    }

    @Test
    public void testGetBirthday() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);
        assertEquals(LocalDate.of(1990, 5, 15), person.getBirthday());
    }

    @Test
    public void testModifyNachnameEmptyString() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        assertThrows(IllegalArgumentException.class, () -> person.setNachname(""));
    }

    @Test
    public void testModifyNachnameValidInput() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        person.setNachname("Johnson");
        assertEquals("Johnson", person.getNachname());
    }

    @Test
    public void testModifyKinderValidInput() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        person.setKinder(0);
        assertEquals(0, person.getKinder());
    }

    @Test
    public void testModifyKinderNegativeInput() {
        Person person = new Person("Alice", "Smith", LocalDate.of(1990, 5, 15), 2);

        assertThrows(IllegalArgumentException.class, () -> person.setKinder(-1));
    }


}
