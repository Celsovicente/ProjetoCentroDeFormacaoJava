/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: FormandoVisao.java
Data: 12.06.2024
---------------------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;


public class FormandoVisao extends JFrame
{
    PainelCentro centro;
    PainelSul sul;

    public FormandoVisao()
    {
        super("Cadastro de Novos Formandos");
        definirTema();

        JPanel painelNorte = new JPanel();
        JLabel lbBanner = new JLabel(new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\images.jpg"));
        painelNorte.add(lbBanner);

        getContentPane().add(painelNorte, BorderLayout.NORTH);
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
        private JComboBoxPersonal provinciaJCB, municipioJCB, comunaJCB;
        private JComboBoxTabela3_Tabela3 proviMunCom;
        private String[] generoArray = {"Masculino", "Feminino"};
        JTextFieldData txtData;

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
            add(provinciaJCB = proviMunCom.getComboBoxFather() );
            add(new JLabel("Municipio"));
            add(municipioJCB = proviMunCom.getComboBoxSun() );

            //adicionando a 5 linha
            add(new JLabel("Comuna"));
            add(comunaJCB = proviMunCom.getComboBoxNeto() );
            add(new JLabel("Data de Nascimento"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);

            // adiconando a 6 linha
            add(new JLabel("Telefone"));
            add(telefoneJTF = new JTextField());
            add(new JLabel("Email"));
            add(emailJTF = new JTextField());
        }

        //metodos getters
        public int getId()
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getNome()
        {
            return nomeJTF.getText().trim();
        }

        public String getNumeroDocumento()
        {
            return numeroDocumentoJTF.getText().trim();
        }
         
        public String getDataNascimento()
        {
            return txtData.getDTestField().getText();
        } 

        public String getTelefone()
        {
            return telefoneJTF.getText().trim();
        }

        public String getEmail()
        {
            return emailJTF.getText().trim();
        }

        public String getTipoDocumento()
        {
            return String.valueOf(tipoDocumentoJCB.getSelectedItem());
        }

        public String getNacionalidade()
        {
            return String.valueOf(nacionalidadeJCB.getSelectedItem());
        }

        public String getGenero()
        {
            return String.valueOf(generoJCB.getSelectedItem());
        }

        public String getProvincia()
        {
            return String.valueOf(provinciaJCB.getSelectedItem());
        }

        public String getMunicipio()
        {
            return String.valueOf(municipioJCB.getSelectedItem());
        }

        public String getComuna()
        {
            return String.valueOf(comunaJCB.getSelectedItem());
        }
        //metodo para salvar os dados
        public void salvar()
        {
            FormandoModelo modelo = new FormandoModelo(
                getId(), 
                getNome(), 
                getTipoDocumento(), 
                getNumeroDocumento(), 
                getTelefone(), 
                getEmail(), 
                getGenero(), 
                getNacionalidade(), 
                getProvincia(),
                getMunicipio(), 
                getComuna(), 
                getDataNascimento()
                );

            JOptionPane.showMessageDialog(null, modelo.toString());

            modelo.salvar();
        }


    }   

    // criando um painel sul
    class PainelSul extends JPanel implements ActionListener
    {
        JButton salvarJB, cancelarJB;
        public PainelSul()
        {
            add(salvarJB = new  JButton("Salvar", new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\save24.PNG")));
            add(cancelarJB = new JButton("Cancelar", new ImageIcon("C:\\Users\\Celso_Vicente\\Documents\\Java\\CelsoVicente33019\\image\\cancel24.PNG")));
            
            salvarJB.addActionListener(this);
            cancelarJB.addActionListener(this);
            
        }

        
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == salvarJB)
                centro.salvar();
            else
                dispose();

        }

    }
    //funcao para definir o tema de fundo
    //definirTema();
         public void definirTema() 
         {
             try {
                 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                     if ("Nimbus".equals(info.getName())) {
                         UIManager.setLookAndFeel(info.getClassName());
                         break;
                     }
                 }
             } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                 }
         }
                

    
}
