/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: FormandoFile.java
Data: 01.07.2024
---------------------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class EditarFormando extends JFrame
{
    PainelCentro centro;
    PainelSul sul;

    public EditarFormando()
    {
        super("Pesquisa para Edicao dos Dados");
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.NORTH);
        pack();
		setLocationRelativeTo(null);
		setVisible(true);   
    }

    class PainelCentro extends JPanel implements ActionListener
    {
            JComboBox nomesJCB;
            JTextField numeroDocumentoJTF;
            ButtonGroup grupo;
            JRadioButton pesquisarPorDocumento, pesquisarPorNome;

            public PainelCentro()
            {
                setLayout(new GridLayout(3, 2));
                
                grupo = new ButtonGroup();
                add(pesquisarPorNome = new JRadioButton("Pesquisar por Nome", true));
                add(pesquisarPorDocumento = new JRadioButton("Pesquisar por Documento"));
                
                grupo.add(pesquisarPorNome);
                grupo.add(pesquisarPorDocumento);

                add(new JLabel("Escolha o nome procurado"));
                add(nomesJCB = new JComboBox(FormandoFile.getAllNames()));

                add(new JLabel("Digite o numero do Documento Procurado"));
                add(numeroDocumentoJTF = new JTextField());
                numeroDocumentoJTF.setEnabled(false);

                pesquisarPorNome.addActionListener(this);
                pesquisarPorDocumento.addActionListener(this);
            }

            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource() == pesquisarPorDocumento)
                {
                    numeroDocumentoJTF.setEnabled(true);
                    nomesJCB.setEnabled(false);
                }
                else
                {
                    numeroDocumentoJTF.setEnabled(false);
                    nomesJCB.setEnabled(true);
                }
            }

            public String getNomeProcurado()
            {
                return String.valueOf(nomesJCB.getSelectedItem());
            }

            public String getNumeroDocumentoProcurado()
            {
                return numeroDocumentoJTF.getText().trim();
            }

            public int getTipoDePesquisa()
            {
                if(pesquisarPorNome.isSelected())
                    return 1;
                else
                    return 2;
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
                {
                    FormandoModelo modelo = new FormandoModelo();

                    if(centro.getTipoDePesquisa() == 1)
                    {
                        modelo = FormandoFile.getFormandoPorNome(centro.getNomeProcurado());
                        new FormandoVisao(true, modelo);
                    }
                    else 
                    {
                        FormandoFile file = new FormandoFile();
                        file.pesquisarFormandoPorDocumento(centro.getNumeroDocumentoProcurado());
                    }
                }

            else
                dispose();
        }
    }


}