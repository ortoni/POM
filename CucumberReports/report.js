$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Login.feature");
formatter.feature({
  "name": "LeafTaps Automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Enter username as DemoSalesManagera",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPage.typeUsername(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter password as crmsfa",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPage.typePassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click login button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPage.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that login is succesful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPage.verifyLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click logout",
  "keyword": "And "
});
formatter.match({
  "location": "HomePage.clickLogOut()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login 2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter username as \u003cusername\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Enter password as \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Click login button",
  "keyword": "When "
});
formatter.step({
  "name": "verify that login is succesful",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "DemoSalesManager",
        "crmsfa"
      ]
    },
    {
      "cells": [
        "DemoCSR",
        "crmsfa"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login 2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Enter username as DemoSalesManager",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPage.typeUsername(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter password as crmsfa",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPage.typePassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click login button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPage.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that login is succesful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPage.verifyLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login 2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Enter username as DemoCSR",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPage.typeUsername(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter password as crmsfa",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPage.typePassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click login button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPage.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that login is succesful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPage.verifyLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});