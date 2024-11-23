package test;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "invalid session");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else 
		{
//			String price=req.getParameter("price");
//			String pqty = req.getParameter("pqty");
			ArrayList<ProductBean> aList=(ArrayList<ProductBean>)hs.getAttribute("alist");
			String pcode=req.getParameter("pcode");
			Iterator<ProductBean> it=aList.iterator();
			while(it.hasNext())
			{
				ProductBean pBean=it.next();
				if(pcode.equals(pBean.getPcode()))
					
				{
					pBean.setPprice(Float.parseFloat(req.getParameter("price")));
					pBean.setPqty(Integer.parseInt(req.getParameter("pqty")));
					
					int k=new UpdateDao().update(pBean);
//                  System.out.println(k);
					if(k>0)
					{
						req.setAttribute("msg","Product updated successfully.");
						req.getRequestDispatcher("UpdateSuccess.jsp").forward(req, res);
					}
					
				}
			}
			

			
		}
	}
}
