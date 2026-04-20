package net.furious.controllers;

import java.io.IOException;
import net.vetfurious.excepcion.DAOExcepcion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.vetfurious.negocio.IPublicidad;
import net.vetfurious.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PublicidadController 
{
	@Autowired
	private IPublicidad Publicidad;
	
	@RequestMapping(value="/pc2-listarPublicidad.jsp")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Publicidad> publicidad = this.Publicidad.listarpublicidad();
				
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("publicidad",publicidad);
       
        return new ModelAndView("pc2-listarPublicidad", "model", myModel);

    }
	
	@RequestMapping(value = "/verRegistroPublicidad", method = RequestMethod.GET)
	public ModelAndView ingresar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevoPublicidad");
	}
	
	@RequestMapping(value = "/registrarPublicidad.jsp", method = RequestMethod.POST)
	public ModelAndView registroPublicidad(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		Publicidad oModelPublicidad = new Publicidad();
		oModelPublicidad.setTitulo(request.getParameter("txtTitulo"));
		oModelPublicidad.setContenido(request.getParameter("txtContenido"));
		oModelPublicidad.setContenido(request.getParameter("txtFechaInicio"));
		oModelPublicidad.setContenido(request.getParameter("txtFechaFin"));
		oModelPublicidad.setContenido(request.getParameter("txtTarifa"));
		oModelPublicidad.setContenido(request.getParameter("txtNumeroClicks"));
		oModelPublicidad.setContenido(request.getParameter("txtUbicacion"));
		
		
		try {
			Publicidad.GrabarModificarPublicidad(oModelPublicidad);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:pc2-listarPublicidad.jsp");
	}

}
