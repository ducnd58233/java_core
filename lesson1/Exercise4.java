import java.util.Scanner;

// giải pt bậc 2

public class Exercise4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("ax^2 + bx + c = 0");
    System.out.print("Nhap a: ");
    int a = sc.nextInt();
    while ( a == 0 ) {
      System.out.println("Phuong trinh khong hop le. a != 0");
      System.out.print("Nhap a: ");
      a = sc.nextInt();
    }
    System.out.print("Nhap b: ");
    int b = sc.nextInt();
    System.out.print("Nhap c: ");
    int c = sc.nextInt();

    int delta = b * b - 4*a*c;

    if (delta < 0) {
      System.out.println("Vo nghiem.\n");
    } else if (delta == 0) {
      float x = -1 * b / (2 * a);
      System.out.printf("Nghiem kep: x1 = x2 = %.2f\n", x);
    } else {
      double x1 = ((-1.0 * b) + Math.sqrt((double)delta)) / (2.0 * a);
      double x2 = ((-1.0 * b) - Math.sqrt((double)delta)) / (2.0 * a);
      System.out.printf("Nghiem 1: x1 = %.2f\n", x1);
      System.out.printf("Nghiem 2: x2 = %.2f\n", x2);
    }
  }
}
