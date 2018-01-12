# little scala functions [![Build Status](https://travis-ci.org/a1p4ca/little-scala-functions.svg?branch=master)](https://travis-ci.org/a1p4ca/little-scala-functions)
> Curated collection of useful little scala functions that you can understand quickly.

## Table of Contents

### Math

<details>
<summary>View contents</summary>

* [`gcdSeq`](#gcdSeq)
* [`lcmSeq`](#lcmSeq)

</details>

---

## Math

### gcdSeq

Calculates the greatest common denominator (gcd) of an Seq of numbers.

```scala
def gcdSeq(numbers: Seq[Int]): Int = numbers reduce gcd

def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
```

### lcmSeq

Calculates the lowest common multiple (lcm) of an array of numbers.

```scala
def lcmSeq(numbers: Seq[Int]): Int = {
    def lcm(a: Int, b: Int) = {
        val g = gcd(a, b)
        if (g == 0) 0 else a * b / g
    }
    numbers reduce lcm
}
```

## Thanks

This project is inspired by shekhargulati's [little-java-functions](https://github.com/shekhargulati/little-java-functions).
And his project is started as a Java fork of [30-seconds-of-code](https://github.com/Chalarangelo/30-seconds-of-code)

I'm planning to start implementing functions in little-java-functions project in Scala style.
After that, I'll write my own functions. This project is just for my study and welcome PR and Issue for my bad implementation.
