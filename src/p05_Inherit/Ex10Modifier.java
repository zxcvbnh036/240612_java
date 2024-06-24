package p05_Inherit;

import common.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex10Modifier {
  // 접근 제어자(Access Modifier) : public, protected, default, private
  // public : 두루두루 사용
  // default : 같은 패키지 내에서 사용
  // private : 클라스 내에서 사용
  public String publicVar;
  protected String protectedVar; // common 패키지에서 사용예
  String defaultVar;
  private String privateVar;
  // 메서드 앞에도 접근 제어자 4가지 다 붙음

  public static void main(String[] args) {
    // private int num = 1; // 지역변수는 접근 제어자 사용불가
    // 지역변수를 익명객체에서 쓸 때 final 붙임, java8부터 안 붙여도 됨
    final int result = 10;
    new JButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(result); // 상수라서 사용은 가능
        // result = 10; // 지역변수는 익명객체에서 변경불가
      }
    });
    Finalclass finalclass = new Finalclass();
    System.out.println(finalclass);
    // java10부터 var 사용가능
    // 선언과 초기화 분리적용 안 됨 (var name; - name="";)
    var name = "LGH"; // 동적할당가능, 단 지역변수일 때!
    Utils.typeOf(name);
  }
}
// final이 class 앞에 붙을 때 제어자는 상속이 안 됨
final class Finalclass { }
// class FinalParents extends Finalclass { }


/*
클래스 : public, default, final, abstract
메서드 : all, final, abstract, static
멤버변수 : all, final, static
지역변수 : final, var
*/


