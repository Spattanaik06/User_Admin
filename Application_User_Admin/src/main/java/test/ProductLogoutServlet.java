package test;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class ProductLogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession hSession=req.getSession(false);
		if(hSession==null)
		{
			req.setAttribute("msg","Invalid session");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else 
		{
			hSession.removeAttribute("alist");
			hSession.removeAttribute("pbean");
			hSession.invalidate();
			req.getRequestDispatcher("Logout.jsp").forward(req, res);
			
		}
	}
}
