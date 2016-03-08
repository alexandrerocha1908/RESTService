package restservice

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional

import grails.rest.RestfulController

class PersonController extends RestfulController {

    static responseFormats = ['json', 'xml']

    PersonController() {
        super(Person)
    }
}
