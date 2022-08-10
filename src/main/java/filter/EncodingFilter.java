package filter;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * The type Encoding filter.
 * @author LeeGaki
 */

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String enc ="UTF-8";
        request.setCharacterEncoding(enc);
        response.setCharacterEncoding(enc);
        response.setContentType("text/html;charset="+enc);
        chain.doFilter(request, response);
    }
}
