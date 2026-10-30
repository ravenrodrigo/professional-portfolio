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

import com.ravenrodrigo.professional_portfolio.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio.data.entity.SkillEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.OwnerInformationRepository;
import com.ravenrodrigo.professional_portfolio.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio.service.IOwnerDetailsService;
import com.ravenrodrigo.professional_portfolio.web.dto.SkillRequest;
import com.ravenrodrigo.professional_portfolio.web.dto.SkillResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of owner information service interface.
 *
 * @author Raven Rodrigo
 */
@Service
public class OwnerDetailsServiceImpl implements IOwnerDetailsService {

    @Autowired
    private final OwnerInformationRepository ownerInformationRepository;

    @Autowired
    private final ProjectRepository projectRepository;

    public OwnerDetailsServiceImpl(OwnerInformationRepository ownerInformationRepository, ProjectRepository projectRepository) {
        this.ownerInformationRepository = ownerInformationRepository;
        this.projectRepository = projectRepository;
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

    /**
     * A method that return a dto get response of skill.
     *
     * @param skillEntity - skill
     * @return dto skill
     */
    @Override
    public SkillResponse translateSkillToWeb(SkillEntity skillEntity) {
        return new SkillResponse(
                skillEntity.getSkillName(),
                skillEntity.getSkillDescription()
        );
    }

    /**
     * A method that translate the skill in web to database.
     *
     * @param skillRequest - skill post request
     *
     * @return skill entity
     */
    @Override
    public SkillEntity translateSkillToDb(SkillRequest skillRequest) {
        SkillEntity skillEntity = new SkillEntity();

        skillEntity.setSkillName(skillRequest.skillName());
        skillEntity.setSkillDescription(skillRequest.skillDescription());

        return  skillEntity;
    }

    /**
     * A method that delete a skill.
     *
     * @param skillEntity - Skill Entity
     */
    @Override
    public void deleteSkill(SkillEntity skillEntity) {
        ownerInformationRepository.delete(skillEntity);
    }

    /**
     * Display all the projects.
     *
     * @return projects
     */
    @Override
    public Iterable<ProjectEntity> displayProjects() {
        return this.projectRepository.findAll();
    }
}
