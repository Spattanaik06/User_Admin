package test;

import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.html.HTMLFieldSetElement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view2")
public class ProductView2Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession hSession=req.getSession(false);
		
		if(hSession==null)
		{
			req.setAttribute("msg","Invalid session");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else
		{
			ArrayList<ProductBean> aList=new ProductView2Dao().viewProduct();
			CustomerBean customerBean = (CustomerBean)hSession.getAttribute("cbean");
			hSession.setAttribute("alist", aList);
			req.getRequestDispatcher("view2allproduct.jsp").forward(req, resp);
			
		}
		
	}
}
