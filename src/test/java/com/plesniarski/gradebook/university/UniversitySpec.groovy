package com.plesniarski.gradebook.university

import spock.lang.Specification
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import spock.lang.Shared
import static groovyx.net.http.ContentType.*

class UniversitySpec extends Specification {
    @Shared
    def client = new RESTClient("http://localhost:8080/");

    def "should return list of universities" () {
        when: "try to find all universities"
        def response = client.get(path: "/university/findAll");

        then: "should return 200 status and list of universities"
        with (response) {
            status: 200
            data.size > 0
        }
    }

    def "should add new university" () {
        when: "try to add new university"
        def response = client.post(path: "/university/add",
        body: [
                universityName: "Testowa uczelnia"
        ],
        contentType: JSON)
        then: "should return status 201 and new univeristy data"
        with (response) {
            status: 201
            data != null
        }
    }
}
