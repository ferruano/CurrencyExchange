package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet({ "/LoginServlet", "/" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = "a@a";
		String pass = "root";
		Subject currentUser = SecurityUtils.getSubject();	
		if ( !currentUser.isAuthenticated() ) {
			UsernamePasswordToken token = new UsernamePasswordToken( email, pass );
			try {
				currentUser.login( token );
				resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );
				
			} catch ( Exception e ) {
				System.out.println(e);
				resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );
			}
		} else
			resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );
	}
	
}
