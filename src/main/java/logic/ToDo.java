package logic;

import beans.LoginBean;
import beans.SettingsBean;
import beans.ToDoBean;
import utilities.ErrorCodes;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ToDo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ToDo() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * Called when the user wants to add a new todo
     *
     * @param request  The POST request
     * @param response The http response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean loginBean = new LoginBean();
        ToDoBean toDoBean = new ToDoBean();
        request.setCharacterEncoding("UTF-8");

        String task = request.getParameter("todo");
        String assignee = request.getParameter("name");
        String dueDateString = request.getParameter("deadline");
        Cookie[] cookies = request.getCookies();
        String sessionIdentifier = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session")) {
                sessionIdentifier = cookie.getValue();
            }
        }

        String userId = loginBean.getUserIdBySessionIdentifier(sessionIdentifier);
        String assigneeId = loginBean.getUserId(assignee);
        String wgId = toDoBean.getWgIdByUserId(userId);
        Date dueDate = null;
        try {
            dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ErrorCodes status = toDoBean.createTodo(task, assigneeId, wgId, dueDate, userId);

        switch (status) {
            case SUCCESS:
                //Redirect back to the todo page
                response.sendRedirect("/todo");
                break;
            case FAILURE:
                //Forward to failure page
                request.getServletContext().getRequestDispatcher("/responseFailure").forward(request, response);
                break;
            case WRONGENTRY:
                //Forward to wrong entry page
                request.getServletContext().getRequestDispatcher("/responseWrongEntry").forward(request, response);
                break;
        }
    }
}
