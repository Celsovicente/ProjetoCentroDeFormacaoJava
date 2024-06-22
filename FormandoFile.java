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
            stream.seak(stream.length());

            // escreve os dados no ficheiro
            modelo.write(stream);
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar dados no Ficheiro");
        }
    }
}
