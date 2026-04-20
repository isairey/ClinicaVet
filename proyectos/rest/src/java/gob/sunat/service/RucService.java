package gob.sunat.service;

import gob.sunat.pojo.Ruc;
import gob.sunat.model.RucModel;

/**
 *
 * @author cesar
 */
public class RucService {

    public Ruc getRucByRuc(String ruc) {
        Ruc rucObj = null;
        RucModel model = new RucModel();
        rucObj = model.getRucByRuc(ruc);
        if(rucObj == null)
        {
            rucObj = new Ruc("","","");
            rucObj.setIdRuc(0);
        }
        return rucObj;
    }
    
    public Ruc getRucByIdRuc(int ruc) {
        Ruc rucObj = null;
        RucModel model = new RucModel();
        rucObj = model.getRucByIdRuc(ruc);
        return rucObj;
    }
    public Ruc addRuc(String ruc, String nombre, String dni) {
        Ruc rucObj = new Ruc();
        rucObj.setRuc(ruc);
        rucObj.setNombre(nombre);        
        rucObj.setDni(dni);
        
        RucModel model = new RucModel();
        rucObj = model.addRuc(rucObj);
        return rucObj;
    }
    
    public Ruc editRuc(String idRuc,String ruc, String nombre, String dni) {
       
        int idRucInt = Integer.parseInt(idRuc);
         System.out.println(" rucObj id 1 edit in service => " + idRucInt);
        RucModel model = new RucModel();
        Ruc rucObj = model.getRucByIdRuc(idRucInt);         
        //rucObj.setRuc(ruc);
        rucObj.setNombre(nombre);
        rucObj.setDni(dni);
        System.out.println(" rucObj id 2 edit in service => " + rucObj);
        rucObj = model.update(rucObj);
        return rucObj;
    }
    
    public boolean deleteRuc(String idRuc) {
       
        int idRucInt = Integer.parseInt(idRuc);
        RucModel model = new RucModel();
        return model.deleteByIdRuc(idRucInt);
         
    }
}
