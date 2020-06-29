package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SessionBean;
import beans.ShoppingBean;
import utilities.ErrorCodes;

/**
 * Called when the user wants to set a shopping request to done / bought
 */
public class SetBoughtShopping extends HttpServlet {
    public SetBoughtShopping() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingBean shoppingBean = new ShoppingBean();
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("sessionBean");
        request.setCharacterEncoding("UTF-8");

        String requestId = request.getParameter("requestId");
        String wgId = sessionBean.getWgId();

        ErrorCodes status = shoppingBean.setRequestDone(requestId, wgId);

        switch (status) {
            case SUCCESS:
                //Show success
                response.sendRedirect("/shopping");
                break;
            default:
                //Show failure
                request.setAttribute("isSadLlama", true);
                request.setAttribute("header", status.getHeader());
                request.setAttribute("message", status.getMessage());
                request.getServletContext().getRequestDispatcher("/status").forward(request, response);
                break;
        }
    }
}
