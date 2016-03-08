import restservice.City
import grails.util.Environment
import restservice.Person

class BootStrap {

    def init = { servletContext ->

        def result = '################## running in UNCLEAR mode.'
        println "Application starting ... "
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                result = 'now running in DEV mode.'
                seedTestData()
                break;
            case Environment.TEST:
                result = 'now running in TEST mode.'
                break;
            case Environment.PRODUCTION:
                result = 'now running in PROD mode.'
                seedProdData()
                break;
        }
        println "current environment: $Environment.current"
        println "$result"
    }

    def destroy = {
        println "Application shutting down... "
    }

    private void seedTestData() {
        println "Start loading cities into database"
        def city = new City(cityName: 'Carmel Valley', postalCode: "92130", countryCode: 'USA')
        assert city.save(failOnError:true, flush:true, insert: true)
        city.errors = null

        city = new City(cityName: 'Berlin', postalCode: "10115", countryCode: 'DE')
        assert city.save(failOnError:true, flush:true, insert: true)
        city.errors = null

        assert City.count == 2;
        println "Finished loading $City.count cities into database"

        println "Loading people into the database"
        def person = new Person(personName: 'Paul Bartlett', age: 51)
        person.save(failOnError:true, flush:true, insert: true)
        person.errors = null

        person = new Person(personName: 'Fauzia Bartlett', age: 49)
        person.save(failOnError:true, flush:true, insert: true)
        person.errors = null

        println "There are ${Person.count} people loaded"
    }
}
