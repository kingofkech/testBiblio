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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lenovo
 */
@Entity
public class Exemplaire implements Serializable {

    @OneToMany(mappedBy = "exemlaire")
    private List<Emprunt> emprunts;

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @ManyToOne
    private Ouvrage ouvrage;

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   
    
    
    
    
  

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

   

    

   
    

  
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    

    

    @Override
    public String toString() {
        return "beans.Exemlaire[ id=" + id + " ]";
    }
    
}
