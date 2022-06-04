package service;

import model.Student;

import java.util.List;

public interface StudentService extends GeneralService<Student> {
    int findIndexById(int id);

    List<Student> filterCourse(String course);

    void updateStudentById(Student t, int id);

    void sortMinToMaxByMath();

    void average();

    void sortMaxToMinByMath();
}
