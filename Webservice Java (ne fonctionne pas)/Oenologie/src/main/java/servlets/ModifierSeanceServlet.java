package servlets;


import entities.Seance;
import impl.SeanceDaoImpl;
import managers.SeanceLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;

@WebServlet("/index")

public class ModifierSeanceServlet extends GenericServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        WebContext context = new WebContext(request, response, request.getServletContext());
        templateEngine.process("index", context, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer Idseance = Integer.parseInt(req.getParameter("seance"));
        String Libelle=req.getParameter("libelle");
        String Date = req.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date FormateDate = sdf.parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Infos=req.getParameter("infos");

        Seance seance = SeanceLibrary.getInstance().updateSeance(Idseance,Libelle,Date,Infos);

        resp.sendRedirect("index");

    }

}
