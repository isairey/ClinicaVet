package gob.sunat.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import gob.sunat.pojo.Ruc;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cesar
 */
public class RucModel {

    Session session = null;

    public RucModel() {
        this.session = HibernateUtil.getSessionFactory().openSession();
        
    }

    public gob.sunat.pojo.Ruc getRucByRuc(String ruc) {
        gob.sunat.pojo.Ruc rucObj = null;
        try {

            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(gob.sunat.pojo.Ruc.class)
                    .add(Restrictions.eq("ruc", ruc));
            rucObj = (gob.sunat.pojo.Ruc) criteria.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rucObj;
    }

    public gob.sunat.pojo.Ruc getRucByIdRuc(int idRuc) {
        gob.sunat.pojo.Ruc rucObj = null;
        try {

            Transaction tx = session.beginTransaction();
            rucObj = (Ruc) this.session.load(Ruc.class, idRuc);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rucObj;
    }

    public gob.sunat.pojo.Ruc addRuc(Ruc rucObj) {
        try {

            Transaction tx = session.beginTransaction();
            this.session.save( rucObj);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rucObj;
    }
    
    public gob.sunat.pojo.Ruc update(Ruc rucObj) {
        try {
            Transaction tx = session.beginTransaction();
            this.session.update(rucObj);            
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rucObj;
    }

    public boolean deleteByIdRuc(int idRucInt) {
        boolean borrado = false;

        Ruc rucObj = this.getRucByIdRuc(idRucInt);

        if (rucObj != null) {
             Transaction tx = session.beginTransaction();
            this.session.delete(rucObj);
            tx.commit();
          
            borrado = true;
        }

        return borrado;
    }
    
    protected void checkSession(){
        if(this.session == null){
            
        }
    }
            
}
