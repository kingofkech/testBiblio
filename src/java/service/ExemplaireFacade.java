/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Exemplaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karim
 */
@Stateless
public class ExemplaireFacade extends AbstractFacade<Exemplaire> {
    @PersistenceContext(unitName = "ProjetBiblioth_quePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExemplaireFacade() {
        super(Exemplaire.class);
    }
    
}
