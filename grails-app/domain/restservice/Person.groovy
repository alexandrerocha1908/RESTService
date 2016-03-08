package restservice

class Person {

    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated

    String personName
    Integer age = 100 // Default

    static constraints = {
    }
}
