package TRIVIAL.TRIVIAL.models;

public class Pregunta {
    private int id;
    private String texto;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String correcta; // "A", "B" o "C"

    // Constructor
    public Pregunta(int id, String texto, String opcionA, String opcionB, String opcionC, String correcta) {
        this.id = id;
        this.texto = texto;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.correcta = correcta;
    }

    // Getters
    public int getId() { return id; }
    public String getTexto() { return texto; }
    public String getOpcionA() { return opcionA; }
    public String getOpcionB() { return opcionB; }
    public String getOpcionC() { return opcionC; }
    public String getRespuestaCorrecta() { return correcta; }
}