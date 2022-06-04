import model.Student;
import service.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        int choice = -1;
        Scanner input = new Scanner(System.in);

        while(choice != 0) {
            int checkEx = -2;
            System.out.println("Menu");
            System.out.println("1. Hiển thị tất cả học sinh ");
            System.out.println("2. Hiển thị học sinh có điểm Toán cao nhất");
            System.out.println("3. Thêm mới 1 học sinh ");
            System.out.println("4. Sửa học sinh theo tên ");
            System.out.println("5. Tính điểm trung bình của lớp ");
            System.out.println("6. 3 bạn điểm toán cao nhất ");
            System.out.println("7. Xem danh sách học sinh theo lớp ");
            System.out.println("0. Exit");
            System.out.println("Chọn menu: ");
            while (checkEx == -2){
                try {
                    choice =  input.nextInt();
                    checkEx = 1;
                } catch (Exception e){
                    System.out.println("Vui lòng nhập số");
                    input.nextLine();

                }
            }
            switch (choice) {
                case 1:
                    studentServiceImpl.print();
                    break;
                case 2:
                    studentServiceImpl.sortMaxToMinByMath();
                    studentServiceImpl.getIndex(0);
                    break;
                case 3:
                    int id = 0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    System.out.println("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    System.out.println("Nhập điểm Toán: ");
                    int scoreMath = scanner.nextInt();
                    System.out.println("Nhập điểm Anh: ");
                    int scoreEnglish = scanner.nextInt();
                    System.out.println("Nhập điểm Văn: ");
                    int scoreLiteral = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập lớp: ");
                    String course = scanner.nextLine();
                    studentServiceImpl.add(new Student(name, age, address, scoreMath, scoreEnglish, scoreLiteral, course));
                    studentServiceImpl.print();
                    break;
                case 4:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Tìm học sinh tên: ");
                    String find_name = sc.nextLine();
                    for (int i = 0; i < studentServiceImpl.getLength(); i++) {
                        if (studentServiceImpl.getStudents().get(i).getName().equals(find_name)) {
                            System.out.println("Tìm thấy học sinh với tên: " + find_name);
                            System.out.println("Cập nhật học sinh: ");

                            int listInfo = -1;
                            String uName = "";
                            int uAge = 0;
                            String uAddress = "";
                            int uScoreMath = 0;
                            int uScoreEnglish = 0;
                            int uScoreLiteral = 0;
                            String uCourse = "";

                            while (listInfo != 0) {
                                System.out.println("Chọn thông tin cần update:");
                                System.out.println("1. Tên");
                                System.out.println("2. Tuổi");
                                System.out.println("3. Địa chỉ");
                                System.out.println("4. Điểm toán");
                                System.out.println("5. Điểm anh");
                                System.out.println("6. Điểm văn");
                                System.out.println("7. Lớp");
                                System.out.println("0. Thoát");

                                listInfo = sc.nextInt();
                                if (listInfo == 1) {
                                    System.out.println("Nhập tên cần sửa");
                                    sc.nextLine();
                                    uName = sc.nextLine();
                                } else if (listInfo == 2) {
                                    System.out.println("Nhập tuổi cần sửa");
                                    uAge = sc.nextInt();
                                } else if (listInfo == 3) {
                                    System.out.println("Nhập địa chỉ cần sửa");
                                    sc.nextLine();
                                    uAddress = sc.nextLine();
                                } else if (listInfo == 4) {
                                    System.out.println("Nhập điểm toán cần sửa");
                                    uScoreMath = sc.nextInt();
                                } else if (listInfo == 5) {
                                    System.out.println("Nhập điểm Anh cần sửa");
                                    uScoreEnglish = sc.nextInt();
                                } else if (listInfo == 6) {
                                    System.out.println("Nhập điểm văn cần sửa");
                                    uScoreLiteral = sc.nextInt();
                                } else if (listInfo == 7) {
                                    System.out.println("Nhập lớp cần sửa");
                                    sc.nextLine();
                                    uCourse = sc.nextLine();
                                } else if (listInfo == 0){
                                    System.out.println("Thoát");
                                    break;
                                }

                            }

                            studentServiceImpl.update(new Student(uName, uAge, uAddress, uScoreMath, uScoreEnglish, uScoreLiteral, uCourse), i);

                        }

                    }
                    break;
                case 5:
                    studentServiceImpl.average();
                    break;
                case 6:
                    studentServiceImpl.sortMaxToMinByMath();
                    studentServiceImpl.getIndex(0);
                    studentServiceImpl.getIndex(1);
                    studentServiceImpl.getIndex(2);
                    break;
                case 7:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Nhập lớp cần tìm: ");
                    String course2 = sc2.nextLine();
                    studentServiceImpl.filterCourse(course2);

                    int choice1 = -1;

                    while(choice1 != 0) {
                        int checkEx1 = -2;
                        System.out.println("Menu theo lớp " + course2);
                        System.out.println("1. Sửa học sinh theo id ");
                        System.out.println("0. Exit");
                        System.out.println("Chọn menu lớp " + course2);
                        while (checkEx1 == -2) {
                            try {
                                choice1 = input.nextInt();
                                checkEx1 = 1;
                            } catch (Exception e) {
                                System.out.println("Vui lòng nhập số");
                                input.nextLine();
                            }
                        }
                        switch (choice1){
                            case 1:
                                System.out.println("Nhập id học sinh: ");
                                int id_c = sc2.nextInt();

                                if(studentServiceImpl.checkStudentExist(studentServiceImpl.getStudentsInCourse(), id_c)) {
                                    System.out.println("Tìm thấy học sinh");
                                    int listInfo = -1;

                                    List<Student> l_s = studentServiceImpl.getStudents();
                                    Student s = l_s.get(studentServiceImpl.findIndexById(id_c));
                                    String uName = s.getName();
                                    int uAge = s.getAge();
                                    String uAddress = s.getAddress();
                                    int uScoreMath = s.getScoreMath();
                                    int uScoreEnglish = s.getScoreEnglish();
                                    int uScoreLiteral = s.getScoreLiteral();
                                    String uCourse = s.getCourse();

                                    while (listInfo != 0) {
                                        System.out.println("Chọn thông tin cần update:");
                                        System.out.println("1. Tên");
                                        System.out.println("2. Tuổi");
                                        System.out.println("3. Địa chỉ");
                                        System.out.println("4. Điểm toán");
                                        System.out.println("5. Điểm anh");
                                        System.out.println("6. Điểm văn");
                                        System.out.println("7. Lớp");
                                        System.out.println("0. Thoát");

                                        listInfo = sc2.nextInt();
                                        if (listInfo == 1) {
                                            System.out.println("Nhập tên cần sửa");
                                            sc2.nextLine();
                                            uName = sc2.nextLine();
                                        } else if (listInfo == 2) {
                                            System.out.println("Nhập tuổi cần sửa");
                                            uAge = sc2.nextInt();
                                        } else if (listInfo == 3) {
                                            System.out.println("Nhập địa chỉ cần sửa");
                                            sc2.nextLine();
                                            uAddress = sc2.nextLine();
                                        } else if (listInfo == 4) {
                                            System.out.println("Nhập điểm toán cần sửa");
                                            uScoreMath = sc2.nextInt();
                                        } else if (listInfo == 5) {
                                            System.out.println("Nhập điểm Anh cần sửa");
                                            uScoreEnglish = sc2.nextInt();
                                        } else if (listInfo == 6) {
                                            System.out.println("Nhập điểm văn cần sửa");
                                            uScoreLiteral = sc2.nextInt();
                                        } else if (listInfo == 7) {
                                            System.out.println("Nhập lớp cần sửa");
                                            sc2.nextLine();
                                            uCourse = sc2.nextLine();
                                        } else if (listInfo == 0){
                                            System.out.println("Thoát");
                                            break;
                                        }

                                    }

                                    studentServiceImpl.updateStudentById(new Student(uName, uAge, uAddress, uScoreMath, uScoreEnglish, uScoreLiteral, uCourse), id_c);

                                } else {
                                    System.out.println("Không tìm thấy học sinh");
                                }

                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("No choice!");
                        }

                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
