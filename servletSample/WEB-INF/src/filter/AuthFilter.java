package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import util.Constants;
import util.SessionLoginUser;

@WebFilter(urlPatterns = { "/user/*" })
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		SessionLoginUser sessionLoginUser = new SessionLoginUser(req);

		// ログイン判定
		if (sessionLoginUser.isLoginSession()) {
			chain.doFilter(req, res);
		} else {
			// 未ログインなのでログイン画面へ
			((HttpServletResponse) res).sendRedirect(Constants.Url.LOGIN);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}