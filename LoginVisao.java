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

        JPanel painelNorte = new JPanel();
        JLabel lbImagem = new JLabel(new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\images.jpg"));
        painelNorte.add(lbImagem);
        
		getContentPane().add(painelNorte, BorderLayout.NORTH);
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
				
		//setSize(400, 400);
        pack();
		setLocationRelativeTo(null);
		setVisible(true);
    }
    
    class PainelCentro extends JPanel 
    {
        private JTextField userJTF;
        private JPasswordField passwordJTF;
        private String correctUser = "1000033019", correctPassword = "ucan";

        public PainelCentro()
        {
            setLayout(new GridLayout(2,2));
            add(new JLabel("Username: "));
            add(userJTF = new JTextField());

            add(new JLabel("Password: "));
            add(passwordJTF = new JPasswordField());
            //funcao para alterar o caracter da palavra passe
            passwordJTF.setEchoChar('#');
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
            if(getUser().equals(correctUser) && getPassword().equals(correctPassword))
                return true;

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
					new MenuPrincipal(user);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login Invalido, tente novamente!", 
							"Invalid Login", JOptionPane.ERROR_MESSAGE);
				}
			}
		
		}
	}
}

