/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: PequisarFormando.java
Data: 24.06.2024
---------------------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class PesquisarFormando extends JFrame
{
    PainelCentro centro;
    PainelSul sul;
    public PesquisarFormando()
    {
        super("Pesquisas");
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.NORTH);

        pack();
		setLocationRelativeTo(null);
		setVisible(true);	
    }

    class PainelCentro extends JPanel 
    {
            JComboBox nomesJCB;
            public PainelCentro()
            {
                setLayout(new GridLayout(1, 2));
                add(new JLabel("Escolha o nome procurado"));
                add(nomesJCB = new JComboBox(FormandoFile.getAllNames()));
            }

            public String getNomeProcurado()
            {
                return String.valueOf(nomesJCB.getSelectedItem());
            }

    }

    class PainelSul extends JPanel implements ActionListener
    {
        JButton pesquisarJB, cancelarJB;
        public PainelSul()
        {
            add(pesquisarJB = new  JButton("Pesquisar", new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\search32.PNG")));
            add(cancelarJB = new JButton("Cancelar", new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\cancel24.PNG")));
            
            pesquisarJB.addActionListener(this);
            cancelarJB.addActionListener(this);

        }
        
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == pesquisarJB)
                FormandoFile.pesquisarFormandoPorNome(centro.getNomeProcurado());
            else
                dispose();
        }
    }
}
