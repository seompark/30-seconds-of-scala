import java.io.{ByteArrayInputStream, File}

import org.scalatest._
import snippets.Snippets

class SnippetsSpec extends FlatSpec with Matchers {
    implicit class TestEach[A, B](x: Vector[(A, B)]) {
        def test(f: (A, B) => _): Unit = {
            x foreach { t => f(t._1, t._2) }
        }
    }

    "gcdVector" should "returns the greatest common denominator of a Vector of numbers." in {
        val cases = Vector (
            Vector(0, 0, 1, 1, 1) -> 1,
            Vector(12, 12, 12, 12) -> 12,
            Vector(18, 24, 36, 48, 60) -> 6,
            Vector(16833, 9593, 9231, 31132) -> 181
        )
        cases test { (input: Vector[Int], answer: Int) =>
            Snippets.gcd(input) shouldEqual answer
        }
    }
    "lcdVector" should "returns the lowest common multiple of a Vector of numbers." in {
        val cases = Vector (
            Vector(0, 0, 1, 1, 1) -> 0,
            Vector(12, 12, 12, 12) -> 12,
            Vector(18, 24, 36, 48, 60) -> 720,
            Vector(128, 291, 491) -> 18288768
        )
        cases test { (input: Vector[Int], answer: Int) =>
            Snippets.lcm(input) shouldEqual answer
        }
    }
    "convertInputStreamToString" should "returns String from InputStream." in {
        val cases = Vector (
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

    "binomialCoefficient" should "returns bionomial coefficient." in {
        val cases = Vector (
            (0, 0) -> 1,
            (5, 3) -> 10,
            (12, 7) -> 792,
            (4, 3) -> 4,
            (4, 2) -> 6
        )
        cases test { (input: (Int, Int), answer: Int) =>
            Snippets.binomialCoefficient _ tupled input shouldEqual answer
        }
    }

    "indexOf" should "find index of element in the Vector." in {
        val cases = Vector(
            (Vector(2, 3, 5, 9), 3) -> Some(1),
            (Vector(9, 1, 2, 3), 2) -> Some(2),
            (Vector(0, 0, 1, 1), 1) -> Some(2), // should returns first index that is found in Vector.
            (Vector(1, 9, 7, 2), 3) -> None // should returns None if element not found.
        )
        cases test { (input: (Vector[Int], Int), answer: Option[Int]) =>
            Snippets.indexOf _ tupled input shouldEqual answer
        }
    }

    "chunk" should "breaks into array with given length." in {
        val cases = Vector(
            (Vector(1, 3, 5, 8, "hello"), 2) -> Vector(Vector(1, 3), Vector(5, 8), Vector("hello")),
            (Vector(1, 3, 5, 8, 11), 3) -> Vector(Vector(1, 3, 5), Vector(8, 11)),
            (Vector(1, 3, 5, 8, "hi", 20), 2) -> Vector(Vector(1, 3), Vector(5, 8), Vector("hi", 20))
        )
        cases test { (input: (Vector[Any], Int), answer: Vector[Vector[Any]]) =>
            Snippets.chunk[Any] _ tupled input shouldEqual answer
        }
    }
}
