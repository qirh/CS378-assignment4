# CS378 Modern Web Apps. Assignment 4 (REST API) [![MIT license](https://img.shields.io/badge/license-MIT-lightgrey.svg)](https://https://raw.githubusercontent.com/qirh/CS378-assignment4/master/LICENSE)

## Description
Modern Web Applications Assignment#4. Done for CS 378, taught by Dr. Devdatta Kulkarni in the fall of 2016. 

* [Assignment details](https://github.com/qirh/CS378-assignment4/blob/master/assignment4.pdf)

* [Course Syllabus](https://github.com/qirh/CS378-assignment4/blob/master/syllabus.pdf)

## Instructions
Import this project in Eclipse and deploy it. You can try following URLs to check the functionality of this application

    --host=fall-2016.cs.utexas.edu -u almto3 -pPxWHQV5wg5
    curl -i --data "<project><name>curl</name><description>testing post on curl</description></project>" -H "Content-Type: application/xml" -X POST http://localhost:8080/assignment4/myeavesdrop/projects/
    curl -i --data "<project><name>curl</name><description>testing poswewerwerwert on curl</description></project>" -H "Content-Type: application/xml" -X PUT http://localhost:8080/assignment4/myeavesdrop/projects/5
    curl -i -X GET http://localhost:8080/assignment4/myeavesdrop/projects/7
    curl -i -X GET http://localhost:8080/assignment4/myeavesdrop/projects/7