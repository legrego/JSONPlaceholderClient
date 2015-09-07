package com.legrego.jsonplaceholder.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User in the JsonPlaceholder system.
 *
 * @author Larry Gregory
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    /** Unique ID */
    private Integer id;

    /** User's Name */
    private String name;

    /** Username */
    private String username;

    /** Physical Address */
    private Address address;

    /** Email Address */
    private String email;

    /** Telephone Number */
    private String phone;

    /** Website URL */
    private String website;

    /** Company */
    private Company company;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'username'.
     *
     * @return Value for property 'username'.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for property 'username'.
     *
     * @param username Value to set for property 'username'.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for property 'address'.
     *
     * @return Value for property 'address'.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for property 'address'.
     *
     * @param address Value to set for property 'address'.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for property 'phone'.
     *
     * @return Value for property 'phone'.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for property 'phone'.
     *
     * @param phone Value to set for property 'phone'.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for property 'website'.
     *
     * @return Value for property 'website'.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Setter for property 'website'.
     *
     * @param website Value to set for property 'website'.
     */
    public void setWebsite(String website) {
        this.website = website;
    }


    /**
     * Getter for property 'company'.
     *
     * @return Value for property 'company'.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Setter for property 'company'.
     *
     * @param company Value to set for property 'company'.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
