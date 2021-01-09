package com.jsu.zcl.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jsu.zcl.dbc.DatabaseConnectionSql;
public class Operation {
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private static DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	private static Vector<String> titles;
//	删除包裹信息
	public static boolean deletesql(String str) {
		ResultSet rs=getResult();
		int flag=0;
		try {
			while(rs.next()) {
				if(rs.getString(1).equals(str)) {
					flag=1;
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(flag==0) {
			return false;
		}
		DatabaseConnectionSql d=new DatabaseConnectionSql();
		Connection con=d.getConnection();
		String sql="delete from package where id='"+str+"'";
		try {
			Statement s=con.createStatement();
			s.executeUpdate(sql);
			s.addBatch(sql);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
// 	增加包裹信息
	public static boolean addData(String str1, String str2, String str3, int str4) {
		DatabaseConnectionSql data = new DatabaseConnectionSql();
		Connection con = (Connection) data.getConnection();
		String sql0 = "select id from package";
		try {
			PreparedStatement p = con.prepareStatement(sql0);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				if (str1.contains(rs.getString(1))) {
					return false;
				}
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "insert into package(id,ad1,ad2,price) values('" + str1 + "','" + str2 + "','" + str3
				+ "','" + str4 +  "')";
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			s.addBatch(sql);
			s.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return true;
	}
//	获得数据库中所有包裹信息
	public static ResultSet getResult() {
		DatabaseConnectionSql d = new DatabaseConnectionSql();
		Connection c = (Connection) d.getConnection();
		String sql = "SELECT * FROM package";
		PreparedStatement p;
		ResultSet r = null;
		try {
			p = c.prepareStatement(sql);
			r = p.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
		// 获取数据库的信息(方法重载)
	public static Vector<Vector> obtainsql1(String str) {
		Vector<Vector> rows = new Vector<>();
		try {
			ResultSet r = getResult();
			if (str.length() != 0) {
				while (r.next()) {
					if (r.getString(1).equals(str)) {
						Vector row = new Vector<>();
						Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4)	);
						rows.add(row);
					}
				}
			} else {
				while (r.next()) {
					Vector row = new Vector<>();
					Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4));
					rows.add(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	public static Vector<Vector> obtainsql(String str) {
		Vector<Vector> rows = new Vector<>();
		try {
			ResultSet r = getResult();
			if (str.length() != 0) {
				while (r.next()) {
					if (r.getString(1).contains(str) || r.getString(2).contains(str) || r.getString(3).contains(str)) {
						Vector row = new Vector<>();
						Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4)	);
						rows.add(row);
					}
				}
			} else {
				while (r.next()) {
					Vector row = new Vector<>();
					Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4));
					rows.add(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	public static Vector<Vector> obtainsql() {
		Vector<Vector> rows=new Vector<>();
		DatabaseConnectionSql d = new DatabaseConnectionSql();
		Connection c = (Connection) d.getConnection();
		String sql="SELECT * FROM package";
		try {
			PreparedStatement p=c.prepareStatement(sql);
			ResultSet r=p.executeQuery();			
			while(r.next()) {
				Vector row=new Vector<>();
				Collections.addAll(row, r.getString(1),r.getString(2),r.getString(3),r.getInt(4));
				rows.add(row);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	public static void updatesql(String id,String ad1,String ad2,int price) {
		DatabaseConnectionSql d=new DatabaseConnectionSql();
		Connection con=d.getConnection();
		String sql="update package set ad1='"+ad1+"',ad2='"+ad2+"',price='"+price+"' where id='"+id+"'";
		try {
			Statement s=con.createStatement();
			s.executeUpdate(sql);
			s.addBatch(sql);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

