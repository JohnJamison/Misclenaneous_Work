object Homework6 {
  def add(x: Int, y: Int): Int = x + y

  def problemOne(f: (Int, Int) => Int, xl: List[Int]): Int = {
    if (xl.isEmpty) 0
    else f(xl.head, problemOne(f, xl.tail))
  }

  // Added ': Unit =' here to satisfy the Scala 3 compiler
  def main(args: Array[String]): Unit = {
    val ls = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    println("Running combination program " + problemOne(add, ls))
  }
}