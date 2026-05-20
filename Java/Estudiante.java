// ============================================================
// Archivo:  Estudiante.java
// Proyecto: APE 04 - Clases, Objetos y Metodos
// Autor:    Carolina
// ============================================================

public class Estudiante {

    // ---------- Atributos privados ----------
    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;

    // ---------- Constructor por defecto ----------
    public Estudiante() {
        this.cedula = "";
        this.nombre = "";
        this.apellido = "";
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    // ---------- Constructor con parametros ----------
    public Estudiante(String cedula, String nombre, String apellido,
                      double nota1, double nota2, double nota3) {
        this.cedula   = cedula;
        this.nombre   = nombre;
        this.apellido = apellido;
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }

    // ---------- Getters y Setters ----------
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public double getNota1() { return nota1; }
    // Validacion del rango 0-10
    public void setNota1(double nota1) {
        if (nota1 >= 0 && nota1 <= 10) this.nota1 = nota1;
        else this.nota1 = 0;
    }

    public double getNota2() { return nota2; }
    public void setNota2(double nota2) {
        if (nota2 >= 0 && nota2 <= 10) this.nota2 = nota2;
        else this.nota2 = 0;
    }

    public double getNota3() { return nota3; }
    public void setNota3(double nota3) {
        if (nota3 >= 0 && nota3 <= 10) this.nota3 = nota3;
        else this.nota3 = 0;
    }

    // ---------- Metodo: calcular promedio ----------
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // ---------- Metodo: determinar estado ----------
    public String estado() {
        return (calcularPromedio() >= 7.0) ? "APROBADO" : "REPROBADO";
    }

    // ---------- Metodo: mostrar informacion ----------
    public void mostrarInformacion() {
        System.out.println("-----------------------------------------");
        System.out.println("Cedula   : " + cedula);
        System.out.println("Nombre   : " + nombre + " " + apellido);
        System.out.println("Nota 1   : " + nota1);
        System.out.println("Nota 2   : " + nota2);
        System.out.println("Nota 3   : " + nota3);
        System.out.printf ("Promedio : %.2f%n", calcularPromedio());
        System.out.println("Estado   : " + estado());
    }
}
