package com.jsu.zcl.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Indentity extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Indentity frame = new Indentity();
					frame.setLocationRelativeTo(null);//窗体居中，最大化可不使用
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
	public Indentity() {
		setTitle("物流管理系统");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Indentity.class.getResource("/Source/fpic6763.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("身份验证");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(118, 116, 71, 86);
		contentPane.add(lblNewLabel_1);
		String str[]= {"用户","物流公司"};
		JComboBox comboBox = new JComboBox(str);
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		comboBox.setBounds(209, 142, 106, 29);
		contentPane.add(comboBox);
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().contains("用户")) {
					PersonEnter frame = new PersonEnter();
					frame.setLocationRelativeTo(null);//窗体居中，最大化可不使用
					frame.setVisible(true);
				}
				else {
					CompanyEnter frame = new CompanyEnter();
					frame.setLocationRelativeTo(null);//窗体居中，最大化可不使用
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.setBounds(169, 201, 93, 29);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Indentity.class.getResource("/Source/apic19700.jpg")));
		lblNewLabel.setBounds(-165, 0, 646, 261);
		contentPane.add(lblNewLabel);
	}
}
