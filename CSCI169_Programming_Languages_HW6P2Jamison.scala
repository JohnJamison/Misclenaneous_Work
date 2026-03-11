object Homework6 {
  def add(x: Int, y: Int): Int = x + y
  
  def multiply(x: Int, y: Int): Int = x * y

  def problemTwo(f: (Int, Int) => Int, xs: List[Int], ys: List[Int]): List[Int] = {
    //Once one list is at the end, the whole sequence ends
    if (xs.isEmpty || ys.isEmpty) Nil
    else f(xs.head, ys.head) :: problemTwo(f, xs.tail, ys.tail) 
  }

  def main(args: Array[String]): Unit = {
    val lsOne = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    val lsTwo = 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: Nil
    
    val ls = problemTwo(multiply, lsOne, lsTwo)
    println("Running combination program " + ls)
  }
}