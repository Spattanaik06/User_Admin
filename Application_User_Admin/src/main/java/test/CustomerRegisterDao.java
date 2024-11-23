package test;

import java.sql.*;

public class CustomerRegisterDao 
{
	public  int k=0;
	public CustomerRegisterDao()
	{
		
	}
	public int register(CustomerBean cb)
	{
		try 
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into CustomerApp67 values(?,?,?,?)");
			ps.setLong(1, cb.getPhno());
			ps.setString(2, cb.getName());
			ps.setString(3, cb.getCity());
			ps.setString(4, cb.getMid());
			 k = ps.executeUpdate();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
}
