package test;

import java.sql.*;

public class ProductAddDao {
public int k=0;
public int add(ProductBean pb)
{
	Connection con=DBConnection.getCon();
	String query="insert into Productapp67 values(?,?,?,?)";
	try 
	{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,pb.getPcode());
		ps.setString(2, pb.getPname());
		ps.setFloat(3, pb.getPprice());
		ps.setInt(4, pb.getPqty());
		 k=ps.executeUpdate();
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return k;
	
}
}
