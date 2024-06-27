package p10_Stream;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ex02StreamRange {
  public static void main(String[] args) {
    IntStream intStream = new Random().ints(1, 5);
    intStream.limit(5).forEach(new IntConsumer() {
      @Override
      public void accept(int x) {
        System.out.println(x);
      }
    });
    // range의 끝수는 제외
    LongStream longStream = LongStream.range(1, 46);
    longStream.forEach(new LongConsumer() {
      @Override
      public void accept(long value) {
        System.out.println(value);
      }
    });
    // rangeClosed()는 끝번호 포함
    IntStream intStream1 = IntStream.rangeClosed(1, 45);
    intStream1.forEach(new IntConsumer() {
      @Override
      public void accept(int value) {
        System.out.println(value);
      }
    });
    Stream<Integer> itrStream = Stream.iterate(0, n -> n + 2);
    itrStream.limit(5).forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println(integer);
      }
    });
    IntStream lottoStream = new Random().ints(1,46);
    lottoStream.distinct().limit(6).forEach(new IntConsumer() {
      @Override
      public void accept(int value) {
        System.out.printf("%3d",value);
      }
    });
  }
}
