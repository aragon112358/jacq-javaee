/*
 * Copyright 2019 wkoller.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jacq.common.model.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wkoller
 */
@Entity
@Table(name = "tbl_specimen_old")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSpecimenOld.findAll", query = "SELECT t FROM TblSpecimenOld t")
    , @NamedQuery(name = "TblSpecimenOld.findBySpecimenId", query = "SELECT t FROM TblSpecimenOld t WHERE t.specimenId = :specimenId")
    , @NamedQuery(name = "TblSpecimenOld.findByHerbarNumber", query = "SELECT t FROM TblSpecimenOld t WHERE t.herbarNumber = :herbarNumber")
    , @NamedQuery(name = "TblSpecimenOld.findByTimestamp", query = "SELECT t FROM TblSpecimenOld t WHERE t.timestamp = :timestamp")})
public class TblSpecimenOld implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "specimen_id")
    private Long specimenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "herbar_number")
    private String herbarNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "botanical_object_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblBotanicalObject botanicalObjectId;

    public TblSpecimenOld() {
    }

    public TblSpecimenOld(Long specimenId) {
        this.specimenId = specimenId;
    }

    public TblSpecimenOld(Long specimenId, String herbarNumber, Date timestamp) {
        this.specimenId = specimenId;
        this.herbarNumber = herbarNumber;
        this.timestamp = timestamp;
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public String getHerbarNumber() {
        return herbarNumber;
    }

    public void setHerbarNumber(String herbarNumber) {
        this.herbarNumber = herbarNumber;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public TblBotanicalObject getBotanicalObjectId() {
        return botanicalObjectId;
    }

    public void setBotanicalObjectId(TblBotanicalObject botanicalObjectId) {
        this.botanicalObjectId = botanicalObjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenId != null ? specimenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSpecimenOld)) {
            return false;
        }
        TblSpecimenOld other = (TblSpecimenOld) object;
        if ((this.specimenId == null && other.specimenId != null) || (this.specimenId != null && !this.specimenId.equals(other.specimenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jacq.common.model.jpa.TblSpecimenOld[ specimenId=" + specimenId + " ]";
    }

}
