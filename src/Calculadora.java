import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultadoLabel;
    private JComboBox<String> operaciones;

    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultadoLabel = new JLabel("Resultado: ");

        operaciones = new JComboBox<>(new String[]{"Suma", "Resta", "Multiplicación", "División"});

        JButton calcularBtn = new JButton("Calcular");
        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion();
            }
        });

        add(new JLabel("Número 1:"));
        add(num1Field);
        add(new JLabel("Número 2:"));
        add(num2Field);
        add(operaciones);
        add(calcularBtn);
        add(resultadoLabel);

    }

    private void realizarOperacion() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            IOperacion op;

            switch (operaciones.getSelectedItem().toString()) {
                case "Suma":
                    op = new Suma();
                    break;
                case "Resta":
                    op = new Resta();
                    break;
                case "Multiplicación":
                    op = new Multiplicacion();
                    break;
                case "División":
                    op = new Division();
                    break;
                default:
                    throw new IllegalArgumentException("Operación no soportada");
            }

            double resultado = op.calcularOperacion(num1, num2);
            op.mostrarResultado(resultado);
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (ArithmeticException ex) {
            resultadoLabel.setText("Error: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error: Entrada inválida");
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
