package p12_database.ui;

import p12_database.controller.MainController;
import p12_database.vo.Members;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FrmMain extends FrmBasic {
  private JTable tbl;
  private JScrollPane scp;
  private JLabel lbTitle;
  private DefaultTableModel tableModel;
  private JPanel pnlBtn;
  private JButton btnModify, btnDelete;

  public FrmMain() {
    super("회원정보관리 "
        + MainController.getInstance().getSession().getName()
        +"님 환영합니다.", 600, 600);
    setTableModel(MainController.getInstance().getMembersService().getList());
  }

  void setTableModel(ArrayList<Members> list) {
    tableModel.setRowCount(0);// JTable의 기존 행을 지우고 추가
    for (int i = 0; i < list.size(); i++) {
      Members m = list.get(i);
      tableModel.addRow(new String[]{
          m.getMno() + "",  m.getName(),m.getId(), m.getPass(),
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
        new String[]{"회원번호", "이름", "ID", "Password","Mobile"}, 0);
    pnlBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    btnModify = new JButton("수정");
    btnModify.addActionListener(e -> {
      int row = tbl.getSelectedRow();
      if (row == -1) {
        JOptionPane.showMessageDialog(null, "회원을 먼저 선택하세요");
        return;
      }
      int mno = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
      String name = tableModel.getValueAt(row, 1).toString();
      String id = tableModel.getValueAt(row, 2).toString();
      String pass = tableModel.getValueAt(row, 3).toString();
      String mobile = tableModel.getValueAt(row, 4).toString();
      //JOptionPane.showMessageDialog(null, mno);
      // 회원을 수정하는 코드를 작성하여 추가하고 수정되었으면 JTable도 새로고침 되도록 한다.
      //new FrmModify(this, mno, true);
      HashMap map = new HashMap();
      map.put("owner", this);
      map.put("members", new Members(mno, id, pass, name,mobile));
      map.put("modal", true);
      MainController.getInstance().dispatchCmd("Modify",map);
      setTableModel(MainController.getInstance().getMembersService().getList());
    });
    btnDelete = new JButton("삭제");
    btnDelete.addActionListener(e -> {
      int row = tbl.getSelectedRow();
      if (row == -1) {
        JOptionPane.showMessageDialog(null, "회원을 먼저 선택하세요");
        return;
      }
      int choice = JOptionPane.showConfirmDialog(null,
          "삭제하시겠어요?", "삭제 선택",
          JOptionPane.YES_NO_OPTION); //yes 1, no 0
      System.out.println("choice:"+choice);
      if (choice == 0) {
        int mno = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
        tableModel.removeRow(row);
        // ui에서 지웠으면 Database에서도 같이 지워야 함.
        MainController.getInstance().getMembersService().deleteMembers(mno);
      }

    });
  }

  @Override
  public void arrange() {
    pnlBtn.add(btnModify);
    pnlBtn.add(btnDelete);
    add(lbTitle, "North");
    add(scp, "Center");
    add(pnlBtn, "South");
  }


}