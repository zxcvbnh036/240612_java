package p05_Inherit;

public class Ex04CastingReason {
  public static void main(String[] args) {
    Buyer b = new Buyer();
    Tv tv = new Tv();
    Audio audio = new Audio();
    Laptop laptop = new Laptop();
    b.buy(tv); b.buy(audio); b.buy(laptop);
  }
}

class Buyer {
  int money = 1000;

  void buy(Product product) {
     money = money - product.price;
  }
}

abstract class Product {
  public Product (int price) {
    this.price = price;
  }
  int price;
}

class Laptop extends Product {
  public Laptop() {
    super(30);
  }
}
class Tv extends Product {
  public Tv() {
    super(20);
  }
}
class Audio extends Product {
  public Audio() {
    super(40);
  }
}