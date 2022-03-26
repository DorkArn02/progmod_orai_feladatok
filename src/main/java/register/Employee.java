package register;

public class Employee extends User{
    private int salary;
    private String position;

    public Employee(String position, int salary) {
        this.salary = salary;
        this.position = position;
    }

    public Employee(String name, int birthYear, String address, String position, int salary) {
        super(name, birthYear, address);
        this.salary = salary;
        this.position = position;
    }

    public Employee(String name, int birthYear, String address, EyeColor eyeColor, String position, int salary) {
        super(name, birthYear, address, eyeColor);
        this.salary = salary;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
