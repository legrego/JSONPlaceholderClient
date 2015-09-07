package com.legrego.jsonplaceholder.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Company details.
 *
 * @author Larry Gregory
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    /** Name of Company */
    private String name;

    /** Company's Catch Phrase */
    private String catchPhrase;

    /** bs */
    private String bs;

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
     * Getter for property 'catchPhrase'.
     *
     * @return Value for property 'catchPhrase'.
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * Setter for property 'catchPhrase'.
     *
     * @param catchPhrase Value to set for property 'catchPhrase'.
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * Getter for property 'bs'.
     *
     * @return Value for property 'bs'.
     */
    public String getBs() {
        return bs;
    }

    /**
     * Setter for property 'bs'.
     *
     * @param bs Value to set for property 'bs'.
     */
    public void setBs(String bs) {
        this.bs = bs;
    }
}
