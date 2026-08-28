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

/**
 * A unit test class for the entity of owner information.
 *
 * @author Raven Rodrigo
 */
public class OwnerInfoEntityUnitTest {

    @Test
    @DisplayName("It can create owner info entity with id, email, and phone number arguments.")
    void canCreateOwnerInfoEntityWithArgsIdEmailAndPhoneNumber() {
        // Arrange
        OwnerInfoEntity ownerInfoEntity = new OwnerInfoEntity(
                1L,
                "sample@email.com",
                "+123456789"
        );

        // Assert
        assertNotNull(ownerInfoEntity);
        assertEquals(1L, ownerInfoEntity.getInfoId());
    }

    @Test
    @DisplayName("It can create owner info entity without the id parameter.")
    void canCreateOwnerInfoEntityWithoutTheId() {
        // Arrange
        OwnerInfoEntity ownerInfoWithOutId = new OwnerInfoEntity(
                "sample@email.com",
                "+123456789"
        );

        // Assert
        assertNotNull(ownerInfoWithOutId);
        assertEquals("sample@email.com", ownerInfoWithOutId.getEmail());
        assertEquals("+123456789", ownerInfoWithOutId.getPhoneNumber());
    }
}
