package p12_database.ui;

import p12_database.dao.MembersDAO;
import p12_database.vo.Members;

import javax.swing.*;
import java.awt.*;

public class FrmUpdate extends FrmBasic {
  private JLabel lbUpdate, lbName, lbId, lbPass, lbMobile;
  private JTextField tfName, tfId, tfMobile;
  private JPasswordField pfPass;
  private JButton btnUpdate, btnClose;
  private JPanel pnlCenter, pnlSouth;

  public FrmUpdate(String title, int width, int height) {
    super(title, width, height);
  }

  @Override
  public void init() {
    lbUpdate = new JLabel("Update");
    lbUpdate.setFont(new Font("맑은 고딕", Font.BOLD|Font.CENTER_BASELINE, 30));
    lbUpdate.setHorizontalAlignment(JLabel.CENTER);
    lbUpdate.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
    lbId = new JLabel("Id");
    lbPass = new JLabel("Pass");
    lbName = new JLabel("Name");
    lbMobile = new JLabel("Mobile");
    tfId = new JTextField(20);
    pfPass = new JPasswordField(20);
    tfName = new JTextField(20);
    tfMobile = new JTextField(20);
    btnUpdate = new JButton("Update");
    btnClose = new JButton("Close");

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
        UpdateAccess(tfId.getText(), new String(pfPass.getPassword()),
            tfName.getText(), tfMobile.getText());}
    });

    btnUpdate.addActionListener(e -> {
      if (!isEmptId() && !isEmptPass() && !isEmptName() && !isEmptMobile()) {
        UpdateAccess(tfId.getText(), new String(pfPass.getPassword()),
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

    btnClose.addActionListener(e -> {
      new FrmMain("Main", 600, 600); // 되돌아가기
      dispose(); // Update 창 닫기;
    });

    pnlCenter = new JPanel(new GridLayout(4, 2));
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(0,30,10,30));
    pnlSouth = new JPanel();
  }

  private void UpdateAccess(String id, String pass, String name, String mobile) {

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
    add(lbUpdate, "North");
    pnlCenter.add(lbId);pnlCenter.add(tfId);
    pnlCenter.add(lbPass);pnlCenter.add(pfPass);
    pnlCenter.add(lbName);pnlCenter.add(tfName);
    pnlCenter.add(lbMobile);pnlCenter.add(tfMobile);
    add(pnlCenter, "Center");
    pnlSouth.add(btnUpdate);pnlSouth.add(btnClose);
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}

