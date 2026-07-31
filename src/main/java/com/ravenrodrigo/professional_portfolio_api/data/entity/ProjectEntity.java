/*
 * Copyright 2026-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ravenrodrigo.professional_portfolio_api.data.entity;

import jakarta.persistence.*;

/**
 * A class that represents a row in tbl_projects.
 *
 * @author Raven Rodrigo
 */
@Entity
@Table(name = "tbl_projects")
public class ProjectEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_source_code")
    private String projectSourceCode;

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectSourceCode() {
        return projectSourceCode;
    }

    public void setProjectSourceCode(String projectSourceCode) {
        this.projectSourceCode = projectSourceCode;
    }
}
