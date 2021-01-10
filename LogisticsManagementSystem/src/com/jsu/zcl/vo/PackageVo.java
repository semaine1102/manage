package com.jsu.zcl.vo;
import java.io.Serializable;
public class PackageVo implements Serializable{
	private String id;
	private String ad1;
	private String ad2;
	private int price;
	public PackageVo() {}
	public PackageVo(String id,String ad1,String ad2,int price) {
		this.id=id;
		this.ad1=ad1;
		this.ad2=ad2;
		this.price=price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAd1() {
		return ad1;
	}
	public void setAd1(String ad1) {
		this.ad1 = ad1;
	}
	public String getAd2() {
		return ad2;
	}
	public void setAd2(String ad2) {
		this.ad2 = ad2;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
