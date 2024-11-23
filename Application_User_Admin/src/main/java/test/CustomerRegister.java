package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	CustomerBean cb=new CustomerBean();
	cb.setPhno(Long.parseLong(req.getParameter("phno")));
	cb.setName(req.getParameter("name"));
	cb.setCity(req.getParameter("city"));
	cb.setMid(req.getParameter("mid"));
	int k=new CustomerRegisterDao().register(cb);
	System.out.println(k);
	if(k>0)
	{
		req.setAttribute("msg", "Register Successfully....");
		req.getRequestDispatcher("msg.jsp").forward(req, res);
	}
}
}
