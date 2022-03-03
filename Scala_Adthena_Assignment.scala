import scala.collection.mutable.ListBuffer

object Scala_Adthena_Assignment {


  def main(args: Array[String]): Unit = {


      if (args.length == 0) {
        println("Please pass atleast one parameter")
      }
      else {
        var items = ListBuffer[String]()
        for (i <- 0 until args.length) {
          items += args(i)
          val a=items.groupBy(l=>l).map(t=> (t._1,t._2.length))
        }
        println(items)
        //if ((items.groupBy(l=>l).map(t=> (t._1,t._2.length)).values).gt(1)) {
          println(items.groupBy(l => l).map(t => (t._1, t._2.length)))

        val a=0
        if (a > 1) {
          val DiscountedBread =0.40
        }
        }
      }
    val Soup = 0.65
    val Apples = 1.00
    val Milk = 1.30
    val Bread = 0.80

    val ApplesDiscount = Apples-Apples * (10.00 / 100.00)
    println(ApplesDiscount)
}
