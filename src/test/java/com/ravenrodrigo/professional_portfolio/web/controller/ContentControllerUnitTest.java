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

import com.ravenrodrigo.professional_portfolio.data.entity.DocumentEntity;
import com.ravenrodrigo.professional_portfolio.service.impl.DocumentServiceImpl;
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
 * A controller unit test class for the content
 * of the application.
 *
 * @author Raven Rodrigo
 */
@WebMvcTest(ContentController.class)
@AutoConfigureMockMvc
public class ContentControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    DocumentServiceImpl documentServiceImpl;

    @Test
    @DisplayName("It should return status ok when the documents are retrieved.")
    void shouldReturnStatusOkWhenProjectGetAll() throws Exception {
        // Given
        DocumentEntity resume = new DocumentEntity(
                new byte[] {10, 20, 30}
        );

        DocumentEntity cv = new DocumentEntity(
                new byte[] {30, 40, 20}
        );

        List<DocumentEntity> documents = List.of(resume, cv);

        // When
        when(documentServiceImpl.getAllDocuments()).thenReturn(documents);

        // Assert
        assertNotNull(documents);

        mockMvc.perform(get("/api/v1/resume-cv"))
                .andExpect(status().isOk());
    }
}
