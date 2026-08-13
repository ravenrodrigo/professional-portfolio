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
package com.ravenrodrigo.professional_portfolio_api.web.controller;

import com.ravenrodrigo.professional_portfolio_api.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio_api.service.IProjectService;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectCreatePostRequest;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A controller class for project.
 *
 * @author Raven Rodrigo
 */
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectEntity> projectCreate(@RequestBody ProjectCreatePostRequest projectCreatePostRequest) {
       ProjectEntity createdProject = projectService.createProject(projectCreatePostRequest);
       return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectPostResponse> getProjectById(@PathVariable("projectId") Long projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @GetMapping("/projects/")
    public ResponseEntity<Iterable<ProjectEntity>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PutMapping("/project/{projectId}")
    public ResponseEntity<?> updateProject(@RequestBody ProjectEntity project) {
        projectService.updateProject(project);
        return ResponseEntity.ok("Project updated successfully!");
    }
}
