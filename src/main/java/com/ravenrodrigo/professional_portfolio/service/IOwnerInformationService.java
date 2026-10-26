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

import com.ravenrodrigo.professional_portfolio.data.entity.SkillEntity;
import com.ravenrodrigo.professional_portfolio.web.dto.SkillCreatePostRequest;
import com.ravenrodrigo.professional_portfolio.web.dto.SkillGetResponse;
import org.springframework.stereotype.Service;

/**
 * An interface for Owner Information service.
 *
 * @author Raven Rodrigo
 */
@Service
public interface IOwnerInformationService {

    /**
     * List all the skills.
     *
     * @return skills
     */
    Iterable<SkillEntity> getAllSkills();

    /**
     * A method that return a dto get response of skill.
     *
     * @param skillEntity - skill
     * @return dto skill
     */
    SkillGetResponse translateSkillToWeb(SkillEntity skillEntity);

    /**
     * A method that translate the skill in web to database.
     *
     * @param skillCreatePostRequest - skill post request
     *
     * @return skill entity
     */
    SkillEntity translateSkillToDb(SkillCreatePostRequest skillCreatePostRequest);

    /**
     * A method to delete a skill.
     *
     * @param skillEntity - Skill Entity
     */
    void deleteSkill(SkillEntity skillEntity);
}
