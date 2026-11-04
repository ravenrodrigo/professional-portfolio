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

import com.ravenrodrigo.professional_portfolio.data.entity.DocumentEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.DocumentRepository;
import com.ravenrodrigo.professional_portfolio.service.impl.DocumentCopyServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * A unit test class for the display of documents.
 *
 * @author Raven Rodrigo
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DocumentCopyServiceUnitTest {

    @InjectMocks
    DocumentCopyServiceImpl documentCopyServiceImpl;

    @Mock
    DocumentRepository documentRepository;

    @Test
    @DisplayName("It should get the resume and cv documents.")
    void shouldGetTheDocuments() {
        // Arrange
        Iterable<DocumentEntity> documents = Arrays.asList(
                new DocumentEntity(new byte[]{30, 40, 40}),
                new DocumentEntity(new byte[]{20, 30, 40})
        );
        // Act
        when(documentRepository.findAll()).thenReturn(documents);
        Iterable<DocumentEntity> actualDocuments = documentCopyServiceImpl.getAllDocuments();

        // Assert
        assertNotNull(actualDocuments);
        assertEquals(2, ((Collection<?>) actualDocuments).size());
    }
}
