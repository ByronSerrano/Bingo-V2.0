package ecu.edu.puce;
// Byron Santiago Serrano Zambrano - Segundo Semestre
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Bingo extends JFrame {

	private JPanel contentPane;
	
	private ArrayList<Integer> bolaList; 
    private Table tablero;
    private JLabel lblNumeroSacado;
    private JButton btnSacarBola;
    private JLabel lblTerminado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bingo frame = new Bingo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bingo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bingo.class.getResource("/ecu/edu/image/bingo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setTitle("Bingo");
        setSize(833, 676);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bolaList = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolaList.add(i);
        }
        
        Collections.shuffle(bolaList);
        tablero = new Table();
        tablero.setBackground(new Color(0, 64, 128));
        tablero.setBounds(25, 11, 556, 465);
        tablero.setSacados(bolaList);
        getContentPane().add(tablero);

        lblNumeroSacado = new JLabel();
        lblNumeroSacado.setBackground(new Color(255, 187, 119));
        lblNumeroSacado.setForeground(new Color(0, 0, 0));
        lblNumeroSacado.setFont(new Font("Times New Roman", Font.BOLD, 64));
        lblNumeroSacado.setBounds(663, 274, 107, 118);
        getContentPane().add(lblNumeroSacado);

        btnSacarBola = new JButton("Sacar Bola");
        btnSacarBola.setBackground(new Color(192, 192, 192));
        btnSacarBola.setFont(new Font("Times New Roman", Font.BOLD, 22));
        btnSacarBola.setBounds(621, 57, 159, 172);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolaList.size() > 0 && !tablero.tablaLlena()) {
                    int numero = bolaList.remove(0);
                    lblNumeroSacado.setText(Integer.toString(numero));
                    tablero.marcarNumero(numero);
                } else {
                btnSacarBola.setEnabled(false);
                lblTerminado.setText("!!!Juego terminado!!!");
                }
                }
                });
                getContentPane().add(btnSacarBola);


                JLabel lblNewLabel = new JLabel("BINGO");
                lblNewLabel.setBackground(new Color(255, 255, 255));
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 90));
                lblNewLabel.setBounds(477, 521, 311, 105);
                getContentPane().add(lblNewLabel);
                
                lblTerminado = new JLabel("");
                lblTerminado.setForeground(new Color(255, 255, 255));
                lblTerminado.setFont(new Font("Times New Roman", Font.BOLD, 39));
                lblTerminado.setBounds(58, 546, 349, 54);
                contentPane.add(lblTerminado);
                
                JPanel panelAbajo = new JPanel();
                panelAbajo.setBackground(new Color(0, 64, 128));
                panelAbajo.setBounds(0, 503, 817, 134);
                contentPane.add(panelAbajo);
            }
}


