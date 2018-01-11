package snippets

object Snippets {
    /**
      * Calculates the greatest common denominator (gcd) of a Seq of numbers
      * @param numbers Seq of numbers
      * @return gcd of Seq of numbers
      */
    def gcdSeq(numbers: Seq[Int]): Int = {
      numbers reduce { gcd }
    }

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
        numbers reduce { lcm }
    }

    /**
      * Get gcd using pattern matching
      *
      * However, the simplest way to get gcd in Scala:
      * {{{
      *   if(b == 0) a else gcd(b, a % b)
      * }}}
      * But I just want to use pattern matching to show scala pattern matching.
      * I prefer using pattern matching in this project if function can be solved with it.
      *
      * @param a
      * @param b
      * @return gcd of a and b
      */
    def gcd(a: Int, b: Int): Int = b match {
        case 0 => a
        case _ => gcd(b, a % b)
    }


}
