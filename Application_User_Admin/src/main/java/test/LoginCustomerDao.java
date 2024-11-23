package test;
import java.sql.*;
public class LoginCustomerDao 
{
	public CustomerBean cb=null;
	public CustomerBean login(Long phno)
	{
		try 
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from customerapp67 where phno=?");
			ps.setLong(1, phno);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				cb=new CustomerBean();
				cb.setPhno(rs.getLong(1));
				cb.setName(rs.getString(2));
				cb.setCity(rs.getString(3));
				cb.setMid(rs.getString(4));
			}
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		return cb;
		
	}
	
	
}
