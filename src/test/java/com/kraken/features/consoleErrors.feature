Feature: Verify console errors on various pages on Kraken website.


  Background:
    Given we are going to test scenarios in Browser "Chrome"

  @Smoke
  Scenario Outline: Verifying console errors for different pages.
    Given user navigates to the URL "<urls>" in browser
    Then verify that no console errors are detected on the page.

    Examples:
      | urls                                               |
      | https://www.kraken.com                             |
      | https://www.kraken.com/prices                      |
      | https://www.kraken.com/doesntexist                 |
      | https://www.kraken.com/en-us/features/security/pgp |


