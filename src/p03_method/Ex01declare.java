package p03_method;

import common.Utils;

public class Ex01declare {
  // 메서드의 구조
  // return type (10 가지)
  // return 없는 경우 => void
  // return 있는 경우 => primitive(8가지), reference (1가지)

  boolean b1;

  void print1() {
    System.out.println("Hello method~!");
    // return; // 암묵적으로 return 생략
  }
  boolean print2() {
    /*boolean result;
    Ex01declare ex01declare = new Ex01declare();
    result = ex01declare.b1;
    return result;*/
    return new Ex01declare().b1; // false를 리턴
  }
  char print3() {
    return 'C';
  }
  int print4() { return 10; }
  int print6() { return (int) 0.0; }
  double print5() {
    System.out.println("print5");
    return 10; //return 이후의 문장은 효용 없음.
    // System.out.println();
  }

  boolean print() {boolean result = false;return result;}
  boolean print(boolean result) {return result;}
  char print(char c) {return c;}
  int print(int i) {return i;}
  double print(double d) {return d;}

  public static void main(String[] args) {
    Ex01declare e1 = new Ex01declare();
    e1.print1();
    System.out.println(e1.print2());
    System.out.println(e1.print5());
    System.out.println(e1.print());
    System.out.println(e1.print(true));
    System.out.println(e1.print('Z'));
    System.out.println(e1.print(1000));
    System.out.println(e1.print(1000.10));
    Utils.typeOf(10/3);
    System.out.println(MyMath.divide(10, 3));
    System.out.println(Math.max(1,3));
    MyMath.shareRemain(10, 3);
  }
}

class MyMath {
  // 메서드가 가지는 기능
  // 1) 객체의 속성(상태)을 처리하는 기능
  // 2) 객체의 속성(상태)를 온전(보호, 보완)하게 하는 기능

  static double add(int n1, int n2) {
//    return n1 + n2 + 0.0;
    return (double) (n1 + n2);
  }

  static int subtract(int n1, int n2) {return n1 - n2;}
  static int multiply(int n1, int n2) {return n1 * n2;}
  static double divide(int n1, int n2) {
    double result = (double) (n1 / n2);
//    double result = n1 / (double) n2;
    return result;
  }
  // Quiz 나머지와 몫을 구하는 메서드를 만드시오.
  public static int share(int n1, int n2){
    return n1 / n2;
  }

  public static int remain(int n1, int n2) {
    return n1 % n2;
  }
  public static void shareRemain(int n1, int n2) {
//    System.out.println("몫은 " + share(n1, n2));
//    System.out.println("나머지는 " + remain(n1, n2));
    System.out.println("몫은 " + share(n1, n2)
        + " 나머지는 " + remain(n1, n2));
    System.out.printf("몫은 %d 나머지는 %d \n", share(n1, n2), remain(n1, n2));
    System.out.println(
        String.format("몫은 %d 나머지는 %d", share(n1, n2), remain(n1, n2))
    );
  }
}
