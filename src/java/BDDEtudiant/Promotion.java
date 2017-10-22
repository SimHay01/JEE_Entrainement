/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDDEtudiant;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Simon Hay
 */
@Entity
@Table(name = "promotion")
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
    , @NamedQuery(name = "Promotion.findAllPromos", query = "SELECT DISTINCT(p.nomPromo) FROM Promotion p")
    , @NamedQuery(name = "Promotion.findAllFilieres", query = "SELECT DISTINCT(p.filiere) FROM Promotion p")
    , @NamedQuery(name = "Promotion.findIdPromo", query = "SELECT p.idPromo FROM Promotion p WHERE p.nomPromo = :nomPromo AND p.filiere = :nomFiliere")        
    , @NamedQuery(name = "Promotion.findByIdPromo", query = "SELECT p FROM Promotion p WHERE p.idPromo = :idPromo")
    , @NamedQuery(name = "Promotion.findByNomPromo", query = "SELECT p FROM Promotion p WHERE p.nomPromo = :nomPromo")
    , @NamedQuery(name = "Promotion.findByFiliere", query = "SELECT p FROM Promotion p WHERE p.filiere = :filiere")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromo;
    private String nomPromo;
    private String filiere;
    @OneToMany(mappedBy = "idPromo")
    private Collection<Etudiant> etudiantCollection;

    public Promotion() {
    }

    public Promotion(Integer idPromo) {
        this.idPromo = idPromo;
    }
    
    public Promotion(Integer idPromo, String nomPromo, String filiere){
        this.idPromo = idPromo;
        this.nomPromo = nomPromo;
        this.filiere = filiere;
    }

    public Integer getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(Integer idPromo) {
        this.idPromo = idPromo;
    }

    public String getNomPromo() {
        return nomPromo;
    }

    public void setNomPromo(String nomPromo) {
        this.nomPromo = nomPromo;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromo != null ? idPromo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idPromo == null && other.idPromo != null) || (this.idPromo != null && !this.idPromo.equals(other.idPromo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDDEtudiant.Promotion[ idPromo=" + idPromo + " ]";
    }
    
}
