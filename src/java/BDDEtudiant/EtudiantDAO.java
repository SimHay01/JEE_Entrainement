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
public class EtudiantDAO {
    
    @PersistenceContext(unitName = "GestionBDD_deux_tablesPU")
    private EntityManager em;
    
    /**
     * Fais appel à la requête nommée de Etudiant
     * @return La liste de tous les étudiants
     */
    public List<Etudiant> allEtudiants(){
        Query query = em.createNamedQuery("Etudiant.findAll");
        return query.getResultList();
    }
    
    public void add(Etudiant e){
        em.persist(e);
        em.flush();
    }
    
    public void remove (Etudiant etu) {
        em.remove(em.merge(etu));
        //em.remove(etu); NE MARCHE PAS
        em.flush();
    }    
}
