class Perfil {
  private String bio
  private Persona persona
  private String twitter
  private String facebook
}

class Pedido {
  Persona persona
  Date dateCreated
  Date lastUpdated
  String toString() {
    "$persona - $dateCreated"
  }
}

def persona = new Persona(new Date())
persona.setNombre("Juan")
println persona.edad
println persona.nombre
println persona
Perfil perfil = new Perfil()
perfil.persona = persona
Pedido pedido = new Pedido()
pedido.setPersona(persona)
println pedido