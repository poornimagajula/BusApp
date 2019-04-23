package com.regnant.BusApp;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetBus
 */
@WebServlet("/GetBusServlet")
public class GetBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BusBean b=new BusBean();
		DBCRUDOperations dbop=new DBCRUDOperations();
		
		String source=request.getParameter("Source");
		String destination=request.getParameter("Destination");
		String date=request.getParameter("Date");
		Date date1=Date.valueOf(date);
		
		b.setSource(source);
		b.setDestination(destination);
		b.setDate(date1);
		List<BusBean> buslist = dbop.getBus(b);
		request.setAttribute("Login", buslist);
		request.getRequestDispatcher("GetBusJSP.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
