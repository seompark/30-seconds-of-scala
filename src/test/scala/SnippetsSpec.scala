import org.scalatest._
import snippets.Snippets

class SnippetsSpec extends FlatSpec with Matchers {
    "gcdSeq" should "returns the greatest common denominator of a seq of numbers " in {
        val cases = List (
            Seq(0, 0, 1, 1, 1) -> 1,
            Seq(12, 12, 12, 12) -> 12,
            Seq(18, 24, 36, 48, 60) -> 6,
            Seq(16833, 9593, 9231, 31132) -> 181
        )
        cases foreach { t =>
            Snippets.gcdSeq(t._1) shouldEqual t._2
        }
    }
}
