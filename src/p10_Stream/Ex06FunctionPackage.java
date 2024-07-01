package p10_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex06FunctionPackage {
  // 자주 쓰이는 메서드 형식 4가지를 @FunctionalInterface형태로 만듦.
  public static void main(String[] args) {
    // 1. 매개변수 없고 리턴타입이 있을 때
    Supplier<Integer> supplier = new Supplier<Integer>() {
      @Override
      public Integer get() {
        return (int) (Math.random() * 100) + 1;
      }
    };
    supplier = () -> (int) (Math.random() * 100) + 1;

    //2. 매개변수 있고 리턴타입이 없을 때
    Consumer<Integer> consumer = new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.print(integer);
      }
    };
    consumer = integer -> System.out.println(integer);

    //3. 매개변수도 있고 리턴타입도 있을 때
    Function<Integer, Integer> function = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer integer) {
        return integer * 10;
      }
    };
    function = integer -> integer * 10;

    //4. 매개변수도 있고 리턴타입도 있는데 리턴 타입이 boolean일 때
    Predicate<Integer> predicate = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer % 2 == 0;
      }
    };
    predicate = integer -> integer % 2 == 0;

    //응용
    List<Integer> list = new ArrayList<>();
    makeRandomList(supplier, list);
    System.out.println(list);
    printEven(predicate, consumer, list);
    List<Integer> newList = doSomething(function, list);
    System.out.println(newList);
  }
  private static <T> void makeRandomList(Supplier<T> supplier, List<T> list) {
    for (int i = 0; i < 10; i++) list.add(supplier.get());
  }
  private static <T> List<T> doSomething(Function<T,T> function, List<T> list) {
    List<T> tempList = new ArrayList<T>(list.size());
    for(T item : list) tempList.add(function.apply(item));
    return tempList;
  }

  private static <T> void printEven(Predicate<T> predicate, Consumer<T> consumer, List<T> list) {
    for(T i: list) if(predicate.test(i)) consumer.accept(i);
    System.out.println();
  }
}