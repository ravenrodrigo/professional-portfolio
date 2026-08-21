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
import com.ravenrodrigo.professional_portfolio_api.service.impl.ProjectServiceImpl;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectCreatePostRequest;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectPostResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * A controller unit test class for project api.
 *
 * @author Raven Rodrigo
 */
@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc
public class ProjectControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProjectServiceImpl projectService;

    @Test
    @DisplayName("It should return status created when project is created.")
    void shouldReturnStatusCreatedWhenProjectIsCreated() throws Exception {
        // Given
        ProjectEntity projectEntity = new ProjectEntity(
                "First Project",
                "The first project.",
                "www.github.com/firstproject"
        );

        // When
        when(projectService.createProject(any(ProjectCreatePostRequest.class))).thenReturn(projectEntity);
        mockMvc.perform(post("/api/v1/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"projectName\": \"Firs Project\", \"projectDescription\": \"The first project.\", \"projectSourceCode\": \"www.github.com/firstproject\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("It should return status ok after a project retrieved by id.")
    void shouldReturnStatusOkWhenProjectGetWithId() throws Exception {
        // Given
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectId(1L);

        ProjectPostResponse projectPostResponse = new ProjectPostResponse(
                "First Project.",
                "This is the first project.",
                "www.github.com/firstproject"
        );

        // When
        when(projectService.getProject(projectEntity.getProjectId())).thenReturn(projectPostResponse);
        mockMvc.perform(get("/api/v1/1"))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("It should return status ok after all projects retrieved.")
    void shouldReturnStatusOkWhenProjectGetAll() throws Exception {
        // Given
        ProjectEntity firstProject = new ProjectEntity(
                1L,
                "First Project",
                "The first project.",
                "www.github.com/firstproject"
        );

        ProjectEntity secondProject = new ProjectEntity(
                2L,
                "Second Project",
                "The second project.",
                "www.github.com/secondproject"
        );

        ProjectEntity thirdProject = new ProjectEntity(
                3L,
                "Third Project",
                "The third project.",
                "www.github.com/thirdproject"
        );

        List<ProjectEntity> projects = List.of(firstProject, secondProject, thirdProject);

        // When
        when(projectService.getAllProjects()).thenReturn(projects);

        // Assert
        assertNotNull(projects);

        mockMvc.perform(get("/api/v1/projects/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("It should return status ok when current project was updated.")
    void shouldReturnStatusOkWhenProjectWasUpdated() throws Exception {
        // Given
        ProjectEntity existingProject = new ProjectEntity(
                1L,
                "Existing Project",
                "The existing project.",
                "www.github.com/existingproject"
        );

        existingProject.setProjectName("Updated Project");
        existingProject.setProjectDescription("The updated project.");

        // When
        doNothing().when(projectService).updateProject(existingProject);

        mockMvc.perform(put("/api/v1/project/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"projectId\": 1, \"projectName\": \"Updated Project\", \"projectDescription\": \"The updated project.\", \"projectSourceCode\": \"www.github.com/existingproject\" }" ))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("It should return status ok when the project is deleted.")
    void shouldReturnStatusOkWhenProjectWasDeleted() throws Exception {
        // Given
        ProjectEntity project = new ProjectEntity(
                2L,
                "Project 2",
                "Second project.",
                "www.github.com/secondproject"
        );

        // When
        doNothing().when(projectService).deleteProject(project);

        mockMvc.perform(delete("/api/v1/project/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"projectId\": 2, \"projectName\": \"Project 2\", \"projectDescription\": \"Second project.\", \"projectSourceCode\": \"www.github.com/secondproject\" }" ))
                .andExpect(status().isOk());

    }
}
