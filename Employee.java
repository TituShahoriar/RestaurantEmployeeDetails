class Employee extends Empp {
    String name;
    int age;
    String position;

    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Position: " + position;
    }
}

