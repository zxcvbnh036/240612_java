package p03_method;

import javax.swing.*;

public class Ex10while {
  public static void main(String[] args) {
    int i = 0;
    int sum = 0;
    while (i < 10) {
      sum += i++;
    }
    System.out.println(sum);
    System.out.println();

    i = 2;
    int j = 1;
    while (j < 10) {
      i = 2;
      while (i < 10) {
        System.out.printf("%d * %d = %2d \t", i, j, i++ * j);
      }
      j++;
      System.out.println();
    }
    System.out.println();


    System.out.println("======내 마음의 숫자를 맞추기 게임=======");
    boolean stop = false;
    while (true) {
      int random = (int) (Math.random() * 100) + 1; // 0~99이므로 +1을 해주어야, int 뒤에 ()로 감싸주기
      if (stop) {break;}
      while (true) {
        String input = JOptionPane.showInputDialog("숫자를 입력하세요(종료하려면 Q,q)");
        if (input.toLowerCase().equals("q")) {
          stop = true;
          break;
        } else {
          int answer = Integer.parseInt(input);
          if (answer > random) {
            System.out.println("입력하신 값보다 작습니다");
          } else if (answer < random) {
            System.out.println("입력하신 값보다 큽니다");
          } else {
            System.out.println("정답입니다");
          }
        }
      }
    }
  }
}

