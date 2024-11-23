package test;
import java.sql.*;
import java.util.ArrayList;
public class ProductViewDao 
{
	public ArrayList<ProductBean> al =new ArrayList<>();
	public ArrayList<ProductBean> view()
	{
		try
		{
			Connection con=DBConnection.getCon();
			String query="Select * from ProductApp67";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ProductBean pb=new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPprice(Float.parseFloat(rs.getString(3)));
				pb.setPqty(Integer.parseInt(rs.getString(4)));
				al.add(pb);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
		
	}
}
