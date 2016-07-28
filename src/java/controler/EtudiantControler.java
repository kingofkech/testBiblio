/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.Etudiant;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.EtudiantFacade;

/**
 *
 * @author Karim
 */
@ManagedBean(name = "etudiantControler")
@SessionScoped
public class EtudiantControler {

    @EJB
    private EtudiantFacade etudiantFacade;
    private ArrayList<Etudiant> etudiants;
    private Etudiant etudiant;

    public EtudiantFacade getEtudiantFacade() {
        return etudiantFacade;
    }

    public void setEtudiantFacade(EtudiantFacade etudiantFacade) {
        this.etudiantFacade = etudiantFacade;
    }

    public ArrayList<Etudiant> getEtudiants() {
        if (etudiants == null) {
            this.etudiants = new ArrayList<>();
        }
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant getEtudiant() {
        if (etudiant == null) {
            this.etudiant = new Etudiant();
        }
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    /**
     * Creates a new instance of EtudiantControler
     */
    public EtudiantControler() {
    }

    public void addEtudiant() {
        etudiantFacade.addEtudiant(etudiant);
    }
}
