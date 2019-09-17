Feature: Character Creation

  Background:
    Given a new game starts

  Scenario: A character is created at level 1, with 1000 health and alive
    When character "linuar" is created
    Then character "linuar" should be level 1
    Then character "linuar" should have 1000 health
    Then character "linuar" should be alive
    Then character "linuar" should be a member of no faction