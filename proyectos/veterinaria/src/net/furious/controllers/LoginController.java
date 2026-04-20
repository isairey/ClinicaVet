package net.furious.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vetfurious.negocio.ILogin;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@Autowired
	private ILogin iLogin;

	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView IrMenu(HttpServletRequest request,HttpServletResponse response)throws Exception {

		System.out.println("Login");
	
		return new ModelAndView("Login");

	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView IrMain(HttpServletRequest request,HttpServletResponse response)throws Exception {

		System.out.println("Login");
	
		return new ModelAndView("main");

	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView inicio(HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		return new ModelAndView("index");

	}
	
	
	@RequestMapping(value = "/editarLogin", method = RequestMethod.POST)
	public ModelAndView j_spring_security_check(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException, DAOExcepcion {
		Login oModelLogin = new Login();
		oModelLogin.setUsuario(request.getParameter("Usuario"));
		oModelLogin.setPassword(request.getParameter("Password"));
		
		try {
			oModelLogin = iLogin.ObtenerCredenciales(oModelLogin);
					
			if(oModelLogin.getAdministrador()==null)
			{
				return new ModelAndView("Login", "model", oModelLogin);
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("username", oModelLogin.getUsuario());
	
		return new ModelAndView("main", "model", oModelLogin);
	}
	

}
