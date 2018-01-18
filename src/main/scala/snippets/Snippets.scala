package snippets

import java.io.{File, InputStream}

import scala.io.Source

object Snippets {
    /**
      * Calculates the greatest common denominator (gcd) of a List of numbers
      * @param numbers List of numbers
      * @return gcd of List of numbers
      */
    def gcdList(numbers: List[Int]): Int = numbers reduce gcd

    /**
      * Calculates the lowest common multiple (lcm) of an array of numbers.
      * @param numbers List of numbers
      * @return lcm of List of numbers
      */
    def lcmList(numbers: List[Int]): Int = {
        def lcm(a: Int, b: Int) = {
            val g = gcd(a, b)
            if (g == 0) 0 else a * b / g
        }
        numbers reduce lcm
    }

    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    /**
      * Converts InputStream to String.
      * @param is
      * @return string from InputStream.
      */
    def convertInputStreamToString(is: InputStream): String = Source.fromInputStream(is).mkString

    /**
      * Reads string from file.
      * @param file
      * @return string from file.
      */
    def readFileAsString(file: File): String = Source.fromFile(file).getLines.mkString

    /**
      * Compute the bionomial coefficient, n C k.
      * @param n
      * @param k
      * @return
      */
    def binomialCoefficient(n: Int, k: Int): Int = {
        if (k < 0 || k > n) return 0
        if (k == 0 || k == n) return 1

        val j = k min (n - k)
        var c = 1

        for (i <- 0 until j)
            c = c * (n - i) / (i + 1)
        c
    }

    /**
      * Find first index of element in the List.
      * @param xs
      * @param el
      * @tparam T
      * @return Option of Index of element which is found in List.
      */
    def indexOf[T](xs: List[T], el: T): Option[Int] = {
        val indexes = for ((v, i) <- xs.zipWithIndex if v equals el) yield Some(i)
        if(indexes.isEmpty) None else indexes.head
    }

    /**
      * Chunks an List into smaller List of specified size.
      * @param xs
      * @param size
      * @tparam T
      * @return
      */
    def chunk[T](xs: List[T], size: Int): List[List[T]] = {
        if (xs.lengthCompare(size) <= 0) xs :: Nil
        else (xs take size) :: chunk(xs drop size, size)
    }
}
