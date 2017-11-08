def fizzbozz(n, closure){
  for(int i = 1 ; i <= n; i++)
    closure(i)

    println "$n"
    
fizzbozz(100) {  n ->
  if(n%5 == 0)
    println "bozz"
}