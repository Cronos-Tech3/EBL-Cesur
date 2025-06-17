package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Pregunta;

public interface PreguntaDAO {
    void createPregunta(Pregunta pregunta);
    Pregunta readPregunta(int id);
    void updatePregunta(Pregunta pregunta);
    void deletePregunta(int id);
    // Otros métodos relevantes
}

