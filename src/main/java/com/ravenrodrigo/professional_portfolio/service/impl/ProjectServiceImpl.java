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
package com.ravenrodrigo.professional_portfolio.service.impl;

import com.ravenrodrigo.professional_portfolio.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio.service.IProjectService;
import com.ravenrodrigo.professional_portfolio.web.dto.ProjectCreatePostRequest;
import com.ravenrodrigo.professional_portfolio.web.dto.ProjectGetResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Raven Rodrigo
 */
@Service
public class ProjectServiceImpl implements IProjectService  {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * A method that lists all the projects.
     *
     * @return projects
     */
    @Override
    public Iterable<ProjectEntity> getAllProjects() {
        return this.projectRepository.findAll();
    }

    /**
     * A method that translate the project from db to web.
     *
     * @param projectEntity
     * @return projectGetResponse
     */
    @Override
    public ProjectGetResponse translateDbToWeb(ProjectEntity projectEntity) {
        return new ProjectGetResponse(
                projectEntity.getProjectName(),
                projectEntity.getProjectDescription(),
                projectEntity.getProjectSourceCode()
        );
    }

    /**
     * A method that translate the project in web to database.
     *
     * @param projectCreatePostRequest - Project Create POST request
     * @return projectEntity
     */
    @Override
    public ProjectEntity translateWebToDb(ProjectCreatePostRequest projectCreatePostRequest) {
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setProjectName(projectCreatePostRequest.projectName());
        projectEntity.setProjectDescription(projectCreatePostRequest.projectDescription());
        projectEntity.setProjectSourceCode(projectCreatePostRequest.projectSourceCode());

        return projectEntity;
    }

    /**
     * A method to delete a project.
     *
     * @param project - Project Entity
     */
    @Override
    public void deleteProject(ProjectEntity project) {
        projectRepository.delete(project);
    }
}
