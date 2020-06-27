package com.bayram.dao;

import java.sql.Connection;
import java.util.List;

import com.bayram.model.Musteri;

public interface MusteriDAO {
	
	public Connection openConnection();
	
	public List<Musteri> musteriList();
	
	public Musteri getMusteriById(int musteriId);
	
	public Musteri addMusteri(Musteri musteri);
	
	public Musteri updateMusteri(Musteri musteri,int musteriId);
	
	public boolean deleteMusteri(int mustweriId);

}
