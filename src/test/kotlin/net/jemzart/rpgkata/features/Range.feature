Feature: Dealing damage is affected by range

  Background:
    Given a new game starts
    Given character "linuar" is created
    Given character "carrie" is created

  Scenario Outline: a melee character may deal damage to a character 2 or less meters away (<distance>)
    Given character "linuar" is a "melee" fighter
    Given character "linuar" and character "carrie" are <distance> meters apart
    When character "linuar" deals damage to character "carrie"
    Then character "carrie" should be harmed
    Examples:
      | distance |
      | 0        |
      | 1        |
      | 2        |

  Scenario Outline: a ranged character may deal damage to a character 20 or less meters away (<distance>)
    Given character "linuar" is a "ranged" fighter
    Given character "linuar" and character "carrie" are <distance> meters apart
    When character "linuar" deals damage to character "carrie"
    Then character "carrie" should be harmed
    Examples:
      | distance |
      | 0        |
      | 1        |
      | 19       |
      | 20       |

  Scenario: a melee character may not deal damage to a character more than 2 meters away
    Given character "linuar" is a "melee" fighter
    Given character "linuar" and character "carrie" are 3 meters apart
    When character "linuar" deals damage to character "carrie"
    Then character "carrie" should be unharmed

  Scenario: a ranged character may not deal damage to a character more than 20 meters away
    Given character "linuar" is a "ranged" fighter
    Given character "linuar" and character "carrie" are 21 meters apart
    When character "linuar" deals damage to character "carrie"
    Then character "carrie" should be unharmed