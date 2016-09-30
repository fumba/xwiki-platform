/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.component.internal;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.internal.multi.ComponentManagerFactory;
import org.xwiki.component.manager.ComponentManager;

/**
 * Implementation of {@link ComponentManagerFactory} which force parent to be {@link DocumentComponentManager}.
 * 
 * @version $Id$
 * @since 3.3M2
 */
@Component
@Named(UserComponentManager.ID)
@Singleton
public class UserComponentManagerFactory extends AbstractComponentManagerFactory
{
    /**
     * The Component Manager to be used as parent when a component is not found in the current Component Manager.
     */
    @Inject
    @Named(DocumentComponentManager.ID)
    private ComponentManager documentComponentManager;

    @Override
    public ComponentManager createComponentManager(String namespace, ComponentManager parentComponentManager)
    {
        return this.defaultFactory.createComponentManager(namespace, this.documentComponentManager);
    }
}
