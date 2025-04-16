package controllers;

import models.Person;
import views.ShowConsole;

public class MetodosBusqueda {

    private ShowConsole showConsole;
    private Person[] people;

    public MetodosBusqueda(Person[] persons){
        showConsole = new ShowConsole();
        this.people = persons;
        showPerson();
    }

    public int busquedaLineal(int[] arreglo, int valorBuscado) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valorBuscado) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param code a buscar
     * @return posición de la persona encontrada 
     */
    public int findPersonByCode(int code) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getCode() == code){
                return i;
            }
        }
        return -1;
    }

    public void showPerson(){
        int codeToFind = showConsole.inputCode();
        int indexPerson = findPersonByCode(codeToFind);
        if (indexPerson >= 0){
            showConsole.showMessage("Persona con código " + codeToFind + " encontrada:");
            System.out.println(people[indexPerson].toString());
        } else {
            showConsole.showMessage("Persona con código " + codeToFind + " no encontrada.");
        }
    }

    public int findPersonByName(String name){
        for (int i = 0; i < people.length; i++) {
            if (people[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void showPersonByName(){
        String nameToFind = showConsole.inputName();
        int indexPerson = findPersonByName(nameToFind);
        if (indexPerson >= 0) {
            showConsole.showMessage("Persona con nombre \"" + nameToFind + "\" encontrada:");
            System.out.println(people[indexPerson].toString());
        } else {
            showConsole.showMessage("Persona con nombre \"" + nameToFind + "\" no encontrada.");
        }
    }
}
