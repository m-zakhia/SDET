# Project Title:  USD Exchange Rate API Test Framework

## Description

This project, "USD Exchange Rate API Test Framework," is a sophisticated testing suite designed to validate the responses from the USD exchange rate API. Leveraging the power of RestAssured and Serenity, this framework aims to provide a thorough assessment of the API's functionality, focusing on the USD to AED exchange rate.

Key features of this test framework include:

- **API Response Validation**: Ensures successful API calls and checks for valid response structures and data, employing RestAssured for HTTP interactions.
- **Response Status Verification**: Incorporates checks for various API response statuses to ensure the API's robust error handling and success message conveyance.
- **Rate Validation**: Specifically tests the USD to AED rate, ensuring the values fall within the expected range, thus verifying the API's currency conversion accuracy.
- **Performance Checks**: Includes validations for the API's response time, ensuring the API's performance is within acceptable thresholds.
- **Data Integrity**: Validates the presence of essential response elements like timestamps and the correct count of currency pairs, ensuring comprehensive data delivery.
- **Schema Compliance**: Utilizes JSON schema validation to confirm the API's response adheres to the defined structure, ensuring consistency and reliability in the data provided.
- **Extensibility**: Designed with modularity in mind, allowing easy expansion to include more currencies or additional API endpoints.
- **Enhanced Reporting**: Integrates Serenity for enriched reporting and test documentation, providing clear insights into test executions and outcomes, facilitating continuous integration and deployment processes.

This framework serves as an essential tool for developers and testers involved in the maintenance and enhancement of the USD exchange rate API, providing a solid foundation for ensuring the API's reliability and accuracy in delivering critical financial data.


## Step 1: Setting Up the Project in IntelliJ IDEA

1. **Open IntelliJ IDEA**:
   - If you don't have IntelliJ IDEA installed, download and install it from the JetBrains website.
   - Launch IntelliJ IDEA.

2. **Create a New Project**:
   - On the IntelliJ IDEA welcome screen, select "New Project."
   - In the New Project window, choose "Maven" or "Gradle" on the left panel depending on your preference.
   - Ensure the "Java" option is selected and the JDK is set (download a JDK if necessary).
   - Click "Next" to proceed.

3. **Configure Project Details**:
   - Enter your project's "GroupId" (e.g., cloud.digitalchain) and "ArtifactId" (e.g., currency-api-test).
   - Define the project name and location.
   - Click "Finish" to create the project.

4. **POM Configuration**:

This Maven `pom.xml` file is set up for a Java project that performs automated API testing using Serenity BDD with Cucumber and RestAssured. Below is an overview of the key configurations and dependencies:

**Project Identifiers**

- **Group ID**: `cloud.digitalchain`
- **Artifact ID**: `currency-api-test`
- **Version**: `1.0-SNAPSHOT`
- **Packaging**: `jar`

**Properties**

- Java source and target compatibility are set to version 17.
- UTF-8 encoding is specified for project building.
- Versions for Serenity, Cucumber, RestAssured, JUnit, and Maven plugins are managed via properties for easy updates.

**Dependencies**

- **Serenity BDD**: Included for behavior-driven development testing.
- **Serenity Cucumber**: Bridges Serenity BDD with Cucumber for BDD style test cases.
- **Serenity RestAssured**: Extends RestAssured with Serenity BDD reporting features.
- **RestAssured**: Provides capabilities for testing REST APIs.
- **JSON Schema Validator**: Used in conjunction with RestAssured for validating API responses against JSON schemas.
- **JUnit**: The testing framework for writing test cases.

**Build Configuration**

- The `maven-surefire-plugin` is configured to skip the default test phase.
- The `maven-failsafe-plugin` is set up to run integration tests, configured for parallel execution with unlimited threads.
- The `maven-compiler-plugin` sets the Java version for source and target compatibility.
- The `serenity-maven-plugin` is set up for post-integration test phase to generate aggregated Serenity reports.

