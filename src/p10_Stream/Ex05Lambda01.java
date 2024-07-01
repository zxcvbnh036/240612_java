package p10_Stream;

public class Ex05Lambda01 {
  public static void main(String[] args) {
    Runnable r = new Runnable() {
      @Override
      //1) 매개변수가 없을 경우 반드시 () 표기
      public void run() {
//        System.out.println("Anonymous Object");
      }
    };
    r = () -> System.out.println("Anonymous Object");
    r = () -> {System.out.println("Anonymous Object");};
    r = () -> {};  // run()메서드 안에 명령 없으면 반드시 {} 표기

    MyInterface mi = new MyInterface() {
      @Override
      public void doIt(int num) {

      }
    };
    //2) 매개변수가 1개일 때만 ()는 생략 가능, 2개이상 생략 불가
    mi = (num) -> {};
    mi = num -> {};
    MyInterface2 mi2 = (n1,n2) -> {};

    //3) 매개변수가 있고, return type이 있는 경우
    MyInterface3 mi3 = (n1,n2) -> {return n1+n2;};
    mi3 = (n1,n2) -> n1+n2; //중괄호를 생략하면 return도 생략

    //4) 중괄호안에 명령이 2개 이상이면 중괄호 생략 불가
    mi3 = (n1,n2) -> {
      n1 = n1 + 10;n2 = n2 * 10;
      return n1+n2;
    }; //중괄호를 생략하면 return도 생략

  }
}

@FunctionalInterface // 함수형 인터페이스 선언시
interface MyInterface {
  void doIt(int num);
}

@FunctionalInterface // 함수형 인터페이스 선언시
interface MyInterface2 {
  void doIt(int num1, int num2);
}

@FunctionalInterface // 함수형 인터페이스 선언시
interface MyInterface3 {
  int doIt(int num1, int num2);
}