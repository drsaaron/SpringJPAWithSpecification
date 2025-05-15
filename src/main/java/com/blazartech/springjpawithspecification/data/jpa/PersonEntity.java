/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.data.jpa;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AAR1069
 */
@Entity
@Table(name = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonEntity.findAll", query = "SELECT p FROM PersonEntity p"),
    @NamedQuery(name = "PersonEntity.findByPersonId", query = "SELECT p FROM PersonEntity p WHERE p.personId = :personId"),
    @NamedQuery(name = "PersonEntity.findByName", query = "SELECT p FROM PersonEntity p WHERE p.name = :name")})
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PersonId")
    private Long personId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Name")
    protected String name;
    @JoinColumn(name = "PersonTypCde", referencedColumnName = "PersonTypCde")
    @ManyToOne(optional = false)
    private PersonTypValEntity personTypCde;

    public PersonEntity() {
    }

    public PersonEntity(Long personId) {
        this.personId = personId;
    }

    public PersonEntity(Long personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public PersonEntity(String name, PersonTypValEntity typeCode) {
        this.name = name;
        this.personTypCde = typeCode;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonTypValEntity getPersonTypCde() {
        return personTypCde;
    }

    public void setPersonTypCde(PersonTypValEntity personTypCde) {
        this.personTypCde = personTypCde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonEntity)) {
            return false;
        }
        PersonEntity other = (PersonEntity) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "personId=" + personId + ", name=" + name + ", personTypCde=" + personTypCde + '}';
    }

}
