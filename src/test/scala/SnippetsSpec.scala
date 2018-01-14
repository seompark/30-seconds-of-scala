import java.io.{ByteArrayInputStream, File}

import org.scalatest._
import snippets.Snippets

class SnippetsSpec extends FlatSpec with Matchers {
    implicit class TestEach[A, B](x: Seq[(A, B)]) {
        def test(f: (A, B) => _): Unit = {
            x foreach { t => f(t._1, t._2) }
        }
    }

    "gcdSeq" should "returns the greatest common denominator of a Seq of numbers." in {
        val cases = List (
            Seq(0, 0, 1, 1, 1) -> 1,
            Seq(12, 12, 12, 12) -> 12,
            Seq(18, 24, 36, 48, 60) -> 6,
            Seq(16833, 9593, 9231, 31132) -> 181
        )
        cases test { (input: Seq[Int], answer: Int) =>
            Snippets.gcdSeq(input) shouldEqual answer
        }
    }
    "lcdSeq" should "returns the lowest common multiple of a Seq of numbers." in {
        val cases = List (
            Seq(0, 0, 1, 1, 1) -> 0,
            Seq(12, 12, 12, 12) -> 12,
            Seq(18, 24, 36, 48, 60) -> 720,
            Seq(128, 291, 491) -> 18288768
        )
        cases test { (input: Seq[Int], answer: Int) =>
            Snippets.lcmSeq(input) shouldEqual answer
        }
    }
    "convertInputStreamToString" should "returns String from InputStream." in {
        val cases = List (
            "Hello, world!",
            "Hi Hello",
            "Test case",
            "little scala functions"
        ) map { i => new ByteArrayInputStream(i.getBytes) -> i }
        cases test { (input: ByteArrayInputStream, answer: String) =>
            Snippets.convertInputStreamToString(input) shouldEqual answer
        }
    }

    "readFileAsString" should "returns String from file" in {
        val input = new File("src/test/resources/TestTextFile.txt")
        val answer =
                "Hello, this is test file." +
                "I love javascript, scala, and functional programming." +
                "I'm a highschool student in Korea." +
                "Thank you so much."

        Snippets.readFileAsString(input) shouldEqual answer
    }
}
