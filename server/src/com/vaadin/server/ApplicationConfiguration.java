/*
 * Copyright 2011 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.server;

import java.util.Properties;


/**
 * A collection of properties configured for all applications as well as a way
 * of accessing third party properties not explicitely supported by this class.
 * 
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0.0
 */
public interface ApplicationConfiguration {
    /**
     * Returns whether Vaadin is in production mode.
     * 
     * @return true if in production mode, false otherwise.
     */
    public boolean isProductionMode();

    /**
     * Returns whether cross-site request forgery protection is enabled.
     * 
     * @return true if XSRF protection is enabled, false otherwise.
     */
    public boolean isXsrfProtectionEnabled();

    /**
     * Returns the time resources can be cached in the browsers, in seconds.
     * 
     * @return The resource cache time.
     */
    public int getResourceCacheTime();

    /**
     * Returns the number of seconds between heartbeat requests of a UI, or a
     * non-positive number if heartbeat is disabled.
     * 
     * @return The time between heartbeats.
     */
    public int getHeartbeatInterval();

    /**
     * Returns whether UIs that have no other activity than heartbeat requests
     * should be closed after they have been idle the maximum inactivity time
     * enforced by the session.
     * 
     * @see ApplicationContext#getMaxInactiveInterval()
     * 
     * @since 7.0.0
     * 
     * @return True if UIs receiving only heartbeat requests are eventually
     *         closed; false if heartbeat requests extend UI lifetime
     *         indefinitely.
     */
    public boolean isIdleUICleanupEnabled();

    /**
     * Gets the properties configured for the deployment, e.g. as init
     * parameters to the servlet or portlet.
     * 
     * @return properties for the application.
     */
    public Properties getInitParameters();

    /**
     * Gets a configured property. The properties are typically read from e.g.
     * web.xml or from system properties of the JVM.
     * 
     * @param propertyName
     *            The simple of the property, in some contexts, lookup might be
     *            performed using variations of the provided name.
     * @param defaultValue
     *            the default value that should be used if no value has been
     *            defined
     * @return the property value, or the passed default value if no property
     *         value is found
     */
    public String getApplicationOrSystemProperty(String propertyName,
            String defaultValue);

}