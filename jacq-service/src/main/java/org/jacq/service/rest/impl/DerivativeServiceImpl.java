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
package org.jacq.service.rest.impl;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.jacq.service.manager.DerivativeManager;
import org.jacq.common.model.jpa.custom.BotanicalObjectDerivative;
import org.jacq.common.model.rest.BotanicalObjectDownloadResult;
import org.jacq.common.model.rest.IdentStatusResult;
import org.jacq.common.model.rest.OrderDirection;
import org.jacq.common.model.rest.PhenologyResult;
import org.jacq.common.model.rest.RelevancyTypeResult;
import org.jacq.common.rest.DerivativeService;

/**
 * Implementation of derivative service
 *
 * @see DerivativeService
 * @author wkoller
 */
@ManagedBean
public class DerivativeServiceImpl implements DerivativeService {

    @Inject
    protected DerivativeManager derivativeManager;

    /**
     * @see DerivativeService#find(java.lang.String, java.lang.Long,
     * java.lang.String, org.jacq.common.model.rest.OrderDirection,
     * java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<BotanicalObjectDerivative> find(String type, Long derivativeId, String placeNumber, String accessionNumber, Boolean separated, Long scientificNameId, Long organisationId, Boolean hierarchic, String orderColumn, OrderDirection orderDirection, Integer offset, Integer count) {
        return derivativeManager.find(type, derivativeId, placeNumber, accessionNumber, separated, scientificNameId, organisationId, hierarchic, orderColumn, orderDirection, offset, count);
    }

    /**
     * @see DerivativeService#count(java.lang.String, java.lang.Long)
     */
    @Override
    public int count(String type, Long derivativeId, String placeNumber, String accessionNumber, Boolean separated, Long scientificNameId, Long organisationId, Boolean hierarchic) {
        return derivativeManager.count(type, derivativeId, placeNumber, accessionNumber, separated, scientificNameId, organisationId, hierarchic);
    }

    /**
     * @see DerivativeService#load(java.lang.Long, java.lang.String)
     */
    @Override
    public Response load(Long derivativeId, String type) {
        return Response.ok().entity(derivativeManager.load(derivativeId, type)).build();
    }

    @Override
    public List<BotanicalObjectDownloadResult> downloadFind(String type, Long derivativeId, String placeNumber, String accessionNumber, Boolean separated, Long scientificNameId, Long organisationId, Boolean hierarchic, String orderColumn, OrderDirection orderDirection, Integer offset, Integer count) {
        return derivativeManager.downloadFind(type, derivativeId, placeNumber, accessionNumber, separated, scientificNameId, organisationId, hierarchic, orderColumn, orderDirection, offset, count);
    }

    /**
     * @see DerivativeService#findAllPhenology()
     */
    @Override
    public List<PhenologyResult> findAllPhenology() {
        return derivativeManager.findAllPhenology();
    }

    /**
     * @see DerivativeService#findAllIdentStatus()
     */
    @Override
    public List<IdentStatusResult> findAllIdentStatus() {
        return derivativeManager.findAllIdentStatus();
    }

    /**
     * @see DerivativeService#findAllRelevancyTypes()
     */
    @Override
    public List<RelevancyTypeResult> findAllRelevancyTypes() {
        return derivativeManager.findAllRelevancyTypes();
    }

    /**
     * @see DerivativeService#findAllImportantRelevancyTypes()
     */
    @Override
    public List<RelevancyTypeResult> findAllImportantRelevancyTypes() {
        return derivativeManager.findAllImportantRelevancyTypes();
    }

}
