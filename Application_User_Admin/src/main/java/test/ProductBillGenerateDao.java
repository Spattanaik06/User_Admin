package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductBillGenerateDao 
{
	public int k=0;
	public int quantityUpdate(String pcode,float qty)
	{
		Connection connection=DBConnection.getCon();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("update productapp67 set quantity=quantity- ? where code= ?");
			preparedStatement.setFloat(1, qty);
			preparedStatement.setString(2, pcode);
			k=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
		
	}
}
