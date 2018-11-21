# Error Prone

Error Prone is a static analysis tool for Java that catches common programming
mistakes at compile-time.

## Getting Started

There are two options for setting up error-prone. A fork at [catherinelee95/error-prone](https://github.com/catherinelee95/error-prone.git) is available and already set up. Alternatively,
it is possible to clone the original error-prone project [google/error-prone](https://github.com/google/error-prone).

### Option 1: Setting Up google/error-prone

If you are running from google/error-prone, perform the following steps to set up.


### Option 2: Using catherinelee95/error-prone

This fork already includes the the changes discussed in the previous section. To use our bug checker, simply clone the repo
and checkout Post-Inc-Dec-Checker.


```
git clone https://github.com/catherinelee95/error-prone.git
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

### Running New Files




