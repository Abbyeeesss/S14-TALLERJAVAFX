public class Resta implements IOperacion {
    @Override
    public double calcularOperacion(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public void mostrarResultado(double resultado) {
        System.out.println("Resultado de la resta: " + resultado);
    }
}
