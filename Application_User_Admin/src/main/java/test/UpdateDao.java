package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDao 
{
	public int k=0;
	public int update(ProductBean pb)
	{
		try 
		{
			Connection con=DBConnection.getCon();
			PreparedStatement pStatement=con.prepareStatement("update productApp67 set price=?,quantity=? where code=?");
			pStatement.setFloat(1, pb.getPprice());
			pStatement.setInt(2, pb.getPqty());
			pStatement.setString(3, pb.getPcode());
			k=pStatement.executeUpdate();
			
					
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return k;
	}
}
