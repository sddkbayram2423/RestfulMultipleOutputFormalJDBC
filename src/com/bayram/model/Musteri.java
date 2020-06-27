package com.bayram.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Musteri {
	
	
	private int id;
	private String adi;
	private String soyAdi;
	private String musteriNo;
	
	public Musteri() {
		// TODO Auto-generated constructor stub
	}

	public Musteri(int id, String adi, String soyAdi, String musteriNo) {
		super();
		this.id = id;
		this.adi = adi;
		this.soyAdi = soyAdi;
		this.musteriNo = musteriNo;
	}
	
	@XmlElement
	public int getId() {
		return id;
	}
	@XmlElement
	public String getAdi() {
		return adi;
	}
	@XmlElement
	public String getSoyAdi() {
		return soyAdi;
	}
	@XmlElement
	public String getMusteriNo() {
		return musteriNo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public void setSoyAdi(String soyAdi) {
		this.soyAdi = soyAdi;
	}

	public void setMusteriNo(String musteriNo) {
		this.musteriNo = musteriNo;
	}

	@Override
	public String toString() {
		return "Musteri [id=" + id + ", adi=" + adi + ", soyAdi=" + soyAdi + ", musteriNo=" + musteriNo + "]";
	}
	
	

}
