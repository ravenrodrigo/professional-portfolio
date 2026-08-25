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

import com.ravenrodrigo.professional_portfolio_api.data.entity.OwnerInfoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A unit test class for Owner Information service.
 *
 * @author Raven Rodrigo
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OwnerInfoUnitTest {

    @Test
    @DisplayName("It should create owner info entity with no arguments.")
    void shouldCreateOwnerInfoEntityWithNoArguments() {
        // Arrange
        OwnerInfoEntity contactDetails = new OwnerInfoEntity();

        // Act
        assertNotNull(contactDetails);
    }
}
