/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lenovo
 */
@Entity
public class Emprunt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date_emprunt;
    private String date_retour;
    private String date_prevu;
    private String etat;
    
    @ManyToOne
    private Exemplaire exemlaire;

    
    @ManyToOne
    private Etudiant etudiant;

    public Exemplaire getExemlaire() {
        return exemlaire;
    }

    public void setExemlaire(Exemplaire exemlaire) {
        this.exemlaire = exemlaire;
    }

    private static final long serialVersionUID = 1L;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(String date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    public String getDate_prevu() {
        return date_prevu;
    }

    public void setDate_prevu(String date_prevu) {
        this.date_prevu = date_prevu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "beans.Emprunt[ id=" + id + " ]";
    }

}
