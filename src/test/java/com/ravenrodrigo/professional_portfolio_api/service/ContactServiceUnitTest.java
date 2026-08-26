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
import com.ravenrodrigo.professional_portfolio_api.data.repository.ContactInformationRepository;
import com.ravenrodrigo.professional_portfolio_api.service.impl.ContactServiceImpl;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ContactDetailsResponse;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ContactInfoResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
public class ContactServiceUnitTest {

    @InjectMocks
    ContactServiceImpl contactServiceImpl;

    @Mock
    ContactInformationRepository contactInformationRepository;

    @Test
    @DisplayName("It should create owner info entity with no arguments.")
    void shouldCreateOwnerInfoEntityWithNoArguments() {
        // Arrange
        OwnerInfoEntity contactDetails = new OwnerInfoEntity();

        // Act
        assertNotNull(contactDetails);
    }

    @Test
    @DisplayName("It should translate contact entity to contact display.")
    void shouldTranslateContactEntityToContactDisplay() {
        // Arrange
        OwnerInfoEntity ownerInfoEntity = new OwnerInfoEntity(
                1L,
                "sample@email.com",
                "+123456789"
        );

        // Act
        ContactDetailsResponse contactDetailsResponse = contactServiceImpl.translateContactEntityToContactDisplay(OwnerInfoEntity ownerInfoEntity);

        // Assert
        assertEquals(ownerInfoEntity.getEmail(), contactDetailsResponse.email());
    }
}
