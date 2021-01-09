package com.jsu.zcl.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Enter {
	public static boolean loginJudgment1(String account, String password) {
		File file=new File("D:/用户账号密码.txt");
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String str;
			String[] ch;
			try {
				while((str=br.readLine())!=null) {
					ch=str.split("\t");
					if(account.contains(ch[0])&&password.contains(ch[1])) {
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
	public static boolean loginJudgment2(String account, String password) {
		File file=new File("D:/管理员账号密码.txt");
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String str;
			String[] ch;
			try {
				while((str=br.readLine())!=null) {
					ch=str.split("\t");
					if(account.contains(ch[0])&&password.contains(ch[1])) {
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
	