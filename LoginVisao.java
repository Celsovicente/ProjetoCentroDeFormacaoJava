/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: LoginVisao.java
Data: 27.06.2024
---------------------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class LoginVisao extends JFrame
{

    private PainelCentro centro;
    private PainelSul sul;
    public LoginVisao()
    {
        super("Tela de Boas Vindas");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel painelNorte = new JPanel();
        JLabel lbImagem = new JLabel(new ImageIcon(""));
        painelNorte.add(lbImagem);
        getContentPane().add(painelNorte , BorderLayout.NORTH);
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

    }
    
    class PainelCentro extends JPanel 
    {
        private JTextField userJTF;
        private JPasswordField passwordJTF;
        private String correctUser = "33019";
        private String correctPassword = "ucan";

        public PainelCentro()
        {
            setLayout(new GridLayout(2,2));
            add(new JLabel("UserName: "));
            add(userJTF = new JTextField());

            add(new JLabel("Password: "));
            add(passwordJTF = new JPasswordField());
        }

        public String getUser()
        {
            return userJTF.getText().trim();
        }

        public String getPassword()
        {
            return passwordJTF.getText().trim();
        }

        public boolean loginValido()
        {
            if(getUser().equals(correctUser) && getPassword().equals(passwordJTF))
                return true;
            else
                return false;
        }
    }

    class PainelSul extends JPanel implements ActionListener
    {   
        private JButton entrarJB, sairJB;
		public PainelSul()
		{
			add( entrarJB = new JButton("Entrar") );
			add( sairJB = new JButton("Sair") );
			
			entrarJB.addActionListener(this);
			sairJB.addActionListener(this);
		}
				
		public void actionPerformed(ActionEvent event)
		{			
			if (event.getSource() == entrarJB)
			{
				if ( centro.loginValido() )
				{
					String user = centro.getUser();					
					dispose();					
					//new MenuPrincipal( user );
				}
				else
				{
                }
           }
        }
    }
}

