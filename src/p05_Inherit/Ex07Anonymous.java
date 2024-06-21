package p05_Inherit;

public class Ex07Anonymous {
  public static void main(String[] args) {
    MyButton myButton = new MyButton();
    Clickable clickable = new Clickable() {
      @Override
      public void click() {
        System.out.println("click");
      }
    };
  }
}

class MyButton implements Clickable {
  @Override
  public void click() {
    System.out.println("clickMyButton");
  }
}
interface Clickable {
  void click();
}
