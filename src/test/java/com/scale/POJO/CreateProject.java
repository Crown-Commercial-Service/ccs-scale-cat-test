package com.scale.POJO;

public class CreateProject {

    String agreementId, lotId;

    public CreateProject(String agreementId, String lotId) {
        this.agreementId = agreementId;
        this.lotId = lotId;
    }

    public String getAgreementId() {
        return this.agreementId;
    }

    public String getLotId() {
        return this.lotId;
    }

}
