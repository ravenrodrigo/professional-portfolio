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
package com.ravenrodrigo.professional_portfolio_api.service;

import com.ravenrodrigo.professional_portfolio_api.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio_api.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio_api.service.impl.ProjectServiceImpl;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectCreatePostRequest;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ProjectPostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * A unit test class for Project service.
 *
 * @author Raven Rodrigo
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProjectServiceUnitTest {

    @InjectMocks
    ProjectServiceImpl projectServiceImpl;

    @Mock
    ProjectRepository projectRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("It should list all the projects.")
    void shouldListAllTheProjects() {
        // Arrange
        Iterable<ProjectEntity> expectedProjects = Arrays.asList(
                new ProjectEntity(), new ProjectEntity()
        );

        // Act
        when(projectRepository.findAll()).thenReturn(expectedProjects);
        Iterable<ProjectEntity> actualProjects = projectRepository.findAll();

        // Assert
        assertNotNull(actualProjects);
        assertEquals(2, ((Collection<?>) actualProjects).size());
    }

    @Test
    @DisplayName("It should translate the web to db - projects.")
    void shouldTranslateTheWebToDb() {
        // Arrange
        ProjectCreatePostRequest firstProject = new ProjectCreatePostRequest();

        firstProject.setProjectName("First Project");
        firstProject.setProjectDescription("The first project.");
        firstProject.setProjectSourceCode("www.github.com/firstproject");

        // Act
        ProjectEntity projectEntity = projectServiceImpl.translateWebToDb(firstProject);

        // Assert
        assertNotNull(projectEntity);
        assertEquals("First Project", projectEntity.getProjectName());
        assertEquals("The first project.", projectEntity.getProjectDescription());
        assertEquals("www.github.com/firstproject", projectEntity.getProjectSourceCode());
    }

    @Test
    @DisplayName("It should save a created project.")
    void shouldSaveACreatedProject() {
        // Arrange
        ProjectCreatePostRequest firstProject = new ProjectCreatePostRequest(
                "First Project",
                "The first project created.",
                "www.github.com/firstprojectcreated"
        );

        // Act
        ProjectEntity createdProject = projectServiceImpl.createProject(firstProject);
        Mockito.lenient().when(projectRepository.save(createdProject)).thenReturn(createdProject);

        // Assert
        assertNotNull(createdProject);
        assertEquals("First Project", createdProject.getProjectName());
        assertEquals("The first project created.", createdProject.getProjectDescription());
        assertEquals("www.github.com/firstprojectcreated", createdProject.getProjectSourceCode());

    }

    @Test
    @DisplayName("It should translate the database to web.")
    void shouldTranslateTheDbToWeb() {
        // Arrange
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("First Project");
        projectEntity.setProjectDescription("The first project.");
        projectEntity.setProjectSourceCode("www.github.com/firstproject");

        // Act
        ProjectPostResponse projectPostResponse = projectServiceImpl.translateDbToWeb(projectEntity);

        // Assert
        assertNotNull(projectPostResponse);
        assertEquals("First Project", projectPostResponse.getProjectName());
        assertEquals("The first project.", projectPostResponse.getProjectDescription());
        assertEquals("www.github.com/firstproject", projectPostResponse.getProjectSourceCode());
    }

    @Test
    @DisplayName("It should get a single project.")
    void shouldGetSingleProject() {
        // Arrange
        ProjectEntity projectFromDb = new ProjectEntity(
                1L,
                "Existing Project",
                "The existing project.",
                "www.github.com/existingproject"
        );

        // Act
        ProjectPostResponse project = projectServiceImpl.getProject(projectFromDb.getProjectId());
        project.setProjectName(projectFromDb.getProjectName());
        project.setProjectDescription(projectFromDb.getProjectDescription());
        project.setProjectSourceCode(projectFromDb.getProjectSourceCode());

        // Assert
        assertNotNull(project);
        assertEquals("Existing Project", project.getProjectName());
    }
}
