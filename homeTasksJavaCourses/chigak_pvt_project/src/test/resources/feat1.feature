Feature: mail.ru test scenarios 
 
 Scenario Outline: User marks inbox emails with flag
 When I send <sendEmailsNumber> emails to my Inbox
 And I mark <toBeMarkedEmailsNumber> emails with flag
 Then I see <markedEmailsNumber> emails are displayed with filled flag icon
 Examples:
 |sendEmailsNumber|toBeMarkedEmailsNumber|markedEmailsNumber|
 |2|1|1|
 
 Scenario Outline: User unflags all emails
 When I send <sendEmailsNumber> emails to my Inbox
 And I mark <toBeMarkedEmailsNumber> emails with flag
 And I select all emails and unflag them
 Then I see that there no emails marked with flag
 Examples:
 |sendEmailsNumber|toBeMarkedEmailsNumber|
 |3|2|

 Scenario: User moves email from Inbox to Spam
 When I send email to myself
 And I move email from Inbox to Spam
 Then I see Spam is not empty
	