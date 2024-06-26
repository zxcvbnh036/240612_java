package p07_Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex08Map {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap();
    map.put("admin", "1");
    map.put("user", "1");
    if (map.containsKey("member") == false) map.put("member", "1");
    if (!map.containsKey("member")) map.put("member", "2");
    map.put("member", "3"); // 키값 중첩 -> 마지막 값으로 덮어씀
    System.out.println(map);
    map.remove("admin");
    System.out.println(map);

    // 접근법 3가지
    // 1. key와 value를 동시에 접근
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();
      System.out.printf("key: %s, value: %s \n", entry.getKey(),
                                               entry.getValue());
    }

    // 2. key로 접근
    it = map.keySet().iterator();
    while (it.hasNext()) {
      String key = (String) it.next();
      String value = map.get(key);
      System.out.printf("k: %s, v: %s \n", key, value);
    }

    // 3. value 접근
    it = map.values().iterator();
    while (it.hasNext()) {
      String value = (String) it.next();
      System.out.printf(value);
    }

  }
}















