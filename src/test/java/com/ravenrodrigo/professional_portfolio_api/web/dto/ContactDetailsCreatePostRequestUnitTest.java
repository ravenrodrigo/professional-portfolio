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
package com.ravenrodrigo.professional_portfolio_api.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * A unit test class for the post request of new contact details.
 *
 * @author Raven Rodrigo
 */
public class ContactDetailsCreatePostRequestUnitTest {

    @Test
    @DisplayName("It can create new contact details with default constructor.")
    void canCreateAContactDetailsWithDefaultConstructor() {
        // Arrange
        ContactDetailsCreatePostRequestUnitTest newContact = new ContactDetailsCreatePostRequestUnitTest();

        // Assert
        assertNotNull(newContact);
    }
}
