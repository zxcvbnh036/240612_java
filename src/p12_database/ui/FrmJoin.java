package p12_database.ui;

import p12_database.controller.MainController;
import p12_database.vo.Members;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmJoin extends FrmBasic {
  private JPanel pnlCenter, pnlSouth;
  private JTextField tfId, tfName, tfMobile;
  private JPasswordField pfPass;
  private JButton btnJoin, btnLogin;
  private JLabel[] labels;
  private String[] strings;

  public FrmJoin() {
    super("회원 가입", 250, 300);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  }

  @Override
  public void init() {
    strings = new String[] {"ID", "Password", "Name", "Mobile"};
    labels = new JLabel[strings.length];
    pnlCenter = new JPanel(new GridLayout(strings.length, 2));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(0,30, 20, 30));
    pnlSouth = new JPanel();
    for (int i = 0; i < strings.length; i++) {
      labels[i] = new JLabel(strings[i]);
    }
    tfId = new JTextField(10); tfName = new JTextField(10);
    tfMobile = new JTextField(10); pfPass = new JPasswordField(10);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        int choice = JOptionPane.showConfirmDialog(null,
            "로그인으로 이동하시겠어요?", "선택하시오",
            JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
          MainController.getInstance().dispatchCmd("Login",null);dispose();
        }
      }
    });
    btnJoin = new JButton("회원 가입"); btnLogin = new JButton("로그인");
    btnJoin.addActionListener(e -> {
      String id = tfId.getText();
      String pw = new String(pfPass.getPassword());
      String name = tfName.getText();
      String mobile = tfMobile.getText();
      if (id == null || id.equals("")) {
        JOptionPane.showMessageDialog(FrmJoin.this, "ID를 확인하세요");
        tfId.requestFocus();
        return;
      } else {
        boolean tmp = MainController.getInstance()
            .getMembersService().isDuplicatedId(id);
        if(tmp){
          JOptionPane.showMessageDialog(this, "중복된 ID입니다.");
          tfId.setText("");tfId.requestFocus();
          return;
        }
      }
      if (pw.equals("")) {
        JOptionPane.showMessageDialog(FrmJoin.this, "Password를 확인하세요");
        pfPass.requestFocus();
        return;
      }
      if (name.equals("")) {
        JOptionPane.showMessageDialog(FrmJoin.this, "이름을 확인하세요");
        tfName.requestFocus();
        return;
      }
      if (mobile.equals("")) {
        JOptionPane.showMessageDialog(FrmJoin.this, "Mobile을 확인하세요");
        tfMobile.requestFocus();
        return;
      }
      // 유효성검사를 완성하세요!!
      boolean result = MainController.getInstance()
          .getMembersService().insertMembers(new Members(id, pw, name, mobile));
      if (result) {
        JOptionPane.showMessageDialog(FrmJoin.this, "등록되었습니다.");
        tfName.setText("");tfId.setText("");pfPass.setText("");tfMobile.setText("");
      } else {
        JOptionPane.showMessageDialog(FrmJoin.this, "등록 실패하였습니다.");
      }

    });
    btnLogin.addActionListener(e -> {
      MainController.getInstance().dispatchCmd("Login", null);dispose();
    });
  }

  @Override
  public void arrange() {
    pnlCenter.add(labels[0]); pnlCenter.add(tfId);
    pnlCenter.add(labels[1]); pnlCenter.add(pfPass);
    pnlCenter.add(labels[2]); pnlCenter.add(tfName);
    pnlCenter.add(labels[3]); pnlCenter.add(tfMobile);
    add(pnlCenter, "Center");

    pnlSouth.add(btnJoin);   pnlSouth.add(btnLogin);
    add(pnlSouth, "South");
  }
}



