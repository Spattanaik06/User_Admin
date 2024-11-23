package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginCustomerServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
	long phno=Long.parseLong(req.getParameter("phno"));
	CustomerBean cb=new LoginCustomerDao().login(phno);
	if(cb==null)
	{
		req.setAttribute("msg", "Invalid Mobile Number....");
		req.getRequestDispatcher("msg.jsp").forward(req, res);
	}
	else
	{
		HttpSession hs=req.getSession();
		hs.setAttribute("cbean", cb);
		req.getRequestDispatcher("CustomerSuccessLogin.jsp").forward(req, res);
	}
	
	
}
}
