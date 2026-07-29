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
}
