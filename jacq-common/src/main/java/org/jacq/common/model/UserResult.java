/*
 * Copyright 2017 fhafner.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jacq.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.jacq.common.model.jpa.FrmwrkUser;

/**
 *
 * @author fhafner
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserResult {

    protected Long id;
    protected String username;
    protected String password;
    protected String salt;
    protected String titlePrefix;
    protected String firstname;
    protected String lastname;
    protected String titleSuffix;
    protected Date birthdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTitlePrefix() {
        return titlePrefix;
    }

    public void setTitlePrefix(String titlePrefix) {
        this.titlePrefix = titlePrefix;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitleSuffix() {
        return titleSuffix;
    }

    public void setTitleSuffix(String titleSuffix) {
        this.titleSuffix = titleSuffix;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public UserResult() {
    }

    public UserResult(FrmwrkUser user) {
        this.id = user.getId();
        this.birthdate = user.getBirthdate();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.password = user.getPassword();
        this.salt = user.getSalt();
        this.titlePrefix = user.getTitlePrefix();
        this.titleSuffix = user.getTitleSuffix();
        this.username = user.getUsername();

    }

    /**
     * Helper function for converting a list of User entries to Userresults
     *
     * @param userList
     * @return
     */
    public static List<UserResult> fromList(List<FrmwrkUser> userList) {
        List<UserResult> userResult = new ArrayList<>();

        if (userList != null) {
            for (FrmwrkUser user : userList) {
                userResult.add(new UserResult(user));
            }
        }

        return userResult;
    }

}
