package com.ravenrodrigo.professional_portfolio.service;

import com.ravenrodrigo.professional_portfolio.data.entity.ProjectEntity;
import com.ravenrodrigo.professional_portfolio.data.entity.SkillEntity;
import com.ravenrodrigo.professional_portfolio.data.repository.OwnerInformationRepository;
import com.ravenrodrigo.professional_portfolio.data.repository.ProjectRepository;
import com.ravenrodrigo.professional_portfolio.service.impl.OwnerInformationServiceImpl;
import com.ravenrodrigo.professional_portfolio.web.dto.SkillRequest;
import com.ravenrodrigo.professional_portfolio.web.dto.SkillResponse;
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
 * A unit test class for the display of owner's information.
 *
 * @author Raven Rodrigo
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InformationDisplayUnitTest {

    @InjectMocks
    OwnerInformationServiceImpl ownerInformationServiceImpl;

    @Mock
    OwnerInformationRepository ownerInformationRepository;

    @Mock
    ProjectRepository projectRepository;

    @Test
    @DisplayName("It should create new skill with default constructor.")
    void shouldCreateNewSkillWithDefaultConstructor() {
        // Arrange
        SkillEntity skill = new SkillEntity();

        // Assert
        assertNotNull(skill);
    }

    @Test
    @DisplayName("It should get the skills.")
    void shouldGetTheSkills() {
        // Arrange
        Iterable<SkillEntity> expectedSkills = Arrays.asList(
                new SkillEntity(), new SkillEntity()
        );

        // Act
        when(ownerInformationRepository.findAll()).thenReturn(expectedSkills);
        Iterable<SkillEntity> actualSkills = ownerInformationRepository.findAll();

        // Assert
        assertNotNull(actualSkills);
        assertEquals(2, ((Collection<?>) actualSkills).size());
    }

    @Test
    @DisplayName("It should translate the skills from database to web.")
    void shouldTranslateTheDbToWeb() {
        // Arrange
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setSkillName("Backend");
        skillEntity.setSkillDescription("Develop backend services and APIs.");

        // Act
        SkillResponse skillResponse = ownerInformationServiceImpl.translateSkillToWeb(skillEntity);

        // Assert
        assertNotNull(skillResponse);
        assertEquals(skillEntity.getSkillName(), skillResponse.skillName());
        assertEquals(skillEntity.getSkillDescription(), skillResponse.skillDescription());
    }

    @Test
    @DisplayName("It should translate the skill from web to database.")
    void shouldTranslateTheWebToDb() {
        // Arrange
        SkillRequest skillOne = new SkillRequest(
                "Skill one",
                "The skill one."
        );

        SkillEntity skillEntity = new SkillEntity(
                "Skill one",
                "The skill one."
        );

        // Act
        SkillEntity actualSkill = ownerInformationServiceImpl.translateSkillToDb(skillOne);

        // Assert
        assertNotNull(actualSkill);
        assertEquals(skillEntity.getSkillName(), actualSkill.getSkillName());
    }

    @Test
    @DisplayName("It should delete a skill.")
    void shouldDeleteASkill() {
        // Arrange
        SkillEntity skill = new SkillEntity(
                "Skill one",
                "The first skill"
        );

        // Act
        ownerInformationServiceImpl.deleteSkill(skill);
    }


    @Test
    @DisplayName("It should display all the projects.")
    void shouldDisplayAllProjects() {
        // Arrange
        Iterable<ProjectEntity> expectedProjects = Arrays.asList(
                new ProjectEntity(), new ProjectEntity()
        );

        // Act
        when(projectRepository.findAll()).thenReturn(expectedProjects);
        Iterable<ProjectEntity> actualProjects = projectRepository.findAll();

        // Assert
        assertNotNull(actualProjects);
        assertEquals(2, ((Collection<?>) actualProjects).size());
    }
}
