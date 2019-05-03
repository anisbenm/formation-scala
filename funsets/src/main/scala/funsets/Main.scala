package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s = map(union(s1, s2), x => 3 * x)
  println(union(s1, s2))
}
