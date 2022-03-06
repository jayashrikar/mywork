import org.apache.spark.sql._
import scala.io.StdIn.readLine

object Scala_Adthena_Assignment {
  def main(args: Array[String]): Unit = {
    println("SubTotal: £"+subTotalPrice(countOccurences,basketData))

    // Checking if there is an offer or not and also calculating the final total price present in the basket after discount
    for (i <- 0 until countOccurences.size) {
      for (j <- 0 until basketData.size) {
        if (countOccurences(i)(k) == basketData(j)(k)) {
          if (countOccurences(i)(k) == "Apples") {
            println("Apples 10% off: " + countOccurences(i)(k + 1) + "*10p")
            newprice = extractDouble(countOccurences(i)(k + 1)) * (extractDouble(basketData(j)(k + 1)) - (extractDouble(basketData(j)(k + 1)) * 0.1))
          }
          else if (soupcount >= 2 && breadcount >= 1 && countOccurences(i)(k) == "Bread") {
            println("Buy 2 Soups and get one Bread for half price")
            newprice = ((extractDouble(basketData(j)(k + 1)) * bread_discount) / 2) + (extractDouble(basketData(j)(k + 1)) * bread_remaining)

          }
          else {
            newprice = extractInteger(countOccurences(i)(k + 1)) * extractDouble(basketData(j)(k + 1))
          }
          cartprice += newprice
        }
      }
    }

    if (BigDecimal(cartprice).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble==subTotalPrice(countOccurences,basketData)){
      println("No offers available")
    }
    println("Total price: £"+BigDecimal(cartprice).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }
    // Defining a list of items and their prices
    val basketData = List(
      Row("Soup", 0.65),
      Row("Apples", 1.00),
      Row("Milk", 1.30),
      Row("Bread", 0.80)
    )

    //Pass the input basket items during run time from the user
    val items = readLine("priceBasket ")

    //Converting the input liat provided by the user into List type
    val inputBasketList = items.split(" ").toList

    //Initializing required variables for further processing
    var cartprice = 0.0
    var soupcount = 0
    var breadcount = 0
    var bread_discount = 0.0
    var bread_remaining= 0.0

    // Extract double type for Any format for making sure the mathematical operations can be performed in calculating new/total price of the items
    def extractDouble(x: Any): Double = x match {
      case n: java.lang.Number => n.doubleValue()
      case _ => 0.0
    }
    // Extract double type for Any format for making sure the mathematical operations can be performed in calculating new/total price of the items
    def extractInteger(x: Any): Int = x match {
      case n: java.lang.Number => n.intValue()
      case _ => 0
    }

    // Calculating the number of times an item was repeated in the user's shopping basket
    val countOccurences = inputBasketList.groupBy(identity).mapValues(_.size).toList.map{case (k,v) => Row(k,v)}

    // Assingning the counts of Soup and Bread to the respective count variables
    for (i<- 0 until countOccurences.size) {
      for (j <- 0 until countOccurences(i).size) {
        if (countOccurences(i)(j)== "Soup"){
          soupcount = extractInteger(countOccurences(i)(j+1))
        }
        if (countOccurences(i)(j)=="Bread") {
          breadcount = extractInteger(countOccurences(i)(j+1))
        }
      }
    }

    var k = 0
    var newprice = 0.0
    bread_discount = (soupcount / 2).toInt
    if (breadcount<bread_discount) {
      bread_discount=breadcount
    }
    bread_remaining=breadcount-(bread_discount)

    //Calculating the SubTotal price of the basket before discount
    def subTotalPrice(countOccurences: List[Row],basketData:List[Row]): Double = {
      var SubTotal = 0.0
      for (i <- 0 until countOccurences.size) {
        for (j <- 0 until basketData.size) {
          if (basketData(j)(k) == countOccurences(i)(k)) {
            val individualItemsTotal = extractDouble(basketData(j)(k+1)) * extractDouble(countOccurences(i)(k+1))
            SubTotal += individualItemsTotal
            SubTotal = BigDecimal(SubTotal).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
          }
        }
      }
      SubTotal
    }
}