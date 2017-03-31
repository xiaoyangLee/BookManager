package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.lxy.bookmanager.dal.BookDal;
import com.lxy.bookmanager.dal.BookTypeDal;
import com.lxy.bookmanager.model.bookType;
import com.lxy.bookmanager.util.DbUtil;
import com.lxy.bookmanager.util.StringUtil;
import com.lxy.bookmanager.model.Book;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class BookManageInterFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField BookNametext;
	private JTextField BookAuthortext;
	private JTable table;
	private JTextField idtext;
	private JTextField booknametext;
	private JTextField pricetext;
	private JTextField bookauthortext;
	private JTextArea BookDesctextArea;
	private JComboBox BTcomboBox1;
	private JComboBox BTcomboBox2;
	private JRadioButton radioButtonMan;
	private JRadioButton radioButtonWoman;

	private DbUtil dbUtil = new DbUtil();
	private BookDal bookDal = new BookDal();
	private BookTypeDal bookTypeDal = new BookTypeDal();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public BookManageInterFrm(JDesktopPane table) {
		this();
		this.setLocation((table.getWidth() - this.getWidth()) / 2, (table.getHeight() - this.getHeight()) / 2);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 988, 656);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 939, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 940, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap()
												.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 281,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(29, Short.MAX_VALUE)));

		JLabel label_2 = new JLabel("\u7F16\u53F7:");

		idtext = new JTextField();
		idtext.setEditable(false);
		idtext.setColumns(10);

		JLabel label_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		booknametext = new JTextField();
		booknametext.setColumns(10);

		JLabel label_4 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");

		radioButtonMan = new JRadioButton("\u7537");
		buttonGroup.add(radioButtonMan);

		radioButtonWoman = new JRadioButton("\u5973");
		buttonGroup.add(radioButtonWoman);

		JLabel label_5 = new JLabel("\u4EF7\u683C\uFF1A");

		pricetext = new JTextField();
		pricetext.setColumns(10);

		JLabel label_6 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

		bookauthortext = new JTextField();
		bookauthortext.setColumns(10);

		JLabel label_7 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

		BTcomboBox2 = new JComboBox();

		JLabel label_8 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

		BookDesctextArea = new JTextArea();

		JButton Modifybutton = new JButton("\u4FEE\u6539");
		Modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionModifyPerform(e);
			}

		});
		Modifybutton.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));

		JButton Deletebutton = new JButton("\u5220\u9664");
		Deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteActionPerform(e);
			}
		});
		Deletebutton.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(
						gl_panel_1
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(label_2).addComponent(label_5))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(idtext, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(pricetext, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(51)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
														.addGroup(
																gl_panel_1.createSequentialGroup().addComponent(label_3)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(booknametext,
																				GroupLayout.PREFERRED_SIZE, 240,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1.createSequentialGroup().addComponent(label_6)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(bookauthortext)))
												.addGap(43).addGroup(
														gl_panel_1
																.createParallelGroup(Alignment.LEADING).addGroup(
																		gl_panel_1.createSequentialGroup()
																				.addComponent(label_4)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(radioButtonMan)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(radioButtonWoman))
																.addGroup(gl_panel_1.createSequentialGroup()
																		.addComponent(label_7)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(BTcomboBox2,
																				GroupLayout.PREFERRED_SIZE, 145,
																				GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(label_8)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(Modifybutton).addGap(125)
																.addComponent(Deletebutton))
														.addComponent(BookDesctextArea, GroupLayout.PREFERRED_SIZE, 818,
																GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
								.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(booknametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButtonWoman).addComponent(radioButtonMan).addComponent(label_4))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_5)
								.addComponent(pricetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6)
								.addComponent(bookauthortext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7).addComponent(BTcomboBox2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_8).addComponent(
								BookDesctextArea, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(Modifybutton)
								.addComponent(Deletebutton))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MousePressPerform(e);
			}
		
		});
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 	},
		 	new String[] {
		 		"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
		 	}
		 ) {
		 	boolean[] columnEditables = new boolean[] {
		 		false, false, false, false, false, false, false
		 	};
		 	public boolean isCellEditable(int row, int column) {
		 		return columnEditables[column];
		 	}
		 });
		 table.getColumnModel().getColumn(5).setPreferredWidth(119);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		BookNametext = new JTextField();
		BookNametext.setColumns(10);

		JLabel label = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

		BookAuthortext = new JTextField();
		BookAuthortext.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

		BTcomboBox1 = new JComboBox();
		BTcomboBox1.setToolTipText("");

		JButton Searchbutton = new JButton("\u67E5\u8BE2");
		Searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPerform(e);
				// JOptionPane.showMessageDialog(null, "确定要搜索吗>");
			}

		});
		Searchbutton.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(BookNametext, GroupLayout.PREFERRED_SIZE, 178,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(BookAuthortext, GroupLayout.PREFERRED_SIZE, 153,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(BTcomboBox1, GroupLayout.PREFERRED_SIZE, 109,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
										.addComponent(Searchbutton).addGap(48)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(BookNametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(BookAuthortext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(BTcomboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Searchbutton))
						.addContainerGap(51, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		// 设置文本域边框
		BookDesctextArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));

		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
	
	}

	// 初始化填充表格
	private void fillTable(Book book) {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = bookDal.query(con, book);
			while (resultSet.next()) {
				Vector vector = new Vector();
				vector.add(resultSet.getInt("id"));
				vector.add(resultSet.getString("bookName"));
				vector.add(resultSet.getString("author"));
				vector.add(resultSet.getString("sex"));
				vector.add(resultSet.getFloat("price"));
				vector.add(resultSet.getString("bookDesc"));
				vector.add(resultSet.getString("bookTypeName"));
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

	// 图书查询事件处理
	private void SearchActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookName = this.BookNametext.getText();
		String author = this.BookAuthortext.getText();
		bookType bookType = (bookType) this.BTcomboBox1.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(bookName, author, bookTypeId);
		this.fillTable(book);
	}

	// 初始化图书类别下拉框
	private void fillBookType(String type) {
		Connection con = null;
		bookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = bookTypeDal.query(con, new bookType());
			if ("search".equals(type)) {
				bookType = new bookType();
				bookType.setBookTypeName("请选择图书类别");
				bookType.setId(-1);
				this.BTcomboBox1.addItem(bookType);
			}
			while (resultSet.next()) {
				bookType = new bookType();
				bookType.setBookTypeName(resultSet.getString("bookTypeName"));
				bookType.setId(resultSet.getInt("id"));
				if ("search".equals(type)) {
					this.BTcomboBox1.addItem(bookType);
				} else if ("modify".equals(type)) {
					this.BTcomboBox2.addItem(bookType);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exceptio
				e2.printStackTrace();
			}
		}
	}

	// 表格行点击事件
	private void MousePressPerform(MouseEvent met) {
		// TODO Auto-generated method stub	
		int row = this.table.getSelectedRow();
		//this.idtext.setText(table.getValueAt(row, 0)+""); //用这种方式转换是可以的
		this.idtext.setText(String.valueOf(table.getValueAt(row, 0))); //String.valueOf()方式也是可以的
		//this.idtext.setText((String)table.getValueAt(row, 0)); //报错为无法将Integer类型转换为String
		this.booknametext.setText((String) table.getValueAt(row, 1));
		this.bookauthortext.setText((String) table.getValueAt(row, 2));
		String sex = (String) table.getValueAt(row, 3);
		if ("男".equals(sex)) {
			this.radioButtonMan.setSelected(true);
		} else if ("女".equals(sex)) {
			this.radioButtonWoman.setSelected(true);
		}
		this.pricetext.setText((Float) table.getValueAt(row, 4) + "");
		this.BookDesctextArea.setText((String) table.getValueAt(row, 5));
		String bookTypeName = (String) this.table.getValueAt(row, 6);
		int n = this.BTcomboBox2.getItemCount();
		for (int i = 0; i < n; i++) {
			bookType item = (bookType) this.BTcomboBox2.getItemAt(i);
			if (item.getBookTypeName().equals(bookTypeName)) {
				this.BTcomboBox2.setSelectedIndex(i);
			}
		}
	}
	
	//修改事件处理
	private void ActionModifyPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.idtext.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		String bookName=this.booknametext.getText();
		String author=this.bookauthortext.getText();
		String price=this.pricetext.getText();
		String bookDesc=this.BookDesctextArea.getText();
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}
		
		String sex="";
		if(radioButtonMan.isSelected()){
			sex="男";
		}else if(radioButtonWoman.isSelected()){
			sex="女";
		}
		
		bookType bookType=(bookType) BTcomboBox2.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(Integer.parseInt(id),  bookName, author, sex, Float.parseFloat(price),  bookTypeId,  bookDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=bookDal.modify(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书修改成功！");
				resetValue();
				this.fillTable(new Book());
			}else{
				JOptionPane.showMessageDialog(null, "图书修改失败！");
			}
		}catch(Exception e2){
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书修改失败！");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	//图书删除事件处理

	private void DeleteActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=idtext.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int deleteNum=bookDal.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Book());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e2){
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
	}
	
	// 重置表单
	private void resetValue() {
		this.booknametext.setText("");
		this.bookauthortext.setText("");
		this.pricetext.setText("");
		this.idtext.setText("");
		this.radioButtonMan.setSelected(true);
		this.BookDesctextArea.setText("");
		if (this.BTcomboBox2.getItemCount() > 0) {
			this.BTcomboBox2.setSelectedIndex(0);
		}
	}
}
