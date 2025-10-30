package sevlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Es una llave para conectar desde cualquier parte
// de el programa al server

@WebServlet("/holaServlet")

public class Servlet extends  HttpServlet{
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //Capturamos los valores y parametros de la solicitud
        String saludo = request.getParameter("saludo");
        String nombre = request.getParameter("nombre");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HolaServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet HolaServlet</h1>");
        out.println("<br>");
        out.println("<h2> Saludando: " + saludo + " " + nombre + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String nombre1 = request.getParameter("nombre");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Servlet</h1>");
        out.println("<br>");
        out.println("<h2> Nombre: " + nombre1 + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
