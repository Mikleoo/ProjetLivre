package InterfaceGraphique;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	
	private JPanel conteneur = new JPanel();
	private DefaultTableModel tablemodel;
	
	// Button
	private JButton boutonAjouter = new JButton("Ajouter");
	private JButton boutonSupprimer = new JButton("Supprimer");
	
	// Text Fields
	private JTextField champNomLivre = new JTextField(10);
	private JTextField champAuteur = new JTextField(10);
	private JTextField champEditeur = new JTextField(10);
	private JTextField champLieu = new JTextField(10);
	private JTextField champDateFinPret = new JTextField(10);
	private JTextField champNomPersonne = new JTextField(10);
	
	// Texts
	private JLabel labelNomLivre = new JLabel ("Nom du livre* : ");
	private JLabel labelAuteur = new JLabel ("Nom de l'auteur : ");
	private JLabel labelEditeur = new JLabel ("Nom de l'editeur : ");
	private JLabel labelLieu = new JLabel ("Lieu où le livre repose* : ");
	private JLabel labelDateFinPret = new JLabel ("Date de fin de prêt : ");
	private JLabel labelNomPersonne = new JLabel ("Nom de la personne qui a le livre : ");
	
	public Fenetre () {
		
		// Parameters
		setTitle("Fenetre JFrame");
		Dimension d = new Dimension(1000, 600);
		setMinimumSize(d);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close frame
		setLocationRelativeTo(null); // Center of screen
		
		// General grid with 2 case
		Panneau panneauGeneral = new Panneau(new GridLayout(1,2));
		conteneur.add(panneauGeneral);
		
		/* Form part */
		
		// First grid for the form of 13 ligne
		Panneau panneauForm = new Panneau(new GridLayout(7,2));
		
		// Feed my form
		panneauForm.add(labelNomLivre);
		panneauForm.add(champNomLivre);
		panneauForm.add(labelAuteur);
		panneauForm.add(champAuteur);
		panneauForm.add(labelEditeur);
		panneauForm.add(champEditeur);
		panneauForm.add(labelLieu);
		panneauForm.add(champLieu);
		panneauForm.add(labelDateFinPret);
		panneauForm.add(champDateFinPret);
		panneauForm.add(labelNomPersonne);
		panneauForm.add(champNomPersonne);
		panneauForm.add(boutonAjouter);
		panneauForm.add(boutonSupprimer);
		
		/* Table part */
		
		// Columns
        String[] columns = new String[] {"Livre", "Auteur", "Editeur", "Date Fin Prêt", "Nom"};
         
        // Data for JTable in 2D table
        Object[][] data = new Object[][] {
            {"La malade imaginaire", "Molière", "LaFonte", "27/05/2021", "Michel" },
            {"La malade imaginaire", "Molière", "LaFonte", "27/05/2021", "Michel" },
            {"La malade imaginaire", "Molière", "LaFonte", "27/05/2021", "Michel" },
            {"La malade imaginaire", "Molière", "LaFonte", "27/05/2021", "Michel" },
            {"La malade imaginaire", "Molière", "LaFonte", "27/05/2021", "Michel" },
        };
 
        // Create a JTable with data and coloms
        tablemodel = new DefaultTableModel(data, columns);
        JTable table = new JTable(tablemodel);
        // Create a Table dynamic
        JScrollPane panneauTable = new JScrollPane(table);
        
        
        // Feed my general grid
        panneauGeneral.add(panneauForm);
        panneauGeneral.add(panneauTable);
		
		setContentPane(conteneur);
		
		// Listener for buttons
		boutonSupprimer.addActionListener(new ActionListener() {
			 @Override
	         public void actionPerformed(ActionEvent ae) {
	            // Check the selected row
	            if(table.getSelectedRow() != -1) {
	            	// Remove the selected row from the table model
	            	tablemodel.removeRow(table.getSelectedRow());
	            	JOptionPane.showMessageDialog(null, "Deleted successfully");
	            }
	         }
		});
		
		boutonAjouter.addActionListener(new ActionListener() {
			 @Override
	         public void actionPerformed(ActionEvent ae) {
				 if(champNomLivre.getText().length()>0 && champLieu.getText().length()>0) {
					 tablemodel.addRow(new Object[]{champNomLivre.getText(), champAuteur.getText(), champEditeur.getText(), champLieu.getText(), champDateFinPret.getText(), champNomPersonne.getText()});
				 } else {
					 if(champNomLivre.getText().length()>0) {
						 JOptionPane.showMessageDialog(null, "Lieu manquant");
					 } else {
						 JOptionPane.showMessageDialog(null, "Nom du livre manquant");
					 }
				 }
	         }
		});
		
	}
	
}
