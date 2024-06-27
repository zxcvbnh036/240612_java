package p09_Thread;

import javax.swing.*;

public class Ex01Thread {
  public static void main(String[] args) {
    Bomb bomb = new Bomb();
    // Thread를 상속 받으면 그 자체로 start()를 적용할 수 있다.
    // bomb.start();

    // Runnable을 implement하면 Thread() 생성자 안에
    // 매개변수로 전달해야만 생성 가능
    new Thread(bomb).start();
    int input = Integer.parseInt(JOptionPane.showInputDialog(
        "빨간선(0), 파란선(1) 중에 선택하세요"));
    bomb.choice(input);
  }
}
// Thread의 장점 : 별도의 흐름을 생성, 자원을 절약 가능
// Thread 생성 방법 : 1) Thread 상속, 2) Runnable을 implement
// 1) class Bomb extends Thread
// 2)
class Bomb implements Runnable {
  private int answer = (int) (Math.random() * 2);
  private boolean state;

  public void choice(int input) {
    state = true;
    if (input == answer) {
      System.out.println("탈출이다 ~!");
    } else System.out.println("Game Over ...");
  }

  @Override // Thread의 동작을 정의한 메서드 = run
  public void run() {
    // super.run();
    for (int i = 10; i > 0 ; i--) {
      if (state) break;
      System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
