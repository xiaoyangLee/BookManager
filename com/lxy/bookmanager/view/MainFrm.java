package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;

public class MainFrm extends JFrame {
	private JDesktopPane table = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 778);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu DataManager = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		DataManager.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		DataManager.setFont(new Font("幼圆", Font.PLAIN, 14));
		menuBar.add(DataManager);

		JMenu BookTypeManage = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		BookTypeManage.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		BookTypeManage.setFont(new Font("幼圆", Font.PLAIN, 14));
		DataManager.add(BookTypeManage);

		JMenuItem BookTypeAdd = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		BookTypeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm(table);
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		BookTypeAdd.setFont(new Font("幼圆", Font.PLAIN, 14));
		BookTypeAdd.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		BookTypeManage.add(BookTypeAdd);

		JMenuItem BookTypeMaintain = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		BookTypeMaintain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm(table);
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		BookTypeMaintain.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		BookTypeMaintain.setFont(new Font("幼圆", Font.PLAIN, 14));
		BookTypeManage.add(BookTypeMaintain);

		JMenu BookManage = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		BookManage.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		BookManage.setFont(new Font("幼圆", Font.PLAIN, 14));
		DataManager.add(BookManage);

		JMenuItem BookAdd = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		BookAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm(table);
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		BookAdd.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		BookAdd.setFont(new Font("幼圆", Font.PLAIN, 14));
		BookManage.add(BookAdd);

		JMenuItem BookMaintain = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		BookMaintain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm = new BookManageInterFrm(table);
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		BookMaintain.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		BookMaintain.setFont(new Font("幼圆", Font.PLAIN, 14));
		BookManage.add(BookMaintain);

		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuitActionPerform(e);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menuItem.setFont(new Font("幼圆", Font.PLAIN, 14));
		DataManager.add(menuItem);

		JMenu About = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		About.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		About.setFont(new Font("幼圆", Font.PLAIN, 14));
		menuBar.add(About);

		JMenuItem AboutUs = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		AboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutFrm aboutFrm = new AboutFrm(table);
				aboutFrm.setVisible(true);
				table.add(aboutFrm);
			}
		});
		AboutUs.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		AboutUs.setFont(new Font("幼圆", Font.PLAIN, 14));
		About.add(AboutUs);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 1904, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 978, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		// 设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	// 退出事件处理
	private void QuitActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		int flag = JOptionPane.showConfirmDialog(null, "确定要退出吗？");
		if (flag == 0) {
			// JOptionPane.showMessageDialog(null, "SB玩意儿！你点了是！");
			dispose();
		}
	}
}
