package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/user")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String role = servletRequest.getParameter("role");

        switch (role) {
            case "junior" -> servletRequest.setAttribute("page", "juniorPage");
            case "middle" -> servletRequest.setAttribute("page", "middlePage");
            case "senior" -> servletRequest.setAttribute("page", "seniorPage");
            default -> servletRequest.setAttribute("page", "error");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
