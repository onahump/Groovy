public class HolaMundo {
  private String nombre;
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String saluda() {
    return "Hola " + this.nombre + " !!!";
  }
  public static void main(String[] args) {
    HolaMundo objeto = new HolaMundo();
    objeto.setNombre("Nahum");
    System.out.println(objeto.saluda());
  }
}