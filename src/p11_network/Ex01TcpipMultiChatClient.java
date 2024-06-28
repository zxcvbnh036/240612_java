package p11_network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ex01TcpipMultiChatClient extends JFrame {
  public static void main(String[] args) {
    new Ex01TcpipMultiChatClient();
  }
  private JTextArea ta;
  private JScrollPane scp;
  private JTextField tf;
  private String nickname;
  private DataOutputStream out;

  public Ex01TcpipMultiChatClient() throws HeadlessException {
    init(); arrange(); inflate();
  }

  private void init() {
    nickname = JOptionPane.showInputDialog("Input Nickname");
    String ip = JOptionPane.showInputDialog("Server IP", "10.100.204.77");

    ta = new JTextArea();ta.setEditable(false);
    scp = new JScrollPane(ta);
    tf = new JTextField();
    ta.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    try {
      Socket socket = new Socket(ip, 7777);
      out = new DataOutputStream(socket.getOutputStream());
      out.writeUTF(nickname);
      new Thread(new Receiver(socket)).start(); // implements Runnable
//      new Receiver().start(); // extends Thread
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    tf.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          out.writeUTF(nickname + ":" + tf.getText());
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void arrange() {
    add(scp, "Center");
    add(tf, "South");
  }

  private void inflate() {
    setTitle("Chatting Room");
    setSize(300, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
  }

  class Receiver implements Runnable {
    //  class Receiver extends Thread {
    DataInputStream in;

    public Receiver(Socket socket) {
      try {
        in = new DataInputStream(socket.getInputStream());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void run() {
      while (in != null) {
        try {
          System.out.println(in.readUTF());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}

