package model;

public class Teacher extends Person {
    private int id;
    private int salary;
    private String courseManager;

    public Teacher() {
    }

    public Teacher(String name, int age, String address, int id, int salary, String courseManager) {
        super(name, age, address);
        this.id = id;
        this.salary = salary;
        this.courseManager = courseManager;
    }

    public Teacher(String name, int age, String address, int salary, String courseManager) {
        super(name, age, address);
        this.salary = salary;
        this.courseManager = courseManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCourseManager() {
        return courseManager;
    }

    public void setCourseManager(String courseManager) {
        this.courseManager = courseManager;
    }
}
