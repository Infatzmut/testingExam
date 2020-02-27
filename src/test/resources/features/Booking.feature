Feature: Begin the process of booking a flight till the complete credit card information page.
  Scenario Outline: Booking a flight without been logged in
    Given User is on home page
    When User selects an "<origin>" and an "<destination>"
    And User selects an exit_date and a return_date
    And User clicks on search button
    Then User must see the available fligths
    Examples:
      | origin | destination |
      | LAS    | LAX         |
