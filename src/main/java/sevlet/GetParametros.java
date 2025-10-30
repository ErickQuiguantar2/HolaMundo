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

public class GetParametros  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Capturo el parámetro id
        String idParam = request.getParameter("id");
        int id = 0; // valor por defecto

        if (idParam != null && !idParam.isEmpty()) {
            try {
                id = Integer.parseInt(idParam);
            } catch (NumberFormatException e) {
                // Si el parámetro no es numérico, puedes manejar el error
                id = -1;
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Parámetros del Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Parámetros del Servlet</h1>");
        out.println("<p>ID: " + id + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
