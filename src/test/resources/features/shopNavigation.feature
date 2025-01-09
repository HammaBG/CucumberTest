Feature: Shop Page Filters

  Scenario: User selects NECKLACE filter and interacts with the favorite item
    Given the user is on the home page
    And the user navigates to the shop page
    And the user selects the NECKLACE checkbox
    And the user clicks on the heart icon to add the necklace to favorites
    Then the user is navigated to the favorites page
    And the user clicks on a favorite item
    Then the user is navigated to the item's details page
   
