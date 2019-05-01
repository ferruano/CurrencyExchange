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

@WebServlet({ "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Subject currentUser = SecurityUtils.getSubject();
		if ( currentUser.isAuthenticated() )
			currentUser.logout();
		String email = req.getParameter("email");
		String pass = "root";
		if ( !currentUser.isAuthenticated() ) {
			UsernamePasswordToken token = new UsernamePasswordToken( email, pass );
			try {
				currentUser.login( token );
				if ( currentUser.hasRole( "admin" ) ) 
					resp.sendRedirect( req.getContextPath() + "/ManageServlet?email=" + currentUser.getPrincipal() );
				else
					resp.sendRedirect( req.getContextPath() + "/PrincipalServlet?email=" + currentUser.getPrincipal() );
			} catch ( Exception e ) {
				System.out.println(e);
				resp.sendRedirect( req.getContextPath() + "/PrincipalServlet?email=error" );
			}
		} else
			resp.sendRedirect( req.getContextPath() + "/PrincipalServlet?email=NoUserFound" );
	}
}
