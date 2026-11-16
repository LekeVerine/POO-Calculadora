
package Projeto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Calculadora {

	private JFrame frmGuilhermeCarvalhoLima;
	private JTextField JTFResultado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmGuilhermeCarvalhoLima.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculadora() {
		initialize();
	}

	double valor1, valor2;
	double resultadoAcumulado = 0;
	String op;

	private void initialize() {

		frmGuilhermeCarvalhoLima = new JFrame();

		frmGuilhermeCarvalhoLima.getContentPane().setBackground(
			new Color(104, 108, 202));

		frmGuilhermeCarvalhoLima.setTitle(
			"Guilherme Carvalho Lima - RA: 0016750");

		frmGuilhermeCarvalhoLima.getContentPane().setFont(
			new Font("Arial", Font.BOLD, 12));

		frmGuilhermeCarvalhoLima.setBounds(100, 100, 400, 502);

		frmGuilhermeCarvalhoLima.setDefaultCloseOperation(
			JFrame.EXIT_ON_CLOSE);

		frmGuilhermeCarvalhoLima.getContentPane().setLayout(null);

		JTFResultado = new JTextField();
		JTFResultado.setBounds(38, 31, 294, 99);
		frmGuilhermeCarvalhoLima.getContentPane().add(JTFResultado);
		JTFResultado.setColumns(10);

		JButton btn1 = criarBotao("1", 23, 332);
		JButton btn2 = criarBotao("2", 90, 332);
		JButton btn3 = criarBotao("3", 156, 332);

		JButton btn0 = criarBotao("0", 90, 391);

		JButton btn4 = criarBotao("4", 23, 278);
		JButton btn5 = criarBotao("5", 90, 278);
		JButton btn6 = criarBotao("6", 156, 278);

		JButton btn7 = criarBotao("7", 23, 224);
		JButton btn8 = criarBotao("8", 90, 224);
		JButton btn9 = criarBotao("9", 156, 224);

		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.BOLD, 12));
		btnC.setBounds(90, 167, 55, 52);
		btnC.addActionListener(e -> {
			JTFResultado.setText("");
			resultadoAcumulado = 0;
			op = null;
		});
		frmGuilhermeCarvalhoLima.getContentPane().add(btnC);

		JButton btnPotencia = new JButton("^");
		btnPotencia.setFont(new Font("Arial", Font.BOLD, 12));
		btnPotencia.setBounds(156, 167, 55, 52);
		btnPotencia.addActionListener(e -> selecionarOperacao("Potencia"));
		frmGuilhermeCarvalhoLima.getContentPane().add(btnPotencia);

		JButton btnDivisao = new JButton("/");
		btnDivisao.setFont(new Font("Arial", Font.BOLD, 12));
		btnDivisao.setBounds(299, 167, 49, 52);
		btnDivisao.addActionListener(e -> selecionarOperacao("Divisao"));
		frmGuilhermeCarvalhoLima.getContentPane().add(btnDivisao);

		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.setFont(new Font("Arial", Font.BOLD, 12));
		btnMultiplicacao.setBounds(299, 224, 49, 52);
		btnMultiplicacao.addActionListener(e -> selecionarOperacao("Multiplicacao"));
		frmGuilhermeCarvalhoLima.getContentPane().add(btnMultiplicacao);

		JButton btnSoma = new JButton("+");
		btnSoma.setFont(new Font("Arial", Font.BOLD, 12));
		btnSoma.setBounds(299, 283, 49, 47);
		btnSoma.addActionListener(e -> selecionarOperacao("Soma"));
		frmGuilhermeCarvalhoLima.getContentPane().add(btnSoma);

		JButton btnSubtracao = new JButton("-");
		btnSubtracao.setFont(new Font("Arial", Font.BOLD, 12));
		btnSubtracao.setBounds(299, 337, 49, 47);
		btnSubtracao.addActionListener(e -> selecionarOperacao("Subtracao"));
		frmGuilhermeCarvalhoLima.getContentPane().add(btnSubtracao);

		JButton btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Arial", Font.BOLD, 12));
		btnIgual.setBounds(299, 391, 49, 52);
		btnIgual.addActionListener(e -> calcular());
		frmGuilhermeCarvalhoLima.getContentPane().add(btnIgual);

		JButton btnVirgula = new JButton(",");
		btnVirgula.setFont(new Font("Arial", Font.BOLD, 12));
		btnVirgula.setBounds(156, 391, 55, 52);
		btnVirgula.addActionListener(e -> adicionarVirgula());
		frmGuilhermeCarvalhoLima.getContentPane().add(btnVirgula);

		JButton btnPonto = new JButton(".");
		btnPonto.setFont(new Font("Arial", Font.BOLD, 12));
		btnPonto.setBounds(23, 391, 57, 52);
		btnPonto.addActionListener(e -> adicionarPonto());
		frmGuilhermeCarvalhoLima.getContentPane().add(btnPonto);
	}

	private JButton criarBotao(String numero, int x, int y) {
		JButton botao = new JButton(numero);
		botao.setFont(new Font("Arial", Font.BOLD, 12));
		botao.setBounds(x, y, 57, 52);
		botao.addActionListener(e -> {
			JTFResultado.setText(JTFResultado.getText() + numero);
		});
		frmGuilhermeCarvalhoLima.getContentPane().add(botao);
		return botao;
	}

	private void selecionarOperacao(String operacao) {
		if (JTFResultado.getText().trim().isEmpty()) {
			return;
		}

		valor1 = Double.parseDouble(JTFResultado.getText().replace(",", "."));
		op = operacao;
		JTFResultado.setText("");
	}

	private void calcular() {
		if (JTFResultado.getText().trim().isEmpty() || op == null) {
			return;
		}

		valor2 = Double.parseDouble(JTFResultado.getText().replace(",", "."));

		switch (op) {
			case "Soma":
				JTFResultado.setText(String.valueOf(valor1 + valor2));
				break;

			case "Subtracao":
				JTFResultado.setText(String.valueOf(valor1 - valor2));
				break;

			case "Potencia":
				JTFResultado.setText(String.valueOf(Math.pow(valor1, valor2)));
				break;

			case "Multiplicacao":
				JTFResultado.setText(String.valueOf(valor1 * valor2));
				break;

			case "Divisao":
				if (valor2 == 0) {
					javax.swing.JOptionPane.showMessageDialog(
						frmGuilhermeCarvalhoLima,
						"Não é possível dividir por zero.",
						"Erro",
						javax.swing.JOptionPane.ERROR_MESSAGE
					);
					JTFResultado.setText("0");
				} else {
					JTFResultado.setText(String.valueOf(valor1 / valor2));
				}
				break;
		}

		op = null;
	}

	private void adicionarVirgula() {
		adicionarPonto();
	}

	private void adicionarPonto() {
		if (!JTFResultado.getText().contains(".")) {
			if (JTFResultado.getText().isEmpty()) {
				JTFResultado.setText("0.");
			} else {
				JTFResultado.setText(JTFResultado.getText() + ".");
			}
		}
	}
}