/* 내 버젼
package p12_database.ui;

import p12_database.dao.MembersDAO;
import p12_database.vo.Members;

import javax.swing.*;
import java.awt.*;

public class FrmJoin extends FrmBasic {
  private JLabel lbJoin, lbName, lbId, lbPass, lbMobile;
  private JTextField tfName, tfId, tfMobile;
  private JPasswordField pfPass;
  private JButton btnJoin, btnLogin;
  private JPanel pnlCenter, pnlSouth;

  public FrmJoin(String title, int width, int height) {
    super(title, width, height);
  }

  @Override
  public void init() {
    lbJoin = new JLabel("Join");
    lbJoin.setFont(new Font("맑은 고딕", Font.BOLD|Font.CENTER_BASELINE, 30));
    lbJoin.setHorizontalAlignment(JLabel.CENTER);
    lbJoin.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
    lbId = new JLabel("Id");
    lbPass = new JLabel("Pass");
    lbName = new JLabel("Name");
    lbMobile = new JLabel("Mobile");
    tfId = new JTextField(20);
    pfPass = new JPasswordField(20);
    tfName = new JTextField(20);
    tfMobile = new JTextField(20);
    btnJoin = new JButton("Join");
    btnLogin = new JButton("Login");

    tfId.addActionListener(e -> {
      if(!isEmptId()) pfPass.requestFocus();
      else return;
    });
    pfPass.addActionListener(e -> {
      if(!isEmptPass()) tfName.requestFocus();
      else return;
    });
    tfName.addActionListener(e -> {
      if(!isEmptName()) tfMobile.requestFocus();
      else return;
    });
    tfMobile.addActionListener(e -> {
      if (!isEmptId() && !isEmptPass() && !isEmptName() && !isEmptMobile()){
        joinAccess(tfId.getText(), new String(pfPass.getPassword()),
            tfName.getText(), tfMobile.getText());}
    });

    btnJoin.addActionListener(e -> {
      if (!isEmptId() && !isEmptPass() && !isEmptName() && !isEmptMobile()) {
        joinAccess(tfId.getText(), new String(pfPass.getPassword()),
            tfName.getText(), tfMobile.getText());
      } else if (isEmptId()) {
        JOptionPane.showMessageDialog(this,
            "ID 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
      } else if (isEmptPass()){
        JOptionPane.showMessageDialog(this,
            "Pass 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
      } else if (isEmptName()){
        JOptionPane.showMessageDialog(this,
            "Name 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
      } else if (isEmptMobile()) {
        JOptionPane.showMessageDialog(this,
            "Mobile 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
      }
    });


    btnLogin.addActionListener(e -> {
        new FrmLogin("Login", 270, 200); // login 창 열기
        dispose(); // Join 창 닫기
    });

    pnlCenter = new JPanel(new GridLayout(4, 2));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(0,30,10,30));
    pnlSouth = new JPanel();
  }

  private void joinAccess(String id, String pass, String name, String mobile) {
    Members members = new MembersDAO().loginCheck(id, pass);
    if (members == null) {
      Members newMember = new Members(id, pass, name, mobile);
      new MembersDAO().insertMembers(newMember);
      boolean success = new MembersDAO().insertMembers(newMember); // 회원가입 성공여부
      if (success) { // 회원가입 성공
        JOptionPane.showMessageDialog(this, "회원가입을 축하합니다!");
        tfId.setText("");
        pfPass.setText("");
        tfName.setText("");
        tfMobile.setText("");
      } else { // 회원가입 실패
        JOptionPane.showMessageDialog(this, "회원가입에 실패하였습니다.",
            "오류", JOptionPane.ERROR_MESSAGE);
      }
    } else { // 회원 존재
      JOptionPane.showMessageDialog(this, "이미 존재하는 회원입니다.");
    }
  }

  private boolean isEmptId() {
    if(!tfId.getText().toString().trim().equals("")) return false;
    return true;
  }
  private boolean isEmptPass() {
    if(!new String(pfPass.getPassword()).toString().trim().equals("")) return false;
    return true;
  }
  private boolean isEmptName() {
    if(!tfName.getText().toString().trim().equals("")) return false;
    return true;
  }
  private boolean isEmptMobile() {
    if(!tfMobile.getText().toString().trim().equals("")) return false;
    return true;
  }

  @Override
  public void arrange() {
    add(lbJoin, "North");
    pnlCenter.add(lbId);pnlCenter.add(tfId);
    pnlCenter.add(lbPass);pnlCenter.add(pfPass);
    pnlCenter.add(lbName);pnlCenter.add(tfName);
    pnlCenter.add(lbMobile);pnlCenter.add(tfMobile);
    add(pnlCenter, "Center");
    pnlSouth.add(btnJoin);pnlSouth.add(btnLogin);
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
*/
