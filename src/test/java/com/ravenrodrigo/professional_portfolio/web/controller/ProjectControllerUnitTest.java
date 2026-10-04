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
package com.ravenrodrigo.professional_portfolio.web.controller;

import com.ravenrodrigo.professional_portfolio.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio.service.impl.ProjectServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    ProjectServiceImpl projectServiceImpl;

    @Test
    @DisplayName("It should return status ok after all projects retrieved.")
    void shouldReturnStatusOkWhenProjectGetAll() throws Exception {
        // Given
        ProjectEntity firstProject = new ProjectEntity(
                "First Project",
                "The first project.",
                "www.github.com/firstproject"
        );

        ProjectEntity secondProject = new ProjectEntity(
                "Second Project",
                "The second project.",
                "www.github.com/secondproject"
        );

        ProjectEntity thirdProject = new ProjectEntity(
                "Third Project",
                "The third project.",
                "www.github.com/thirdproject"
        );

        List<ProjectEntity> projects = List.of(firstProject, secondProject, thirdProject);

        // When
        when(projectServiceImpl.getAllProjects()).thenReturn(projects);

        // Assert
        assertNotNull(projects);

        mockMvc.perform(get("/api/v1/"))
                .andExpect(status().isOk());
    }
}
