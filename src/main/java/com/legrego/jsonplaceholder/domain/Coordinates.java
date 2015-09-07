package com.legrego.jsonplaceholder.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Simple Lat/Long Coordinate System.
 *
 * @author Larry Gregory
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {
    /** Latitude */
    private String lat;

    /** Longitude */
    private String lng;

    /**
     * Getter for property 'lat'.
     *
     * @return Value for property 'lat'.
     */
    public String getLat() {
        return lat;
    }

    /**
     * Setter for property 'lat'.
     *
     * @param lat Value to set for property 'lat'.
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * Getter for property 'lng'.
     *
     * @return Value for property 'lng'.
     */
    public String getLng() {
        return lng;
    }

    /**
     * Setter for property 'lng'.
     *
     * @param lng Value to set for property 'lng'.
     */
    public void setLng(String lng) {
        this.lng = lng;
    }
}
