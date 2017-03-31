package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.lxy.bookmanager.dal.BookTypeDal;
import com.lxy.bookmanager.model.bookType;
import com.lxy.bookmanager.util.DbUtil;
import com.lxy.bookmanager.util.StringUtil;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookTypeAddInterFrm extends JInternalFrame {
	public BookTypeAddInterFrm(JDesktopPane table) {
		this();
		this.setLocation((table.getWidth() - this.getWidth()) / 2, (table.getHeight() - this.getHeight()) / 2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField BookTypeNametext;
	private JTextArea BookTypeDesctext;

	private DbUtil dbUtil = new DbUtil();
	private BookTypeDal bookTypeDal = new BookTypeDal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/bookTypeManager.png")));
		setTitle("\u56FE\u4E66\u7C7B\u578B\u6DFB\u52A0");
		setBounds(100, 100, 605, 413);

		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

		BookTypeNametext = new JTextField();
		BookTypeNametext.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");

		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddActionPerform(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		BookTypeDesctext = new JTextArea();

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerform(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(81)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label).addPreferredGap(ComponentPlacement.RELATED).addComponent(
												BookTypeNametext, GroupLayout.PREFERRED_SIZE, 288,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(
														BookTypeDesctext, GroupLayout.PREFERRED_SIZE, 288,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup().addComponent(button)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(button_1)))))
						.addContainerGap(132, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(76)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						BookTypeNametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(34)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
						.addComponent(BookTypeDesctext, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
				.addContainerGap(85, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		BookTypeDesctext.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));

	}

	// 图书类别添加事件处理
	private void AddActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookTypeName = this.BookTypeNametext.getText();
		String bookTypeDesc = this.BookTypeDesctext.getText();
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		bookType bookType = new bookType(bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int flag = bookTypeDal.add(con, bookType);
			if (flag == 1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功!");
			} else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败！");
			}
		} catch (Exception evt) {
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败！");
		} finally {
			// TODO: handle finally clause
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	// 重置事件处理
	private void ResetActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.BookTypeNametext.setText("");
		this.BookTypeDesctext.setText("");
	}

}
