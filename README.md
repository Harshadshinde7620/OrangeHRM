# OrangeHRM Test Automation Framework

A robust **Selenium WebDriver + Cucumber BDD** automation framework built with **Java, TestNG, and Maven**, following the **Page Object Model (POM)** design pattern. Test scenarios are written in **Gherkin** (plain English), making them readable by both technical and non-technical stakeholders.

Built on the live demo site: [https://opensource-demo.orangehrmlive.com/](https://opensource-demo.orangehrmlive.com/)

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Automation Tool | Selenium WebDriver |
| BDD Framework | Cucumber |
| Test Runner | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Configuration | config.properties |
| Reporting | Cucumber HTML Reports |
| IDE | Eclipse |
| Version Control | Git & GitHub |

---

## 📁 Framework Architecture

```
OrangeHRMProject/
│
├── src/
│   └── test/
│       └── java/
│           ├── features/                  # Gherkin feature files
│           │   ├── login.feature
│           │   ├── dashboard.feature
│           │   └── sideMenu.feature
│           ├── pageObjectModel/           # Page Object classes
│           │   ├── loginPage.java
│           │   ├── AdminPage.java
│           │   ├── SideMenuElementDashboard.java
│           │   └── dashboard/             # Dashboard widget page objects
│           ├── stepDefinations/           # Cucumber step definitions
│           │   ├── StepDefination.java
│           │   └── hooks.java
│           ├── testRunner/                # TestNG Cucumber runner
│           │   └── TestRunner.java
│           └── utilities/                 # Reusable utilities
│               └── webUtils.java
│
├── config.properties                      # Browser, URL, credential configs
└── pom.xml                                # Maven dependencies
```

---

## ✅ Modules & Scenarios Automated

### 1. Login / Authentication (`login.feature`)
```gherkin
Scenario: Valid login with correct credentials
Scenario: Invalid login with wrong password
Scenario: Invalid login with wrong username
```

### 2. Dashboard Widgets (`dashboard.feature`)
```gherkin
Scenario: Verify Time At Work widget visibility and stopwatch
Scenario: Verify Quick Launch widget visibility and clickable links
Scenario: Verify My Actions widget visibility and links
Scenario: Verify Buzz Latest Posts widget visibility and links
```

### 3. Side Menu Navigation (`sideMenu.feature`)
```gherkin
Scenario: Verify visibility of side menu and its options
Scenario: Search side menu element by exact text
Scenario: Search side menu element by partial text
Scenario: Search side menu element by case-insensitive text
Scenario: Search side menu element with blank search text
```

---

## ⚙️ Prerequisites

- Java JDK 8 or higher
- Maven 3.x
- Google Chrome (latest)
- Eclipse IDE (or IntelliJ IDEA)

---

## 🚀 How to Run

### Step 1 – Clone the Repository
```bash
git clone https://github.com/Harshadshinde7620/OrangeHRM.git
cd OrangeHRM
```

### Step 2 – Configure the Application
Open `config.properties` and verify the values:
```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com/
username=Admin
password=admin123
```

### Step 3 – Run Tests via Maven
```bash
mvn clean test
```

### Step 4 – View the Test Report
After execution, open the Cucumber HTML report generated inside the `target/` folder in your browser.

---

## 📊 Sample Test Report

> ![Test Report](assets/report-screenshot.png)

---

## 🔑 Key Framework Features

- **Cucumber BDD (Gherkin):** Test scenarios written in plain English using Given/When/Then syntax — readable by developers, testers, and business stakeholders alike.
- **Page Object Model (POM):** Each page has a dedicated class separating UI locators from test logic, making the framework highly maintainable.
- **Hooks:** `@Before` and `@After` hooks manage WebDriver setup and teardown cleanly before and after each scenario.
- **config.properties:** All environment-specific values are externalized — no hardcoded values in test code.
- **Maven Build Management:** All dependencies managed via `pom.xml` for easy setup on any machine.

---

## 🗺️ Upcoming Improvements

- [ ] Integrate **Extent Reports** with screenshots on scenario failure
- [ ] Add **Data-Driven Testing** using Cucumber `Scenario Outline` + `Examples`
- [ ] Add **REST Assured API automation** for OrangeHRM backend APIs
- [ ] Set up **GitHub Actions CI/CD** pipeline to run tests on every push
- [ ] Expand coverage to PIM and Leave Management modules
- [ ] Implement **parallel execution** across feature files

---

## 👤 Author

**Harshad Chandrakant Shinde**
QA Automation Engineer | 3.5+ Years Experience
📧 harshadshinde.work@gmail.com
🔗 [LinkedIn](https://www.linkedin.com/in/) | [GitHub](https://github.com/Harshadshinde7620)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
