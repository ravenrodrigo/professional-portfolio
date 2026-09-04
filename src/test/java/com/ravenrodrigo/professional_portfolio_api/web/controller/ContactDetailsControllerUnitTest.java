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

import com.ravenrodrigo.professional_portfolio_api.data.entity.OwnerInfoEntity;
import com.ravenrodrigo.professional_portfolio_api.service.impl.ContactServiceImpl;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ContactDetailsCreatePostRequest;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ContactDetailsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * A controller unit test class for contact details.
 *
 * @author Raven Rodrigo
 */
@WebMvcTest(ContactDetailsController.class)
@AutoConfigureMockMvc
public class ContactDetailsControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ContactServiceImpl contactService;

    @Test
    @DisplayName("It should return status created when contact details are added.")
    void shouldReturnStatusCreatedWhenContactDetailsAreAdded() throws Exception {
        // Given
        ContactDetailsCreatePostRequest newContactDetails = new ContactDetailsCreatePostRequest(
                "sample@email.com",
                "+123456789"
        );

        OwnerInfoEntity ownerInfoEntity = new OwnerInfoEntity(
                1L,
                newContactDetails.email(),
                newContactDetails.phoneNumber()
        );

        // When
        when(contactService.addContact(newContactDetails)).thenReturn(ownerInfoEntity);
        mockMvc.perform(post("/api/v1/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\": \"sample@email.com\", \"phoneNumber\": \"+123456789\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("It should return status ok when get contact details.")
    void shouldReturnStatusOkWhenGetContactDetails() throws  Exception {
        // Given
        OwnerInfoEntity ownerInfoEntity = new OwnerInfoEntity();
        ownerInfoEntity.setInfoId(1L);

        ContactDetailsResponse contactDetailsResponse = new ContactDetailsResponse(
                "sample@email.com",
                "+123456789"
        );

        // When
        when(contactService.displayContactDetails(ownerInfoEntity.getInfoId())).thenReturn(contactDetailsResponse);
        mockMvc.perform(get("/api/v1/1"))
                .andExpect(status().isOk());
    }
}
