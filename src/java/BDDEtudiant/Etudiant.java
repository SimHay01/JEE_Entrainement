/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDDEtudiant;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Simon Hay
 */
@Entity
@Table(name = "etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e")
    , @NamedQuery(name = "Etudiant.findByIdE", query = "SELECT e FROM Etudiant e WHERE e.idE = :idE")
    , @NamedQuery(name = "Etudiant.findByNomE", query = "SELECT e FROM Etudiant e WHERE e.nomE = :nomE")
    , @NamedQuery(name = "Etudiant.findByPrenomE", query = "SELECT e FROM Etudiant e WHERE e.prenomE = :prenomE")
    , @NamedQuery(name = "Etudiant.findByAgeE", query = "SELECT e FROM Etudiant e WHERE e.ageE = :ageE")})

public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idE;
    private String nomE;
    private String prenomE;
    private Integer ageE;
    @JoinColumn(name = "idPromo", referencedColumnName = "idPromo")
    @ManyToOne
    private Promotion idPromo;

    public Etudiant() {
    }
    
    public Etudiant(Integer id) {
        this.idE = id;
    }
    
    public Etudiant(Integer idE, String nomE, String prenomE, Integer ageE, Promotion idPromo) {
        this.idE = idE;
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.ageE = ageE;
        this.idPromo = idPromo;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public Integer getAgeE() {
        return ageE;
    }

    public void setAgeE(Integer ageE) {
        this.ageE = ageE;
    }

    public Promotion getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(Promotion idPromo) {
        this.idPromo = idPromo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idE != null ? idE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idE == null && other.idE != null) || (this.idE != null && !this.idE.equals(other.idE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDDEtudiant.Etudiant[ idE=" + idE + " ]";
    }
    
}
