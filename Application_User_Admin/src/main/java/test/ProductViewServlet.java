package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ProductViewServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Invalid Session...");
			req.getRequestDispatcher("msj.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al = new ProductViewDao().view();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllProduct.jsp").forward(req, res);
		}
		
	}
}
