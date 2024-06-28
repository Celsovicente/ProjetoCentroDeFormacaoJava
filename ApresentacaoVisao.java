/*------------------------------------
Tema: Gestão de Um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: ApresentacaoVisao.java
Data: 20.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class ApresentacaoVisao extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    public ApresentacaoVisao()
    {
        super("Tela de Boas Vindas");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel painelNorte = new JPanel();
        JLabel lbImagem = new JLabel(new ImageIcon(""));
        painelNorte.add(lbImagem);
        getContentPane().add(painelNorte , BorderLayout.NORTH);
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

    }
    
    class PainelCentro extends JPanel implements ActionListener
    {
        JTextArea areaPrincipal;
        JCheckBox concordarJCB;
        public PainelCentro()
        {
            setLayout(new GridLayout(2,1));
            add(new JScrollPane(areaPrincipal = new JTextArea(80, 40)));
            areaPrincipal.setFocusable(false);
            areaPrincipal.setText("Seja BenVindo ao Sistema de Gestao de Um Centro de Formacao");

            add( concordarJCB = new JCheckBox("concordo com os termos de uso!") );
			
			concordarJCB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{			
			if (evt.getSource() == concordarJCB)
				if (concordarJCB.isSelected())
					sul.ativarBotao(true);
				else
					sul.ativarBotao(false);
		}
        
    }

    class PainelSul extends JPanel implements ActionListener
    {
        private JButton entrarJB, sairJB;
        
        public PainelSul()
        {
            add(entrarJB = new JButton("Entrar"));
            add(sairJB = new JButton("Sair"));

            ativarBotao(false);
            
            entrarJB.addActionListener(this);
            sairJB.addActionListener(this);
        }

        public void ativarBotao(boolean status)
        {
            entrarJB.setEnabled(status);
        }
        
        public void actionPerformed(ActionListener event)
        {
            if(event.getSource() == entrarJB)
                JOptionPane.showMessageDialog(null, "Login");
            else
                dispose();
        }
    }


    public static void main(String[] args)
    {
        Vector_Tabelas.inic();
        new ApresentacaoVisao();
    }
}