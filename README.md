# Precision Unified Automation Framework

A comprehensive hybrid automation framework that combines API and UI testing capabilities using modern tools and best practices.

## Overview

This framework provides a unified solution for testing web applications through both REST API endpoints and Selenium WebDriver UI automation. Built with Maven multi-module architecture, it supports parallel execution, detailed reporting, and scalable test management.

## Architecture

```
HybridAutomation/
|-- APIAutomation/          # API testing module
|   |-- src/test/java/
|   |   |-- client/         # API client utilities
|   |   |-- config/         # Configuration management
|   |   |-- factory/        # Test data factories
|   |   |-- stepdefinitions/ # Cucumber step definitions (TC1-TC6)
|   |   `-- runner/         # TestNG Cucumber runner
|   |-- src/test/resources/
|   |   |-- features/       # Cucumber feature files
|   |   `-- schemas/       # JSON schema validation
|   `-- testng-api.xml      # TestNG configuration
|
|-- UIAutomation/           # UI testing module
|   |-- src/test/java/
|   |   |-- PageObjects/    # Selenium Page Object Model
|   |   |-- constants/      # Test constants
|   |   |-- stepdefinitions/ # Cucumber step definitions (TC1-TC5)
|   |   `-- runner/         # TestNG Cucumber runner
|   |-- src/test/resources/
|   |   `-- Feature/        # Cucumber feature files
|   `-- testng-ui.xml       # TestNG configuration
|
|-- Common/                  # Shared utilities module
|   |-- src/main/java/       # Common utilities
|   `-- src/test/resources/ # Shared resources
|
|-- pom.xml                  # Parent Maven configuration
|-- testng.xml              # Unified test execution
`-- README.md               # This file
```

## Features

### API Automation
- **RESTful API Testing** with RestAssured
- **JSON Schema Validation** for response verification
- **Test Data Management** with factory pattern
- **Configuration-driven** testing via properties
- **Parallel Execution** support
- **Allure Reporting** integration

### UI Automation
- **Selenium WebDriver** for cross-browser testing
- **Page Object Model** design pattern
- **Cucumber BDD** framework
- **Extent Reports** for detailed test reporting
- **WebDriver Manager** for automatic driver management
- **Parallel Test Execution**

### Shared Features
- **Maven Multi-Module** architecture
- **TestNG** test runner
- **Cucumber** BDD framework
- **Log4j2** logging framework
- **Apache POI** for Excel operations
- **SLF4J** logging facade

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- Chrome Browser (for UI tests)
- IDE (Eclipse/IntelliJ)

## Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/sailubandi/Precision-Unified-Automation-Framework.git
cd Precision-Unified-Automation-Framework
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run All Tests
```bash
# Execute both API and UI tests
mvn clean test

# Or with failure tolerance (recommended)
mvn clean test -Dmaven.test.failure.ignore=true
```

### 4. Run Individual Modules

#### API Tests Only
```bash
cd APIAutomation
mvn clean test -Dtestng.xml=testng-api.xml
```

#### UI Tests Only
```bash
cd UIAutomation
mvn clean test -Dtestng.xml=testng-ui.xml
```

## Test Scenarios

### API Test Cases (TC1-TC6)
- **TC1**: Get All Products List
- **TC2**: Get Single Product Details by Search
- **TC3**: Create New User Account
- **TC4**: Delete User Account
- **TC5**: Update User Account
- **TC6**: Negative Validation Tests

### UI Test Cases (TC1-TC5)
- **TC1**: User Registration Flow
- **TC2**: User Login Flow
- **TC3**: Invalid Login Validation
- **TC4**: Add Products to Cart
- **TC5**: Remove Products from Cart

## Configuration

### API Configuration
Edit `APIAutomation/src/test/resources/config.properties`:
```properties
# API endpoints
api.base.url=https://api.example.com
api.timeout=10000

# Test data
test.user.name=Test User
test.user.email=test@example.com
```

### UI Configuration
Edit `UIAutomation/src/test/resources/config.properties`:
```properties
# Browser settings
browser=chrome
headless=false
implicit.wait=10

# Application URL
app.url=https://example.com
```

## Reports

### TestNG Reports
- Location: `target/surefire-reports/`
- Format: HTML and XML

### Cucumber Reports
- Location: `target/cucumber-reports/`
- Format: HTML and JSON

### Allure Reports (API)
- Location: `target/allure-results/`
- Generate with: `allure serve target/allure-results`

### Extent Reports (UI)
- Location: `target/extent-reports/`
- Format: Interactive HTML

## Parallel Execution

The framework supports parallel execution at multiple levels:

### Test Level Parallelism
```xml
<suite name="Test Suite" parallel="tests" thread-count="3">
```

### Scenario Level Parallelism
```java
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}
```

## Best Practices

### Code Organization
- Follow Page Object Model for UI tests
- Use factory pattern for test data
- Implement proper exception handling
- Maintain consistent naming conventions (TC1, TC2, etc.)

### Test Data Management
- Externalize test data in properties files
- Use data factories for complex objects
- Implement data-driven testing with Cucumber DataTables

### Reporting
- Include meaningful test descriptions
- Add proper assertions and error messages
- Utilize logging for debugging
- Generate comprehensive test reports

## Troubleshooting

### Common Issues

1. **Browser Driver Issues**
   - Ensure WebDriverManager is properly configured
   - Check browser compatibility

2. **ClassPath Issues**
   - Run `mvn clean install` before execution
   - Verify Maven dependencies

3. **Test Failures**
   - Check logs in `target/surefire-reports/`
   - Verify test data and configuration

### Debug Mode
Enable debug logging:
```bash
mvn test -Dmaven.test.debug=true
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

- **Maintainer**: Veeva Automation Team
- **Email**: automation@veeva.com
- **GitHub**: https://github.com/sailubandi/Precision-Unified-Automation-Framework

## Acknowledgments

- [Selenium WebDriver](https://selenium.dev/) for UI automation
- [RestAssured](https://rest-assured.io/) for API testing
- [Cucumber](https://cucumber.io/) for BDD framework
- [TestNG](https://testng.org/) for test execution
- [Maven](https://maven.apache.org/) for build management
