class Money {
   BigDecimal amount
 
   Money plus(Money other){
     new Money(amount: this.amount + other.amount)
   }
   Money minus(Money other){
     new Money(amount: this.amount - other.amount)
   }
   Money multiply(int other){
     new Money(amount: this.amount * other)
   }
   String toString(){ "\$ ${amount}" }
 }
 
 m1 = new Money(amount : 100)
 m2 = new Money(amount : 323)
 
 println m1 + m2
 println m1 - m2
 println m1 * 3

