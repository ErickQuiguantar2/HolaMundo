package sevlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

//Es una llave para conectar desde cualquier parte
// de el programa al server

@WebServlet("/holaServlet")

public class Servlet extends HttpServlet {

    // Metodo que se ejecuta cuando se hace una petición GET al Servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Capturamos los parámetros "saludo" y "nombre" enviados en la URL
        String saludo = request.getParameter("saludo");
        String nombre = request.getParameter("nombre");

        // Preparamos la respuesta HTML
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HolaServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet HolaServlet</h1>");
        out.println("<br>");
        out.println("<h2>Saludando: " + saludo + " " + nombre + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    // Método que se ejecuta cuando se hace una petición POST al Servlet (desde un formulario)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Capturamos los parámetros enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String cedula = request.getParameter("cedula");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");

        // Calculamos la edad a partir de la fecha de nacimiento
        String edad = "";
        if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            LocalDate hoy = LocalDate.now();
            Period periodo = Period.between(fechaNacimiento, hoy);
            edad = String.valueOf(periodo.getYears()); // Obtenemos la edad en años
        }

        // Mostramos los datos capturados y la edad calculada en HTML
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<p>Nombre: " + nombre + "</p>");
        out.println("<p>Apellido: " + apellido + "</p>");
        out.println("<p>Dirección: " + direccion + "</p>");
        out.println("<p>Cédula: " + cedula + "</p>");
        out.println("<p>Fecha de Nacimiento: " + fechaNacimientoStr + "</p>");
        out.println("<p>Edad calculada: " + edad + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

}
