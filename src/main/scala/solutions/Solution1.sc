var x = 1

while(x <=  5) {
  var y = 1
  while(y <= 5) {
    val result = x  * y
    if(result.toString.contains('4') || result.toString.contains('6')) println(s"$x times $y is $result")
    y += 1
  }
  x +=  1
}