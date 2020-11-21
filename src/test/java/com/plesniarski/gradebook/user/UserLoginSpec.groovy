package com.plesniarski.gradebook.user

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

//    def "should return server error when login data invalid" () {
//        when: "try to pass invalid data"
//        def response = client.post(path: "user/login", body: [
//                login: "dawid",
//                password: "invalid password"
//        ],
//                contentType : JSON);
//        then: 'should return error status'
//        with(response) {
//            status != 200
//            contentType == "application/json"
//        }
//    }
}
