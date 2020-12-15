/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.HibernateCore;
import Entity.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author diego
 */
public class UsuarioDATA {

    public Usuario findById(Integer codigo) {

        Usuario u = new Usuario();

        u.setCodigo(codigo);

        EntityManager em = new Conn().getConnection();

        try {

            return em.find(u.getClass(), u.getCodigo());

        } catch (Exception e) {
            System.err.println(e);
            u.setCodigo(0);
            return u;
        } finally {
            em.close();
        }
    }

    public Usuario inserir(Usuario u) {
        if (u == null) {
            return null;
        }

        EntityManager em = new Conn().getConnection();

        try {

            em.getTransaction().begin();
            if (u.getCodigo() == 0) {
                em.persist(u);
            } else {
                em.merge(u);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return u;
    }
}
