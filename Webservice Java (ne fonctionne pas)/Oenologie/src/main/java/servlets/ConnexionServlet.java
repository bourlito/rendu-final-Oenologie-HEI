package servlets;


import managers.UserManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class ConnexionServlet extends GenericServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String errorMessage = null;
        try {
            if (new UserManager().confirmPassword(username, password)){
                request.getSession().setAttribute("username", username);
                response.sendRedirect("index");
            } else {
                errorMessage = "Les identifiants saisis sont incorrects!";
            }
        } catch (Exception e ) {
            errorMessage = "Les identifiants saisis sont incorrects!";
        }
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("errorMessage", errorMessage);
        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        templateEngine.process("login", context, response.getWriter());
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (request.getSession().getAttribute("username")!=null){
            response.sendRedirect("/login");
        } else {
            WebContext context = new WebContext(request, response, request.getServletContext());
            TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
            templateEngine.process("login", context, response.getWriter());
        }
    }


}
