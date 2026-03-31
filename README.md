# OrangeHRM Test Automation Framework

A robust **Selenium WebDriver** automation framework built with **Java, TestNG, and Maven**, following the **Page Object Model (POM)** design pattern. This framework automates functional and regression test scenarios for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/) web application.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Automation Tool | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Configuration | config.properties |
| Reporting | TestNG HTML Reports |
| IDE | Eclipse |
| Version Control | Git & GitHub |

---

## 📁 Framework Architecture

```
OrangeHRM/
│
├── src/
│   └── test/
│       └── java/
│           ├── pages/           # Page Object classes (element locators + page actions)
│           ├── tests/           # TestNG test classes
│           └── utilities/       # Reusable utilities (BaseClass, config reader, etc.)
│
├── testdata/                    # Test data files (Excel / properties)
├── config/
│   └── config.properties        # Browser, URL, and credential configs
├── test-output/                 # Auto-generated TestNG HTML reports
└── pom.xml                      # Maven dependencies and plugin config
```

---

## ✅ Modules Automated

### 1. Login / Authentication
- Valid login with correct credentials
- Invalid login with wrong password
- Invalid login with wrong username
- Empty field validations
- Successful logout

### 2. PIM – Personal Information Management
- Add new employee
- Search employee by name / ID
- Verify employee details on the list
- Edit employee information
- Delete employee record

---

## ⚙️ Prerequisites

Make sure you have the following installed before running the framework:

- Java JDK 8 or higher
- Maven 3.x
- Google Chrome (latest)
- ChromeDriver (matching your Chrome version, or use WebDriverManager)
- Eclipse IDE (or IntelliJ IDEA)

---

## 🚀 How to Run

### Step 1 – Clone the Repository
```bash
git clone https://github.com/Harshadshinde7620/OrangeHRM.git
cd OrangeHRM
```

### Step 2 – Configure the Application
Open `config/config.properties` and set your values:
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
After execution, open the following file in your browser:
```
test-output/index.html
```

---

## 📊 Sample Test Report

> TestNG HTML report showing execution results across Login and PIM modules.
> *(Add a screenshot of your test-output/index.html here)*

---

## 🔑 Key Framework Features

- **Page Object Model (POM):** Each page has a dedicated class with element locators and actions, keeping test logic separate from UI logic.
- **config.properties:** All environment-specific values (URL, credentials, browser) are externalized — no hardcoded values in test code.
- **Reusable Base Class:** Common setup and teardown logic (WebDriver init, browser launch, driver quit) is centralized in a BaseClass.
- **TestNG Annotations:** Tests are organized using `@BeforeClass`, `@AfterClass`, `@Test` for clean execution flow.
- **Maven Build Management:** All dependencies managed via `pom.xml` — no manual jar downloads needed.

---

## 🗺️ Upcoming Improvements

- [ ] Integrate **Extent Reports** with screenshots on test failure
- [ ] Add **Data-Driven Testing** using Excel + TestNG DataProvider
- [ ] Add **REST Assured API automation** for OrangeHRM APIs
- [ ] Set up **GitHub Actions CI/CD** pipeline for automated test runs on push
- [ ] Expand coverage to Leave Management and Recruitment modules
- [ ] Implement **parallel execution** via TestNG XML suite

---

## 👤 Author

**Harshad Chandrakant Shinde**
QA Automation Engineer | 3.5+ Years Experience
📧 harshadshinde.work@gmail.com
🔗 [LinkedIn](https://www.linkedin.com/in/) | [GitHub](https://github.com/Harshadshinde7620)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
