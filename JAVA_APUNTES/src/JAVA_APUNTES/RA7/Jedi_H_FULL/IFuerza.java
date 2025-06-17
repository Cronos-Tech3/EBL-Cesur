package JAVA_APUNTES.RA7.Jedi_H_FULL;


/*
Ckase diseñada para que clases que tienen relación con la fuerza
 */
public interface IFuerza {
    // Metodo para sumar la potencia de todas las habilidades y devolver el resultado
    // En caso contrario lanza la excepción
    int calcularSumaPotenciaHabilidades() throws SinHabilidadesException;

    // Devuelve la habilidad con mayor potencia que posee el objeto
    Habilidad obtenerHabilidadPotenciaMaxima() throws SinHabilidadesException;
}