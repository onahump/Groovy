lista = [7,10,1,2,3,100,5,4,1,33]
lista2 = []

size = lista.size()
memoria = 0 
memoria2 = 0

for(i=0; i<size; i++){
    for(j=i+1; j<size; j++){
         if(lista[i]> lista[j]){
         memoria = lista[i]
         lista[i] = lista[j]
         lista[j] = memoria 
         }
     }
}
