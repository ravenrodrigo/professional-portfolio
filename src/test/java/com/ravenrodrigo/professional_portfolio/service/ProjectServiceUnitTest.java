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
package com.ravenrodrigo.professional_portfolio.service;

import com.ravenrodrigo.professional_portfolio.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio.service.impl.ProjectServiceImpl;
import com.ravenrodrigo.professional_portfolio.web.dto.ProjectCreatePostRequest;
import com.ravenrodrigo.professional_portfolio.web.dto.ProjectGetResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * A unit test class for project service.
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
    void shouldGetAllProjects() {
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
    @DisplayName("It should translate the project from database to web.")
    void shouldTranslateTheDbToWeb() {
        // Arrange
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("First Project");
        projectEntity.setProjectDescription("The first project.");
        projectEntity.setProjectSourceCode("www.github.com/firstproject");

        // Act
        ProjectGetResponse projectGetResponse = projectServiceImpl.translateDbToWeb(projectEntity);

        // Assert
        assertNotNull(projectGetResponse);
        assertEquals("First Project", projectEntity.getProjectName());
        assertEquals("The first project.", projectEntity.getProjectDescription());
        assertEquals("www.github.com/firstproject", projectEntity.getProjectSourceCode());
    }

    @Test
    @DisplayName("It should translate the project from web to db.")
    void shouldTranslateTheWebToDb() {
        // Arrange
        ProjectCreatePostRequest firstProject = new ProjectCreatePostRequest(
                "First Project",
                "The first project.",
                "www.github.com/firstproject"
        );

        ProjectEntity expectedProject = new ProjectEntity(
                "First Project",
                "The first project.",
                "www.github.com/firstproject"
        );

        // Act
        ProjectEntity actualProject = projectServiceImpl.translateWebToDb(firstProject);

        // Assert
        assertNotNull(actualProject);
        assertEquals(expectedProject.getProjectName(), actualProject.getProjectName());
    }
}
