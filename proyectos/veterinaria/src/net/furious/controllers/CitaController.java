package net.furious.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Cita;
import net.vetfurious.negocio.ICita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CitaController 
{

	@Autowired
	private ICita Cita;

	@RequestMapping(value = "/menuCita", method = RequestMethod.GET)
	public ModelAndView ingresarMenuCita(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("menuCita");
	}


	
	@RequestMapping(value="/listarVacuna")
	public ModelAndView handleRequestVacunas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Cita> vacunas = this.Cita.ListarCitaVacunas();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("vacunas",vacunas);
       
        return new ModelAndView("listarVacunas", "model", myModel);
    }
	
	@RequestMapping(value="/listarTarea")
	public ModelAndView handleRequestTareas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Cita> tareas = this.Cita.ListarCitaTareas();		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("tareas",tareas);
       
        return new ModelAndView("listarTareas", "model", myModel);
    }

	
	@RequestMapping(value = "/verRegistroTarea", method = RequestMethod.GET)
	public ModelAndView ingresarTarea(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevaTarea");
	}

	@RequestMapping(value = "/verRegistroVacuna", method = RequestMethod.GET)
	public ModelAndView ingresarVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevaVacuna");
	}
	
	@RequestMapping(value = "/verRegistroNombreVacuna", method = RequestMethod.GET)
	public ModelAndView ingresarNombreVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevaVacunaNombre");
	}


	@RequestMapping(value = "/registrarTarea", method = RequestMethod.POST)
	public ModelAndView registroTarea(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarTarea");
		
		Cita oModelCita = new Cita();
		oModelCita.setCodigoCita("0");
		oModelCita.setTipoCita("T");
		oModelCita.setCodigoDoctor(request.getParameter("txtCodigoDoctor"));
		oModelCita.setCodigoPersona(request.getParameter("hiddencliente"));
		oModelCita.setCodigoPaciente(request.getParameter("hiddenpaciente"));
		oModelCita.setDescripcionCita(request.getParameter("txtDescripcion"));
		oModelCita.setFechaCita(request.getParameter("txtFecha"));
		
		try 
		{
			Cita.GrabarModificarCita(oModelCita);
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		List<Cita> tareas = this.Cita.ListarCitaTareas();		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("tareas",tareas);
       
        return new ModelAndView("listarTareas", "model", myModel);
	}

	
	@RequestMapping(value = "/registrarVacuna", method = RequestMethod.POST)
	public ModelAndView registroVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarVacuna");
		
		Cita oModelCita = new Cita();
		oModelCita.setCodigoCita("0");
		oModelCita.setTipoCita("V");
		oModelCita.setCodigoDoctor(request.getParameter("txtCodigoDoctor"));
		oModelCita.setCodigoPersona(request.getParameter("hiddencliente"));
		oModelCita.setCodigoPaciente(request.getParameter("hiddenpaciente"));
		oModelCita.setNombreVacuna(request.getParameter("txtVacuna"));
		oModelCita.setDescripcionCita(request.getParameter("txtDescripcion"));
		oModelCita.setFechaCita(request.getParameter("txtFecha"));
		
		try 
		{
			Cita.GrabarModificarCita(oModelCita);
		} 
		catch (Exception e) 
		{
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		List<Cita> vacunas = this.Cita.ListarCitaVacunas();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("vacunas",vacunas);
       
        return new ModelAndView("listarVacunas", "model", myModel);
	}

	@RequestMapping(value = "/registrarNombreVacuna", method = RequestMethod.POST)
	public ModelAndView registroNombreVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarNombreVacuna");
		
		try 
		{
			Cita.InsertarVacuna(request.getParameter("txtNombreVacuna"));
		} 
		catch (Exception e) 
		{
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("menuCita");
	}
	
	@RequestMapping(value = "/editarTarea", method = RequestMethod.GET)
	public ModelAndView editarTarea(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		System.out.println("idCita "+request.getParameter("idCita"));
		
		Cita oModelCita = new Cita();
		oModelCita = Cita.ObtenerCita(request.getParameter("idCita"));
		return new ModelAndView("editarTarea", "model", oModelCita);
	}

	@RequestMapping(value = "/editarVacuna", method = RequestMethod.GET)
	public ModelAndView editarVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		System.out.println("idCita "+request.getParameter("idCita"));
		
		Cita oModelCita = new Cita();
		oModelCita = Cita.ObtenerCita(request.getParameter("idCita"));
		return new ModelAndView("editarVacuna", "model", oModelCita);
	}

	
	@RequestMapping(value = "/guardarTarea", method = RequestMethod.POST)
	public ModelAndView modificarTarea(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarTarea");
		
		Cita oModelCita = new Cita();
		oModelCita.setCodigoCita(request.getParameter("idCita"));
		oModelCita.setTipoCita("T");
		oModelCita.setCodigoDoctor(request.getParameter("txtCodigoDoctor"));
		oModelCita.setCodigoPersona(request.getParameter("txtCodigoCliente"));
		oModelCita.setCodigoPaciente(request.getParameter("txtCodigoPaciente"));
		oModelCita.setDescripcionCita(request.getParameter("txtDescripcion"));
		oModelCita.setFechaCita(request.getParameter("txtFecha"));
		
		try 
		{
			Cita.GrabarModificarCita(oModelCita);
		} 
		catch (Exception e) 
		{
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		List<Cita> tareas = this.Cita.ListarCitaTareas();		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("tareas",tareas);
       
        return new ModelAndView("listarTareas", "model", myModel);
	}
	
	@RequestMapping(value = "/guardarVacuna", method = RequestMethod.POST)
	public ModelAndView modificarVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarVacuna");
		
		Cita oModelCita = new Cita();
		oModelCita.setCodigoCita(request.getParameter("idCita"));
		oModelCita.setTipoCita("V");
		oModelCita.setCodigoDoctor(request.getParameter("txtCodigoDoctor"));
		oModelCita.setCodigoPersona(request.getParameter("txtCodigoCliente"));
		oModelCita.setCodigoPaciente(request.getParameter("txtCodigoPaciente"));
		oModelCita.setNombreVacuna(request.getParameter("txtVacuna"));
		oModelCita.setDescripcionCita(request.getParameter("txtDescripcion"));
		oModelCita.setFechaCita(request.getParameter("txtFecha"));
		
		try 
		{
			Cita.GrabarModificarCita(oModelCita);
		} 
		catch (Exception e) 
		{
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

        List<Cita> vacunas = this.Cita.ListarCitaVacunas();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("vacunas",vacunas);
       
        return new ModelAndView("listarVacunas", "model", myModel);
	}

	
	@RequestMapping(value = "/eliminarTarea", method = RequestMethod.GET)
	public ModelAndView eliminarTarea(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarTarea");
		
		Cita oModelCita = new Cita();
		oModelCita.setCodigoCita(request.getParameter("idCita"));
		
		try 
		{
			Cita.BorrarCita(oModelCita.getCodigoCita());
		} 
		catch (Exception e) 
		{
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		List<Cita> tareas = this.Cita.ListarCitaTareas();		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("tareas",tareas);
       
        return new ModelAndView("listarTareas", "model", myModel);
	}
	
	@RequestMapping(value = "/eliminarVacuna", method = RequestMethod.GET)
	public ModelAndView eliminarVacuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarVacuna");
		
		Cita oModelCita = new Cita();
		oModelCita.setCodigoCita(request.getParameter("idCita"));
		
		try 
		{
			Cita.BorrarCita(oModelCita.getCodigoCita());
		} 
		catch (Exception e) 
		{
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

        List<Cita> vacunas = this.Cita.ListarCitaVacunas();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("vacunas",vacunas);
       
        return new ModelAndView("listarVacunas", "model", myModel);
	}

}
