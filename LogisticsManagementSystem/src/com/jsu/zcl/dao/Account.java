package com.jsu.zcl.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Account {
	// –ﬁ∏ƒ√‹¬Î
		public static void passwordChange(String account, String password) {
			File file = new File("D:/”√ªß’À∫≈√‹¬Î.txt");
			FileReader fr;
			try {
				fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String str;
				String ch[] = new String[1024];
				try {
					int i = 0;
					while ((str = br.readLine()) != null) {
						if (str.contains(account)) {
							str = account + "\t" + password;
						}
						ch[i++] = str;
					}
					br.close();
					for (int j = 0; j < i; j++) {
						if(j==0)
						Register.dataStorage3(ch[j],false);
						else Register.dataStorage3(ch[j], true);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		// ◊¢œ˙’À∫≈
			public static void accountCancel(String account) {
				File file = new File("D:/”√ªß’À∫≈√‹¬Î.txt");
				FileReader fr;
				try {
					fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String str;
					String ch[] = new String[1024];
					try {
						int i = 0;
						while ((str = br.readLine()) != null) {
							if (str.contains(account)) {
								continue;
							}
							ch[i++] = str;
						}
						br.close();
						for (int j = 0; j < i; j++) {
							if(j==0)
								Register.dataStorage3(ch[j],false);
							else Register.dataStorage3(ch[j], true);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}

}
