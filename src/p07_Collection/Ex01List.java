package p07_Collection;

import common.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Ex01List {
  public static void main(String[] args) {
    // 순서 있다, 중복 된다
    // List의 타입은 Object
    // List<Member> list = new ArrayList(); = 타입 한정
    List list = new ArrayList();
    list.add(new Member("hgd", "1", "홍길동"));
    list.add(new Member("kgd", "1", "김길동"));
    list.add(new Member("jgd", "1", "정길동"));
    list.add(10); list.add(true);
    list.remove(2);

    System.out.println(list);

    // 1. for index
     for (int i = 0; i < list.size(); i++) Utils.typeOf(list.get(i));
       // list.get(0) 타입 = Object

    // 2. enhanced for
     for(Object o : list) Utils.typeOf(o);

    // 3. iterator
    Iterator it = list.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }


    // 4. foreach
    // 익명객체는 일회성, 참조할 일 없는 경우
    list.forEach(new Consumer() {
      @Override
      public void accept(Object o) {
        Utils.typeOf(o);
      }
    });
    // 4-1. 람다식(Lambda)
    list.forEach(o -> Utils.typeOf(o));


    // 4-2. 4번의 full ver
    // interface의 형변환
    // 클래스를 생성해야 하는 경우, 참조할 경우가 있을 경우
    class ObjConsumer implements Consumer {
      String lists = "";
      @Override
      public void accept(Object o) {
        lists += o;
        Utils.typeOf(o);
      }
    }
    ObjConsumer oc = new ObjConsumer();
    list.forEach(oc); // list.forEach(Consumer consumer)
    System.out.println(oc.lists);
    System.out.println(">> " + list.contains(10));
    list.addAll(new ArrayList(5));
    list.clear(); // 모두 삭제
    System.out.println(list);
    System.out.println(list.isEmpty());

  }
}

class Member {
  private String id;
  private String pass;
  private String name;

  public Member(String id, String pass, String name) {
    this.id = id;
    this.pass = pass;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("%s(ID: %s)", name, id);
  }
}











