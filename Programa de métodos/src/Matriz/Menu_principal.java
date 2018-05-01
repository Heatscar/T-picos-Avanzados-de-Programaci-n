package Matriz;

/**
 *
 * @author heatscar
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import Metodos.MetodoMatrizEnum;
import javax.swing.JScrollPane;


public class Menu_principal{

	public JFrame Menu;
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
            
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principal window = new Menu_principal();
					window.Menu.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Menu = new JFrame();
		Menu.setBounds(100, 130, 580, 500);
                Menu.setTitle("Solucion de sistemas de ecuaciones lineales");
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
                
		Menu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 560, 21);
		panel.add(menuBar);

		JMenu mnMatrices = new JMenu("Matrices");
		menuBar.add(mnMatrices);

		JMenuItem mntmGauss = new JMenuItem("Gauss");
		mntmGauss.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Matriz matriz = new Matriz(MetodoMatrizEnum.GAUSS);
				matriz.setVisible(true);
				Menu.setVisible(false);
			}
		});
		mnMatrices.add(mntmGauss);

		JMenuItem mntmGaussJordan = new JMenuItem("Gauss Jordan");
		mntmGaussJordan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matriz matriz = new Matriz(MetodoMatrizEnum.GAUSS_JORDAN);
				matriz.setVisible(true);
				Menu.setVisible(false);
			}
		});
		mnMatrices.add(mntmGaussJordan);


		JMenuItem mntmCramer = new JMenuItem("Cramer");
		mntmCramer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matriz matriz = new Matriz(MetodoMatrizEnum.CRAMER);
				matriz.setVisible(true);
				Menu.setVisible(false);
			}
		});
		mnMatrices.add(mntmCramer);

		
		JMenuItem mntmGaussSeidel = new JMenuItem("Gauss Seidel");
		mntmGaussSeidel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matriz matriz = new Matriz(MetodoMatrizEnum.GAUSS_SEIDEL);
				matriz.setVisible(true);
				Menu.setVisible(false);
			}
		});
		mnMatrices.add(mntmGaussSeidel);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}