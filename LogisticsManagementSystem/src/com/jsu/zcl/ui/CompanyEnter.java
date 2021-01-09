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
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompanyEnter extends JFrame {

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
//					CompanyEnter frame = new CompanyEnter();
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
	public CompanyEnter() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CompanyEnter.class.getResource("/Source/apic23529.jpg")));
		setTitle("�û�����ϵͳ��������˾��¼���棩");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 14));
		lblNewLabel.setBounds(86, 70, 54, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(167, 70, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.BOLD, 14));
		lblNewLabel_1.setBounds(86, 122, 54, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Enter.loginJudgment2(textField.getText(),new String(passwordField.getPassword()))) {
					Company frame = new Company();
					frame.setLocationRelativeTo(null);//������У���󻯿ɲ�ʹ��
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�˺Ż��������");
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setBounds(152, 197, 93, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CompanyEnter.class.getResource("/Source/apic23529.jpg")));
		lblNewLabel_2.setBounds(-186, -50, 743, 345);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 122, 150, 21);
		contentPane.add(passwordField);
	}
}
