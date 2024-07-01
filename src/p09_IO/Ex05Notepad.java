package p09_IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Ex05Notepad {
  public static void main(String[] args) {
    new Notepad();
  }
}

class Notepad extends JFrame {
  private JMenuBar menuBar;
  private JMenu menuF, menuE, menuO, menuV, menuH;
  private JMenuItem miNew, miOpen, miSave, miExit, miInfo;
  private JTextArea textArea; private JScrollPane scp;
  private JFileChooser fc;

  public Notepad() throws HeadlessException {
    init();  arrange(); inflate();
  }
  //window의 구성품을 초기화
  private void init() {
    menuBar = new JMenuBar();
    menuF = new JMenu("파일(F)");menuE = new JMenu("편집(E)");
    menuO = new JMenu("서식(O)");menuV = new JMenu("보기(V)");
    menuH = new JMenu("도움말(H)");
    miNew = new JMenuItem("새로 만들기(N)");
    miOpen = new JMenuItem("열기(O)");
    miSave = new JMenuItem("저장(S)");
    miExit = new JMenuItem("끝내기(X)");
    miInfo = new JMenuItem("정보(A)");
    textArea = new JTextArea();
    scp = new JScrollPane(textArea);
    fc = new JFileChooser();
    miNew.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textArea.setText("");
      }
    });
    miOpen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int ret = fc.showOpenDialog(miOpen);
        if (ret == 0) {
          try {
            FileReader fr = new FileReader(fc.getSelectedFile().toString());
            int data;
            textArea.setText("");
            while ((data = fr.read()) != -1) {
              textArea.append(String.valueOf((char)data));
            }
            fr.close();
          } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    //파일 저장하기
    miSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int ret = fc.showSaveDialog(miSave);
        if (ret == 0) {
          try {
            File file = fc.getSelectedFile();
            FileWriter writer = new FileWriter(fc.getSelectedFile().toString());
            String text = textArea.getText();
            writer.write(text);
            writer.close();
          } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    miInfo.addActionListener(e -> {
      new InfoDialog(this, true);
    });
  }

  // 배치
  private void arrange() {
    menuF.add(miNew);menuF.add(miOpen);menuF.add(miSave);
    menuF.add(miExit); menuH.add(miInfo);
    menuBar.add(menuF);menuBar.add(menuE);menuBar.add(menuO);
    menuBar.add(menuV);menuBar.add(menuH);
    setJMenuBar(menuBar);
    add(scp);
  }
  // 나타나게 함
  private void inflate() {
    setTitle("나의 메모장");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}

class InfoDialog extends JDialog {
  public InfoDialog(JFrame fr, boolean modal) {
    super(fr, modal);
    JPanel pnl = new JPanel();
    JLabel label = new JLabel("널 위해 만들었어");
    pnl.add(label);
    add(pnl, "Center");
    setTitle("점보");
    setSize(200, 100);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}







