# little scala functions [![Build Status](https://travis-ci.org/a1p4ca/little-scala-functions.svg?branch=master)](https://travis-ci.org/a1p4ca/little-scala-functions)
> Curated collection of useful little scala functions that you can understand quickly.

## Table of Contents

### Array

<details>
<summary>View contents</summary>

* [`chunk`](#chunk)
* [`indexOf`](#indexof)

</details>

### Math

<details>
<summary>View contents</summary>

* [`gcdList`](#gcdList)
* [`lcmList`](#lcmList)
* [`binomialCoefficient`](#binomialcoefficient)

</details>

### I/O

<details>
<summary>View contents</summary>

* [`convertInputStreamToString`](#convertinputstreamtostring)
* [`readFileAsString`](#readfileasstring)

</details>

---

## Array

### chunk

Chunks an List into smaller List of specified size.

```scala
def chunk[T](elements: List[T], size: Int): List[List[T]] = {
    if (elements.lengthCompare(size) <= 0) elements :: Nil
    else (elements take size) :: chunk(elements drop size, size)
}
```

### indexOf

Find first index of element in the List.

```scala
def indexOf[T](elements: List[T], el: T): Option[Int] = {
    val indexes = for ((v, i) <- elements.zipWithIndex if v equals el) yield Some(i)
    if(indexes.isEmpty) None else indexes.head
}
```

## Math

### gcdList

Calculates the greatest common denominator (gcd) of an List of numbers.

```scala
def gcdList(numbers: List[Int]): Int = numbers reduce gcd

def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
```

### lcmList

Calculates the lowest common multiple (lcm) of an array of numbers.

```scala
def lcmList(numbers: List[Int]): Int = {
    def lcm(a: Int, b: Int) = {
        val g = gcd(a, b)
        if (g == 0) 0 else a * b / g
    }
    numbers reduce lcm
}
```

### binomialCoefficient

Compute the [`bionomial coefficient`](https://en.wikipedia.org/wiki/Binomial_coefficient), n C k.

```scala
def binomialCoefficient(n: Int, k: Int): Int = {
    if (k < 0 || k > n) return 0
    if (k == 0 || k == n) return 1

    val j = k min (n - k)
    var c = 1

    for (i <- 0 until j) c = c * (n - i) / (i + 1)
    c
}
```

## I/O

### convertInputStreamToString

Converts InputStream to String.

```scala
def convertInputStreamToString(is: InputStream): String = Source.fromInputStream(is).mkString
```

### readFileAsString

Reads string from file.

```scala
def readFileAsString(file: File): String = Source.fromFile(file).getLines.mkString
```

## Thanks

This project is inspired by shekhargulati's [little-java-functions](https://github.com/shekhargulati/little-java-functions).
And his project is started as a Java fork of [30-seconds-of-code](https://github.com/Chalarangelo/30-seconds-of-code).

I'm planning to start implementing functions in little-java-functions project in Scala style.
After that, I'll write my own functions. This project is just for my study and welcome PR and Issue for my bad implementation.
