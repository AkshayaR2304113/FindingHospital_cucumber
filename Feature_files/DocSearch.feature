Feature: Finding Hospital

  Scenario: Search Doctors
    Given Opening the browser
    When Provide Location and Specialization of the Doctor
    And Filter by Experience, Patient Stories
    And Retrive first five Doctors
    And Retrive the list of surgeries
    And Validate form by valid and invalid data
    And close the browser
