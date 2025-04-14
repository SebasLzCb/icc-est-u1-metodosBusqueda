public class App {

    MetodosBusqueda metodosBusqueda = new MetodosBusqueda();

    public static void main(String[] args) {
        App app = new App();
        int[] numeros = {4, 8, 15, 16, 23, 42};

        int valorABuscar = 15;
        int indice = app.metodosBusqueda.busquedaLineal(numeros, valorABuscar);

        if (indice != -1) {
            System.out.println("Elemento encontrado en el índice: " + indice);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
