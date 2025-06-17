package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.serie;

public class MainSerie {
    public static void main(String[] args) {
        Capitulo c1 = new Capitulo("cap1","01/01/24","00:45",4.5, 1);
        Capitulo c2 = new Capitulo("cap2","02/01/24","00:45",5, 2);
        Capitulo c3 = new Capitulo("cap3","03/01/24","00:45",2, 3);
        Capitulo c4 = new Capitulo("cap4","04/01/24","00:45",3, 4);
        Capitulo c5 = new Capitulo("cap5","05/01/24","00:45",5, 5);

        Capitulo[] capitulost1 = {c1, c2, c3};
        Capitulo[] capitulost2 = {c4, c5};
        Temporada t1 = new Temporada(1, 2024, capitulost1);
        Temporada t2 = new Temporada(2, 2024, capitulost2);
        Temporada[] temps = {t1, t2};
        Serie s1 = new Serie("serie","accion",temps);

        System.out.println(s1.valoracionMedia());
    }
}
