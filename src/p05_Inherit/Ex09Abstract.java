package p05_Inherit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex09Abstract {
  public static void main(String[] args) {
    // 스스로 인스턴스 생성 불가 (추상 클래스, interface)
    // Abstract abs = new Abstract();
    // interface inter = new Interface();
  }
}
// 공통(표준)으로 사용위해 만듦. 인스턴스 생성 불가.
abstract class Abstract {
  int num = 10; void general(){ }
  // 추상메서드로 사용할 경우 반드시 abstract 붙일 것
  abstract void special();
}
interface Interface { }
