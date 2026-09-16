package com.instagramweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.State;

public class InstagramDAO implements InstagramDAOInterface {

	@Override
	public int createProfileDAO(InstagramUser iu) {
		int i=0;
		try {
		//step 1 load driver
		Class.forName("com.mysql.jdbc.Driver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustbatch","root","rajesh");
		//step 3 create query
		
		PreparedStatement st =con.prepareStatement("insert into instagramuser values(?,?,?,?,?)");
		st.setString(1, iu.getName());
		st.setString(2, iu.getPassword());
		st.setString(3, iu.getEmail());
		st.setString(4, iu.getAddress());
		st.setInt(5, iu.getAge());
		//step 4 execute query
		i=st.executeUpdate();   //if query is insert,delete,update we will use executeUpdate() method, for select we will use executeQuery() method
		//step 5 display result
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}

	@Override
	public int loginProfileDAO(InstagramUser iu) {
		int i=0;
		try {
		//step 1 load driver
		Class.forName("com.mysql.jdbc.Driver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustbatch","root","rajesh");
		//step 3 create query
		
		PreparedStatement st =con.prepareStatement("select * from instagramuser where email=? and password=?");
		st.setString(1, iu.getEmail());
		st.setString(2, iu.getPassword());
		
		
		//step 4 execute query
		ResultSet res = st.executeQuery();   //if query is insert,delete,update we will use executeUpdate() method, for select we will use executeQuery() method
		//step 5 display result
		if(res.next()) {
			i=1;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}

	@Override
	public InstagramUser viewProfileDAO(InstagramUser iu1) {
		InstagramUser iu=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustbatch","root","rajesh");
			PreparedStatement st =con.prepareStatement("select * from instagramuser where email=?");
			st.setString(1, iu1.getEmail());
			
			ResultSet i=st.executeQuery();   //if query is insert,delete,update we will use executeUpdate() method, for select we will use executeQuery() method
			
			if(i.next()) {
				iu=new InstagramUser();
				iu.setName(i.getString(1));  //fetching first column i.e. name in employee table data
				iu.setPassword(i.getString(2)); //fetching second column i.e. password in employee table data
				iu.setEmail(i.getString(3));
				iu.setAddress(i.getString(4));
				iu.setAge(i.getInt(5));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return iu;
	}

	@Override
	public int checkEmailDAO(InstagramUser iu) {
		int iu1=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustbatch","root","rajesh");
			PreparedStatement st =con.prepareStatement("select * from instagramuser where email=?");
			st.setString(1, iu.getEmail());
			
			ResultSet i=st.executeQuery();   //if query is insert,delete,update we will use executeUpdate() method, for select we will use executeQuery() method
			
			if(i.next()) {
				iu1=1;
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return iu1;
	}

	@Override
	public ArrayList<Country> loadCountryDAO() {
		ArrayList<Country> cc =new ArrayList<Country>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustbatch","root","rajesh");
			PreparedStatement st =con.prepareStatement("select * from country");
			
			ResultSet i=st.executeQuery();   //if query is insert,delete,update we will use executeUpdate() method, for select we will use executeQuery() method
			
			while(i.next()) {
				Country c1=new Country();
				c1.setCountryId(i.getInt(1));
				c1.setCountryName(i.getString(2));
				
				cc.add(c1);
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return cc;
	}

	@Override
	public ArrayList<State> loadStateDAO(Country c) {
		ArrayList<State> cc =new ArrayList<State>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustbatch","root","rajesh");
			
			System.out.println(c.getCountryName());
			
			PreparedStatement st1 =con.prepareStatement("select * from country where countryName=?");
			st1.setString(1, c.getCountryName());
			
			ResultSet res=st1.executeQuery();
			res.next();
			int countryId = res.getInt(1);
			
			PreparedStatement st =con.prepareStatement("select * from state where countryId=?");
			st.setInt(1, countryId);
			
			ResultSet i=st.executeQuery();   //if query is insert,delete,update we will use executeUpdate() method, for select we will use executeQuery() method
			
			while(i.next()) {
				State c1=new State();
				
				c1.setStateName(i.getString(2));
				
				cc.add(c1);
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return cc;
	}

}
