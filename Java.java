import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String subscribe = request.getParameter("subscribe");

        if (subscribe != null) {
            System.out.println("Checkbox is CHECKED");
        } else {
            System.out.println("Checkbox is NOT CHECKED");
        }
    }
}