Rules to set up Page Object Model:
============================
1. Create BaseClass(ProjectSpecificMethods) for common methods and variables
2. Create separate java class for each page that you navigate in the application
3. Create methods for each action / verification in the respective java classes
4. All the java classes for pages should extends BaseClass (PSM)
5. Each method should have the return type based on the control
6. Create separate java class for each test case
7. All the test cases should extends BaseClass(PSM)

Configuration for Parallel Execution:
============================
1. Remove static declaration for driver
2.Create public parameterized constructor in all the pages with ChromeDriver as argument
3. Pass driver in all the constructor call
