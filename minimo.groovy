lista = [7,10,1,2,3,100,5,4,1,33]

tamañodelista = lista.size()
memoria = 0 

for(i=0; i<=tamañodelista; i++){
     if(lista[i] < lista [i+1]){
        memoria = lista[i]
     }
}

println memoria