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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wkoller
 */
@Entity
@Table(name = "srvc_uuid_minter_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SrvcUuidMinterType.findAll", query = "SELECT s FROM SrvcUuidMinterType s")
    , @NamedQuery(name = "SrvcUuidMinterType.findByUuidMinterTypeId", query = "SELECT s FROM SrvcUuidMinterType s WHERE s.uuidMinterTypeId = :uuidMinterTypeId")
    , @NamedQuery(name = "SrvcUuidMinterType.findByDescription", query = "SELECT s FROM SrvcUuidMinterType s WHERE s.description = :description")
    , @NamedQuery(name = "SrvcUuidMinterType.findByTimestamp", query = "SELECT s FROM SrvcUuidMinterType s WHERE s.timestamp = :timestamp")})
public class SrvcUuidMinterType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uuid_minter_type_id")
    private Long uuidMinterTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uuidMinterTypeId", fetch = FetchType.LAZY)
    private List<SrvcUuidMinter> srvcUuidMinterList;

    public SrvcUuidMinterType() {
    }

    public SrvcUuidMinterType(Long uuidMinterTypeId) {
        this.uuidMinterTypeId = uuidMinterTypeId;
    }

    public SrvcUuidMinterType(Long uuidMinterTypeId, String description, Date timestamp) {
        this.uuidMinterTypeId = uuidMinterTypeId;
        this.description = description;
        this.timestamp = timestamp;
    }

    public Long getUuidMinterTypeId() {
        return uuidMinterTypeId;
    }

    public void setUuidMinterTypeId(Long uuidMinterTypeId) {
        this.uuidMinterTypeId = uuidMinterTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @XmlTransient
    public List<SrvcUuidMinter> getSrvcUuidMinterList() {
        return srvcUuidMinterList;
    }

    public void setSrvcUuidMinterList(List<SrvcUuidMinter> srvcUuidMinterList) {
        this.srvcUuidMinterList = srvcUuidMinterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuidMinterTypeId != null ? uuidMinterTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrvcUuidMinterType)) {
            return false;
        }
        SrvcUuidMinterType other = (SrvcUuidMinterType) object;
        if ((this.uuidMinterTypeId == null && other.uuidMinterTypeId != null) || (this.uuidMinterTypeId != null && !this.uuidMinterTypeId.equals(other.uuidMinterTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jacq.common.model.jpa.SrvcUuidMinterType[ uuidMinterTypeId=" + uuidMinterTypeId + " ]";
    }

}
