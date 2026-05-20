// ============================================================
// Archivo:  Main.java
// Proyecto: APE 04 - Clases, Objetos y Metodos
// Autor:    Carolina
// ============================================================

import java.util.Scanner;

public class Main {

    // Metodo auxiliar para leer y validar una nota
    public static double leerNota(Scanner sc, String mensaje) {
        double nota;
        do {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("  >> ERROR: La nota debe estar entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 5;
        Estudiante[] estudiantes = new Estudiante[N];
        int aprobados = 0, reprobados = 0;

        System.out.println("===========================================");
        System.out.println("  SISTEMA DE CONTROL DE ESTUDIANTES (Java) ");
        System.out.println("===========================================");

        // ---------- Ingreso de datos ----------
        for (int i = 0; i < N; i++) {
            System.out.println("\n----- Estudiante " + (i + 1) + " -----");
            System.out.print("Ingrese cedula  : ");
            String ced = sc.next();
            System.out.print("Ingrese nombre  : ");
            String nom = sc.next();
            System.out.print("Ingrese apellido: ");
            String ape = sc.next();
            double n1 = leerNota(sc, "Ingrese nota 1 (0 a 10): ");
            double n2 = leerNota(sc, "Ingrese nota 2 (0 a 10): ");
            double n3 = leerNota(sc, "Ingrese nota 3 (0 a 10): ");
            // Se crea el objeto Estudiante
            estudiantes[i] = new Estudiante(ced, nom, ape, n1, n2, n3);
        }

        // ---------- Mostrar listado ----------
        System.out.println("\n========== LISTADO DE ESTUDIANTES ==========");
        for (int i = 0; i < N; i++) {
            estudiantes[i].mostrarInformacion();
            if (estudiantes[i].estado().equals("APROBADO")) aprobados++;
            else reprobados++;
        }

        // ---------- Resumen ----------
        System.out.println("\n============== RESUMEN GENERAL =============");
        System.out.println("Total de estudiantes : " + N);
        System.out.println("Aprobados            : " + aprobados);
        System.out.println("Reprobados           : " + reprobados);
        System.out.println("============================================");
        sc.close();
    }
}

