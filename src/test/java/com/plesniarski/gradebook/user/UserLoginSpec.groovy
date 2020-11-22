package com.plesniarski.gradebook.user

import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import static groovyx.net.http.ContentType.*


class UserLoginSpec extends Specification {
    @Shared
    def client = new RESTClient("http://localhost:8080/");

    def "should return 200 status when login data valid" () {
        when: "try to pass valid data"
        def response = client.post(path: "user/login", body: [
                login: "dawid",
                password: "dawid"
        ],
                contentType : JSON);
        then: 'should return 200 status'
        with(response) {
            status == 200
            contentType == "application/json"
        }
    }

    def "should return 401 status when login data invalid" () {
        when: "try to pass invalid data"
        def response = client.post(path: "user/login", body: [
                login: "dawid",
                password: "invalidPassword"
        ],
                contentType : JSON);
        then: 'should return error status'
        HttpResponseException e = thrown(HttpResponseException);
        assert e.response.status == 401: 'response code should be 400 if provided incorrect album id parameter'
    }

    def "should return list of students found by university ID" () {
        when: "try to find students by university ID"
        def response = client.get(path: "user/findByUniversity/1");
        then: "should return 200 status and list of students"
        with (response) {
            status == 200
            data.size > 0
        }
    }

    def "should return user by ID" () {
        when: "try to find user by ID"
        def response = client.get(path: "user/findUser/1");
        then: "should return 200 status and user"
        with (response) {
            status == 200
            data != null
        }
    }

}
