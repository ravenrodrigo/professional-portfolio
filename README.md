# Professional Portfolio

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

## Introduction

A compilation of projects made by a professional.

## API

When the embedded web server is running, swagger is enabled on the development environment.

### Accessing the Swagger UI

1. Run the 'Professional Portfolio Application'.
2. Navigate to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

## Services

### Project Management

The following are the services that manages the project/s.

|  Service Name   |  HTTP Method  |         URL         |        Parameter         |    Summary    |
|:---------------:|:-------------:|:-------------------:|:------------------------:|:-------------:|
| Create Project  |     POST      | `/api/v1/projects`  | ProjectCreatePostRequest | Add a project |
