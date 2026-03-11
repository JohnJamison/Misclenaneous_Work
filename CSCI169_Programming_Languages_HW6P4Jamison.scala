object Homework6 {
  //Add fucntion
  def add(x: Int, y: Int): Int = x + y
  //Multiply function
  def multiply(x: Int, y: Int): Int = x * y
  
  //Problem 1
  def problemOne(f: (Int, Int) => Int, xl: List[Int]): Int = {
    if (xl.isEmpty) 0
    else f(xl.head, problemOne(f, xl.tail))
  }
  
  
  //Problem 2 fucntion
  def problemTwo(f: (Int, Int) => Int, xs: List[Int], ys: List[Int]): List[Int] = {
    //Once one list is at the end, the whole sequence ends
    if (xs.isEmpty || ys.isEmpty) Nil
    else f(xs.head, ys.head) :: problemTwo(f, xs.tail, ys.tail) 
  }
  
  
  //Problem 3
  def flatten(zl: List[List[Int]]): List[Int] = {
    //Base case, end of list of list
    if (zl.isEmpty) Nil
    //otherwise append next list
    else zl.head:::flatten(zl.tail)
  }
  
  
  //Problem 4
  def curried_problemOne(f: (Int, Int) => Int): List[Int] => Int = {
    def inner(xl: List[Int]): Int = {
      if (xl.isEmpty) 0
      else f(xl.head, inner(xl.tail))
    }
    inner
  }
  
  
  // Added ': Unit =' here to satisfy the Scala 3 compiler
  def main(args: Array[String]): Unit = {
    val lsOne = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    val lsTwo = 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: Nil
    val lsThree = 67::0::2::Nil
    val lol = lsOne :: lsTwo :: lsThree :: Nil 
    val listAdder = curried_problemOne(add) 
    val result = listAdder(lsOne)
    
    println("Running combination program " + result)
  }
}