package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBuyDao 
{
	 public ProductBean productBean=null;
	
	public ProductBean buy(String pcode)
	{
		Connection connection=DBConnection.getCon();
		try {
			PreparedStatement pStatement=connection.prepareStatement("select * from productapp67 where code=?");
			pStatement.setString(1, pcode);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				 productBean=new ProductBean();
				productBean.setPcode(rSet.getString(1));
				productBean.setPname(rSet.getString(2));
				productBean.setPprice(rSet.getFloat(3));
				productBean.setPqty(rSet.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productBean;
	}
}
