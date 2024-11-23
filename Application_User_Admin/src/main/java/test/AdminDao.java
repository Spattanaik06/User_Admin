package test;

import java.sql.*;

public class AdminDao 
{
	public AdminBean ab=null;
	public AdminBean login(String name,String password)
	{
		Connection con=DBConnection.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("select * from admin67 where username=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet r=ps.executeQuery();
			if(r.next())
			{
				ab=new AdminBean();
				ab.setUname(r.getString(1));
				ab.setPassword(r.getString(2));
				ab.setFname(r.getString(3));
				ab.setLname(r.getString(4));
				ab.setCity(r.getString(5));
				ab.setMailid(r.getString(6));
				ab.setPhno(r.getLong(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}
}
