Feature: Characters may join and leave factions

  Background:
    Given a new game starts
    Given character "linuar" is created

  Scenario: a character may join a faction
    When character "linuar" joins faction "Winged Avengers"
    Then character "linuar" should be a member of faction "Winged Avengers"

  Scenario: a character may join two factions at the same time
    Given character "linuar" is a member of the "Winged Avengers" faction
    When character "linuar" joins faction "Underworld"
    Then character "linuar" should be a member of faction "Winged Avengers"
    Then character "linuar" should be a member of faction "Underworld"

  Scenario: a character may leave a faction
    Given character "linuar" is a member of the "Winged Avengers" faction
    When character "linuar" leaves faction "Winged Avengers"
    Then character "linuar" should be a member of no faction