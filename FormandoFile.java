/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: FormandoFile.java
Data: 22.06.2024
---------------------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class FormandoFile extends ObjectsFile
{
    public FormandoFile()
    {
        super("FormandoFile.dat", new FormandoModelo());
    }

    public void salvarDados(FormandoModelo modelo)
    {
        // posicionando o file pointer no fim do arquivo
        try
        {
            stream.seek(stream.length());

            // escreve os dados no ficheiro
            modelo.write(stream);
            incrementarProximoCodigo();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar dados no Ficheiro");
        }
    }

    public static void listarFormandos()
    {
        FormandoFile ficheiro = new FormandoFile();
        FormandoModelo modelo = new FormandoModelo();
        String saida = "Listagem de Dados do Ficheiro\n\n";

        try
        {
            ficheiro.stream.seek(4);
            for(int i = 0; i < ficheiro.getNregistos(); i++)
            {
                modelo.read(ficheiro.stream);
                saida += "=======================================\n";
                saida += modelo.toString() + "\n\n";
            }

            JTextArea area = new JTextArea(40, 60);
			area.setText( saida );
			area.setEditable(false);
			
			JOptionPane.showMessageDialog(null, new JScrollPane( area ), 
				"Gestao de Um Centro de Formacao Profissional", JOptionPane.INFORMATION_MESSAGE );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void pesquisarFormandoPorNome(String nomeProcurado)
	{		
        FormandoFile ficheiro = new FormandoFile();
		FormandoModelo modelo = new FormandoModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for(int i = 0; i < ficheiro.getNregistos(); i++)
			{
				modelo.read( ficheiro.stream );
				// equalsignorecase para desativar o case sensetive
				if (modelo.getNome().equalsIgnoreCase(nomeProcurado) )
				{
					JOptionPane.showMessageDialog(null, modelo.toString(),
                    "Gestão de Um Centro de Formação Profissional", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}

    public static StringVector getAllNames()
    {
        FormandoFile file = new FormandoFile();
        FormandoModelo modelo = new FormandoModelo();
        StringVector vetor = new StringVector();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                vetor.add(modelo.getNome());
            }
            //ordena os nomes de forma ordenada
            vetor.sort();
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }   
        return vetor;
    }

}
