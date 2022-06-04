package model;

public class Student extends Person {
    private int id;
    private int scoreMath;
    private int scoreEnglish;
    private int scoreLiteral;
    private String course;

    public Student() {}

    public Student(int id, String name, int age, String address, int scoreMath, int scoreEnglish, int scoreLiteral, String course) {
        super(name, age, address);
        this.id = id;
        this.scoreMath = scoreMath;
        this.scoreEnglish = scoreEnglish;
        this.scoreLiteral = scoreLiteral;
        this.course = course;
    }

    public Student(String name, int age, String address, int scoreMath, int scoreEnglish, int scoreLiteral, String course) {
        super(name, age, address);
        this.scoreMath = scoreMath;
        this.scoreEnglish = scoreEnglish;
        this.scoreLiteral = scoreLiteral;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(int scoreMath) {
        this.scoreMath = scoreMath;
    }

    public int getScoreEnglish() {
        return scoreEnglish;
    }

    public void setScoreEnglish(int scoreEnglish) {
        this.scoreEnglish = scoreEnglish;
    }

    public int getScoreLiteral() {
        return scoreLiteral;
    }

    public void setScoreLiteral(int scoreLiteral) {
        this.scoreLiteral = scoreLiteral;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                " id=" + getId() +
                ", name=" + super.getName() +
                ", age=" + super.getAge() +
                ", address=" + super.getAddress() +
                ", scoreMath=" + scoreMath +
                ", scoreEnglish=" + scoreEnglish +
                ", scoreLiteral=" + scoreLiteral +
                ", course=" + course +
                " }";
    }
}
