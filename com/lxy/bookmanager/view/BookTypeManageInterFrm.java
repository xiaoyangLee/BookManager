package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lxy.bookmanager.dal.BookTypeDal;
import com.lxy.bookmanager.model.bookType;
import com.lxy.bookmanager.util.DbUtil;
import com.lxy.bookmanager.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInterFrm extends JInternalFrame {

	public BookTypeManageInterFrm(JDesktopPane table) {
		this();
		this.setLocation((table.getWidth() - this.getWidth()) / 2, (table.getHeight() - this.getHeight()) / 2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField BookTypeNametextfield;
	private JTable BookTypetable;
	private JTextField BookTypeManageIdtext;
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
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/bookTypeManager.png")));
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		setBounds(100, 100, 838, 576);

		@SuppressWarnings("unused")
		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));

		BookTypeNametextfield = new JTextField();
		BookTypeNametextfield.setColumns(10);

		JButton Searchbutton = new JButton("\u67E5\u8BE2");
		Searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryActionPerform(e);
			}
		});
		Searchbutton.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/search.png")));

		JScrollPane BookTypescrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout
										.createSequentialGroup().addGap(128).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(BookTypeNametextfield, GroupLayout.PREFERRED_SIZE, 244,
												GroupLayout.PREFERRED_SIZE)
										.addGap(27).addComponent(Searchbutton))
								.addGroup(groupLayout.createSequentialGroup().addGap(113)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(panel, GroupLayout.PREFERRED_SIZE, 569,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(BookTypescrollPane, GroupLayout.PREFERRED_SIZE, 571,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(158, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(51)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
						.addComponent(BookTypeNametextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(Searchbutton))
				.addGap(41)
				.addComponent(BookTypescrollPane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");

		BookTypeManageIdtext = new JTextField();
		BookTypeManageIdtext.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

		BookTypeNametext = new JTextField();
		BookTypeNametext.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u63CF\u8FF0\uFF1A");

		BookTypeDesctext = new JTextArea();

		JButton Modifybutton = new JButton("\u4FEE\u6539");
		Modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyActionPerform(e);
			}
		});
		Modifybutton.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/modify.png")));

		JButton Deletebutton = new JButton("\u5220\u9664");
		Deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteActionPerform(e);
			}
		});
		Deletebutton.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(BookTypeManageIdtext, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addGap(107).addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(BookTypeNametext, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addComponent(Modifybutton)
														.addGap(126).addComponent(Deletebutton))
												.addComponent(BookTypeDesctext, GroupLayout.PREFERRED_SIZE, 496,
														GroupLayout.PREFERRED_SIZE))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(BookTypeManageIdtext, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(BookTypeNametext, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(BookTypeDesctext, GroupLayout.PREFERRED_SIZE, 106,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(Modifybutton)
								.addComponent(Deletebutton))));
		panel.setLayout(gl_panel);

		BookTypetable = new JTable();
		BookTypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressedActionPerform(e);
			}
		});
		BookTypetable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
				"\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTypescrollPane.setViewportView(BookTypetable);
		getContentPane().setLayout(groupLayout);

	}

	// 图书类别修改事件处理

	private void ModifyActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookTypeName = this.BookTypeNametext.getText();
		String bookTypeDesc = this.BookTypeDesctext.getText();
		String id = BookTypeManageIdtext.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的图书信息！");
			return;
		}
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		bookType bookType = new bookType(Integer.parseInt(id), bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifynum = bookTypeDal.modify(con, bookType);
			if (modifynum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetvalue();
				// this.fillTable(bookType);
				// //这里由于booktype里只修改了一条信息，所以最后只会显示出被修改的那一列，而非全部。
				this.fillTable(new bookType());
			} else
				JOptionPane.showMessageDialog(null, "修改失败！");
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception ev) {
				ev.printStackTrace();
			}

		}
	}

	// 重置表单
	private void resetvalue() {
		// TODO Auto-generated method stub
		this.BookTypeNametext.setText("");
		this.BookTypeDesctext.setText("");
		this.BookTypeManageIdtext.setText("");
	}

	// 图书类别删除时事件处理
	private void DeleteActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = this.BookTypeManageIdtext.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的图书类别信息！");
			return;
		}
		bookType bookType = new bookType();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int deletenum = bookTypeDal.delete(con, id);
			if (deletenum == 1) {
				JOptionPane.showMessageDialog(null, "删除信息成功！");
				this.resetvalue();
				this.fillTable(bookType);
			} else {
				JOptionPane.showMessageDialog(null, "删除信息失败！");
				return;

			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}

	}

	// 图书类别查询事件处理
	private void QueryActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String searchBookTypeName = this.BookTypeNametextfield.getText();
		bookType bookType = new bookType();
		bookType.setBookTypeName(searchBookTypeName);
		this.fillTable(bookType);
	}

	// 表格初始化
	@SuppressWarnings("unchecked")
	private void fillTable(bookType bookType) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) BookTypetable.getModel();
		defaultTableModel.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = bookTypeDal.query(con, bookType);
			while (resultSet.next()) {
				@SuppressWarnings("rawtypes")
				Vector vector = new Vector();
				vector.add(resultSet.getString("id"));
				vector.add(resultSet.getString("bookTypeName"));
				vector.add(resultSet.getString("bookTypeDesc"));
				defaultTableModel.addRow(vector);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	// 表格行点击事件处理
	private void mousePressedActionPerform(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = BookTypetable.getSelectedRow();
		BookTypeManageIdtext.setText((String) BookTypetable.getValueAt(row, 0));
		BookTypeNametext.setText((String) BookTypetable.getValueAt(row, 1));
		BookTypeDesctext.setText((String) BookTypetable.getValueAt(row, 2));
	}
}
