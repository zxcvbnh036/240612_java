package p05_Inherit;

import common.Utils;

public class Ex08InterfaceCasting {
  public static void main(String[] args) {
    // 참조형 타입의 형변환은 상속관계일 때, interface일 경우 적용
    // 객체지향언어의 특징 중 하나인 다형성(Polymorphism)
    Mammals[] mammals = {new Dog(), new Cat(), new Bat()};
    Birds[] birds = {new Chicken(), new Eagle(), new Parrot()};

    Flyable[] flyables = {new Bat(), new Eagle(), new Parrot()};
    IGround[] iGrounds = {new Dog(), new Cat(), new Chicken()};
    Object obj = 10;
    Utils.typeOf(obj);
    Boolean b = false; Character c = 'A';
    Byte b1 = 0; Short s = 10; Integer i = 100; Long l1 = 10L;
    Float f1 = 0.0f; Double d1 = 1.1;
  }
}
interface Flyable {}
interface IGround {}

class Birds {}
class Parrot extends Birds implements Flyable{}
class Eagle extends Birds implements Flyable{}
class Chicken extends Birds implements IGround{}

class Mammals {}
class Dog extends Mammals implements IGround{}
class Cat extends Mammals implements IGround{}
class Bat extends Mammals implements Flyable{}
