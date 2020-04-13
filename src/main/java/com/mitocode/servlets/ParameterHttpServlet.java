package com.mitocode.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParameterServlet", description = "Este es un servlet de parametros", urlPatterns = { "/parameter",
		"/parameters" }, initParams = {

				@WebInitParam(name = "param1", value = "Mito"), 
				@WebInitParam(name = "param2", value = "Code") })
public class ParameterHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String var1 = req.getParameter("param1");
		String var2 = req.getParameter("param2");
		
		
		if (var1==null) {
			var1 = getInitParameter("param1");
		}
		

		if (var2==null) {
			var2 = getInitParameter("param2");
		}
		
		resp.getWriter().write("Param1 :"+var1+"- Param2 :"+var2);
	}

	
}
