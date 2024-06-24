package p05_Inherit;

import java.util.Objects;

public class Ex05Override {
  public static void main(String[] args) {
    Data d1 = new Data(1);
    Data d2 = new Data(1);
    System.out.println(d1);System.out.println(d2);
    System.out.println(d1.hashCode());
    System.out.println(d2.hashCode());
    if(d1==d2) System.out.println("같다");
    if(d1.equals(d2)) System.out.println("같다");
  }
}

class Data {
  int value;
  public Data(int value) {this.value = value;}
  @Override
  public String toString() {
    // return "value:"+value;
    return String.valueOf(value);
  }

  @Override
  public boolean equals(Object obj){
    if (obj instanceof Data) {
      Data d = (Data) obj;
      return value == d.value;
    }
    return false;
  }

  @Override
  public int hashCode() {
    //hashcode의 값이 동일할 때
    return Objects.hash(value);
  }
}