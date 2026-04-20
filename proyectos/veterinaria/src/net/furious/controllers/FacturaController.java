package net.furious.controllers;

import java.io.*;
import net.vetfurious.excepcion.DAOExcepcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vetfurious.negocio.ICliente;
import net.vetfurious.negocio.IFactura;
import net.vetfurious.negocio.IProducto;
import net.vetfurious.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacturaController {

	@Autowired
	private IFactura Factura;
	@Autowired
	private ICliente Cliente;
	@Autowired
	private IProducto Producto;
	
	@RequestMapping(value="/listarfacturas")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<FacturaCliente> facturas = this.Factura.ListarFacturas();
				
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("facturas",facturas);
       
		String mensaje="";
		if(request.getParameter("mensaje")!=null){
			mensaje=request.getParameter("mensaje");
		}
		
		ModelAndView mav = new ModelAndView("listarfacturas");
        mav.addObject("model",myModel);
        mav.addObject("mensaje", mensaje);
        return mav;

    }
	
	@RequestMapping(value="/nuevafactura")
	public ModelAndView NuevaFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
       Factura objNewFactura=Factura.iniciarfactura();
       
       ModelAndView mav = new ModelAndView("factura");
       mav.addObject("model",objNewFactura);
       mav.addObject("accion","-1");
       return mav;
       
	   //return new ModelAndView("factura", "model", objNewFactura);
	   

    }
	
	@RequestMapping(value="/buscacliente")
	public ModelAndView BuscaCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
       
		List<Cliente> clientes = this.Cliente.listClientes();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("clientes",clientes);
		
        return new ModelAndView("buscacliente","model", myModel);

    }
	
	@RequestMapping(value="/buscaproducto")
	public ModelAndView BuscaProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
       
		List<Producto> productos = this.Producto.listarproductos();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("productos",productos);
       
        return new ModelAndView("buscaproducto","model", myModel);

    }
	
	@RequestMapping(value="/buscapaciente")
	public ModelAndView BuscaPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
       
		List<Paciente> pacientes = this.Factura.listarpacientesxcliente(Integer.parseInt(request.getParameter("idcliente")));
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("pacientes",pacientes);
       
        return new ModelAndView("buscapaciente","model", myModel);

    }
	@RequestMapping(value="/eliminarfactura")
	public ModelAndView EliminarFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
	
		Factura.ElimnarFactura(Integer.parseInt(request.getParameter("id")));
		System.out.println("eliminarfactura");
		
		ModelAndView mav = new ModelAndView("redirect:listarfacturas");
        mav.addObject("mensaje",new String ("Factura eliminada!!!"));
        return mav;

    }
	
	@RequestMapping(value="/verfactura")
	public ModelAndView VerFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
	
		System.out.println("verfactura");
		Factura objFactura=Factura.VerFactura(Integer.parseInt(request.getParameter("id")));
		
        return new ModelAndView("verfactura", "model", objFactura);
    }
	
	@RequestMapping(value="/recargafactura")
	public ModelAndView RecargaFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
	
		System.out.println("recargafactura");
		
		String accion=request.getParameter("Hiddenaccion");
		
		Factura objFactura=new Factura();
		objFactura.setCodFactura(Integer.parseInt(request.getParameter("txtfactura")));
		objFactura.setIntidCliente(Integer.parseInt(request.getParameter("hiddencliente")));
		objFactura.setCliente(request.getParameter("txtCliente"));
		objFactura.setIdPaciente(Integer.parseInt(request.getParameter("hiddenpaciente")));
		objFactura.setPaciente(request.getParameter("txtpaciente"));
		objFactura.setRuc(request.getParameter("txtruc"));
		objFactura.setFeRegistro(request.getParameter("txtfecha"));
		
		if(accion.equals("1")){
			
			Factura.GrabarFactura(objFactura);
			
			ModelAndView mav = new ModelAndView("redirect:listarfacturas");
            mav.addObject("mensaje",new String ("Factura registrada!!!"));
            return mav;
           
		}else{
				FacturaDetalle objFacturaDetalle=new FacturaDetalle();
				objFacturaDetalle.setCodFactura(Integer.parseInt(request.getParameter("txtfactura")));
				objFacturaDetalle.setCodProducto(Integer.parseInt(request.getParameter("idproducto")));
				objFacturaDetalle.setProducto(request.getParameter("nombreproducto"));
				objFacturaDetalle.setQtCantidad(Integer.parseInt(request.getParameter("txtxcantidad")));
				objFacturaDetalle.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
				
				Factura objNewFactura=Factura.RecargarFactura(objFactura,objFacturaDetalle);
				
				ModelAndView mav = new ModelAndView("factura");
			    mav.addObject("model",objNewFactura);
			    mav.addObject("accion","0");
			    return mav;
				//return new ModelAndView("factura", "model", objNewFactura);
		}
		
    }
	
	/*@RequestMapping(value="/eliminaritem")
	public ModelAndView EliminarItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
	
		Factura objFactura=new Factura();
		objFactura.setCodFactura(Integer.parseInt(request.getParameter("txtfactura")));
		objFactura.setIntidCliente(Integer.parseInt(request.getParameter("hiddencliente")));
		objFactura.setCliente(request.getParameter("txtCliente"));
		objFactura.setIdPaciente(Integer.parseInt(request.getParameter("hiddenpaciente")));
		objFactura.setPaciente(request.getParameter("txtpaciente"));
		objFactura.setRuc(request.getParameter("txtruc"));
		objFactura.setFeRegistro(request.getParameter("txtfecha"));
		
		System.out.println("eliminar item");
		
		FacturaDetalle objFacturaDetalle=new FacturaDetalle();
		objFacturaDetalle.setCodFactura(Integer.parseInt(request.getParameter("id")));
		objFacturaDetalle.setCodProducto(Integer.parseInt(request.getParameter("item")));
		
		Factura.DeleteFacturaDetalle(objFacturaDetalle);
		Factura objNewFactura=Factura.RecargarFactura2(objFactura);
		return new ModelAndView("factura", "model", objNewFactura);
    }*/
	
}
