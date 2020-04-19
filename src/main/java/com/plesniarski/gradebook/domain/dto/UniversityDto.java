package com.plesniarski.gradebook.domain.dto;

public class UniversityDto {
    private Long universityId;
    private String universityName;

    public UniversityDto(){}

    public Long getUniversityId() {
        return universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public UniversityDto(Builder builder){
        universityId = builder.universityId;
        universityName = builder.universityName;
    }

    public static final class Builder{
        private Long universityId;
        private String universityName;

        public Builder universityId(Long universityId){
            this.universityId = universityId;
            return this;
        }
        public Builder universityName(String universityName){
            this.universityName = universityName;
            return this;
        }

        public UniversityDto build(){
            return new UniversityDto(this);
        }
    }
}
