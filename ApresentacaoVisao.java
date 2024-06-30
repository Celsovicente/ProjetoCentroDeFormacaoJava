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

        JPanel painelNorte = new JPanel();
        JLabel lbImagem = new JLabel(new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\images.jpg"));
        painelNorte.add(lbImagem);
        getContentPane().add(painelNorte , BorderLayout.NORTH);
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

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
            areaPrincipal.setText("Seja BenVindo ao Sistema de Gestao de Centro de Formacao\n"
            + "Este Sistema foi concebido para registrar a inscricao de formandos que queiram fazer cursos no nosso centro\n"+
            "Este projecto foi criado no ambito da cadeira de Fundamentos de Programacao II, \n" +
			"no Curso de Engenharia Informatica da UCAN. \n");

            add( concordarJCB = new JCheckBox("Concordo com os termos de uso!") );
			
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
        
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == entrarJB)
            {
                dispose();
                new LoginVisao();
            }
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