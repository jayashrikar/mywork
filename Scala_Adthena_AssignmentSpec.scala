import Scala_Adthena_Assignment._
import org.apache.spark.sql.Row
import org.scalatest.flatspec.AnyFlatSpec

class Scala_Adthena_AssignmentSpec extends AnyFlatSpec with App{
  behavior of "Spark Adthena Assignment"

  val inputBasketData1 = List("Milk", "Milk", "Apples", "Soup", "Soup", "Bread", "Bread")
  // Calculating the number of times an item was repeated in the user's shopping basket
  val countOccurences1 = inputBasketData1.groupBy(identity).mapValues(_.size).toList.map{case (k,v) => Row(k,v)}

  it should "Scala Adthena Assignment Testing" in {
    assert(Scala_Adthena_Assignment.subTotalPrice(countOccurences1, basketData) == 6.5)
  }
  it should "Scala Adthena Assignment Testing2" in {
  assert(Scala_Adthena_Assignment.cartprice == 6.0)
  }

}

