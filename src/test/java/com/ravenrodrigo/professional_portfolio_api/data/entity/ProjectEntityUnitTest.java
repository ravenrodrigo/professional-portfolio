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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * A unit test class for the entity of project.
 *
 * @author Raven Rodrigo
 */
public class ProjectEntityUnitTest {

    @Test
    @DisplayName("It can create project entity with default constructor.")
    void canCreateProjectEntityWithDefaultConstructor() {
        // Arrange
        ProjectEntity projectEntity = new ProjectEntity();

        // Assert
        assertNotNull(projectEntity);
    }

    @Test
    @DisplayName("It should create a project entity with 3 arguments.")
    void shouldCreateAProjectEntityWithAllArguments() {
        // Arrange
        ProjectEntity projectEntity = new ProjectEntity(
                "Project",
                "The project entity.",
                "www.github.com/projectsample"
        );

        // Assert
        assertNotNull(projectEntity);
    }
}
