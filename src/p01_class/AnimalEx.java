package p01_class;

public class AnimalEx {
  Animal a2 = new Animal();
  // Quiz) Animal을 인스턴스로 만들어 사용해보시오.
  public void done() {
    Animal a1 = new Animal();
    a1.run();    a2.run();
  }

  public static void main(String[] args) {
    Animal a1 = new Animal();
    a1.run();
    AnimalEx animalEx = new AnimalEx();
    animalEx.done();
    System.out.println(animalEx.a2);
    //a2.run(); // static은 같은 static 끼리만 사용: 시점이 다름.
  }
}