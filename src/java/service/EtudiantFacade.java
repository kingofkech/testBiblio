/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Etudiant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Karim
 */
@Stateless
public class EtudiantFacade extends AbstractFacade<Etudiant> {

    @PersistenceContext(unitName = "ProjetBiblioth_quePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtudiantFacade() {
        super(Etudiant.class);
    }

    public int addEtudiant(Etudiant etudiant) {
        int res = 0;
        List<Long> counts = em.createQuery("select count(E) from Etudiant E where E.email='"+etudiant.getEmail()+"'").getResultList();
        if (counts==null || counts.isEmpty()) {
            create(etudiant);
            res = 1;

        } else {
            res = -1;//email déja existant
        }
        return res;
    }

    public int modifierEtudiant(Etudiant etudiant) {
        int res = 0;
        List<Etudiant> etudiants = em.createQuery("select E from Etudiant E where E.email=:email")
                .setParameter("email", etudiant.getEmail()).getResultList();
        if (!etudiants.isEmpty()) {//size=1
            edit(etudiants.get(0));
            res = 1;
        } else {
            res = -1;//etudiant non existant
        }
        return res;
    }


}
