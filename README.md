
# Nordea

Prepare TestNG automated tests in a suite named: FAR.xml
Manage this project via Maven but be able to run it from IntelliJ editor in a class view.

Set one parameter that can change for each run - param name: gender.
Let it have a default value and be set according to active maven profile.

Create one api test and one gui test that accesses a website:
https://randomuser.me/

For GUI:
check if all 6 values present under element with id = user_value. Use XPath only.
Print all those values as a csv row in a new file (unique for each run).

For API:
pass gender param to the test
obtain 10 generated users' names and logins having given gender
serialize them into a list of records stored in a List<User> collection

