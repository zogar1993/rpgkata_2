Feature: Characters may deal damage to characters

  Background:
    Given a new game starts
    Given character "linuar" is created
    Given character "carrie" is created

  Scenario: damage dealt to a character is subtracted from her health
    Given character "carrie" has 1000 health
    When character "linuar" deals 100 damage to character "carrie"
    Then character "carrie" should have 900 health

  Scenario: dealing a character her current health in damage leaves her dead
    Given character "carrie" has 1000 health
    When character "linuar" deals 1000 damage to character "carrie"
    Then character "carrie" should have 0 health
    Then character "carrie" should be dead

  Scenario: damaging a character may not drop her health to a value lower than 0
    Given character "carrie" has 1000 health
    When character "linuar" deals 1100 damage to character "carrie"
    Then character "carrie" should have 0 health
    Then character "carrie" should be dead

  Scenario: a character may not deal damage to herself
    Given character "linuar" has 1000 health
    When character "linuar" deals 100 damage to character "linuar"
    Then character "linuar" should be unharmed

  Scenario Outline: a character of level <attacker_level> deals <percentage>% damage to a character of level <target_level>
    Given character "linuar" is level <attacker_level>
    Given character "carrie" is level <target_level>
    When character "linuar" deals 100 damage to character "carrie"
    Then character "carrie" should have received <percentage>% of 100 damage
    Examples:
      | attacker_level | target_level | percentage |
      | 1              | 1            | 100        |
      | 1              | 5            | 100        |
      | 5              | 1            | 100        |
      | 1              | 6            |  50        |
      | 1              | 7            |  50        |
      | 2              | 7            |  50        |
      | 6              | 1            | 150        |
      | 7              | 1            | 150        |
      | 7              | 2            | 150        |