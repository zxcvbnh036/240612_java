package p02_variable;

public class Ex04boolean {
  public static void main(String[] args){
    Tv tv;
    tv = new Tv();
    System.out.println(tv);

    tv.power();

    tv.channelUp();
    tv.channelDown();
    tv.channel(12);

    tv.volumeUp();
    tv.volumeDown();

  }
}

// *** class 사용하려면 instance => instance 하려면 main method
class Tv {
  boolean power;
  int channel;
  int volume;

  void power() {
    // 1
    /*if (power == false) {
      power = true;
    } else {
      power = false;
    }
    if (power == true) {
      System.out.println("Tv 전원이 켜졌습니다.");
    } else {
      System.out.println("Tv 전원이 꺼졌습니다.");
    }*/

    // 2
    /*if (power == false) {
      power = true;
      System.out.println("Tv 전원이 켜졌습니다.");
    } else {
      power = false;
      System.out.println("Tv 전원이 꺼졌습니다.");
    }*/

    // 3
    // 연산자 [?, :] = 삼항 연산자
    power = !power;
    System.out.println(power ? "전원 ON" : "전원 Off");
  }

  void channelUp() {
    /*
      channel++
      channel = channel + 1
      channel += 1
    */
    if (power) {
      System.out.println(++channel);
    }
  }

  void channelDown() {
    if (power) {
      System.out.println(--channel);
    }
  }

  void channel(int channel) {
    this.channel = channel;
  }

  void volumeUp() {
    if (power) {
      System.out.println(++volume);
    }
  }
  void volumeDown() {
    if (power) {
      System.out.println(--volume);
    }
  }

}















