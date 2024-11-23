package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDeleteDao 
{
	public int k=0;
	public int delete(String pcode)
	{
		try 
		{
			Connection connection=DBConnection.getCon();
			PreparedStatement pStatement=connection.prepareStatement("delete from ProductApp67 where code=?");
			pStatement.setString(1, pcode);
			k=pStatement.executeUpdate();
		}
		catch (Exception e) 
		{
			
		}
		return k;
		
	}
}
