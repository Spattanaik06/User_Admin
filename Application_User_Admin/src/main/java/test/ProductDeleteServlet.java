package test;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class ProductDeleteServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession hSession=req.getSession(false);
		if(hSession==null)
		{
			req.setAttribute("msg","invalid session...");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else 
		{
			ArrayList<ProductBean> aList=(ArrayList<ProductBean>) hSession.getAttribute("alist");
			String pcode=req.getParameter("pcode");
			Iterator<ProductBean> it=aList.iterator();
			while(it.hasNext())
			{
				ProductBean pBean=it.next();
				if(pcode.equals(pBean.getPcode()))
				{
					int k=new ProductDeleteDao().delete(pBean.getPcode());
					if(k>0)
					{
						req.setAttribute("delete","Product Deleted Successfully...");
						req.getRequestDispatcher("DeleteSuccess.jsp").forward(req, res);
					}
					else 
					{
						req.setAttribute("msg","Invalid Details.....");
						req.getRequestDispatcher("msg.jsp").forward(req, res);
					}
					
					
				}
			}
		}
		
	}
}
