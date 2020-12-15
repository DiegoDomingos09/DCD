/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import javax.persistence.EntityManager;

/**
 *
 * @author diego
 */
public class HibernateCore {
    
    public Object inserir(Object obj){
        if(obj == null) return null;
        
        EntityManager em = new Conn().getConnection();
        
        try{
            /*
            em.getTransaction().begin();
            if(obj.getCodigo() == null){
                em.persist(obj);
            }else{
                em.merge(obj);
            }
            */
            em.getTransaction().commit();
            
        }catch(Exception e){
            System.err.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return obj;
    }
    
    /*public <T> findBy(Class<T> t){
        
        EntityManager em = new Conn().getConnection();
        
        try {
            
            //return em.find(<t>.class, t.codigo);
            
        } catch (Exception e) {
            System.err.println(e);
            //return null;
        }finally{
            em.close();
        }
    }*/
}
