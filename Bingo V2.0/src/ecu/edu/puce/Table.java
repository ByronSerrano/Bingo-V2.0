package ecu.edu.puce;
//Byron Santiago Serrano Zambrano - Segundo Semestre
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class Table extends JPanel {
	
	private JToggleButton[][] botones;
    private ArrayList<Integer> sacados;
	
	/**
	 * Create the panel.
	 */
	public Table() {
		setLayout(new GridLayout(9, 10));
        botones = new JToggleButton[9][10];
        
        //Ciclo para crear la tabla con los botones
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                int numero = i * 10 + j + 1;
                botones[i][j] = new JToggleButton(Integer.toString(numero));
                botones[i][j].setEnabled(false);
                add(botones[i][j]);
            }
        }

	}
	//El set para los numeros que han salido
	public void setSacados(ArrayList<Integer> sacados) {
        this.sacados = sacados;
    }
	
	public void marcarNumero(int numero) {
        int i = (numero - 1) / 10;
        int j = (numero - 1) % 10;
        botones[i][j].setBackground(Color.BLUE);
        botones[i][j].setEnabled(false);
        sacados.add(numero);
    }
    
    // Funcion para ver si la tabla esta llena, da un resultado booleano
    public boolean tablaLlena() {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (!botones[i][j].getBackground().equals(Color.BLUE)) {
                    return false;
                }
            }
        }
        return true;
    }
	

}
