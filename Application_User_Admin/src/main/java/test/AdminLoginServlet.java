package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		AdminBean ab=new AdminDao().login(uname, password);
		if(ab==null)
		{
			req.setAttribute("msg", "invalid details.....");
			req.getRequestDispatcher("LoginFailedMessage.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminSuccessLogin.jsp").forward(req, res);
		}
	}
}
