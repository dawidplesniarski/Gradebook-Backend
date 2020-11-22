package com.plesniarski.gradebook.courses

import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import static groovyx.net.http.ContentType.*

class CoursesSpec extends Specification {
    @Shared
    def client = new RESTClient("http://localhost:8080/");

    def "should add new course" () {
        when: "trying to add new course"
        def response = client.post(path: "courses/addCourse",
        body: [
                course: "testowy kierunek"
        ],
        contentType: JSON)
        then: "new course should be added"
        with (response) {
            status: 201
            data: !null
        }
    }

    def "should find all courses" () {
        when: "trying to find all courses"
        def response = client.get(path: "courses/findAll");
        then: "should return list of courses"
        with (response) {
            status: 200
            data.size > 0
        }
    }

    def "should find course by ID" () {
        when: "trying to find course by ID"
        def response = client.get(path: "courses/findCourse/1");
        then: "should return course with special ID"
        with (response) {
            status: 200
            data: !null
        }
    }
}
