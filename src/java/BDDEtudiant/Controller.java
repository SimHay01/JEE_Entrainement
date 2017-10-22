/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDDEtudiant;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Simon Hay
 */
@Named(value = "simonCtrl")
@ViewScoped
public class Controller implements Serializable {

    @EJB
    private EtudiantDAO eDao; 
    private Etudiant etu;  
    
    @EJB
    private PromotionDAO pDao;
    private Promotion promo;
    
    //Pour la suppression
    private List<Etudiant> selectedEtu;
    
    //Pour l'ajout : promo et filière selectionés
    private String selectedP, selectedF;

    
    public Controller() {
        this.etu = new Etudiant();
        this.promo = new Promotion();
    }

    /**
     * Fais appel à la méthode de EtudiantDAO allEtudiants() qui va faire la requête
     * @return La liste de tous les étudiants
     */
    public List<Etudiant> getEtudiants(){
        return eDao.allEtudiants();
    }
    
    public List<Promotion> getPromos(){
        return pDao.allPromos();
    }
    
    public List<Promotion> getFilieres(){
        return pDao.allFilieres();
    }    
    
    public void addEtudiant(){
        this.promo.setIdPromo(pDao.findIdPromo(getSelectedP(), getSelectedF()));
        this.etu.setIdPromo(promo);
        eDao.add(this.etu);
        this.etu = new Etudiant();
        this.promo = new Promotion();
    }

    public List<Etudiant> getSelectedEtu() {
        return selectedEtu;
    }

    public void setSelectedEtu(List<Etudiant> selectedEtu) {
        this.selectedEtu = selectedEtu;
    }
    
    public void removeEtudiant(){
        for(Etudiant e : selectedEtu){
            eDao.remove(e);
        }               
    }  

    public Etudiant getE() {
        return etu;
    }

    public void setE(Etudiant e) {
        this.etu = e;
    }

    public EtudiantDAO geteDao() {
        return eDao;
    }

    public void seteDao(EtudiantDAO eDao) {
        this.eDao = eDao;
    }
    
    

//    public Promotion getP() {
//        return promo;
//    }
//
//    public void setP(Promotion p) {
//        this.promo = p;
//    }
//
//    public PromotionDAO getpDao() {
//        return pDao;
//    }
//
//    public void setpDao(PromotionDAO pDao) {
//        this.pDao = pDao;
//    }

    public String getSelectedP() {
        return selectedP;
    }

    public void setSelectedP(String selectedP) {
        this.selectedP = selectedP;
    }

    public String getSelectedF() {
        return selectedF;
    }

    public void setSelectedF(String selectedF) {
        this.selectedF = selectedF;
    }
    
    
}
