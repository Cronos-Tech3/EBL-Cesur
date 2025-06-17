package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba4;

public class Cine {
    private String nombre;
    private Entrada[] entradas;

    public Cine(String nombre, Entrada[] entradas) {
        this.nombre = nombre;
        this.entradas = entradas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrada[] getEntradas() {
        return entradas;
    }

    public void setEntradas(Entrada[] entradas) {
        this.entradas = entradas;
    }
    public boolean agregarEntrada(String nombreCliente, double precio, String diaSemana, boolean vip) {
        for (int i = 0; i < entradas.length ; i++) {
            if (entradas[i]==null){
                entradas[i]=new Entrada(nombreCliente,precio,diaSemana,vip);
                return true;

            }
        }
      return false;
    }

    public double calcularRecaudacionTotal(){
        double total = 0;
        for (Entrada entrada : entradas) {
            if (entrada!=null){
               total+= entrada.calcularPrecioFinal();
            }
        }

       return total;
    }
    public double calcularRecaudacionTotal2(){
        double total = 0;
        for (int i = 0; i < entradas.length ; i++) {
            if (entradas[i]!=null){
                total+=entradas[i].calcularPrecioFinal();
            }
        }
        return total;
        }

        public void listarEntradasVip(){
            for (int i = 0; i < entradas.length ; i++) {
                if (entradas[i]!=null && entradas[i].isVip()){
                    System.out.println(entradas[i]);
                }

            }


        }
    public void listarEntradasVip2(){
       for (Entrada entrada : entradas) {
           if (entrada!=null && entrada.isVip()){
               System.out.println(entrada);
           }
       }
    }

    @Override
    public String toString() {
        String resultado= "cine" + nombre + "numeroEntrada \n";
        for (Entrada entrada : entradas) {
            if (entrada!=null){
                resultado+= entrada.toString() + "\n";
            }else{
                resultado+= "null\n";
            }
        }
        return resultado;
    }
}
