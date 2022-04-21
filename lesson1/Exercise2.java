/*
B2. in 1 dãy số từ 1 đến 100. Nếu số chia hết cho 3 thì in ra hello. Chia hết cho 4 in ra My. 
Chia hết cho 5 in ra friend, chia hết cho 3 và 4 thì in hello my, 
chia hết cho 4 và 5 in ra my friend, chia hết cho 3 4 5 in ra hello my friend
*/

public class Exercise2 {
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0 && i % 4 == 0 && i % 5 == 0){
        System.out.println("hello my friend");
      }else if (i % 3 == 0 && i % 4 == 0) {
        System.out.println("hello my");
      } else if (i % 4 == 0 && i % 5 == 0) {
        System.out.println("my friend"); 
      } else if (i % 3 == 0) {
        System.out.println("hello");
      } else if (i % 4 == 0) {
        System.out.println("my");
      } else if (i % 5 == 0) {
        System.out.println("friend");
      } else {
        System.out.println(i);
      }
    }
  }
}
