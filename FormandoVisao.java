/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: CentroFormacao.java
Data: 12.06.2024
---------------------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import SwingComponents.JComboBoxPersonal.*;
import SwingComponents.JComboBoxTabela3_Tabela3.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class FormandoVisao extends JFrame
{
    PainelCentro centro;
    PainelSul sul;

    public FormandoVisao()
    {
        super("Cadastro de Novos Formandos");
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        pack();
       //setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // criando um painel centro
    class PainelCentro extends JPanel
    {   
        private JTextField idJTF, nomeJTF, numeroDocumentoJTF, dataNascimentoJTF, telefoneJTF, emailJTF ;
        private JComboBox tipoDocumentoJCB, nacionalidadeJCB, generoJCB;
        private JComboBoxPersonal telefoneCJB, emailJCB, provinciaJCB, municipioJCB, comunaJCB;
        private JComboBoxTabela3_Tabela3 proviMunCom;
        private String[] generoArray = {"Maculino", "Feminino"};
        
        public PainelCentro()
        {
            setLayout(new GridLayout(6, 4));
            proviMunCom = new JComboBoxTabela3_Tabela3("Provincia.tab", "Municipio.tab", "Comunas.tab");

            // adicionando a 1 linha 
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            add(new JLabel("Nome"));
            add(nomeJTF = new JTextField());

            // adicionando a 2 linha
            add(new JLabel("Tipo de Documento"));
            add(tipoDocumentoJCB = UInterfaceBox.createJComboBoxPersonalTab2("TipoDeDocumento.tab"));
            add(new JLabel("Numero do Documento"));
            add(numeroDocumentoJTF = new JTextField());

            //adicionando a 3 linha
            add(new JLabel("Nacionalidade"));
            add(nacionalidadeJCB = UInterfaceBox.createJComboBoxPersonalTab2("Nacionalidade.tab"));
            add(new JLabel("Genero"));
            add(generoJCB = new JComboBox(generoArray));

            //adicionando a 4 linha
            add(new JLabel("Provincia"));
            add(provinciaJCB = proviMunCom.getComboBoxFather());
            add(new JLabel("Municipio"));
            add(municipioJCB = proviMunCom.getComboBoxSun());

            //adicionando a 5 linha
            add(new JLabel("Comuna"));
            add(comunaJCB = proviMunCom.getComboBoxNeto());
            add(new JLabel("Data de Nascimento"));
            add(dataNascimentoJTF = new JTextField());

            // adiconando a 6 linha
            add(new JLabel("Telefone"));
            add(telefoneJTF = new JTextField());
            add(new JLabel("email"));
            add(emailJTF = new JTextField());


        }

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

    //funcao para definir o tema de fundo
        public void definirTema() 
        {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Window".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }
        }
    }
    
}
