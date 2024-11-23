package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/payment")
public class productPaymentServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession hSession=req.getSession(false);
		if(hSession==null)
		{
			req.setAttribute("msg", "session expired..");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else 
		{
			hSession.getAttribute("cbean");
			ProductBean productBean=(ProductBean) hSession.getAttribute("pbean");
			String pcode=productBean.getPcode();
			float qty =(Float) hSession.getAttribute("quantity");
			
			int k=new ProductBillGenerateDao().quantityUpdate(pcode, qty);
			if(k>0)
			{
				req.setAttribute("msg", "Payment successfull...");
				req.getRequestDispatcher("PaymentSuccess.jsp").forward(req, resp);
			}
			
		}
		
	}
}

