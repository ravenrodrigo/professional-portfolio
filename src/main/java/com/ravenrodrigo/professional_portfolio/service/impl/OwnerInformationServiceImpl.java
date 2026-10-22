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

import com.ravenrodrigo.professional_portfolio.data.entity.SkillEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.OwnerInformationRepository;
import com.ravenrodrigo.professional_portfolio.service.IOwnerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of owner information service interface.
 *
 * @author Raven Rodrigo
 */
@Service
public class OwnerInformationServiceImpl implements IOwnerInformationService {

    @Autowired
    private final OwnerInformationRepository ownerInformationRepository;

    public OwnerInformationServiceImpl(OwnerInformationRepository ownerInformationRepository) {
        this.ownerInformationRepository = ownerInformationRepository;
    }

    /**
     * A method that list all the skills.
     *
     * @return skills
     */
    @Override
    public Iterable<SkillEntity> getAllSkills() {
        return this.ownerInformationRepository.findAll();
    }
}
