Feature: Product Search in Shop

Scenario: User searches for a product
    Given the user is on the shop page
    When the user searches for a product "Necklace"
    And the user selects the NECKLACE checkbox
    Then the user should see search results for "Necklace"
