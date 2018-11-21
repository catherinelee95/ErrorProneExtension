

## The Bug: "Useless Increment in Return Statement"

Developers may sometimes perform mathematical operations in a return statement. However, if the post-increment (e.g. x++) or post-decrement (e.g. x--) operator is used during a return statement, the variable would remain unchanged. The post operator would not be executed. That is, the statement [return x++] would be equivalent to [return x]. This bug may not be apparent to developers initially, but can cause unwanted behaviour.

An simple example of the bug:

```
public int addOne(int x){
  return x++;
}
```

This bug is also referenced by the Spotbugs [https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html] as “DLS: Useless increment in return statement”.

We cover all valid cases of a post-increment and post-decrement being used in a return statement. As post-increment/decrements can only be applied to numberical data types stored in variables, we only cover such cases. Note that when we state variables, this includes variables in both the global and local scopes. 


### Valid instances of a ‘useless increment in return statement’ bug:
1. A single variable being post incremented/decremented (e.g. x++ or x--)

```
public int subtractOne(int x){
  return x--;
}
```
2. A variable being post incremented/decremented within a more complex expression(e.g. (x++ - y) or (y + x++))

```
public int calculate(int x, int y){
  return y + x++;
}
```
3. Either case (1) or (2) involved in a type cast

```
public int subtractOne(double x){
  return (int)x--;
}
```

4. Any of the above cases involving parentheses. 

```
public int subtractOne(double x){
  return ((int)x)--;
}
```

### Invalid instances of the return statement bug:
1. A return statement returning a string that contains  a post-increment/decrement (e.g. return “c++”)

```
public String getLanguage(){
  return "c++";
}
```

2. Any return statement that does not contain any post-increment/decrement.

```
public int subtractOne(int x){
  return --x;
}
```

### Uncompilable instances:

As the following instances cannot be compiled, our bug checker does not detect them. We do not consider them to be valid instances of our bug.

1. The result of a method being post-incremented/decremented

```
public int addFoo(){
  return foo()++;
}
```

2. An numerical value not stored in a variable being post-incremented/decremented

```
public int addOne(){
  return 1++;
}
```

