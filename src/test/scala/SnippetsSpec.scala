import org.scalatest._
import snippets.Snippets

class SnippetsSpec extends FlatSpec with Matchers {
    "gcdSeq" should "returns the greatest common denominator of a Seq of numbers." in {
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
    "lcdSeq" should "returns the lowest common multiple of a Seq of numbers."in {
        val cases = List (
            Seq(0, 0, 1, 1, 1) -> 0,
            Seq(12, 12, 12, 12) -> 12,
            Seq(18, 24, 36, 48, 60) -> 720,
            Seq(128, 291, 491) -> 18288768
        )
        cases foreach { t =>
            Snippets.lcmSeq(t._1) shouldEqual t._2
        }
    }
}
