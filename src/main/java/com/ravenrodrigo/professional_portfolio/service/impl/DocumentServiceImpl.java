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
package com.ravenrodrigo.professional_portfolio.service.impl;

import com.ravenrodrigo.professional_portfolio.data.entity.DocumentEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.DocumentRepository;
import com.ravenrodrigo.professional_portfolio.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation class of interface document service.
 *
 * @author Raven Rodrigo
 */
@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * A method that retrieve the documents.
     *
     * @return documents
     */
    @Override
    public Iterable<DocumentEntity> getAllDocuments() {
        return this.documentRepository.findAll();
    }
}
