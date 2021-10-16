package Data.Person;

public abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(){
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return null;
    }

}
