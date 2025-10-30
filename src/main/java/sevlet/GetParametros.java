package sevlet;

import jakarta.persistence.Id;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/parametros")

public class GetParametros extends HttpServlet {

    // Metodo que se ejecuta cuando se hace una petición GET al Servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Configuramos el tipo de contenido de la respuesta
        response.setContentType("text/html;charset=UTF-8");

        // Capturamos el parámetro "id" enviado en la URL
        String idParam = request.getParameter("id");
        int id = 0; // valor por defecto en caso de no recibir parámetro

        if (idParam != null && !idParam.isEmpty()) {
            try {
                // Intentamos convertir el parámetro a entero
                id = Integer.parseInt(idParam);
            } catch (NumberFormatException e) {
                // Si el parámetro no es numérico, asignamos -1
                id = -1;
            }
        }

        // Preparamos la respuesta HTML
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Parámetros del Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Parámetros del Servlet</h1>");
        out.println("<p>ID: " + id + "</p>"); // Mostramos el ID recibido o el valor por defecto
        out.println("</body>");
        out.println("</html>");
    }
}
