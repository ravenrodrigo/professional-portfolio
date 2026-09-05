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
import com.ravenrodrigo.professional_portfolio_api.web.dto.ContactDetailsCreatePostRequest;
import com.ravenrodrigo.professional_portfolio_api.web.dto.ContactDetailsResponse;
import org.springframework.stereotype.Service;

/**
 * An interface for the owner's information.
 *
 * @author Raven Rodrigo
 */
@Service
public interface IContactService {
    ContactDetailsResponse translateOwnerInfoEntityToContactDetails(OwnerInfoEntity ownerInfoEntity);
    ContactDetailsResponse displayContactDetails(Long contactId);
    OwnerInfoEntity addContact(ContactDetailsCreatePostRequest newContactDetails);
    void deleteContact(Long contactId);
}
