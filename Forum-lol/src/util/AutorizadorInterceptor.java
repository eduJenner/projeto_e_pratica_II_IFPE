package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		String uri = request.getRequestURI();
		if (uri.contains("login") || uri.endsWith("exibirLogin") || uri.endsWith("efetuarLogin")
				|| uri.endsWith("novoUsuario") || uri.endsWith("cadastraUsuario")) {
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("login/login");
		return false;
	}
}
