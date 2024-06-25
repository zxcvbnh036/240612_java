package p07_Collection;

import java.util.*;

public class Ex05Set {
  public static void main(String[] args) {
    Set<Integer> set = new HashSet();
    set.add(4);set.add(4);set.add(2);set.add(3);
    System.out.println(set);
    set.add(1); set.remove(4);
    System.out.println(set);
    for (int i : set) System.out.println(i);
    Iterator it = set.iterator();
    while (it.hasNext()) System.out.println(it.next());


    Set<Integer> lotto = new HashSet<>();
    while (lotto.size() < 6) {
      int random = (int) (Math.random() * 45) + 1;
      lotto.add(random);
    }
    ArrayList list = new ArrayList(lotto);
    Collections.sort(list);
    System.out.println(lotto);

    Set<Integer> lotto2 = new TreeSet<>();
    while (lotto2.size() < 6) {
      lotto2.add((int) (Math.random() * 45) + 1);
    }
    System.out.println(lotto2);
  }
}
