// 15 số nguyên tố đầu tiên

public class Exercise5 {
  public static void main(String[] args) {
    int cnt = 15;
    int i = 2;
    while (cnt > 0) {
      if (checkPrime(i)) {
        System.out.println(i);
        cnt--;
      }
      i++;
    }
  }

  static boolean checkPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
