package p05_Inherit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex07Anonymous {
  public static void main(String[] args) {
    MyButton myButton = new MyButton();
    Clickable clickable = new Clickable() {
      @Override
      public void click() {
        System.out.println("click");
      }
    };
    new MyFrame();
  }
}

class MyButton implements Clickable {
  @Override
  public void click() {
    System.out.println("clickMyButton");
  }
}
interface Clickable {
  void click();
}

class MyFrame extends JFrame {
  public MyFrame() throws HeadlessException {
    setSize(300, 200);
    setTitle("My Window");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new FlowLayout());
    JButton jButton = new JButton("확인");
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
      }
    });
    add(jButton);
    setVisible(true);
  }
}