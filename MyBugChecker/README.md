# Error Prone

Error Prone is a static analysis tool for Java that catches common programming
mistakes at compile-time.

## Getting Started

There are two options for setting up error-prone. A fork at [catherinelee95/error-prone](https://github.com/catherinelee95/error-prone.git) is available and already inclues our bug checker. Alternatively,
it is possible to clone the original error-prone project [google/error-prone](https://github.com/google/error-prone).

### Option 1: Setting Up google/error-prone

If you are running from google/error-prone, perform the following steps to set up.
1. Copy or move the file `ReturnPostIncDecChecker.java` containing the implementation of the checker into `error-prone\core\src\main\java\com\google\errorprone\bugpatterns` directory.
2. Copy or move the test file `ReturnPostIncDecCheckerTest.java` into `error-prone\core\src\test\java\com\google\errorprone\bugpatterns` directory.
3. Copy or move the two files to be tested by the checker `ReturnPostIncDecCheckerPositiveCases.java` and `ReturnPostIncDecCheckerNegativeCases.java` into `error-prone\core\src\test\java\com\google\errorprone\bugpatterns\testdata directory.`

### Option 2: Using catherinelee95/error-prone

This fork already includes the the changes discussed in the previous section. To use our bug checker, simply clone the repo
and checkout Post-Inc-Dec-Checker.


```
git clone https://github.com/catherinelee95/error-prone.git
cd error-prone
git checkout Post-Inc-Dec-Checker
```

Then, continue with the Building with Maven step in the following section.

### Building with Maven 

Run the following commands in your root project directory for error-prone to compile and run the test for our bug checker. If you are unable to compile the project, consider updating to the latest version of Java (Java version 11.01).

```
mvn clean
mvn compile
cd core
mvn -Dtest=*ReturnPostIncDecCheckerTest.java test
```

### Running New Test Files

To add new java files to be tested by our bug checker, perform the following steps.

1. To create positive cases, you need to add the `// BUG: Diagnostic contains:` notation at the begining of the method that you wanted to test. On the other hand, negative cases do not need any additional notation or changes to be tested.
```
	// BUG: Diagnostic contains: Do not return int post increment or decrement.
	public int returnsPostInc(int x) {
		return x++;
	}
```

2. Add the new java file to be tested into the `error-prone\core\src\test\java\com\google\errorprone\bugpatterns\testdata` directory.
3. //TODO





