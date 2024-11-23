package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buy")
public class ProductBuyServlet extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		HttpSession hSession=req.getSession(false);
		if(hSession==null)
		{
			req.setAttribute("msg", "Session expired...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else 
		{
			
			String pcode=req.getParameter("pcode");
			ProductBean productBean=new ProductBuyDao().buy(pcode);
			CustomerBean customerBean=(CustomerBean) hSession.getAttribute("cbean");
//			System.out.println(customerBean);
			hSession.setAttribute("pbean", productBean);
			req.getRequestDispatcher("QuantityAdd.jsp").forward(req, resp);
		}
		
	}
}
