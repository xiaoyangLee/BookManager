package com.lxy.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class AboutFrm extends JInternalFrame {
	public AboutFrm(JDesktopPane table) {
		this();
		this.setLocation((table.getWidth()-this.getWidth())/2, (table.getHeight()-this.getHeight())/2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrm frame = new AboutFrm();
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
	public AboutFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 577, 434);
		
		JLabel lblNewLabel = new JLabel("Copyright@lxy  \u7248\u6743\u6240\u6709");
		lblNewLabel.setIcon(new ImageIcon(AboutFrm.class.getResource("/images/java4lit.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(lblNewLabel)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(lblNewLabel)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}

}
