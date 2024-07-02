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
        dispose(); // Join 창 닫기;
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
        new FrmMain("회원정보관리 " + newMember.getName() + "님 환영합니다.", 600, 600);
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
