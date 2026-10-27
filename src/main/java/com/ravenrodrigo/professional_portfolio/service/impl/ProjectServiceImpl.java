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
import com.ravenrodrigo.professional_portfolio.web.dto.ProjectRequest;
import com.ravenrodrigo.professional_portfolio.web.dto.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Raven Rodrigo
 */
@Service
public class ProjectServiceImpl implements IProjectService  {

    @Autowired
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
    public ProjectResponse translateDbToWeb(ProjectEntity projectEntity) {
        return new ProjectResponse(
                projectEntity.getProjectName(),
                projectEntity.getProjectDescription(),
                projectEntity.getProjectSourceCode()
        );
    }

    /**
     * A method that translate the project in web to database.
     *
     * @param projectRequest - Project Create POST request
     * @return projectEntity
     */
    @Override
    public ProjectEntity translateWebToDb(ProjectRequest projectRequest) {
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setProjectThumbnail(projectRequest.projectThumbnail());
        projectEntity.setProjectName(projectRequest.projectName());
        projectEntity.setProjectDescription(projectRequest.projectDescription());
        projectEntity.setProjectSourceCode(projectRequest.projectSourceCode());

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

    /**
     * A method that updates a project.
     *
     * @param existingProject - Project in database
     */
    @Override
    public void updateProject(ProjectEntity existingProject) {
        // Get the project id
        projectRepository.findById(existingProject.getProjectId())
                .ifPresent(existingProjectUpdate -> {
                    existingProjectUpdate.setProjectName(existingProject.getProjectName());
                    existingProjectUpdate.setProjectDescription(existingProject.getProjectDescription());
                    existingProjectUpdate.setProjectSourceCode(existingProject.getProjectSourceCode());

                    projectRepository.save(existingProjectUpdate);
                });
    }

    /**
     * A method for project creation.
     *
     * @param projectRequest - project from client
     * @return createdProject
     */
    @Override
    public ProjectEntity createProject(ProjectRequest projectRequest) {
        ProjectEntity createdProject = translateWebToDb(projectRequest);
        return createdProject;
    }

    /**
     * A method that retrieve a project by id.
     *
     * @param id - project id
     * @return project dto
     */
    @Override
    public Optional<ProjectEntity> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
}
