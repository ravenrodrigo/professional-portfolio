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
package com.ravenrodrigo.professional_portfolio_api.service.impl;

import com.ravenrodrigo.professional_portfolio_api.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio_api.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio_api.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the Project service interface.
 *
 * @author Raven Rodrigo
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<ProjectEntity> getAllProjects() {
        return this.projectRepository.findAll();
    }
}
