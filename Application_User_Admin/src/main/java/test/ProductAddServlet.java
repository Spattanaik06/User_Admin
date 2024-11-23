package test;
import java.io.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class ProductAddServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException,ServletException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","invalid session....");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else
		{
			ProductBean pb=new ProductBean();
			pb.setPcode(req.getParameter("pcode"));
			pb.setPname(req.getParameter("pname"));
			pb.setPprice(Float.parseFloat(req.getParameter("pprice")));
			pb.setPqty(Integer.parseInt(req.getParameter("pqty")));
			int k=new ProductAddDao().add(pb);
			if(k>0)
			{
				req.setAttribute("msg","Product Added Successfully.....");
				req.getRequestDispatcher("ProductSuccessAdd.jsp").forward(req, res);
			}
		}
	}
}
