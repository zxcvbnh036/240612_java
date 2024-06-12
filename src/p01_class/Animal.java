package p01_class;

public class Animal {
  /*
  클래스 선언할 경우
  1) 멤버변수와 메서드가 없어도 클래스를 선언가능.
  2) 멤버변수와 메서드를 정의하려고 하면 반드시 클래스를 선언.
  3) 파일명과 일치하는 클래스에만 public 사용가능.
  4) 클래스를 사용하려면 인스턴스로 만들어야 한다.
  5) 클래스는 new를 통해 인스턴스를 생성할 수 있다.

  명명규칙
  1)영문 대소 문자와 한글을 사용할 수 있다.
  - abc(O),ABC(O),aBc(O),가나다(O)
  2)특수 문자는 밑줄(_)과 달러($)표기만 사용이 가능하다.
  - $abc(O),_abc(O),ab_c(O),$abc_(O)
  3)아라비아 숫자를 사용할 수 있다. 단, 첫 번째 글자로는 사용할 수 없다.
  - a3bc(O),ab3c(O),abc3(O),3abc(X)
  4)자바에서 사용하는 예약어는 사용할 수 없다.
  - int(X),break(X),public(X),static(X) 등등
  */
  public int legs;
  String color;

  public void run() {
    System.out.println(legs);
  }
}