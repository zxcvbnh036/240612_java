package p05_Inherit;

public class Ex02Object {
  public static void main(String[] args) {
    Member m1 = new Member("LGH", "010-3446-7374");
    String str = new String("hello");
    System.out.println(m1);
    System.out.println(str);
    System.out.println(m1 instanceof Object);
    System.out.println(m1 instanceof Member);
    // 에러 System.out.println(m1 instanceof String);
  }
}
// 모든 class는 Object를 상속 받는다.
// extends Object 안 써도 됨.
// 상속할 경우에는 Member 변수와 method 만 상속
class Member extends Object {
  // Object 메서드 9가지
  String name, mobile;

  public Member(String name, String mobile) {
    this.name = name;
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return String.format("%s, %s", name, mobile);
  }
}

class Phone { int key; }
class Computer { int key; }
// java는 다중상속 불허용 --> 명확하기 때문
// class Smartphone extends Phone, Computer { }










