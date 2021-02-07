package ru.geekbrains;

import ru.geekbrains.persist.UserRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first-http-servlet/*")
public class FirstHttpServlet extends HttpServlet {

    private UserRepository userRepository;  //добавляем в качестве поля, за счет этого в строке 20 можем его инициализировать

    @Override
    public void init() throws ServletException {
        this.userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
        /* данный способ дает возможность (если его прописать в др.сервлетах) любому сервлету получить доступ к userRepository */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Привет, как дела?</h1>");
            resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
            resp.getWriter().println("<p>contextPath: " + req.getServletPath() + "</p>");
            resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() +"</p>");
            resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
            resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
            resp.getWriter().println("<p>param1: " + req.getParameter("param2") + "</p>");


    }
}