This `pom.xml` establishes a framework for running robust, automated API tests, ensuring that the application's REST endpoints perform as expected across different scenarios and environments.


   - For Maven: Open the pom.xml file and add dependencies for Cucumber, JUnit, RestAssured, and Serenity. Here's an example of what the dependencies might look like:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cloud.digitalchain</groupId>
    <artifactId>currency-api-test</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <serenity.version>4.0.18</serenity.version>
        <serenity.cucumber.version>4.0.18</serenity.cucumber.version>
        <rest.assured.version>5.3.2</rest.assured.version>
        <junit.version>4.13.2</junit.version>
        <maven.compiler.plugin.version>3.11.0</maven.compiler.plugin.version>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <maven.surefire.plugin.version>3.2.1</maven.surefire.plugin.version>
        <maven.failsafe.plugin.version>3.2.1</maven.failsafe.plugin.version>
        <tags></tags>
    </properties>

    <dependencies>

        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>${serenity.cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-rest-assured</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${rest.assured.version}</version>
            <scope>test</scope>
        </dependency>
        <!-- JSON Schema Validator for RestAssured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>${rest.assured.version}</version> <!-- Make sure this version matches RestAssured's version -->
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>${maven.surefire.plugin.version}</version>
                <configuration>
                    <skip>true</skip>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>${maven.failsafe.plugin.version}</version>
                <configuration>
                    <includes>
                        <include>**/*.java</include>
                    </includes>
                    <parallel>methods</parallel>
                    <useUnlimitedThreads>true</useUnlimitedThreads>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven.compiler.plugin.version}</version>
                <configuration>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
                <dependencies>
                    <dependency>
                        <groupId>net.serenity-bdd</groupId>
                        <artifactId>serenity-single-page-report</artifactId>
                        <version>${serenity.version}</version>
                    </dependency>
                </dependencies>
                <configuration>
                    <tags>${tags}</tags>
                    <reports>single-page-html</reports>
                </configuration>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

- After adding the dependencies, IntelliJ should automatically start downloading them. If it doesn’t, you can trigger a reload of the project.


5. **Enable Annotation Processing (if necessary):**
- Go to “File” > “Settings” > “Build, Execution, Deployment” > “Compiler” > “Annotation Processors.”
- Check “Enable annotation processing.”
- Click “Apply” and “OK.”

6. **Create Base Project Structure:**
- Organize your project with directories for your features, step definitions, and utility classes within the src/test/java and src/test/resources folders.

# Step 2: Project Structure for BDD Testing with Serenity

Proper project structuring is crucial for maintaining a clear and manageable codebase, especially when integrating Serenity for BDD testing. Follow these guidelines to structure your Maven or Gradle project in IntelliJ IDEA.

## Main Source Directory

- **Location**: `src/main/java`
- **Purpose**: Contains the main source code of your application.
- **Note**: Even though the focus is on testing, it's good practice to maintain this standard structure.

## Test Source Directory

- **Location**: `src/test/java`
- **Purpose**: Houses all your test code, including BDD step definitions and supporting Java classes.
- **Structure**:
  - Store your BDD step definitions and any supporting Java classes here.
  - Organize step definitions and helper classes into appropriate packages, for example, `cloud.digitalchain.currencyapitest.steps` and `cloud.digitalchain.currencyapitest.utils`.

## Resource Directories

### Main Resources

- **Location**: `src/main/resources`
- **Purpose**: Stores configuration files and other necessary resources for the application.
- **Note**: This directory might not be heavily used in the context of this project.

### Test Resources

- **Location**: `src/test/resources`
- **Purpose**: Crucial for storing Cucumber feature files.
- **Structure**:
  - Create a `features` directory to contain your `.feature` files.
  - These feature files should define your BDD scenarios using Gherkin syntax.

## Configuring Cucumber with Serenity

Set up a Serenity-enabled Cucumber runner class to benefit from enhanced reporting and test management capabilities:

- **Example `TestRunner` class with Serenity**:

  ```java
  package cloud.digitalchain.currencyapitest;

  import net.serenitybdd.cucumber.CucumberWithSerenity;
  import io.cucumber.junit.CucumberOptions;
  import org.junit.runner.RunWith;

  @RunWith(CucumberWithSerenity.class)
  @CucumberOptions(
      features = "src/test/resources/features",
      glue = "cloud.digitalchain.currencyapitest.steps",
      plugin = {"pretty", "html:target/cucumber-reports"}
  )
  public class TestRunner {
  }
# Step 3: Writing BDD Features and Scenarios with Serenity

For Step 3, we'll focus on writing BDD features and scenarios using Cucumber and Serenity in the IntelliJ IDEA environment. We'll create a feature file that describes the behavior of the USD exchange rate API, with a particular focus on fetching the USD to AED rate and validating various response aspects.

## 1. Create a Feature File

- **Location**: Place your feature file in the `src/test/resources/features` directory.
- **File Creation**: Create a new file named `USDRateValidation.feature`.
- **Content**: Feature files should have the `.feature` extension and contain text written in Gherkin syntax, which can be understood in plain English (or your chosen language).

## 2. Define the Feature and Scenarios

- **Feature Definition**: Start by defining the feature and outlining its purpose. Then, detail the scenarios using Given, When, Then, And steps.

### Example Content for `USDRateValidation.feature`:

```gherkin
Feature: Validate USD exchange rate API responses

  The API at 'https://open.er-api.com/v6/latest/USD' should return valid and accurate exchange rate data for USD against multiple currencies, specifically focusing on the USD to AED rate.

  Scenario: Successful API call returns valid USD to AED rate
    Given I make a request to the USD exchange rate API with Serenity
    When I receive the response
    Then the status code should be 200
    And the response status should indicate success
    And the USD to AED rate should be between 3.6 and 3.7
    And the response should include a timestamp
    And the API response time should be less than 3 seconds
    And the response should contain 162 currency pairs

  Scenario: API returns a failure status
    Given I make a request to the USD exchange rate API with Serenity
    When I receive the response
    Then the response status should indicate failure
    And the error message should be descriptive

  Scenario: Validate JSON schema of the API response
    Given I make a request to the USD exchange rate API with Serenity
    When I receive the response
    Then the response should match the expected JSON schema
```
## 3. Understanding the Gherkin Syntax

-  Given: Sets up the context for the scenario.
-  When: Describes the action that triggers the scenario.
-  Then: Specifies the expected outcome or result.
-  And: Used for adding additional steps while maintaining readability.

## 4. Next Steps

After defining the features and scenarios, the next step involves implementing the step definitions in Java, integrating Serenity to enhance the testing process. These definitions will contain the actual code to interact with the API and assert the expected outcomes, leveraging Serenity's capabilities for richer test context and reporting.

# Step 4: Implementing Step Definitions in Java with Serenity

In Step 4, we'll implement the step definitions in Java for the scenarios defined in the `USDRateValidation.feature` file, integrating Serenity to enhance the testing process.

## 1. Create Step Definitions Java File

- **Location**: In the `src/test/java/cloud/digitalchain/currencyapitest/steps` directory, create a new Java class named `USDRateValidationSteps`.

## 2. Implement Step Definitions

- Implement methods for each step in your feature file within `USDRateValidationSteps.java`.
- These methods should be annotated with `@Given`, `@When`, `@Then`, and `@And` from Cucumber to connect the Java code to the Gherkin steps.
- Below picture depicts the project structure in IntellJ
- ![image](https://github.com/m-zakhia/SDET/assets/126255737/6575078d-799d-44ad-8463-1bbad064dec4)


### Step Definitions Template

```java
package cloud.digitalchain.currencyapitest.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class USDRateValidationSteps {

    private Response response;
    private static final String wrong_URL = "https://open.er-api.com/v6/latest/UUD";
    private static final String correct_URL = "https://open.er-api.com/v6/latest/USD";

    @Given("I make a request to the USD exchange rate API with Serenity")
    public void iMakeARequestToTheUSDExchangeRateAPI() {
        response = SerenityRest.given()
                .when()
                .get(correct_URL);
    }

    @When("I receive the response")
    public void iReceiveTheResponse() {
        // This step may not require any code if the response is already captured in the Given step
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response status should indicate success")
    public void theResponseStatusShouldIndicateSuccess() {
        response.then().body("result", equalTo("success"));
    }

    @Then("the USD to AED rate should be between {float} and {float}")
    public void theUSDToAEDRateShouldBeBetweenAnd(float minRate, float maxRate) {
        response.then().body("rates.AED", allOf(greaterThanOrEqualTo(minRate), lessThanOrEqualTo(maxRate)));
    }

    @Then("the response should include a timestamp")
    public void theResponseShouldIncludeATimestamp() {
        response.then().body("time_last_update_unix", notNullValue());
    }

    @Then("the API response time should be less than {int} seconds")
    public void theAPIResponseTimeShouldBeLessThanSeconds(int seconds) {
        response.then().time(lessThan((long)seconds * 1000));
    }

    @Then("the response should contain {int} currency pairs")
    public void theResponseShouldContainCurrencyPairs(int count) {
        response.then().body("rates.size()", equalTo(count));
    }

    @Then("the response status should indicate failure")
    public void theResponseStatusShouldIndicateFailure() {
        response = SerenityRest.given().contentType("application/json").header("Content-Type", "application/json").when().get(wrong_URL);
        response.then().body("result", not(equalTo("success")));
    }

    @Then("the error message should be descriptive")
    public void theErrorMessageShouldBeDescriptive() {
        response.then().body("error", notNullValue());
    }

    @Then("the response should match the expected JSON schema")
    public void theResponseShouldMatchTheExpectedJSONSchema() {
        // Assume that the JSON schema is stored in src/test/resources/schemas/usd_rate_schema.json
        response.then().body(matchesJsonSchemaInClasspath("schemas/usd_rate_schema.json"));
    }
}
```


1. **Validating the API Call and Response**

- Ensure the API call is successful and returns a valid response. The status code check is already implemented in the step definitions. Additionally, verify that the response body is not empty.

2. **Checking the Response Status**

- Implement steps to check if the response status indicates success or other statuses like FAILURE.

3. **Validating the USD to AED Rate**

- Include a method in the step definitions to verify the USD to AED rate is within the specified range (3.6 - 3.7), ensuring the rate is present and within the expected range.

4. **Response Time Validation**

- Add a step definition to validate that the API response time is less than the specified threshold (e.g., 3 seconds).

5. **Timestamp Verification**

- Verify that the API response includes a timestamp, checking for its presence and possibly validating its format.

6. **Currency Pairs Count Validation**

- Confirm that the API returns data for 162 currency pairs by asserting the size of the rates object in the JSON response.

7. **JSON Schema Validation**

- Utilize RestAssured's schema validation feature to ensure the API response matches the expected JSON schema. Generate a JSON schema from the API response and use it in a step definition.
  
## 3. Connect Steps to Feature File

The Java methods are connected to the steps in your feature file via the annotations. Cucumber, integrated with Serenity, will execute the Java code for each step during the test run.

## 4. Running Your Tests

After implementing the step definitions, run the TestRunner class to execute your feature file scenarios. Serenity enhances the output, showing which steps passed or failed and providing detailed reports.

**maven command**
-  Let's run the code: maven clean install
-  Responses as below:
-  First Scenario successful:
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/d0f40f67-7619-438b-8825-1f1c5eb0c33f)

-  Second Scenario (failed, as eveven with wrong input, the API is either returning a sucess or a Null message without description):
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/ef21e7be-a018-4e16-b150-3d5516ec1ad9)

-  Third Scenario successfull:
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/2fca33f6-3cae-47a2-8a77-562b7e895343)

- Test Results for the 3 Scenarios:
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/f5a19bf3-d0d3-4fd1-8d74-6250aaccdf50)

## Step 5: SERENITY REPORTS
**Full Report**: file:///Users/marwanzakhia/Library/CloudStorage/OneDrive-Personal/Desktop/QA_Assesment/SDET/target/site/serenity/index.html

-  Overall test REsult
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/6bd6b73a-88d6-4038-91fe-9f394bdc99c3)
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/71cfc9a9-9b03-4d81-9876-6ce6aaa0e164)

-  Reuirements
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/d8d559da-71a3-46e3-94a2-3061db64fe3f)

-  Features
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/0d453ddc-c0a0-46fb-a534-0342ed0f111b)
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/4af50676-5f7b-4bcd-93bb-49d5dc4aca4d)

-  Test Results
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/39faf901-2fba-4165-953a-0736f9693408)
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/7c038652-a849-4149-8006-0b2cca55ba4d)


  **Single Page HTML Summary**: file:///Users/marwanzakhia/Library/CloudStorage/OneDrive-Personal/Desktop/QA_Assesment/SDET/target/site/serenity/serenity-summary.html
  ![image](https://github.com/m-zakhia/SDET/assets/126255737/c6c58cbe-7fdf-494c-92b3-bff9d3fd363e)
