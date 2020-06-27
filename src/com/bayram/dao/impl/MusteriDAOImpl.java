package com.bayram.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bayram.dao.MusteriDAO;
import com.bayram.model.Musteri;

public class MusteriDAOImpl implements MusteriDAO {
	
	static Connection connection=null;
	@Override
	public Connection openConnection() {
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/web?serverTimezone=Turkey","root","1234");
				if(!connection.isClosed()) {
					System.out.println("Baðlantý baþarýlý");
				}else {
					
					System.out.println("Baðlantý hatasý");
				}
			} catch (SQLException | ClassNotFoundException e) {
				System.err.println("Hata: "+e);
				e.printStackTrace();
			}
			

		return connection;
	}


	@Override
	public List<Musteri> musteriList() {
		Connection connection=openConnection();
		List<Musteri> musteris=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * from Musteri");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				musteris.add(new Musteri(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
				
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Hata: "+e);
		}
		
		return musteris;
	}

	
	@Override
	public Musteri getMusteriById(int musteriId) {
		Connection connection=openConnection();
		Musteri musteri=new Musteri();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * from Musteri where id=?");
			preparedStatement.setInt(1, musteriId);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				musteri.setId(resultSet.getInt(1));
				musteri.setAdi(resultSet.getString(2));
				musteri.setSoyAdi(resultSet.getString(3));
				musteri.setMusteriNo(resultSet.getString(4));
				
			}
		} catch (SQLException e) {
			System.out.println("Hata: "+e);
		}
		
		return musteri;
	}

	
	@Override
	public Musteri addMusteri(Musteri musteri) {
		Connection connection=openConnection();
		PreparedStatement preparedStatement=null;
		
		String query="INSERT INTO Musteri(adi,soyadi,musteriNo) values(?,?,?) ";
		
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, musteri.getAdi());
			preparedStatement.setString(2, musteri.getSoyAdi());
			preparedStatement.setString(3, musteri.getMusteriNo());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return musteri;
	}
	
	
	@Override
	public Musteri updateMusteri(Musteri musteri, int musteriId) {
		Connection connection=openConnection();
		PreparedStatement preparedStatement=null;	
		String sorgu="UPDATE musteri SET adi = ?, soyAdi = ?, musteriNo = ? WHERE id = ?";
	
		
		try {
			preparedStatement=connection.prepareStatement(sorgu);
			preparedStatement.setString(1, musteri.getAdi());
			preparedStatement.setString(2, musteri.getSoyAdi());
			preparedStatement.setString(3, musteri.getMusteriNo());
			preparedStatement.setInt(4, musteriId);
			
			preparedStatement.executeUpdate();
			musteri=getMusteriById(musteriId);
			
		} catch (SQLException e) {
			System.out.println("HATA: "+e);
		}
		
		return musteri;
	}

	@Override
	public boolean deleteMusteri(int mustweriId) {
		Connection connection=openConnection();
		PreparedStatement preparedStatement=null;
	
		try {
			preparedStatement = connection.prepareStatement("DELETE from Musteri where id=?");
			preparedStatement.setInt(1, mustweriId);
			preparedStatement.execute();
		
			
		} catch (SQLException e) {
			System.out.println("Hata: "+e);
		}
		return true;
	}



	}
	

