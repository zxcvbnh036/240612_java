package p07_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class Ex10Generics {
  public static void main(String[] args) {
    // Generics 사용목적
    //1) 형변환 코드를 생략하여 간결해짐.
    //2) 타입의 안정성을 도모.
//    ArrayList list = new ArrayList();  // 제네릭스 미사용
    ArrayList<Card> list = new ArrayList(); //제네릭스 사용
    list.add(new Card(7,"Spade","rect"));list.add(new Card(2,"Spade", 2));
    list.add(new Card(3,"Spade", true));
    list.add(new Card(4,"Spade", new Object()));list.add(new Card(5,"Spade",'A'));
//    Card card = (Card) list.get(0); // 제네릭스 미사용
    Card card = list.get(0); // 제네릭스 사용

    // 배열을 List 타입으로 변경하는 3가지 방법
//    Card[] cards = list.toArray(new Card[list.size()]); //Java 8 이전
//    Card[] cards = list.stream().toArray(Card[]::new); //Java 8 이후
//    Card[] cards = list.toArray(Card[]::new); //Java 11 이후
    Card[] cards = list.toArray(new IntFunction<Card[]>() { //Java 11 이후
      @Override
      public Card[] apply(int value) {
        System.out.println(">>"+value); //0인 이유:
        //배열을 가리키는 참조변수는 null대신 길이가 0인 배열로 초기화하기도 함.
        //배열의 길이가 0인 이유는 배열을 참조하기 위함.
        return new Card[value];
      }
    });
    Deck<Card> deck = new Deck<>();
    deck.set(cards);
    deck.print();
  }
}
/*
class Card {
  private int num; private String type;
  public Card(int num, String type) {this.num = num;this.type=type;}
  public String toString(){return num + "/" + type;}
}
*/
class Card<K,V,G> {
  private K num; private V type;private G fig;
  public Card(K num, V type, G fig) {this.num = num;this.type=type;this.fig = fig;}
  public void setKVG(K num, V type, G fig){
    this.num = num;this.type=type;this.fig = fig;
  }
  public String toString(){return num + "/" + type;}
}
class Deck<T> {
  T[] deck;  // Card[] deck;

  void set(T[] deck) {
    this.deck = deck;
  }

  void print() {
    for (int i = 0; i < deck.length; i++) {
      if (i != 0) System.out.print(", ");
      System.out.print(deck[i]);
    }
    System.out.println();
  }
}
