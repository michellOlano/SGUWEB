package servlet;
import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "Sitext")
public class Sitext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  

    public Sitext() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("application/xml");
	        PrintWriter out = response.getWriter();
	        
	        out.println("<html>");
	         out.println("<body>");
	         out.println("PETER");
	         out.println("</body>");
	          out.println("</html>");
	          out.close();
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
