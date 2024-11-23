package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductView2Dao 
{
	public ArrayList<ProductBean> aList=new ArrayList<ProductBean>();
	public ArrayList<ProductBean> viewProduct()
	{
		Connection connection=DBConnection.getCon();
		try {
			PreparedStatement pStatement=connection.prepareStatement("select * from ProductApp67");
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				ProductBean productBean=new ProductBean();
				productBean.setPcode(rSet.getString(1));
				productBean.setPname(rSet.getString(2));
				productBean.setPprice(Float.parseFloat(rSet.getString(3)));
				productBean.setPqty(Integer.parseInt(rSet.getString(4)));
				aList.add(productBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aList;
		
	}
}
