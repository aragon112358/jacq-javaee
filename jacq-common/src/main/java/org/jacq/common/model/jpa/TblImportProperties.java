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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wkoller
 */
@Entity
@Table(name = "tbl_import_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblImportProperties.findAll", query = "SELECT t FROM TblImportProperties t")
    , @NamedQuery(name = "TblImportProperties.findById", query = "SELECT t FROM TblImportProperties t WHERE t.id = :id")
    , @NamedQuery(name = "TblImportProperties.findByIDPflanze", query = "SELECT t FROM TblImportProperties t WHERE t.iDPflanze = :iDPflanze")
    , @NamedQuery(name = "TblImportProperties.findBySpeciesName", query = "SELECT t FROM TblImportProperties t WHERE t.speciesName = :speciesName")
    , @NamedQuery(name = "TblImportProperties.findBySourceName", query = "SELECT t FROM TblImportProperties t WHERE t.sourceName = :sourceName")
    , @NamedQuery(name = "TblImportProperties.findByOriginalBotanicalObjectId", query = "SELECT t FROM TblImportProperties t WHERE t.originalBotanicalObjectId = :originalBotanicalObjectId")})
public class TblImportProperties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "IDPflanze")
    private Long iDPflanze;
    @Size(max = 255)
    @Column(name = "species_name")
    private String speciesName;
    @Lob
    @Size(max = 65535)
    @Column(name = "Verbreitung")
    private String verbreitung;
    @Size(max = 45)
    @Column(name = "source_name")
    private String sourceName;
    @Column(name = "original_botanical_object_id")
    private Long originalBotanicalObjectId;
    @JoinColumn(name = "derivative_id", referencedColumnName = "derivative_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private TblDerivative derivativeId;

    public TblImportProperties() {
    }

    public TblImportProperties(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIDPflanze() {
        return iDPflanze;
    }

    public void setIDPflanze(Long iDPflanze) {
        this.iDPflanze = iDPflanze;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getVerbreitung() {
        return verbreitung;
    }

    public void setVerbreitung(String verbreitung) {
        this.verbreitung = verbreitung;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Long getOriginalBotanicalObjectId() {
        return originalBotanicalObjectId;
    }

    public void setOriginalBotanicalObjectId(Long originalBotanicalObjectId) {
        this.originalBotanicalObjectId = originalBotanicalObjectId;
    }

    public TblDerivative getDerivativeId() {
        return derivativeId;
    }

    public void setDerivativeId(TblDerivative derivativeId) {
        this.derivativeId = derivativeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblImportProperties)) {
            return false;
        }
        TblImportProperties other = (TblImportProperties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jacq.common.model.jpa.TblImportProperties[ id=" + id + " ]";
    }

}
