package p08_IO;

import java.io.*;
import java.util.ArrayList;

public class Ex07Serializable {
  public static void main(String[] args) {
    User u1 = new User("LGH", 10);
    User u2 = new User("LSM", 10);
    ArrayList<User> list = new ArrayList<>();
    list.add(u1);
    list.add(u2);
    String exportFile = "UserInfo.ser";

    try {
      FileOutputStream fos = new FileOutputStream(exportFile);
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(u1);
      oos.writeObject(u2);
      oos.writeObject(list);
      oos.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      FileInputStream fis = new FileInputStream(exportFile);
      BufferedInputStream bis = new BufferedInputStream(fis);
      ObjectInputStream ois = new ObjectInputStream(bis);
      User get1 = (User) ois.readObject();
      User get2 = (User) ois.readObject();
      ArrayList result = (ArrayList) ois.readObject();
      System.out.println(get1);
      System.out.println(get2);
      System.out.println(result);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}

class User implements Serializable {
  private String name;
  private int age;

  public User() {
    this("Unknown", 10);
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + "/" + age;
  }
}