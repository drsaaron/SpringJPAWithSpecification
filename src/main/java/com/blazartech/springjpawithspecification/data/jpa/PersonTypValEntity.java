/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.data.jpa;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AAR1069
 */
@Entity
@Table(name = "PersonTypVal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonTypValEntity.findAll", query = "SELECT p FROM PersonTypValEntity p"),
    @NamedQuery(name = "PersonTypValEntity.findByPersonTypCde", query = "SELECT p FROM PersonTypValEntity p WHERE p.personTypCde = :personTypCde"),
    @NamedQuery(name = "PersonTypValEntity.findByPersonTypTxt", query = "SELECT p FROM PersonTypValEntity p WHERE p.personTypTxt = :personTypTxt")})
public class PersonTypValEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonTypCde")
    private Short personTypCde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PersonTypTxt")
    private String personTypTxt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personTypCde")
    private Collection<PersonEntity> personEntityCollection;

    public PersonTypValEntity() {
    }

    public PersonTypValEntity(Short personTypCde) {
        this.personTypCde = personTypCde;
    }

    public PersonTypValEntity(Short personTypCde, String personTypTxt) {
        this.personTypCde = personTypCde;
        this.personTypTxt = personTypTxt;
    }

    public Short getPersonTypCde() {
        return personTypCde;
    }

    public void setPersonTypCde(Short personTypCde) {
        this.personTypCde = personTypCde;
    }

    public String getPersonTypTxt() {
        return personTypTxt;
    }

    public void setPersonTypTxt(String personTypTxt) {
        this.personTypTxt = personTypTxt;
    }

    @XmlTransient
    public Collection<PersonEntity> getPersonEntityCollection() {
        return personEntityCollection;
    }

    public void setPersonEntityCollection(Collection<PersonEntity> personEntityCollection) {
        this.personEntityCollection = personEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personTypCde != null ? personTypCde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonTypValEntity)) {
            return false;
        }
        PersonTypValEntity other = (PersonTypValEntity) object;
        if ((this.personTypCde == null && other.personTypCde != null) || (this.personTypCde != null && !this.personTypCde.equals(other.personTypCde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonTypValEntity{" + "personTypCde=" + personTypCde + ", personTypTxt=" + personTypTxt + "}";
    }

   
    
}
