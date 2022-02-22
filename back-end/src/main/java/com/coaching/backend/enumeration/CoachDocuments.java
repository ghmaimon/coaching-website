package com.coaching.backend.enumeration;

/**
 * no need for this class i guess
 */
public enum CoachDocuments {
    COACHING_CERTIFICATE("coachingCertificate"),
    /**
     * could be either id, passport, or other documents
     */
    IDENTITY_DOCUMENT("identityDocument"),
    /**
     * portrait photo
     */
    IMAGE("image"),
    UNKNOWN_DOCUMENT("unknownDocument");

    private final String valueField;

    CoachDocuments(String valueField) {
        this.valueField = valueField;
    }

    public final String value() { return this.valueField; }

    public static CoachDocuments fromValue (String valueField) {
        for(CoachDocuments requestName : CoachDocuments.values())
            if(requestName.valueField.equals(valueField)) return requestName;
        return UNKNOWN_DOCUMENT;
    }
}
