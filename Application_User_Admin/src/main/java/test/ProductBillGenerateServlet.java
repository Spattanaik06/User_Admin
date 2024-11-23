package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/generateBill")
public class ProductBillGenerateServlet extends HttpServlet
{
	@Override
	protected void doPost
	(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession hSession=req.getSession(false);
		if(hSession==null)
		{
			req.setAttribute("msg", "Invalid session");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else 
		{
			float qty=Float.parseFloat(req.getParameter("qty"));
			ProductBean productBean=(ProductBean) hSession.getAttribute("pbean");
			hSession.getAttribute("cbean");
			hSession.setAttribute("quantity", qty);
			String pcode= productBean.getPcode();
			
//				req.setAttribute("qty", qty);
				req.getRequestDispatcher("BillAmount.jsp").forward(req, resp);
			
		}
		
	}
}
