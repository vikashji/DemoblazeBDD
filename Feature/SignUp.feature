@tag
	Feature: SignUp	

  Scenario: Verify User is able to Signup with Valid credentials
    Given user Launch Chrome Browser 
    And User opens url "https://demoblaze.com/"
    When User enter New Username as "Newuser3@D10198" and Password as "admin123"
    Then Alert message should be "Sign up successful."
    
  Scenario: Verify User is unable to Signup with existing credentials
    Given user Launch Chrome Browser 
    And User opens url "https://demoblaze.com/"
    When  User enter existing Username as "Test1@D10198" and Password as "admin123"
    Then With Invalid credential Alert message should be "This user already exist."