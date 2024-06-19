package p03_method;

public class EX04CallByValue {
  public static void main(String[] args) {
    String st; // 선언만 할 경우 String 타입의 구조만 결정된 것
    // System.out.println(st); // 초기화가 안되어서 에러
    String str = "hello";
    System.out.println(str);
    Data d = new Data();
    System.out.println("main:    "+d);
    d.value = 100;
    System.out.println(d.value);
    change(500);   // 19번 라인 호출
    change(d.value);    // 19번 라인 호출
    change((int)1.12f); // 19번 기본형 타입의 명시적 형변환
    change(d);          // 20번 라인 호출
    System.out.println(d.value);
  }
// 지역변수 = {}, 일회성, 세팅 내맘대로임
  static void change(int value) {value = 1000;}
  static void change(Data data) {
    data.value = 1000;
    System.out.println("change:    "+data);
  }
}

class Data {
  int value;
}
