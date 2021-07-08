package co.edu.utp.misiontic2022.c2;

/**
 * App Sistema de Notas
 *
 */
public class App {
    public static void main( String[] args ){

        //Crear estudiante
        Estudiante estudianteRegistrado = new Estudiante(555666, "Tripulante MinTIC", "Buendía", 5, "F");

        //Crear la materia
        //Materia materia = new Materia(40,50,39,76,96);
        Materia materia = new Materia(estudianteRegistrado,40,50,39,76,96);//Asociación

        //Utilizar el comportamiento de la materia para resolver el requerimiento
        materia.calcularPromedioAjustado();
        materia.calcularPromedio();
        materia.calcularMejorNota();

        //Revisar cómo queda la materia después del proceso
        //materia.mostrarMateria();

        //Revisar el atributo colección
        System.out.println("&&&&&& Antes de agregar");
        System.out.println("Promedio estático ->"+materia.getPromedio());
        materia.calcularPromedio(1111);
        System.out.println("Promedio colección ->"+materia.getPromedio());
        //materia.mostrarColeccionNotas();

        //Utilizar el nuevo comportamiento (adicionar notas)
        materia.adicionarNota(77);

        System.out.println("&&&&&& Después de agregar");
        materia.calcularPromedio();
        System.out.println("Promedio estático ->"+materia.getPromedio());
        materia.calcularPromedio(22222);
        System.out.println("Promedio colección ->"+materia.getPromedio());
        //materia.mostrarColeccionNotas();

        // //Probar el comportamiento de Nota
        // Nota notaVacia = new Nota();
        // // System.out.println("NotaVacía");
        // // System.out.println("Valor Escala 5 -> " + notaVacia.getEscala5());
        // // System.out.println("Valor Escala 100 -> " + notaVacia.getEscala100());
        // // System.out.println("Cualitativa  -> " + notaVacia.getCualitativa());
        // System.out.println("Antes de actualizar uno de sus atributos");
        // notaVacia.mostrarNotaConsola();

        // //Actualizar la nota vacía
        // notaVacia.setEscala100(45);
        // System.out.println("Después de actualizar uno de sus atributos");
        // notaVacia.mostrarNotaConsola();
        // notaVacia.convertirNota100_5();
        // System.out.println("Después de utilizar uno de sus métodos (comportamiendo)");
        // notaVacia.mostrarNotaConsola();
        // notaVacia.convertirNota100_Cualitativo();
        // System.out.println("Habiendo utilizado todo el comportamiento");
        // notaVacia.mostrarNotaConsola();      


        // Nota notaEscala5 = new Nota(4.4);
        // // System.out.println("NotaEscala5");
        // // System.out.println("Valor Escala 5 -> " + notaEscala5.getEscala5());
        // // System.out.println("Valor Escala 100 -> " + notaEscala5.getEscala100());
        // // System.out.println("Cualitativa  -> " + notaEscala5.getCualitativa());
        // notaEscala5.mostrarNotaConsola();

        // Nota notaEscala100 = new Nota(79);
        // // System.out.println("NotaEscala5");
        // // System.out.println("Valor Escala 5 -> " + notaEscala100.getEscala5());
        // // System.out.println("Valor Escala 100 -> " + notaEscala100.getEscala100());
        // // System.out.println("Cualitativa  -> " + notaEscala100.getCualitativa());
        // notaEscala100.mostrarNotaConsola();

        // Nota notaTodos = new Nota(5, 100, "Aprobado");
        // // System.out.println("NotaTodos");
        // // System.out.println("Valor Escala 5 -> " + notaTodos.getEscala5());
        // // System.out.println("Valor Escala 100 -> " + notaTodos.getEscala100());
        // // System.out.println("Cualitativa  -> " + notaTodos.getCualitativa());
        // notaTodos.mostrarNotaConsola();


        
    }

}
