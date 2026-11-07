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
package com.ravenrodrigo.professional_portfolio.data.entity;

import jakarta.persistence.*;

/**
 * A class that represents a row in tbl_owner.
 *
 * @author Raven Rodrigo
 */
@Entity
@Table(name = "tbl_owner")
public class Owner {

    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerID;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "title")
    private String title;

    public Owner() {
    }

    public Owner(Long ownerID, String firstName, String lastName, String title) {
        this.ownerID = ownerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public Owner(String firstName, String title) {
        this.firstName = firstName;
        this.title = title;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
