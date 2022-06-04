package service;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentServiceImpl implements StudentService, BFileService<Student> {
    List<Student> students = new ArrayList<>();
    List<Student> studentsInCourse = new ArrayList<>();
    private int id;
    private String path = "./students.txt";

    public StudentServiceImpl() {
        students = readDataFromFile(path);
        if (students.size() == 0) {
            students.add(new Student(getId(), "duc", 21, "abc", 9, 8, 10, "A"));
            setId();
            students.add(new Student(getId(), "an", 21, "asd", 9, 10, 7, "A"));
            setId();
            students.add(new Student(getId(), "hoang", 21, "qwer", 7, 8, 10, "B"));
            setId();
            students.add(new Student(getId(), "khang", 21, "ddd", 9, 8, 7, "C"));
            writeToFile(path, students);
        }
        id = students.get(students.size() - 1).getId();
    }


    public boolean checkStudentExist(List<Student> ls, int id) {
        for (Student s: ls) {
            if (s.getId() == id) {
                System.out.println(s);
                return true;
            }
        }
        return false;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public List<Student> filterCourse(String course) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCourse().equals(course)) {
                studentsInCourse.add(students.get(i));
                System.out.println(students.get(i));
            }
        }

        return studentsInCourse;
    }


    @Override
    public void add(Student student) {
        setId();
        student.setId(getId());
        students.add(student);
        writeToFile(path, students);
    }


    @Override
    public void update(Student student, int id) {
        int index = findIndexById(id);
        int cur_id = students.get(index).getId();
        student.setId(cur_id);
        students.set(index, student);
        writeToFile(path, students);
    }


    @Override
    public void updateStudentById(Student student, int id) {
        for (Student s: studentsInCourse) {
            if (s.getId() == id) {
                s = student;
                update(s, id);
                System.out.println(s);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        int index = findIndexById(id);
        students.remove(index);
        writeToFile(path, students);
    }

    @Override
    public void print() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    @Override
    public void sort() {
        students.sort(Comparator.comparing(Student::getName));
    }

    @Override
    public void sortMinToMaxByMath() {
        students.sort(Comparator.comparingInt(Student::getScoreMath));
    }

    @Override
    public void average() {
        float avgMath = 0;
        float avgEnglish = 0;
        float avgLiteral = 0;
        for (int i = 0; i < students.size(); i++) {
            avgMath += students.get(i).getScoreMath();
        }

        for (int i = 0; i < students.size(); i++) {
            avgEnglish +=  students.get(i).getScoreEnglish();
        }

        for (int i = 0; i < students.size(); i++) {
            avgLiteral += students.get(i).getScoreLiteral();
        }
        avgMath /= (float) students.size();
        avgEnglish /= (float) students.size();
        avgLiteral /= (float) students.size();
        float avgAll = (avgEnglish + avgLiteral + avgMath) / 3;

        System.out.println("Điểm trung bình môn toán của cả lớp là " + avgMath + ", môn anh là " + avgEnglish + ", môn văn là " + avgLiteral + ", và cả 3 môn là " + avgAll);
    }

    @Override
    public void sortMaxToMinByMath() {
        students.sort((s1, s2) -> {
            if (s1.getScoreMath() > s2.getScoreMath()) {
                return -1;
            } else if (s1.getScoreMath() == s2.getScoreMath()) {
                return 0;
            }
            return 1;
        });
    }

    public int getLength() {
        return students.size();
    }

    public void getIndex(int index){
        System.out.println(students.get(index));
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id++;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    public void setStudentsInCourse(List<Student> studentsInCourse) {
        this.studentsInCourse = studentsInCourse;
    }

    @Override
    public void writeToFile(String path, List list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List readDataFromFile(String path) {
        List<Student> lstudents = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lstudents = (List<Student>) ois.readObject();
            fis.close();
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstudents;
    }
}
