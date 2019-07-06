package ex0606.sku.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ex0606.sku.controller.UserListController;
import ex0606.sku.model.dto.UserListDTO;

@SuppressWarnings("serial")
public class UserJDialogView extends JDialog implements ActionListener {
	JPanel pw = new JPanel(new GridLayout(4, 1));
	JPanel pc = new JPanel(new GridLayout(4, 1));
	JPanel ps = new JPanel();

	JLabel lableId = new JLabel("ID");
	JLabel lableName = new JLabel("이름");
	JLabel lableAge = new JLabel("나이");
	JLabel lableAddr = new JLabel("주소");

	JTextField id = new JTextField();
	JTextField name = new JTextField();
	JTextField age = new JTextField();
	JTextField addr = new JTextField();

	JButton confirm;
	JButton reset = new JButton("취소");

	UserJTableView userJTableView;

	JPanel idCkP = new JPanel(new BorderLayout());
	JButton idCkBtn = new JButton("IDCheck");

	public UserJDialogView(UserJTableView userJTableView, String index) {
		super(userJTableView, "다이어로그");

		this.userJTableView = userJTableView;

		if (index.equals("가입")) {
			confirm = new JButton(index);
		} else {
			confirm = new JButton(index);

			// 선택된 레코드의 순번을 받아온다.
			int selected = this.userJTableView.jt.getSelectedRow();

			id.setText((String) (this.userJTableView.dt.getValueAt(selected, 0)));
			name.setText((String) (this.userJTableView.dt.getValueAt(selected, 1)));
			age.setText(Integer.toString((int) (this.userJTableView.dt.getValueAt(selected, 2))));
			addr.setText((String) (this.userJTableView.dt.getValueAt(selected, 3)));

			// id text박스 비활성
			id.setEditable(false);

			// IDCheck버튼 비활성화
			idCkBtn.setEnabled(false);
		}

		// Label추가부분
		pw.add(lableId);// ID
		pw.add(lableName);// 이름
		pw.add(lableAge);// 나이
		pw.add(lableAddr);// 주소

		idCkP.add(id, "Center");
		idCkP.add(idCkBtn, "East");

		// TextField 추가
		pc.add(idCkP);
		pc.add(name);
		pc.add(age);
		pc.add(addr);

		ps.add(confirm);
		ps.add(reset);

		add(pw, "West");
		add(pc, "Center");
		add(ps, "South");

		setSize(300, 250);
		setVisible(true);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// 이벤트등록
		confirm.addActionListener(this); // 가입/수정 이벤트등록
		reset.addActionListener(this); // 취소 이벤트등록
		idCkBtn.addActionListener(this);// ID중복체크 이벤트 등록

	}// 생성자끝

	/**
	 * 가입/수정/취소/IDCheck 기능에 대한 부분
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean idcheck = false;
		
		/** 확인버튼 */
		if (e.getSource().equals(confirm)) {
			if(confirm.getText().equals("가입")) {
				try {
					UserListDTO user = new UserListDTO(id.getText(), name.getText(), Integer.parseInt(age.getText()), addr.getText());
					int result = UserListController.userListInsert(user);
					
					if(result != 0)
						this.setVisible(false);
					
				} catch (NumberFormatException e1) {
					FailView.errorMessage("나이에 제대로 입력하쇼.");
				}
			} else {
				
			}
			this.userJTableView.refreshTable(UserListController.getSelectAll());
			
		/** 취소버튼 */
		} else if (e.getSource().equals(reset)) {

			this.setVisible(false);
			
		/** 아이디 체크 버튼 */
		} else if (e.getSource().equals(idCkBtn)) {
			idcheck = UserListController.getCheckById(id.getText());
			if(idcheck) {
				idCkBtn.setEnabled(false);
				id.setEditable(false);
			}
		}

	}// actionPerformed끝

}// 클래스끝
