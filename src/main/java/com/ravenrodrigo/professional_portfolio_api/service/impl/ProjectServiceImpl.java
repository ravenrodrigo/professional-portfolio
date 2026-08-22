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
package com.ravenrodrigo.professional_portfolio_api.service.impl;

import com.ravenrodrigo.professional_portfolio_api.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio_api.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio_api.service.IProjectService;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectCreatePostRequest;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectPostResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * A class that implements the Project service interface.
 *
 * @author Raven Rodrigo
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<ProjectEntity> getAllProjects() {
        return this.projectRepository.findAll();
    }

    /**
     * A method that translate the web data to database.
     *
     * @param projectCreatePostRequest
     * @return
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
     * A method that translate the database to web.
     *
     * @param projectEntity
     * @return
     */
    @Override
    public ProjectPostResponse translateDbToWeb(ProjectEntity projectEntity) {
        return new ProjectPostResponse(
                projectEntity.getProjectName(),
                projectEntity.getProjectDescription(),
                projectEntity.getProjectSourceCode()
        );
    }

    /**
     * A method for project creation.
     *
     * @return project entity
     */
    @Override
    public ProjectEntity createProject(ProjectCreatePostRequest projectCreatePostRequest) {
        return translateWebToDb(projectCreatePostRequest);
    }

    /**
     * A method for getting a single project.
     *
     * @param id
     * @return Project
     */
    @Override
    public ProjectPostResponse getProject(Long id) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectId(id);

        return translateDbToWeb(projectEntity);
    }

    /**
     * A method to update a project.
     *
     * @return Project
     */
    @Override
    public void updateProject(ProjectEntity currentProject) {
        // Get the project id
        projectRepository.findById(currentProject.getProjectId())
                .ifPresent(currentProjectUpdate -> {
                    currentProjectUpdate.setProjectName(currentProject.getProjectName());
                    currentProjectUpdate.setProjectDescription(currentProject.getProjectDescription());
                    currentProjectUpdate.setProjectSourceCode(currentProject.getProjectSourceCode());

                    projectRepository.save(currentProjectUpdate);
                });

    }


    /**
     * A method to delete a project.
     *
     * @param project
     */
    @Override
    public void deleteProject(ProjectEntity project) {
        projectRepository.delete(project);
    }
}
