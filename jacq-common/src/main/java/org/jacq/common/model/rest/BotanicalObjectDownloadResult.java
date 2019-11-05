/*
 * Copyright 2018 fhafner.
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
package org.jacq.common.model.rest;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.jacq.common.model.jpa.TblDerivative;
import org.apache.commons.lang3.StringUtils;
import org.jacq.common.model.jpa.TblClassification;
import org.jacq.common.model.jpa.TblPerson;
import org.jacq.common.model.jpa.TblScientificNameInformation;
import org.jacq.common.model.jpa.ViewProtolog;
import org.jacq.common.model.jpa.custom.BotanicalObjectDerivative;

/**
 *
 * @author fhafner
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BotanicalObjectDownloadResult extends BotanicalObjectDerivative {

    protected String habitat;
    protected String altitudeMin;
    protected String altitudeMax;
    protected String latitude;
    protected String longitude;
    protected String acquisitionDate;
    protected String gatheringNumber;
    protected String ipenNumber;
    protected String family;
    protected String person;
    protected String scientificNameNoAuthor;
    protected String spatialDistribution;
    protected String commonNames;
    protected String labelSynonymScientificName;
    protected String aquesitionLocation;
    protected String scientificNameAuthor;
    protected String familyAuthor;
    protected String familyNoAuthor;
    protected String familyReference;
    protected String indexSeminumType;
    protected long count;
    protected float price;

    public BotanicalObjectDownloadResult() {
    }

    public BotanicalObjectDownloadResult(BotanicalObjectDerivative botanicalObjectDerivative, TblDerivative derivative, TblClassification classificationFamily, ViewProtolog protolog, TblScientificNameInformation tblScientificNameInformation) {
        // BotanicalObjectDerivative properties
        this.setType(botanicalObjectDerivative.getType());
        this.setDerivativeId(botanicalObjectDerivative.getDerivativeId());
        this.setBotanicalObjectId(botanicalObjectDerivative.getBotanicalObjectId());
        this.setScientificName(botanicalObjectDerivative.getScientificName());
        this.setAccessionNumber(botanicalObjectDerivative.getAccessionNumber());
        this.setLabelAnnotation(botanicalObjectDerivative.getLabelAnnotation());
        this.setOrganisationDescription(botanicalObjectDerivative.getOrganisationDescription());
        this.setPlaceNumber(botanicalObjectDerivative.getPlaceNumber());
        this.setDerivativeCount(botanicalObjectDerivative.getDerivativeCount());
        this.setSeparated(botanicalObjectDerivative.getSeparated());
        this.setScientificNameId(botanicalObjectDerivative.getScientificNameId());
        super.setCultivarName(botanicalObjectDerivative.getCultivarName());

        if (classificationFamily != null && classificationFamily.getViewScientificName() != null) {
            this.setFamily(classificationFamily.getViewScientificName().getScientificName() != null ? classificationFamily.getViewScientificName().getScientificName() : null);
            this.setFamilyAuthor(classificationFamily.getViewScientificName().getScientificNameAuthor() != null ? classificationFamily.getViewScientificName().getScientificNameAuthor() : null);
            this.setFamilyNoAuthor(classificationFamily.getViewScientificName().getScientificNameNoAuthor() != null ? classificationFamily.getViewScientificName().getScientificNameNoAuthor() : null);
        }

        if (protolog != null) {
            this.setFamilyReference(protolog.getProtolog() != null ? protolog.getProtolog() : null);
        }

        if (derivative.getBotanicalObjectId().getViewScientificName() != null) {
            // ScientificNameNoAuthor
            this.setScientificNameNoAuthor(derivative.getBotanicalObjectId().getViewScientificName().getScientificNameNoAuthor() != null ? derivative.getBotanicalObjectId().getViewScientificName().getScientificNameNoAuthor() : null);
            // ScientificNameAuthor
            this.setScientificNameAuthor(derivative.getBotanicalObjectId().getViewScientificName().getScientificNameAuthor() != null ? derivative.getBotanicalObjectId().getViewScientificName().getScientificNameAuthor() : null);
        }
        if (derivative.getBotanicalObjectId().getAcquisitionEventId() != null) {
            // acquisition_Location
            this.setAquesitionLocation(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationId() != null ? derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationId().getLocation() : null);
            // acqustition_number
            this.setGatheringNumber(derivative.getBotanicalObjectId().getAcquisitionEventId().getNumber() != null ? String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getNumber()) : null);
            // acquisition_date
            if (!StringUtils.isEmpty(derivative.getBotanicalObjectId().getAcquisitionEventId().getAcquisitionDateId().getCustom())) {
                this.setAcquisitionDate(derivative.getBotanicalObjectId().getAcquisitionEventId().getAcquisitionDateId().getCustom());
            } else {
                this.setAcquisitionDate(derivative.getBotanicalObjectId().getAcquisitionEventId().getAcquisitionDateId().getDay() + "." + derivative.getBotanicalObjectId().getAcquisitionEventId().getAcquisitionDateId().getMonth() + "." + derivative.getBotanicalObjectId().getAcquisitionEventId().getAcquisitionDateId().getYear());
            }
            if (derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId() != null) {
                // altitude_min
                this.setAltitudeMin(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getAltitudeMin() != null ? derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getAltitudeMin().toString() : null);
                // altitude_max
                this.setAltitudeMax(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getAltitudeMax() != null ? derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getAltitudeMax().toString() : null);
                // latitude
                if (derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLatitudeDegrees() != null && derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLatitudeMinutes() != null && derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLatitudeSeconds() != null) {
                    this.setLatitude(String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLatitudeDegrees()) + "." + String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLatitudeMinutes()) + "." + String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLatitudeSeconds()));
                }
                // longitude
                if (derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLongitudeDegrees() != null && derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLongitudeMinutes() != null && derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLongitudeSeconds() != null) {
                    this.setLongitude(String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLongitudeDegrees()) + "." + String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLongitudeMinutes()) + "." + String.valueOf(derivative.getBotanicalObjectId().getAcquisitionEventId().getLocationCoordinatesId().getLongitudeSeconds()));
                }

            }
        }
        if (derivative.getTblLivingPlant() != null) {
            // accession_number
            this.setAccessionNumber(String.format("%07d", derivative.getTblLivingPlant().getAccessionNumber()));
            // ipen_number
            this.setIpenNumber((derivative.getTblLivingPlant().getIpenNumber() != null ? derivative.getTblLivingPlant().getIpenNumber().toString() : "") + "-" + ("0000000" + String.valueOf(derivative.getTblLivingPlant().getAccessionNumber())).substring(String.valueOf(derivative.getTblLivingPlant().getAccessionNumber()).length()));
            //label synonym scientific name
            if (derivative.getTblLivingPlant().getViewLabelSynonymScientificName() != null) {
                this.setLabelSynonymScientificName(derivative.getTblLivingPlant().getViewLabelSynonymScientificName().getScientificName() != null ? derivative.getTblLivingPlant().getViewLabelSynonymScientificName().getScientificName() : null);
            }
            if (derivative.getTblLivingPlant().getIndexSeminumTypeId() != null) {
                this.setIndexSeminumType(derivative.getTblLivingPlant().getIndexSeminumTypeId().getType());
            }
        }
        if (tblScientificNameInformation != null) {
            // spatialDistribution;
            this.setSpatialDistribution(tblScientificNameInformation.getSpatialDistribution() != null ? tblScientificNameInformation.getSpatialDistribution() : null);
            // commonNames;
            this.setCommonNames(tblScientificNameInformation.getCommonNames() != null ? tblScientificNameInformation.getCommonNames() : null);
        }
        // habitat
        this.setHabitat(derivative.getBotanicalObjectId().getHabitat() != null ? derivative.getBotanicalObjectId().getHabitat() : null);

        // Load all Person to Acquisition Event
        List<TblPerson> tblPersonList = derivative.getBotanicalObjectId().getAcquisitionEventId().getTblPersonList();
        for (TblPerson person : tblPersonList) {
            this.setPerson(this.getPerson() != null ? this.getPerson() : "" + person.getName() + ",");
        }
        if (this.getPerson() != null) {
            this.setPerson(this.getPerson().replaceAll(", $", ""));
        }

        // count & price
        this.setCount(derivative.getCount());
        this.setPrice(derivative.getPrice());
    }

    public String getFamilyReference() {
        return familyReference;
    }

    public void setFamilyReference(String familyReference) {
        this.familyReference = familyReference;
    }

    public String getFamilyNoAuthor() {
        return familyNoAuthor;
    }

    public void setFamilyNoAuthor(String familyNoAuthor) {
        this.familyNoAuthor = familyNoAuthor;
    }

    public String getFamilyAuthor() {
        return familyAuthor;
    }

    public void setFamilyAuthor(String familyAuthor) {
        this.familyAuthor = familyAuthor;
    }

    public String getScientificNameAuthor() {
        return scientificNameAuthor;
    }

    public void setScientificNameAuthor(String scientificNameAuthor) {
        this.scientificNameAuthor = scientificNameAuthor;
    }

    public String getGatheringNumber() {
        return gatheringNumber;
    }

    public void setGatheringNumber(String gatheringNumber) {
        this.gatheringNumber = gatheringNumber;
    }

    public String getAquesitionLocation() {
        return aquesitionLocation;
    }

    public void setAquesitionLocation(String aquesitionLocation) {
        this.aquesitionLocation = aquesitionLocation;
    }

    public String getLabelSynonymScientificName() {
        return labelSynonymScientificName;
    }

    public void setLabelSynonymScientificName(String labelSynonymScientificName) {
        this.labelSynonymScientificName = labelSynonymScientificName;
    }

    public String getSpatialDistribution() {
        return spatialDistribution;
    }

    public void setSpatialDistribution(String spatialDistribution) {
        this.spatialDistribution = spatialDistribution;
    }

    public String getCommonNames() {
        return commonNames;
    }

    public void setCommonNames(String commonNames) {
        this.commonNames = commonNames;
    }

    public String getScientificNameNoAuthor() {
        return scientificNameNoAuthor;
    }

    public void setScientificNameNoAuthor(String scientificNameNoAuthor) {
        this.scientificNameNoAuthor = scientificNameNoAuthor;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAltitudeMin() {
        return altitudeMin;
    }

    public void setAltitudeMin(String altitudeMin) {
        this.altitudeMin = altitudeMin;
    }

    public String getAltitudeMax() {
        return altitudeMax;
    }

    public void setAltitudeMax(String altitudeMax) {
        this.altitudeMax = altitudeMax;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getIpenNumber() {
        return ipenNumber;
    }

    public void setIpenNumber(String ipenNumber) {
        this.ipenNumber = ipenNumber;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getIndexSeminumType() {
        return indexSeminumType;
    }

    public void setIndexSeminumType(String indexSeminumType) {
        this.indexSeminumType = indexSeminumType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
