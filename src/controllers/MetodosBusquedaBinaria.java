package controllers;

import models.Person;
import views.ShowConsole;

public class MetodosBusquedaBinaria {

    private Person[] people; 
    private ShowConsole pantalla;

    public MetodosBusquedaBinaria(Person[] people){
        this.people = people;
        this.pantalla = new ShowConsole();
        pantalla.showMessage("Método de búsqueda binaria");
    }

    // Ordenar por código usando Bubble Sort
    private void ordenarPorCodigo() {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getCode() > people[j + 1].getCode()) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    // Ordenar por nombre usando Bubble Sort
    private void ordenarPorNombre() {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getName().compareToIgnoreCase(people[j + 1].getName()) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    private int findPersonByCode(int code){
        ordenarPorCodigo(); // ordenar antes de buscar

        int bajo = 0;
        int alto = people.length - 1;

        while (bajo <= alto) {
            int central = (bajo + alto) / 2;
            int codeCentral = people[central].getCode();

            if (codeCentral == code) {
                return central;
            } else if (codeCentral > code) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

    private int findPersonByName(String name){
        ordenarPorNombre(); // ordenar antes de buscar

        int bajo = 0;
        int alto = people.length - 1;

        while (bajo <= alto) {
            int central = (bajo + alto) / 2;
            String nombreCentral = people[central].getName();

            int comparacion = name.compareToIgnoreCase(nombreCentral);

            if (comparacion == 0) {
                return central;
            } else if (comparacion < 0) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

    public void showPersonByCode(){
        int codeToFind = pantalla.inputCode();
        int index = findPersonByCode(codeToFind);

        if (index == -1) {
            pantalla.showMessage("Persona con código " + codeToFind + " no encontrada.");
        } else {
            pantalla.showMessage("Persona con código " + codeToFind + " encontrada:");
            System.out.println(people[index].toString());
        }
    }

    public void showPersonByName(){
        String nameToFind = pantalla.inputName();
        int index = findPersonByName(nameToFind);

        if (index == -1) {
            pantalla.showMessage("Persona con nombre '" + nameToFind + "' no encontrada.");
        } else {
            pantalla.showMessage("Persona con nombre '" + nameToFind + "' encontrada:");
            System.out.println(people[index].toString());
        }
    }
}
