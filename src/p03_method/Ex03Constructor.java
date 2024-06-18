package p03_method;

public class Ex03Constructor {
  public static void main(String[] args) {
    Car gv70 = new Car();
  //  gv70.setColor("white");
    System.out.println(gv70.getColor());
  }
}

class Car {
  // 생성자는 없어도 기본 생성자가 자동으로 생성
  // 생성자는 new에 의해서 instance가 생성
  // 사용자가 생성자를 등록하면 기본 생성자는 자동 추가 안 됨
  // 생성자도 overloading 이 된다.

  // this = 자신이 속한 class
  // this. = 멤버변수 = 속성
  // this() = 자신이 속한 생성자
  public Car() {
    this("GV80", "whith", "hd");
  }
  public Car(String mod, String color, String maker) {
    model = mod;
    this.color = color;
    this.maker = maker;
  }
  private String model;
  private String color;
  private String maker;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
      this.color = color;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }

}









