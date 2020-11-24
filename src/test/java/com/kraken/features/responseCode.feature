Feature: Verification of HTTP response codes on Kraken website.

  @Smoke
  Scenario Outline: Verifying response codes on Chrome browser.
    Given we are going to test scenarios in Browser "Chrome"
#    Given user navigates to the URL "<urls>" in browser
    Then verify that expected response code "<responseCode>" is received when we navigate to url "<urls>".

    Examples:
      | urls                                               | responseCode |
      | https://www.kraken.com                             | 200          |
      | https://www.kraken.com/prices                      | 200          |
      | https://www.kraken.com/doesntexist                 | 404          |
      | https://www.kraken.com/en-us/features/security/pgp | 200          |


