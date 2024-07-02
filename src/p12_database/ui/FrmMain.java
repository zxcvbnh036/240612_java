package p12_database.ui;

import p12_database.dao.MembersDAO;
import p12_database.vo.Members;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FrmMain extends FrmBasic {
  private JTable tbl;
  private JScrollPane scp;
  private JLabel lbTitle;
  private DefaultTableModel tableModel;
  private JPanel pnlBtn;
  private JButton btnModify, btnDelete;

  public FrmMain(String title, int width, int height) {
    super(title, width, height);
    ArrayList<Members> list = new MembersDAO().getList();
    setTableModel(list);
  }

  void setTableModel(ArrayList<Members> list) {
    for (int i = 0; i < list.size(); i++) {
      Members m = list.get(i);
      tableModel.addRow(new String[]{
          m.getMno() + "", m.getId(), m.getId(), m.getName(),
          m.getMobile()});
    }
    tbl.setModel(tableModel);
  }

  @Override
  public void init() {
    lbTitle = new JLabel("회원 목록");
    lbTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
    lbTitle.setHorizontalAlignment(JLabel.CENTER);
    tbl = new JTable();
    scp = new JScrollPane(tbl);
    tableModel = new DefaultTableModel(
        new String[]{"회원번호", "이름", "ID", "Password", "Mobile"}, 0);
    pnlBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    btnModify = new JButton("수정");
    btnModify.addActionListener(e -> {
      int row = tbl.getSelectedRow();
      if (row == -1) {
        JOptionPane.showMessageDialog(null, "회원을 먼저 선택하세요");
        return;
      }
      JOptionPane.showMessageDialog(null, tableModel.getValueAt(row, 0));
      // 회원을 수정하는 코드를 작성하여 추가하고 수정되었으면 JTable도 새로고침 되도록 한다.

    });
    btnDelete = new JButton("삭제");
    btnDelete.addActionListener(e -> {
      int row = tbl.getSelectedRow();
      if (row == -1) {
        JOptionPane.showMessageDialog(null, "회원을 먼저 선택하세요");
        return;
      }
      tableModel.removeRow(row);
      // ui에서 지웠으면 Database에서도 같이 지워야 함.

      });
    }

    @Override
    public void arrange () {
      pnlBtn.add(btnModify);
      pnlBtn.add(btnDelete);
      add(lbTitle, "North");
      add(scp, "Center");
      add(pnlBtn, "South");
    }


  }