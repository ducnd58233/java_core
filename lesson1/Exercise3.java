import java.util.Scanner;

// dịch số có 3 chứ số sang chữ 

public class Exercise3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number has 3 digits: ");
    int n = sc.nextInt();

    int lastDigit = n % 10;
    int midDigit = (n % 100) / 10;
    int firstDigit = n / 100;
    String res = "";

    switch (firstDigit) {
      case 1:
        res += "Mot ";
        break;
      case 2:
        res += "Hai ";
        break;
      case 3:
        res += "Ba ";
        break;
      case 4:
        res += "Bon ";
        break;
      case 5:
        res += "Nam ";
        break;
      case 6:
        res += "Sau ";
        break;
      case 7:
        res += "Bay ";
        break;
      case 8:
        res += "Tam ";
        break;
      case 9:
        res += "Chin ";
        break;
      default:
        break;
    }

    res += "Tram ";

    switch (midDigit) {
      case 2:
        res += "Hai ";
        break;
      case 3:
        res += "Ba ";
        break;
      case 4:
        res += "Bon ";
        break;
      case 5:
        res += "Nam ";
        break;
      case 6:
        res += "Sau ";
        break;
      case 7:
        res += "Bay ";
        break;
      case 8:
        res += "Tam ";
        break;
      case 9:
        res += "Chin ";
        break;
      default:
        break;
    }

    if (midDigit == 1 && lastDigit == 0) {
      res += "Muoi";
    } else {
      res += "Muoi ";
      switch (lastDigit) {
        case 1:
          res += "Mot";
          break;
        case 2:
          res += "Hai";
          break;
        case 3:
          res += "Ba";
          break;
        case 4:
          res += "Bon";
          break;
        case 5:
          res += "Nam";
          break;
        case 6:
          res += "Sau";
          break;
        case 7:
          res += "Bay";
          break;
        case 8:
          res += "Tam";
          break;
        case 9:
          res += "Chin";
          break;
        default:
          break;
      }
    }

    System.out.println(res);
  }
}
