/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: CentroFormacao.java
Data: 12.06.2024
---------------------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*; 
import Calendario.*;

public class FormandoVisao extends JFrame
{
    PainelCentro centro;
    PainelSul sul;

    public FormandoVisao()
    {
        super("Cadastro de Novos Formandos");
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // criando um painel centro
    class PainelCentro extends JPanel
    {

    }

    // criando um painel sul
    class PainelSul extends JPanel implements ActionListener
    {
        JButton salvarJB, cancelarJB;
        public PainelSul()
        {
            add(salvarJB = new  JButton("Salvar"));
            add(cancelarJB = new JButton("Cancelar"));
            
            salvarJB.addActionListener(this);
            cancelarJB.addActionListener(this);
            
        }

        
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == salvarJB)
                JOptionPane.showMessageDialog(null, "Salvar");
            else
                dispose();

        }
    }
    
}
