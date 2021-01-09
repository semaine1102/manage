package com.jsu.zcl.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import com.jsu.zcl.dao.Operation;
import com.jsu.zcl.dao.PackageDataOperate;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Company extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField6;
	private JTextField textField5;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	private Vector<String> titles;
	private JTable table_1;
	private JTable table;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textField10;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Company frame = new Company();
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
	public Company() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Company.class.getResource("/Source/zzpic3220.jpg")));
		setTitle("物流管理系统（物流公司管理界面）");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 581, 388);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("包裹清单", null, panel, null);
		panel.setLayout(null);
		Vector<String> titles = new Vector<String>();
		Collections.addAll(titles, "运单号", "发货地址","收货地址", "运费");
		model=new DefaultTableModel(Operation.obtainsql(),titles);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 556, 339);
		table_1 = new JTable(model);
		table_1.setFont(new Font("微软雅黑", Font.BOLD, 12));
		sorter = new TableRowSorter<DefaultTableModel>(model);;
		scrollPane_1.setViewportView(table_1);
		panel.add(scrollPane_1);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Company.class.getResource("/Source/zzpic22727.jpg")));
		lblNewLabel_7.setBounds(0, 0, 588, 370);
		panel.add(lblNewLabel_7);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("删除包裹", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("请输入运单号");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(125, 105, 100, 40);
		panel_4.add(lblNewLabel_2);
		
		textField5 = new JTextField();
		textField5.setBounds(266, 115, 187, 30);
		panel_4.add(textField5);
		textField5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("确认删除");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation.deletesql(textField5.getText());
				JOptionPane.showMessageDialog(null, "删除成功！");
			}
		});
		btnNewButton_1.setBounds(219, 208, 93, 34);
		panel_4.add(btnNewButton_1);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon(Company.class.getResource("/Source/alogo1293.jpg")));
		lblNewLabel_14.setBounds(0, 0, 576, 359);
		panel_4.add(lblNewLabel_14);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("查询包裹", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("请输入关键字");
		lblNewLabel_1.setBounds(74, 17, 86, 21);
		panel_2.add(lblNewLabel_1);
		
		textField6 = new JTextField();
		textField6.setBounds(197, 17, 170, 21);
		panel_2.add(textField6);
		textField6.setColumns(10);
		Vector<String> title = new Vector<String>();
		Collections.addAll(title, "运单号", "发货地址","收货地址", "运费");			
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String str=textField6.getText();
						model=new DefaultTableModel(Operation.obtainsql(str),title);
						table.setModel(model);
						sorter = new TableRowSorter<DefaultTableModel>(model);
						table.setRowSorter(sorter);
			}
		});
		btnNewButton.setBounds(402, 13, 70, 29);
		panel_2.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 556, 301);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Company.class.getResource("/Source/zzpic22727.jpg")));
		lblNewLabel_8.setBounds(0, 0, 576, 359);
		panel_2.add(lblNewLabel_8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("修改包裹", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("运单号");
		lblNewLabel_9.setBounds(10, 10, 44, 31);
		panel_3.add(lblNewLabel_9);
		
		textField7 = new JTextField();
		textField7.setEnabled(false);
		textField7.setBounds(64, 15, 95, 21);
		panel_3.add(textField7);
		textField7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("发货地址");
		lblNewLabel_10.setBounds(169, 10, 54, 31);
		panel_3.add(lblNewLabel_10);
		
		textField8 = new JTextField();
		textField8.setBounds(233, 15, 66, 21);
		panel_3.add(textField8);
		textField8.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("收货地址");
		lblNewLabel_11.setBounds(309, 10, 54, 31);
		panel_3.add(lblNewLabel_11);
		
		textField9 = new JTextField();
		textField9.setBounds(367, 15, 66, 21);
		panel_3.add(textField9);
		textField9.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("运费");
		lblNewLabel_12.setBounds(443, 10, 54, 31);
		panel_3.add(lblNewLabel_12);
		
		textField10 = new JTextField();
		textField10.setBounds(500, 15, 66, 21);
		panel_3.add(textField10);
		textField10.setColumns(10);
				
		JButton btnNewButton_3 = new JButton("确认");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,ad1,ad2;
				int price;
				id=textField7.getText();
				ad1=textField8.getText();
				ad2=textField9.getText();
				price=Integer.parseInt(textField10.getText());
				Operation.updatesql(id, ad1, ad2,price);
				JOptionPane.showMessageDialog(null, "修改成功");
				Vector<String> titles = new Vector<String>();
				Collections.addAll(titles, "运单号", "发货地址","收货地址", "运费");
				model=new DefaultTableModel(Operation.obtainsql(),titles);
				table_2.setModel(model);
				
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_3.setBounds(296, 63, 93, 23);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("选择");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_2.getSelectedRow() != -1) {
					textField7.setText(model.getValueAt(table_2.getSelectedRow(), 0).toString());
					textField8.setText(model.getValueAt(table_2.getSelectedRow(), 1).toString());
					textField9.setText(model.getValueAt(table_2.getSelectedRow(), 2).toString());
					textField10.setText(model.getValueAt(table_2.getSelectedRow(), 3).toString());
				}

			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_4.setBounds(158, 63, 93, 23);
		panel_3.add(btnNewButton_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 96, 556, 253);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable(model);
		table_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon(Company.class.getResource("/Source/zzpic22727.jpg")));
		lblNewLabel_13.setBounds(0, 0, 576, 359);
		panel_3.add(lblNewLabel_13);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("新增包裹", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		textField1 = new JTextField();
		textField1.setEnabled(false);
		
		textField1.setBounds(285, 101, 149, 21);
		textField1.setText("");
		panel_1.add(textField1);
		textField1.setColumns(10);
		JButton btnNewButton_5 = new JButton("生成");
		btnNewButton_5.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=PackageDataOperate.getStuno().toString();
				textField1.setText(id);
			}
		});
		btnNewButton_5.setBounds(296, 292, 93, 34);
		panel_1.add(btnNewButton_5);
		JLabel lblNewLabel = new JLabel("运单号");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel.setBounds(146, 101, 70, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("发货地址");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_3.setBounds(146, 147, 70, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("收货地址");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_4.setBounds(146, 189, 70, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("运费");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_5.setBounds(146, 226, 70, 21);
		panel_1.add(lblNewLabel_5);
		
		textField2 = new JTextField();
		textField2.setBounds(285, 144, 149, 21);
		panel_1.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(285, 186, 149, 21);
		panel_1.add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setBounds(285, 229, 149, 21);
		panel_1.add(textField4);
		textField4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("确认增加");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation.addData(textField1.getText(), textField2.getText(),textField3.getText(),Integer.parseInt(textField4.getText()));
				JOptionPane.showMessageDialog(null, "增加成功！");
			}
		});
		btnNewButton_2.setBounds(417, 292, 93, 34);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Company.class.getResource("/Source/flash3609.jpg")));
		lblNewLabel_6.setBounds(-48, 0, 674, 380);
		panel_1.add(lblNewLabel_6);
		
		
	}
}
