package cn.tedu;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "FilterTest")
public class FilterTest implements Filter {
    String charset;

    public void init(FilterConfig config) throws ServletException {
        charset = config.getInitParameter("charset");
        System.out.println("FilterTest---init---^^-^-^");
    }

    public void destroy() {
        System.out.println("FilterTest-^-^-^--^-^--destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterTest--doFileter-^-^-^-^-^-^-^-^-^-^--^");
        // 跳转到url所映射的web程序
        System.out.println(charset);
        request.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }
}
