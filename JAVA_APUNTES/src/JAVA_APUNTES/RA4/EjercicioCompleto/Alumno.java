package JAVA_APUNTES.RA4.EjercicioCompleto;

public class Alumno extends RA4_POO.Persona {


    public String numMatricula;

    //cuando es private necesitamos
    // getted  para llamar a los datos
    //setted    para cambiar esos datos


    // modificadores de acceso tenemos 3
    //public puedo acceder desde cualquier sitio
    //private solo puedo acceder desde mi propia clase y para modificarlo setter y para mostrarlo getter
    //protected  modifciador de acceso podre acceder desde la propia clase y todas las que hereden de ella
    // protected limita el acceso solo a la herencia
    //default tambien es un modificador por defecto


    //extends es heredar una clase puede heredar de otra para usar sus valores

    //object clase padre de todos de la que hereda todo el mundo

    //super palabra reservada hace referencia al padre de esa clase de la que hereda

    // override va a sobreescribir el metodo de mostrar informacio ej. y cambia el nombre de la clase de persona a alumno llamando a este metodo

    // this. para llamar la clase

    // super. para llamar a la del padre

    // toString llama al override y sobreescribe la clase que queremos mostrar

}
