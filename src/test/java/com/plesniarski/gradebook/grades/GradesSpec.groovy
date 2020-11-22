package com.plesniarski.gradebook.grades

import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import static groovyx.net.http.ContentType.*

class GradesSpec extends Specification {
    @Shared
    def client = new RESTClient("http://localhost:8080/");

    def "should add new grade" () {
        when: "try to add new grade"
        def response = client.post(path: "grades/addGrade",
                body: [
                        grade    : grade,
                        subject  : subject,
                        studentId: studentId
                ],
                contentType: JSON,
        headers: ["auth-token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYXdpZCIsInJvbGVzIjoidXNlciIsImlhdCI6MTYwNjA2MTEwOH0.fMGjj597FdfEnZfcSNjQhhXxTMQMdLvBGLQ-eZF7b_vutB93MyBX2bk86LoPDTFR3iYSsXGluD1X4CBUAY2E0A"])
        then: "should return 200 status and add grades"
        assert response.status == 200
        where:
        grade   |   subject |   studentId
        3.0 |   "TOK"   | 1
        2.0 | "Kryptografia" | 2
        5.0 | "TIJO" | 3
    }
}
