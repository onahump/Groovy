lista = [100,10,500,2,3,400,5,4,1,700]

tamañodelista = lista.size()

memoria = 0 

/*
memoria = 0
if(lista[1] > memoria){
    memoria = lista[1] 
}

if(lista[2] > memoria){
    memoria = lista[2] 
}*/

for(i=0; i<=tamañodelista; i++){
     if(lista[i] > memoria){
        memoria = lista[i]
     }
}

println memoria