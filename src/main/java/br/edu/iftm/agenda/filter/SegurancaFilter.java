/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package br.edu.iftm.agenda.filter;

import br.edu.iftm.agenda.entity.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danilo
 */
@WebFilter(filterName = "SegurancaFilter", urlPatterns = {"/*"})
public class SegurancaFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        System.out.println("\n\n\nFiltro executou..." + servletRequest.getRequestURI() + "\n\n\n\n");
        if (redireciona(servletRequest)) {
            servletResponse.sendRedirect(servletRequest.getContextPath() + "/login.xhtml");
        }

        chain.doFilter(request, response);

    }

    public boolean redireciona(HttpServletRequest httpRequest) {
        Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
        if (httpRequest.getRequestURI().endsWith("login.xhtml")) {
            return false;
        }
        if (httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + "/javax.faces.resource")) {
            return false;
        }
        if(usuario != null) {
            return false;
        }
        return true;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }

}
