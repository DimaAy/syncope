/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.persistence.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.syncope.core.persistence.api.entity.Application;
import org.apache.syncope.core.persistence.api.entity.Privilege;

@Entity
@Table(name = JPAPrivilege.TABLE)
public class JPAPrivilege extends AbstractProvidedKeyEntity implements Privilege {

    private static final long serialVersionUID = -6479069294944858456L;

    public static final String TABLE = "Privilege";

    @ManyToOne
    private JPAApplication application;

    private String description;

    @NotNull
    private String specMimeType;

    @Lob
    private byte[] spec;

    @Override
    public Application getApplication() {
        return application;
    }

    @Override
    public void setApplication(final Application application) {
        checkType(application, JPAApplication.class);
        this.application = (JPAApplication) application;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String getSpecMimeType() {
        return specMimeType;
    }

    @Override
    public void setSpecMimeType(final String specMimeType) {
        this.specMimeType = specMimeType;
    }

    @Override
    public byte[] getSpec() {
        return spec;
    }

    @Override
    public void setSpec(final byte[] spec) {
        this.spec = ArrayUtils.clone(spec);
    }

}