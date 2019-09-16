Feature: Characters may heal characters

  Background:
    Given a new game starts
    And character "linuar" is created
    And character "carrie" is created

  Scenario: healing received is added to health
    Given character "linuar" has 800 health
    When character "linuar" heals character "linuar" for a value of 100
    Then character "linuar" should have 900 health

  Scenario: the dead may not be healed
    Given character "linuar" is dead
    When character "linuar" heals character "linuar" for a value of 100
    Then character "linuar" should have 0 health
    Then character "linuar" should be dead

  Scenario: healed character may not be raise her health above 1000
    Given character "linuar" has 900 health
    When character "linuar" heals character "linuar" for a value of 200
    Then character "linuar" should have 1000 health

  Scenario: a character may not heal another character
    Given character "carrie" has 900 health
    When character "linuar" heals character "carrie" for a value of 100
    Then character "carrie" should have 900 health