public class Division implements IOperacion {
    @Override
    public double calcularOperacion(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("El denominador no puede ser cero");
        }
        return num1 / num2;
    }

    @Override
    public void mostrarResultado(double resultado) {
        System.out.println("Resultado de la división: " + resultado);
    }
}
