package com.jsu.zcl.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsu.zcl.dao.Register;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
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
	public Login() {
		setTitle("ŒÔ¡˜π‹¿ÌœµÕ≥£®”√ªß◊¢≤·ΩÁ√Ê£©");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Source/alogo1516.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("–’√˚");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 12));
		lblNewLabel.setBounds(60, 25, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("…Ì∑›÷§∫≈");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 12));
		lblNewLabel_1.setBounds(60, 73, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("µÿ÷∑");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 12));
		lblNewLabel_2.setBounds(60, 122, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("’À∫≈");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 12));
		lblNewLabel_3.setBounds(60, 176, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("√‹¬Î");
		lblNewLabel_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 12));
		lblNewLabel_4.setBounds(60, 215, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("◊¢≤·");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Register.registerJudge(textField1.getText(), textField2.getText(), textField3.getText(),textField4.getText(), textField5.getText())) {
					Register.dataStorage1(textField1.getText() + "\t" + textField2.getText()+"\t"+textField3.getText()+"\t"+textField4.getText()+"\t"+textField5.getText());
					Register.dataStorage2(textField4.getText()+"\t"+textField5.getText()+"\t");
					JOptionPane.showMessageDialog(null, "◊¢≤·≥…π¶");
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
					textField4.setText("");
					textField5.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
		btnNewButton.setBounds(331, 215, 93, 36);
		contentPane.add(btnNewButton);
		
		textField1 = new JTextField();
		textField1.setBounds(145, 22, 117, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(145, 70, 117, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(145, 119, 117, 21);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setBounds(145, 173, 117, 21);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		textField5 = new JTextField();
		textField5.setBounds(145, 212, 117, 21);
		contentPane.add(textField5);
		textField5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/Source/alogo1516.jpg")));
		lblNewLabel_5.setBounds(-99, -1, 610, 261);
		contentPane.add(lblNewLabel_5);
	}

}
