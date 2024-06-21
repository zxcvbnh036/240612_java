package p05_Inherit;

public class Ex06Interface {
  public static void main(String[] args) {
    Athlete athlete = new Athlete();
    System.out.println(athlete);
  }


}

// java(class)에서는 다중상속이 안 된다. 그래서, interface를 사용한다.
// interface 다중상속 가능
class Athlete implements ISwim, IBicycle, IMarathon{
  @Override
  public void swim() {
    // 중복된 상수는 static 붙어 있기 때문에 클래스와 함께 지정
    System.out.println(IBicycle.LEVEL);
  }
  @Override
  public void ride() {
    Triathlon.start();
  }
  @Override
  public void run() {

  }
}

// interface는 추상자료형, 반드시 class에서 implements 후에 사용
// 목적: 클래스들이 구현해야 하는 동작을 보완하기 위해 사용
// 장점: 표준화가 가능
interface ISwim {
  // 추상메서드와 상수만 정의(static, default 메서드 추가)
  public abstract void swim();
  public static final int LEVEL = 10;

}

interface IBicycle {
  void ride();
  int LEVEL = 20;
}

interface IMarathon {
  void run();
}

interface Triathlon extends ISwim, IBicycle, IMarathon {
  public default void complete() {
    swim(); ride(); run();
  }

  public static void start() {
    System.out.println("출발이다!");
  }
}