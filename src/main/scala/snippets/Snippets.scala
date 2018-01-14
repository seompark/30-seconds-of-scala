package snippets

import java.io.{File, InputStream}

import scala.io.Source


object Snippets {
    /**
      * Calculates the greatest common denominator (gcd) of a Seq of numbers
      * @param numbers Seq of numbers
      * @return gcd of Seq of numbers
      */
    def gcdSeq(numbers: Seq[Int]): Int = numbers reduce gcd

    /**
      * Calculates the lowest common multiple (lcm) of an array of numbers.
      * @param numbers Seq of numbers
      * @return lcm of Seq of numbers
      */
    def lcmSeq(numbers: Seq[Int]): Int = {
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
}
