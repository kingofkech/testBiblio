/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Auteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karim
 */
@Stateless
public class AuteurFacade extends AbstractFacade<Auteur> {

    @PersistenceContext(unitName = "ProjetBiblioth_quePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuteurFacade() {
        super(Auteur.class);
    }

    public Auteur findByName(String nom) {

        List<Auteur> auteurs = em.createQuery("select A from Auteur A where A.nom=:nom").setParameter("nom", nom).getResultList();
        if (auteurs.isEmpty()) {
            return null;
        }
        return auteurs.get(0);
    }
}
