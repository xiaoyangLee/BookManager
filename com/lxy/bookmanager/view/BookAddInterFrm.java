package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.lxy.bookmanager.dal.BookDal;
import com.lxy.bookmanager.dal.BookTypeDal;
import com.lxy.bookmanager.model.Book;
import com.lxy.bookmanager.model.bookType;
import com.lxy.bookmanager.util.DbUtil;
import com.lxy.bookmanager.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	public BookAddInterFrm(JDesktopPane table) {
		this();
		this.setLocation((table.getWidth() - this.getWidth()) / 2, (table.getHeight() - this.getHeight()) / 2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField BookNametext;
	private JTextField BookPricetext;
	@SuppressWarnings("rawtypes")
	private JComboBox BookTypecomboBox;
	private JTextField BookAuthortext;
	private JRadioButton radioButtonMan;
	private JRadioButton radioButtonWoman;
	private JTextArea BookDesctextArea;

	private DbUtil dbUtil = new DbUtil();
	private BookTypeDal bookTypeDal = new BookTypeDal();
	private BookDal bookDal = new BookDal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	@SuppressWarnings({ "rawtypes" })
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/bookManager.png")));
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 816, 479);

		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		BookNametext = new JTextField();
		BookNametext.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

		BookAuthortext = new JTextField();
		BookAuthortext.setColumns(10);

		JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");

		radioButtonMan = new JRadioButton("\u7537");
		buttonGroup.add(radioButtonMan);
		radioButtonMan.setSelected(true);

		radioButtonWoman = new JRadioButton("\u5973");
		buttonGroup.add(radioButtonWoman);
		buttonGroup.add(radioButtonMan);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");

		BookPricetext = new JTextField();
		BookPricetext.setColumns(10);

		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

		BookTypecomboBox = new JComboBox();

		JLabel label_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

		BookDesctextArea = new JTextArea();

		JButton BookManageAddbutton = new JButton("\u6DFB\u52A0");
		BookManageAddbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddActionPerform(e);
			}
		});
		BookManageAddbutton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));

		JButton BookManageResetbutton = new JButton("\u91CD\u7F6E");
		BookManageResetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerform(e);
			}
		});
		BookManageResetbutton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(69)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout
												.createSequentialGroup()
												.addComponent(label_3)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(BookTypecomboBox, GroupLayout.PREFERRED_SIZE, 175,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(label).addComponent(label_2))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(radioButtonMan).addGap(18).addComponent(
																		radioButtonWoman))
														.addComponent(BookNametext, GroupLayout.PREFERRED_SIZE, 228,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(label_1).addComponent(lblNewLabel))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(BookAuthortext, GroupLayout.PREFERRED_SIZE, 249,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(BookPricetext, GroupLayout.PREFERRED_SIZE, 126,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_4)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(BookManageAddbutton).addGap(184)
																.addComponent(BookManageResetbutton))
														.addComponent(BookDesctextArea, GroupLayout.PREFERRED_SIZE, 578,
																GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(132, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(BookNametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1).addComponent(BookAuthortext, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(
										groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
												.addComponent(radioButtonMan).addComponent(radioButtonWoman))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
										.addComponent(BookPricetext, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
								.addComponent(BookTypecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_4).addComponent(
										BookDesctextArea, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(BookManageAddbutton).addComponent(BookManageResetbutton))
						.addContainerGap(90, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		// 设置文本域边框
		BookDesctextArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
		fillBookType();
	}

	// 图书添加事件处理
	private void AddActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String BookName = this.BookNametext.getText();
		String Author = this.BookAuthortext.getText();
		String Price = this.BookPricetext.getText();
		String BookDesc = this.BookDesctextArea.getText();

		if (StringUtil.isEmpty(BookName)) {
			JOptionPane.showMessageDialog(null, "图书名不能为空！");
			return;
		}

		if (StringUtil.isEmpty(Author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}

		if (StringUtil.isEmpty(Price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}

		String sex = "";
		if (radioButtonMan.isSelected()) {
			sex = "男";
		} else if (radioButtonWoman.isSelected()) {
			sex = "女";
		}
		bookType bookType = (bookType) BookTypecomboBox.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(BookName, Author, sex, Float.parseFloat(Price), bookTypeId, BookDesc);
		Connection con = null;

		try {
			con = dbUtil.getCon();
			int addNum = bookDal.add(con, book);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "图书添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
				return;
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
	}

	// 重置事件处理
	private void ResetActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.ResetValue();

	}

	private void ResetValue() {
		this.BookNametext.setText("");
		this.BookAuthortext.setText("");
		this.BookDesctextArea.setText("");
		this.BookPricetext.setText("");
		this.radioButtonMan.setSelected(true);
		if (this.BookTypecomboBox.getItemCount() > 0) {
			this.BookTypecomboBox.setSelectedIndex(0);
		}
	}

	// 初始化图书下拉框
	private void fillBookType() {
		Connection con = null;
		bookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = bookTypeDal.query(con, new bookType());

			while (resultSet.next()) {
				bookType = new bookType();
				bookType.setId(resultSet.getInt("id"));
				bookType.setBookTypeName(resultSet.getString("bookTypeName"));
				this.BookTypecomboBox.addItem(bookType);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

		}
	}
}
