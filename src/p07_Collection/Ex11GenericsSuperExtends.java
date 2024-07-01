package p07_Collection;

public class Ex11GenericsSuperExtends {
  public static void main(String[] args) {
    Gen1 gen1 = new Gen1();
    Gen2 gen2 = new Gen2();
    Gen3 gen3 = new Gen3();
    // <? super type>, <? extends type> 상속관계를 이용하여 타입을 제약

    // Gen2의 조상이 Gen1, Gen1을 조상으로 하는 하위 모든 자손 gen1, gen2, gen3
    GenType<? super Gen2> genType = new GenType<>(gen3);

    // Gen2를 상속받는 하위 모든 자손 gen2, gen3
    GenType<? extends Gen2> genType2 = new GenType<>(gen2);

    // ?는 모든 클래스 타입이 가능
    GenType<?> genType3 = new GenType<>(gen2);
  }
}

class Gen1 {
  String name = "Gen1";
  public String toString(){return name;}
}

class Gen2 extends Gen1 {
  String name = "Gen2";
  public String toString() {return name;}
}

class Gen3 extends Gen2 {
  String name = "Gen3";
  public String toString() {return name;}
}

class GenType<T> {
  T obj;
  public GenType(T obj){this.obj = obj;}
  public void set(T obj){ this.obj = obj;}
  public T get(){ return obj;}
}

