package com.jsu.zcl.vo;
import java.io.Serializable;
public class PersonVo implements Serializable{
	private String name;
	private String id;
	private String ad;
	private String account;
	private String password;
	public PersonVo() {}
	public PersonVo(String name,String id,String ad,String account,String password) {
		this.name=name;
		this.id=id;
		this.ad=ad;
		this.account=account;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
