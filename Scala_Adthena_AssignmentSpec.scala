import Scala_Adthena_Assignment._
import org.apache.spark.sql.Row
import org.scalatest.flatspec.AnyFlatSpec

class Scala_Adthena_AssignmentSpec extends AnyFlatSpec {
  behavior of "Spark Adthena Assignment"

    val basketData = List(
      Row("Soup", 0.65),
      Row("Apples", 1.00),
      Row("Milk", 1.30),
      Row("Bread", 0.80)
    )
    val inputBasketData = List("Milk", "Bread","Milk", "Soup", "Apples","Soup")

    // Calculating the number of times an item was repeated in the user's shopping basket
    val countOccurences = inputBasketData.groupBy(identity).mapValues(_.size).toList.map { case (k, v) => Row(k, v) }

    //val subTotalPrice = Scala_Adthena_Assignment.subTotalPrice(countOccurences,basketData)

    // Assingning the counts of Soup and Bread to the respective count variables
    for (i <- 0 until countOccurences.size) {
      for (j <- 0 until countOccurences(i).size) {
        if (countOccurences(i)(j) == "Soup") {
          soupcount = extractInteger(countOccurences(i)(j + 1))
        }
        if (countOccurences(i)(j) == "Bread") {
          breadcount = extractInteger(countOccurences(i)(j + 1))
        }
      }
    }
    var k = 0
    var newprice = 0.0
    bread_discount = (soupcount / 2).toInt
    if (breadcount < bread_discount) {
      bread_discount = breadcount
    }
    bread_remaining = breadcount - (bread_discount)

  it should "Scala Adthena Assignment Testing" in {
    assert(Scala_Adthena_Assignment.subTotalPrice(countOccurences, basketData) == 6.5)
  }
  it should "Scala Adthena Assignment Testing2" in {
    assert(Scala_Adthena_Assignment.cartprice == 6.0)
  }
}
