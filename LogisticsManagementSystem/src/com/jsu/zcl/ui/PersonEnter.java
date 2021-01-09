package com.jsu.zcl.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jsu.zcl.dao.Enter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PersonEnter extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PersonEnter frame = new PersonEnter();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	public PersonEnter() {
		setTitle("物流管理系统（用户登录界面）");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonEnter.class.getResource("/Source/apic23436.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(110, 116, 54, 24);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(174, 118, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(110, 158, 54, 31);
		contentPane.add(lblNewLabel_1);
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Enter.loginJudgment1(textField.getText(),new String(passwordField.getPassword()))) {
					Person frame = new Person();
					frame.setLocationRelativeTo(null);//窗体居中，最大化可不使用
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "账号或密码错误");
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.setBounds(233, 212, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setLocationRelativeTo(null);//窗体居中，最大化可不使用
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton_1.setBounds(57, 212, 93, 23);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PersonEnter.class.getResource("/Source/apic23436.jpg")));
		lblNewLabel_2.setBounds(-205, -86, 652, 372);
		contentPane.add(lblNewLabel_2);	
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 163, 133, 21);
		contentPane.add(passwordField);
	}

}
