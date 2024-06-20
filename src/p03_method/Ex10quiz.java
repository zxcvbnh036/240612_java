package p03_method;

import javax.swing.*;

public class Ex10quiz {
  public static void main(String[] args) {
    // 배열 : 같은 변수의 이름으로 반복되는 작업을 위한 저장 공간
    boolean stop = false;
    do {
      System.out.println("\n[가위바위보 게임]");
      String input = JOptionPane.showInputDialog("가위(0), 바위(1), 보(2) 입력 또는 종료버튼 Q/q");

      // 게임 종료 확인
      if (input.equalsIgnoreCase("q")) {
        stop = true;
        break;
      }

      int me;
      try {
        me = Integer.parseInt(input);
        if (me < 0 || me > 2) {
          System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
          continue;
        }
      } catch (Exception e) {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        continue;
      }
      int you = (int) (Math.random() * 3);

      System.out.println("컴퓨터: " + changeSign(you));
      System.out.println("나: " + changeSign(me));

      // 결과
      if (me == you) {
        System.out.println("비겼습니다.");
      } else if ((me == 0 && you == 2) || (me - you == 1)) {
        System.out.println("이겼습니다.");
      } else {
        System.out.println("졌습니다.");
      }
    } while (!stop);
    System.out.println("게임을 종료합니다.");
  }

  static String changeSign(int num) {
    String randomStr;
    switch (num) {
      case 0:
        randomStr = "가위";
        break;
      case 1:
        randomStr = "바위";
        break;
      case 2:
        randomStr = "보";
        break;
      default:
        randomStr = "알 수 없음";
        break;
    }
    return randomStr;
  }
}