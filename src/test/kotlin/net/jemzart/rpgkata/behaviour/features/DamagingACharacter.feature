Feature: Characters may deal damage to characters

  Background:
    Given a new game starts
    Given character "linuar" is created
    Given character "carrie" is created

  Scenario: damage received is subtracted from health
    Given character "carrie" has 1000 health
    When character "linuar" deals 100 damage to character "carrie"
    Then character "carrie" should have 900 health

  Scenario: receiving current health in damage leaves the character dead
    Given character "carrie" has 1000 health
    When character "linuar" deals 1000 damage to character "carrie"
    Then character "carrie" should have 0 health
    Then character "carrie" should be dead

  Scenario: health may not drop to a value lower than 0
    Given character "carrie" has 1000 health
    When character "linuar" deals 1100 damage to character "carrie"
    Then character "carrie" should have 0 health
    Then character "carrie" should be dead