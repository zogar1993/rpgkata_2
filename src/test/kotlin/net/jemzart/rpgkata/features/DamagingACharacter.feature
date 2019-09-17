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

  Scenario Outline: a character deals normal damage to targets with a level difference of less than 5 (<attacker_level>-<target_level>)
    Given character "linuar" is level <attacker_level>
    Given character "carrie" is level <target_level>
    When character "linuar" deals 100 damage to character "carrie"
    Then character "carrie" should have received 100 damage
    Examples:
      | attacker_level | target_level |
      | 1              | 1            |
      | 1              | 5            |
      | 5              | 1            |

  Scenario Outline: a character deals 50% more damage to targets 5 or more levels below (<attacker_level>-<target_level>)
    Given character "linuar" is level <attacker_level>
    Given character "carrie" is level <target_level>
    When character "linuar" deals 100 damage to character "carrie"
    Then character "carrie" should have received 150 damage
    Examples:
      | attacker_level | target_level |
      | 6              | 1            |
      | 7              | 1            |
      | 7              | 2            |

  Scenario Outline: a character deals 50% less damage to targets 5 or more levels above (<attacker_level>-<target_level>)
    Given character "linuar" is level <attacker_level>
    Given character "carrie" is level <target_level>
    When character "linuar" deals 100 damage to character "carrie"
    Then character "carrie" should have received 50 damage
    Examples:
      | attacker_level | target_level |
      | 1              | 6            |
      | 1              | 7            |
      | 2              | 7            |