package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lxy.bookmanager.dal.UserDal;
import com.lxy.bookmanager.model.User;
import com.lxy.bookmanager.util.DbUtil;
import com.lxy.bookmanager.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUserNameLogin;
	private JPasswordField passwordFieldLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/logo.png")));
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 23));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userName.png")));
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		
		textUserNameLogin = new JTextField();
		textUserNameLogin.setColumns(10);
		
		passwordFieldLogin = new JPasswordField();
		
		JButton LoginButton = new JButton("\u767B\u5F55");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionPerform(e);
			}
		});
		LoginButton.setFont(new Font("幼圆", Font.PLAIN, 14));
		LoginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));
		
		JButton ResetButton = new JButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionReset(e);
			}
		});
		ResetButton.setFont(new Font("幼圆", Font.PLAIN, 14));
		ResetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textUserNameLogin, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(LoginButton)
									.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
									.addComponent(ResetButton))
								.addComponent(passwordFieldLogin))))
					.addGap(89))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(textUserNameLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ResetButton)
						.addComponent(LoginButton))
					.addGap(52))
		);
		contentPane.setLayout(gl_contentPane);
		// 设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录事件处理
	 * @param e
	 */

	private void LoginActionPerform(ActionEvent e){
		// TODO Auto-generated method stub
		String userName =this.textUserNameLogin.getText();
		String password =new String(this.passwordFieldLogin.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user=new User(userName,password);
		UserDal userDal=new UserDal();
		Connection con =null;
		DbUtil dbUtil=new DbUtil();
		try{
			con=dbUtil.getCon();
			User currentUser=userDal.login(con, user);
			if (currentUser!=null) {
				dispose(); 						//释放登录窗体资源
				new MainFrm().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "用户名或者密码错误！");
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 * 
	 */
	private void LoginActionReset(ActionEvent evt) {
		this.textUserNameLogin.setText("");
		this.passwordFieldLogin.setText("");	
	}
}
