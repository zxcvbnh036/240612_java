package p05_Inherit;

public class Ex03extends {
  public static void main(String[] args) {
    Marine m1 = new Marine();
    System.out.println(m1);
    Medic medic = new Medic();
    System.out.println(medic);
  }
}

// 추상클래스는 인스턴스 생성 불가, 상속받은 후 인스턴스 생성 가능
abstract class Unit {
  public Unit(String tribe, String name, int hp) {
    super();
    this.tribe = tribe;
    this.hp = hp;
    this.name = name;
  }
  int hp;
  String tribe;
  String name;
  public void move(int x, int y){}
  public void stop(){}

  @Override
  public String toString() {
    return String.format( "Unit{tribe=%s, name=%s, hp=%d}", tribe, name, hp );
  }
}

abstract class Protoss extends Unit {
  public Protoss(String name, int hp) {
    super("Protoss", name, hp);
  }
}

abstract class Terran extends Unit {
  // 상속할 경우에는 Member 변수와 method 만 상속
  public Terran(String name, int hp) {
    super("Terran", name, hp);
  }
}

class Marine extends Terran {
  public Marine() {
    super("Marine", 60);
  }
}

class Medic extends Terran {
  public Medic() {
    super("Medic", 45);
  }
}




