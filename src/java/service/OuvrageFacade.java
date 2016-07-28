/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Auteur;
import bean.Ouvrage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karim
 */
@Stateless
public class OuvrageFacade extends AbstractFacade<Ouvrage> {

    @EJB
    AuteurFacade AuteurFacade;
    @PersistenceContext(unitName = "ProjetBiblioth_quePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OuvrageFacade() {
        super(Ouvrage.class);
    }

    public List<Ouvrage> findByAuteur(String nom) {
        Auteur auteur = AuteurFacade.findByName(nom);
        if (auteur != null) {
            List<Ouvrage> ouvrages = em.createQuery("select O from Ouvrage O where O.auteur=:id")
                    .setParameter("id", auteur.getId()).getResultList();
            return ouvrages;
        }
        return null;
    }

//    public ArrayList<Ouvrage> findByNom(String nom) {
//
//    }
//
//    public ArrayList<Ouvrage> findByTheme(String nom) {
//
//    }
}
