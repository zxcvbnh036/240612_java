package p05_Inherit;

public class Ex02extends {
  public static void main(String[] args) {
    Marine m1 = new Marine();
    System.out.println(m1.hp);
  }
}

abstract class Unit {
  int hp;
  String tribe;
  public void move(int x, int y){}
  public void stop(){}
}

abstract class Terran extends Unit {

}

class Marine extends Terran {

}