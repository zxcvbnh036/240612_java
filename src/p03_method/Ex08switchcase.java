package p03_method;

import javax.swing.*;

public class Ex08switchcase {
  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog("당신이 태어난 달 입력:");
    int birthMonth = Integer.parseInt(input);
    String result = "";
    switch (birthMonth) {
      case 3: case 4: case 5:
        result = "봄"; break;
      case 6: case 7: case 8:
        result = "여름"; break;
      case 9: case 10: case 11:
        result = "가을"; break;
      default:
        result = "겨울"; break;
    }
    System.out.println(result);

    input = JOptionPane.showInputDialog("당신의 이름을 입력:");
    String familyname = input.substring(0, 1);
    switch (familyname) {
      case "김": System.out.println("Kim"); break;
      case "이": System.out.println("Lee"); break;
      case "박": System.out.println("Park"); break;
      case "성": System.out.println("Seong"); break;
      case "최": System.out.println("Choi"); break;
      case "정": System.out.println("Jeong"); break;
      case "강": System.out.println("Kang"); break;
    }
  }
}
