package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ((c==r) || (c==0)) 1
      else pascal(c-1,r-1)+pascal(c,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def compteParenthese(c:Char, i:Int): Int={
        if(c=='(') i+1
        else if( c==')') i-1
        else i
      }
     def compter(charsIn: List[Char],i:Int):Int = {

       if((i >= 0) && (charsIn.nonEmpty)){
          val sum= compteParenthese(charsIn.head, i)
          compter(charsIn.tail, sum)}
          else i

     }

      if(compter(chars,0) == 0) true
      else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def sumWays(money: Int, coins: List[Int],ways:Int): Int={
        if (coins.isEmpty) ways
        else{
          val coin=coins.head
          if ((coin>money)||(coin<=0))
            sumWays(money,coins.tail,ways)
          else {
            var w=ways
              if (money % coin == 0) w += 1
              for (i <- 1 to (money / coin))
                w = sumWays(money - i * coin, coins.tail, w)
              sumWays(money, coins.tail, w)
          }
        }
      }
      sumWays(money,coins,0)
    }
  }
