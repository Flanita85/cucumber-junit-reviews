Feature: Create list


  Scenario: create list
    Given the user is on the login page
    And the user is logged in
    When user can click task icon
    And Click Add to list
    And Enter "TaskTeam3" task and click save
    Then User cans see left drop down menu "TaskTeam3" appear in the School list


  Scenario: Add to task
    Given the user is on the login page
    And the user is logged in
    When user can click task icon
    And Click Add to list
    And Enter "Hopelast1" task and click save
    And Enter your task "Titata"
    Then User can see created task "Titata" in the "Hopelast1" list