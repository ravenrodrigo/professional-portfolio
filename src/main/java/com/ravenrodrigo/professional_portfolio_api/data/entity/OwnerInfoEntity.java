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
package com.ravenrodrigo.professional_portfolio_api.data.entity;

import jakarta.persistence.*;

/**
 * A class that represents a row in tbl_contact_details.
 *
 * @author Raven Rodrigo
 */
@Entity
@Table(name = "tbl_owner_info")
public class OwnerInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long infoId;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public OwnerInfoEntity() {}

    public OwnerInfoEntity(Long infoId, String email, String phoneNumber) {
        this.infoId = infoId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
