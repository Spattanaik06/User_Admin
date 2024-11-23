package test;
import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class ProductEditServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Invalid session");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
			String pcode=req.getParameter("pcode");
			Iterator<ProductBean> it=al.iterator();
			while(it.hasNext())
			{
				ProductBean pb=(ProductBean)it.next();
				if(pcode.equals(pb.getPcode()))
				{
					req.setAttribute("pbean", pb);
//					System.out.println(pb);
					req.getRequestDispatcher("Edit.jsp").forward(req, res);
					break;
					
				}
			}
		
		}
	}
}
