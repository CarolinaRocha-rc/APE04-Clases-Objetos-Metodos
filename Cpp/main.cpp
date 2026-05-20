// ============================================================
// Archivo:  main.cpp
// Proyecto: APE 04 - Clases, Objetos y Metodos
// Autor:    Carolina
// ============================================================

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

// ============================================================
// CLASE ESTUDIANTE
// ============================================================
class Estudiante {
private:
    // Atributos privados (encapsulamiento)
    string cedula;
    string nombre;
    string apellido;
    double nota1;
    double nota2;
    double nota3;

public:
    // Constructor por defecto
    Estudiante() {
        cedula = ""; nombre = ""; apellido = "";
        nota1 = 0.0; nota2 = 0.0; nota3 = 0.0;
    }

    // Constructor con parametros
    Estudiante(string ced, string nom, string ape,
               double n1, double n2, double n3) {
        cedula = ced; nombre = nom; apellido = ape;
        setNota1(n1); setNota2(n2); setNota3(n3);
    }

    // ---------- Getters y Setters ----------
    string getCedula() { return cedula; }
    void setCedula(string c) { cedula = c; }

    string getNombre() { return nombre; }
    void setNombre(string n) { nombre = n; }

    string getApellido() { return apellido; }
    void setApellido(string a) { apellido = a; }

    double getNota1() { return nota1; }
    // Validacion: la nota debe estar entre 0 y 10
    void setNota1(double n) {
        if (n >= 0 && n <= 10) nota1 = n; else nota1 = 0;
    }

    double getNota2() { return nota2; }
    void setNota2(double n) {
        if (n >= 0 && n <= 10) nota2 = n; else nota2 = 0;
    }

    double getNota3() { return nota3; }
    void setNota3(double n) {
        if (n >= 0 && n <= 10) nota3 = n; else nota3 = 0;
    }

    // ---------- Metodo: calcular promedio ----------
    double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // ---------- Metodo: determinar estado ----------
    string estado() {
        if (calcularPromedio() >= 7.0) return "APROBADO";
        return "REPROBADO";
    }

    // ---------- Metodo: mostrar informacion ----------
    void mostrarInformacion() {
        cout << "-----------------------------------------" << endl;
        cout << "Cedula   : " << cedula << endl;
        cout << "Nombre   : " << nombre << " " << apellido << endl;
        cout << "Nota 1   : " << nota1 << endl;
        cout << "Nota 2   : " << nota2 << endl;
        cout << "Nota 3   : " << nota3 << endl;
        cout << fixed << setprecision(2);
        cout << "Promedio : " << calcularPromedio() << endl;
        cout << "Estado   : " << estado() << endl;
    }
};

// ============================================================
// FUNCION AUXILIAR: leer y validar una nota
// ============================================================
double leerNota(string mensaje) {
    double nota;
    do {
        cout << mensaje;
        cin  >> nota;
        if (nota < 0 || nota > 10) {
            cout << "  >> ERROR: La nota debe estar entre 0 y 10." << endl;
        }
    } while (nota < 0 || nota > 10);
    return nota;
}

// ============================================================
// FUNCION PRINCIPAL
// ============================================================
int main() {
    const int N = 5;                 // Cantidad de estudiantes
    Estudiante estudiantes[N];       // Arreglo de objetos
    int aprobados = 0, reprobados = 0;

    cout << "===========================================" << endl;
    cout << "  SISTEMA DE CONTROL DE ESTUDIANTES (C++)  " << endl;
    cout << "===========================================" << endl;

    // ---------- Ingreso de datos ----------
    for (int i = 0; i < N; i++) {
        string ced, nom, ape;
        double n1, n2, n3;
        cout << "\n----- Estudiante " << (i + 1) << " -----" << endl;
        cout << "Ingrese cedula  : "; cin >> ced;
        cout << "Ingrese nombre  : "; cin >> nom;
        cout << "Ingrese apellido: "; cin >> ape;
        n1 = leerNota("Ingrese nota 1 (0 a 10): ");
        n2 = leerNota("Ingrese nota 2 (0 a 10): ");
        n3 = leerNota("Ingrese nota 3 (0 a 10): ");
        // Se crea el objeto Estudiante
        estudiantes[i] = Estudiante(ced, nom, ape, n1, n2, n3);
    }

    // ---------- Mostrar resultados ----------
    cout << "\n========== LISTADO DE ESTUDIANTES ==========" << endl;
    for (int i = 0; i < N; i++) {
        estudiantes[i].mostrarInformacion();
        if (estudiantes[i].estado() == "APROBADO") aprobados++;
        else reprobados++;
    }

    // ---------- Resumen ----------
    cout << "\n============== RESUMEN GENERAL =============" << endl;
    cout << "Total de estudiantes : " << N << endl;
    cout << "Aprobados            : " << aprobados << endl;
    cout << "Reprobados           : " << reprobados << endl;
    cout << "============================================" << endl;
    return 0;
}
