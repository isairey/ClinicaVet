package gob.sunat.rest;

import gob.sunat.pojo.Ruc;
import gob.sunat.service.RucService;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/rucrest")
@Consumes({"application/json"})
@Produces({"application/json"})
public class RucRest {
    private static final Logger log = Logger.getLogger(RucRest.class.getName());
    
    @GET
    @Path("get/{ruc}")
    public Ruc getRuc(@PathParam("ruc") String ruc){
        Ruc rucObj = new Ruc("","","");
        RucService rucService = new RucService();
        log.info("getRuc: " + ruc);
        rucObj = rucService.getRucByRuc(ruc);
        
        return rucObj;
    }
    
    @GET
    @Path("get2/{ruc}")
    public String getRuc2(@PathParam("ruc") String ruc){
        Ruc rucObj = new Ruc("","","");
        
        RucService rucService = new RucService();
        log.info("getRuc: " + ruc);
        rucObj = rucService.getRucByRuc(ruc);
        String rspsta = "";
        rspsta = "myCallBack({"
                + "\"idRuc\":\"" + rucObj.getIdRuc()+ "\", "
                + "\"ruc\":\"" + rucObj.getRuc() + "\", "
                + "\"nombre\":\"" + rucObj.getNombre()+ "\", "
                + "\"dni\":\"" + rucObj.getDni()+ "\" "                
                + "})";
        
        return rspsta;
    }
    
    @GET
    @Path("getfirst")
    public Ruc getRucFirst(){
        Ruc rucObj = null;
        RucService rucService = new RucService();
        
        rucObj = rucService.getRucByRuc("aaaaaaa");
        
        return rucObj;
    }
}
