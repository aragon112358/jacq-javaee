/*
 * Copyright 2016 wkoller.
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
package org.jacq.output.util;

import org.jacq.common.rest.BotanicalObjectService;
import org.jacq.common.rest.filter.ContentTypeResponseFilter;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 * Helper function for providing proxies to several service backends
 *
 * @author wkoller
 */
public class ServicesUtil {

    private static final String JACQ_SERVICE_URL = "http://localhost:8081/jacq-service/rest/";

    public static BotanicalObjectService getBotanicalObjectService() {
        return getProxy(BotanicalObjectService.class, JACQ_SERVICE_URL);
    }

    protected static <T> T getProxy(Class<T> serviceInterfaceClass, String serviceURI) {
        ResteasyClient resteasyClient = new ResteasyClientBuilder().connectionPoolSize(20).build();
        //resteasyClient.register(new ContentTypeResponseFilter());
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target(serviceURI);
        return (T) resteasyWebTarget.proxy(serviceInterfaceClass);
    }
}
