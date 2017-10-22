/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDDEtudiant;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Simon Hay
 */
@Stateless
public class PromotionDAO {
        
    @PersistenceContext(unitName = "GestionBDD_deux_tablesPU")
    private EntityManager em;
    
    public List<Promotion> allPromos(){
        Query query = em.createNamedQuery("Promotion.findAllPromos");
        return query.getResultList();
    }
    
    public List<Promotion> allFilieres(){
        Query query = em.createNamedQuery("Promotion.findAllFilieres");
        return query.getResultList();
    }

    public Integer findIdPromo(String nomPromo, String filiere){
        Query query = em.createQuery(
            "SELECT p.idPromo FROM Promotion p WHERE p.nomPromo = :nomPromo AND p.filiere = :nomFiliere")
                .setParameter("nomPromo", nomPromo)
                .setParameter("nomFiliere", filiere);
        return (Integer) query.getSingleResult();
        
        //Query query = em.createNamedQuery("Promotion.findIdPromo");
        //return (Promotion) query.setParameter("nomPromo", nomPromo);
    }

}
