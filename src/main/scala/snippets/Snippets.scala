package snippets

object Snippets {
    /**
      * Calculates the greatest common denominator (gcd) of a Seq of numbers
      * @param numbers Seq of numbers
      * @return gcd of Seq of numbers
      */
    def gcdSeq(numbers: Seq[Int]): Int = {
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
      numbers reduce { gcd }
    }
}
