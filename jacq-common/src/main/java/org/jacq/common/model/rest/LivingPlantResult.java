/*
 * Copyright 2017 wkoller.
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

import org.jacq.common.model.BotanicalObjectDerivative;
import org.jacq.common.model.jpa.TblLivingPlant;

/**
 * Model for transfering living plant details over REST interface
 *
 * @author wkoller
 */
public class LivingPlantResult extends BotanicalObjectDerivative {

    protected Long scientificNameId;

    public LivingPlantResult() {
    }

    public LivingPlantResult(TblLivingPlant tblLivingPlant) {
        // BotanicalObjectDerivative properties
        this.setType(BotanicalObjectDerivative.LIVING);
        this.setDerivativeId(tblLivingPlant.getTblDerivative().getDerivativeId());
        this.setBotanicalObjectId(tblLivingPlant.getTblDerivative().getBotanicalObjectId().getId());
        this.setScientificName(tblLivingPlant.getTblDerivative().getBotanicalObjectId().getViewScientificName().getScientificName());
        this.setAccessionNumber(String.format("%07d", tblLivingPlant.getAccessionNumber()));
        this.setLabelAnnotation(tblLivingPlant.getLabelAnnotation());
        this.setOrganisationDescription(tblLivingPlant.getTblDerivative().getOrganisationId().getDescription());
        this.setPlaceNumber(tblLivingPlant.getPlaceNumber());
        this.setDerivativeCount(tblLivingPlant.getTblDerivative().getCount());

        // new properties
        this.setScientificNameId(tblLivingPlant.getTblDerivative().getBotanicalObjectId().getScientificNameId());
    }

    public Long getScientificNameId() {
        return scientificNameId;
    }

    public void setScientificNameId(Long scientificNameId) {
        this.scientificNameId = scientificNameId;
    }
}
