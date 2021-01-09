package com.jsu.zcl.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
public class Register {
//	判断账号
	public static boolean registerJudge(String name,String id,String ad,String account,String password) {
		if(name==null) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return false;
		}
		else if(id==null) {
			JOptionPane.showMessageDialog(null, "身份证号不能为空");
				return false;
		}
		else if(id.length()!=18) {
			JOptionPane.showMessageDialog(null, "身份证长度必须是18位");
			return false;
		}
		else if(ad==null) {
			JOptionPane.showMessageDialog(null, "地址不能为空");
				return false;
		}
		else if(account==null) {
			JOptionPane.showMessageDialog(null,"账号不能为空");
			return false;
		}
		else if(account.length()!=9||account.matches("//d+")) {
			JOptionPane.showMessageDialog(null,"账号长度必须是9位，而且为数字");
			return false;
		}else if(accountJudge(account)) {
			JOptionPane.showMessageDialog(null, "该账户已存在");
			return false;
		}else if(password.length()==0) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return false;
		}
		return true;
	}
	public static void dataStorage1(String data) {
		File file = new File("D:/用户信息.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(data + "\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void dataStorage2(String data) {
		File file = new File("D:/用户账号密码.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(data + "\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void dataStorage3(String data, boolean b) {
		File file = new File("D:/用户账号密码.txt");
		try {
			FileWriter fw = new FileWriter(file, b);
			fw.write(data + "\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	账号判断
	public static boolean accountJudge(String account) {
		File file = new File("D:/用户信息.txt");
		String str;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			try {
				while ((str = br.readLine()) != null) {
					if (str.contains(account)) {
						return true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
