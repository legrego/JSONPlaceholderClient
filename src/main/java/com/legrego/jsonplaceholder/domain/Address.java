package com.legrego.jsonplaceholder.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Representation of a physical address.
 *
 * @author Larry Gregory
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    /** Street Name */
    private String street;

    /** Suite Name */
    private String suite;

    /** City */
    private String city;

    /** ZIP Code */
    private String zipcode;

    /** Lat/Long coordinates of address */
    private Coordinates geo;

    /**
     * Getter for property 'street'.
     *
     * @return Value for property 'street'.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for property 'street'.
     *
     * @param street Value to set for property 'street'.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for property 'suite'.
     *
     * @return Value for property 'suite'.
     */
    public String getSuite() {
        return suite;
    }

    /**
     * Setter for property 'suite'.
     *
     * @param suite Value to set for property 'suite'.
     */
    public void setSuite(String suite) {
        this.suite = suite;
    }

    /**
     * Getter for property 'city'.
     *
     * @return Value for property 'city'.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for property 'city'.
     *
     * @param city Value to set for property 'city'.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for property 'zipcode'.
     *
     * @return Value for property 'zipcode'.
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Setter for property 'zipcode'.
     *
     * @param zipcode Value to set for property 'zipcode'.
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Getter for property 'geo'.
     *
     * @return Value for property 'geo'.
     */
    public Coordinates getGeo() {
        return geo;
    }

    /**
     * Setter for property 'geo'.
     *
     * @param geo Value to set for property 'geo'.
     */
    public void setGeo(Coordinates geo) {
        this.geo = geo;
    }
}
