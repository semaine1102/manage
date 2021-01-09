package com.jsu.zcl.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jsu.zcl.dao.Account;
import com.jsu.zcl.dao.Operation;
import com.jsu.zcl.dao.PackageDataOperate;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
public class Person extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTextField textField_8;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Person frame = new Person();
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
	public Person() {
		setTitle("物流管理系统（用户操作界面）");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("/Source/6BAgWp3ef96e838523452b63d243f98f407764.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 584, 352);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("查询包裹", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入运单号");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel.setBounds(62, 35, 105, 49);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(203, 48, 148, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textField.getText();
				Vector<String> title = new Vector<String>();
				Collections.addAll(title, "运单号", "发货地址","收货地址", "运费");		
				DefaultTableModel model=new DefaultTableModel (Operation.obtainsql1(str),title);	
				table.setModel(model);
//				sorter = new TableRowSorter<DefaultTableModel>(model);
//				table.setRowSorter(sorter);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton.setBounds(408, 43, 93, 32);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 559, 208);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Person.class.getResource("/Source/xpic6106.jpg")));
		lblNewLabel_8.setBounds(0, 0, 579, 313);
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("邮寄包裹", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("运单号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_1.setBounds(122, 40, 54, 15);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(229, 37, 140, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("发货地址");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_2.setBounds(122, 86, 54, 15);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(229, 83, 140, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("收货地址");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_3.setBounds(122, 133, 54, 15);
		panel_1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(229, 130, 140, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		JButton btnNewButton_5 = new JButton("资费");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int price=PackageDataOperate.getNum(12, 72);//随机获取运费
				textField_4 .setText(String.valueOf(price));
			}
		});
		btnNewButton_5.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton_5.setBounds(310, 247, 82, 35);
		panel_1.add(btnNewButton_5);
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(229, 171, 140, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		JButton btnNewButton_1 = new JButton("邮寄");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation.addData(textField_1.getText(), textField_2.getText(),textField_3.getText(),Integer.parseInt(textField_4.getText()));
				JOptionPane.showMessageDialog(null, "增加成功！");
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton_1.setBounds(426, 247, 83, 35);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("运费");
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_9.setBounds(122, 174, 54, 15);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Person.class.getResource("/Source/flash3609.jpg")));
		lblNewLabel_4.setBounds(-62, 0, 718, 313);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("签收包裹", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("请输入运单号");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_5.setBounds(106, 95, 96, 34);
		panel_2.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(267, 99, 164, 27);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("签收");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation.deletesql(textField_5.getText());
				JOptionPane.showMessageDialog(null, "完成签收！");
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton_2.setBounds(202, 169, 93, 34);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(Person.class.getResource("/Source/alogo172.jpg")));
		lblNewLabel_10.setBounds(0, 0, 579, 313);
		panel_2.add(lblNewLabel_10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("修改密码", null, panel_3, null);
		panel_3.setLayout(null);
		JLabel lblNewLabel_6 = new JLabel("请输入账号");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_6.setBounds(107, 68, 73, 36);
		panel_3.add(lblNewLabel_6);	
		textField_6 = new JTextField();
		textField_6.setBounds(267, 76, 154, 21);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		JLabel lblNewLabel_7 = new JLabel("请输入要修改的密码");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_7.setBounds(64, 135, 115, 36);
		panel_3.add(lblNewLabel_7);
	
		textField_7 = new JTextField();
		textField_7.setBounds(267, 143, 154, 21);
		panel_3.add(textField_7);
		textField_7.setColumns(10);		
		JButton btnNewButton_3 = new JButton("确认");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account.passwordChange(textField_6.getText(), textField_7.getText());
				JOptionPane.showMessageDialog(null, "修改成功！");
			}
		});	
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton_3.setBounds(328, 204, 93, 31);
		panel_3.add(btnNewButton_3);	
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(Person.class.getResource("/Source/fpic6507.jpg")));
		lblNewLabel_11.setBounds(0, 0, 579, 313);
		panel_3.add(lblNewLabel_11);
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("注销账号", null, panel_4, null);
		panel_4.setLayout(null);	
		JLabel lblNewLabel_12 = new JLabel("请输入账号");
		lblNewLabel_12.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_12.setBounds(122, 114, 87, 33);
		panel_4.add(lblNewLabel_12);	
		textField_8 = new JTextField();
		textField_8.setBounds(281, 117, 184, 27);
		panel_4.add(textField_8);
		textField_8.setColumns(10);	
		JButton btnNewButton_4 = new JButton("注销");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account.accountCancel(textField_8.getText());
				JOptionPane.showMessageDialog(null,"已注销！");
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		btnNewButton_4.setBounds(261, 219, 93, 33);
		panel_4.add(btnNewButton_4);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon(Person.class.getResource("/Source/xpic6106.jpg")));
		lblNewLabel_13.setBounds(10, -95, 579, 408);
		panel_4.add(lblNewLabel_13);
	}

}
