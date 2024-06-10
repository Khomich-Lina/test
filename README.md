# Player controller - QA Automation (API)

As a result of preparation the test cases table was created and you can see it in `TestCases-playerController.xlsx` file

---

**To run this project:**

1. Install Java 11+
2. Install Gradle
3. Run `./gradlew clean test` or `./gradlew clean test -Dtest.threadCount=5` to specify thread count different from standard **3**

After the test run, you can generate an Allure report from the `build/allure-results` directory

---

TestNG config is located in `src/main/resources/testng.xml`
Log config is located in `src/main/resources/log4j2.properties`

---

## OpenAPI DTOs Generation

The project attempted to configure OpenAPI DTOs generation for better API testing and documentation. However, this setup is currently incomplete. To finish this setup, further configuration of the OpenAPI Generator is required. The generator can be configured in the `build.gradle` file under the `openApiGenerate` task.

For more information on how to complete this setup, refer to the [OpenAPI Generator documentation](https://openapi-generator.tech/docs/generators/java/).

