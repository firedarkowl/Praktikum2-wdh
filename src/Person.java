import java.time.LocalDate;

public class Person implements Comparable<Person>{

    private String vorname;
    private String nachname;
    private LocalDate birthday;
    private int kinder;


    public Person(String vorname, String nachname, LocalDate birthday, int kinder) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.birthday = birthday;
        this.kinder = kinder;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        if(nachname == null || nachname == ""){
            throw new IllegalArgumentException("Nachname darf nicht leer sein");
        }
        this.nachname = nachname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getKinder() {
        return kinder;
    }

    public void setKinder(int kinder) {
        if(kinder < 0){
            throw new IllegalArgumentException("Anzahl der Kinder ungültig");
        }
        this.kinder = kinder;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person comp = (Person) o;
        return (this.getVorname().equals(comp.getVorname()) && this.getNachname().equals(comp.getNachname()) && this.getBirthday().equals(comp.getBirthday()));
    }

    @Override
    public int hashCode(){
        if(vorname == null || nachname == null || kinder < 0 || birthday == null){
            throw new IllegalArgumentException("Ungültige Parameter für Hashing");
        }
        return (vorname + nachname + kinder + birthday).hashCode();
    }

    @Override
    public int compareTo(Person o) {
        return this.birthday.compareTo(o.getBirthday());
    }

    @Override
    public String toString(){
        return "Person{vorname='"+vorname+"', " + "nachname='" +nachname + "', " + "birthday=" + birthday + ", kinder=" + kinder + "}";
    }

}
