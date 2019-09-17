Feature: Characters may deal damage to things

  Background:
    Given a new game starts
    Given character "linuar" is created
    Given thing "chair" is created with 1000 health

  Scenario: damage dealt to a thing is subtracted from its health
    Given thing "chair" has 1000 health
    When character "linuar" deals 100 damage to thing "chair"
    Then thing "chair" should have 900 health
    Then thing "chair" should not be destroyed

  Scenario: dealing a thing its current health in damage leaves it destroyed
    Given thing "chair" has 1000 health
    When character "linuar" deals 1000 damage to thing "chair"
    Then thing "chair" should have 0 health
    Then thing "chair" should be destroyed

  Scenario: damaging a thing may not drop its health to a value lower than 0
    Given thing "chair" has 1000 health
    When character "linuar" deals 1100 damage to thing "chair"
    Then thing "chair" should have 0 health
    Then thing "chair" should be destroyed