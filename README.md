# Professional Portfolio

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

## Introduction

A compilation of projects made by a professional.

## Services

### Project Management

The following are the services that manages the project/s.

|    Service Name    | HTTP Method |          URL          |        Parameter         |      Summary       |
|:------------------:|:-----------:|:---------------------:|:------------------------:|:------------------:|
|   Create Project   |    POST     |   `/api/v1/projects`    | ProjectCreatePostRequest |   Add a project    |
| Retrieve all Projects | GET |      `/api/v1/`       |           None           |  Get all projects  |  
| Update a Project | PUT | `/api/v1/project/{projectId}` |      Project Entity      | Modify the project |
| Delete a Project | DELETE | `/api/v1/{projectId}` | Project Entity | Delete a project |