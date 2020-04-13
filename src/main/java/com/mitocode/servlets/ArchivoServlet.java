package com.mitocode.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/archivo")
public class ArchivoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpg");
		resp.setHeader("Content-Disposition", "attachment; filename=imagen.jpg"); // Permite descargar la imagen
		ServletOutputStream out = resp.getOutputStream(); // respuesta del browser
		
		String ruta ="/resources/images/imagen.jpg";
		
		InputStream in = getServletContext().getResourceAsStream(ruta);
		
		BufferedInputStream bin = new BufferedInputStream(in);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		int ch = 0;
		
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
			
		}
		
		out.close();
		in.close();
		bin.close();
		bout.close();
	}

}
