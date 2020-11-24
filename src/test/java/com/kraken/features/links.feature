Feature: Verification of Links on various pages of Kraken website.

  @Smoke
  Scenario Outline: Verifying broken links in Chrome browser.
    Given we are going to test scenarios in Browser "Chrome"
    Given user navigates to the URL "<urls>" in browser
    Then verify that there are no broken links on the page.

    Examples:
      | urls                          |
#      | https://www.kraken.com                             |
      | https://www.kraken.com/prices |
#      | https://www.kraken.com/doesntexist                 |
#      | https://www.kraken.com/en-us/features/security/pgp |


#  @Smoke @Ignore
#  Scenario Outline: Verifying broken links in Firefox browser.
#    Given we are going to test scenarios in Browser "Firefox"
#    Given user navigates to the URL "<urls>" in browser
#    Then verify that there are no broken links on the page.
#
#    Examples:
#      | urls                          |
##      | https://www.kraken.com                             |
#      | https://www.kraken.com/prices |
##      | https://www.kraken.com/doesntexist                 |
##      | https://www.kraken.com/en-us/features/security/pgp |
#
