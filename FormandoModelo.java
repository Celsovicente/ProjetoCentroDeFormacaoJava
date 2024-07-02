/*--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: FormandoModelo.java
Data: 19.06.2024
---------------------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;
import javax.swing.UIManager.*;

public class FormandoModelo implements RegistGeneric
{
   private int id;
    private StringBufferModelo nome, tipoDocumento, numeroDocumento, provincia, municipio, comuna;
    private StringBufferModelo telefone, email, genero, nacionalidade;
    private DataModelo dataNascimento;

    //Construtor Vazio
    public FormandoModelo()
    {
        id = 0;
        nome = new StringBufferModelo("", 50);
        tipoDocumento = new StringBufferModelo("", 50);
        numeroDocumento = new StringBufferModelo("", 20);
        provincia = new StringBufferModelo("", 20);
        municipio = new StringBufferModelo("", 20);
        comuna = new StringBufferModelo("", 20);
        telefone = new StringBufferModelo("", 10);
        email = new StringBufferModelo("", 50);
        genero = new StringBufferModelo("", 10);
        nacionalidade = new StringBufferModelo("", 20);
        dataNascimento = new DataModelo();
    }

    //Construtor com parametros
    public FormandoModelo(int id, String nome, String tipoDocumento, String numeroDocumento, String telefone,
    String email, String genero, String nacionalidade, String provincia, String municipio, String comuna, 
    String dataNascimento)
    {
        this.id = id;
        this.nome = new StringBufferModelo(nome, 50);
        this.tipoDocumento = new StringBufferModelo(tipoDocumento, 50);
        this.numeroDocumento = new StringBufferModelo(numeroDocumento, 20);
        this.provincia = new StringBufferModelo(provincia, 20);
        this.municipio = new StringBufferModelo(municipio, 20);
        this.comuna = new StringBufferModelo(comuna, 20);
        this.telefone = new StringBufferModelo(telefone, 10);
        this.email = new StringBufferModelo(email, 50);
        this.genero = new StringBufferModelo(genero, 10);
        this.nacionalidade = new StringBufferModelo(nacionalidade, 20);
        this.dataNascimento = new DataModelo(dataNascimento);
    }

    // metodos getters
    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome.toStringEliminatingSpaces();
    }

    public String getTipoDocumento()
    {
        return tipoDocumento.toStringEliminatingSpaces();
    }

    public String getNumeroDocumento()
    {
        return numeroDocumento.toStringEliminatingSpaces();
    }

    public String getDataNascimento()
    {
        return dataNascimento.toString();
    }

    public String getGenero()
    {
        return genero.toStringEliminatingSpaces();
    }

    public String getTelefone()
    {
        return telefone.toStringEliminatingSpaces();
    }

    public String getEmail()
    {
        return email.toStringEliminatingSpaces();
    }

    public String getNacionalidade()
    {
        return nacionalidade.toStringEliminatingSpaces();
    }

    public String getProvincia()
    {
        return provincia.toStringEliminatingSpaces();
    }

    public String getMunicipio()
    {
        return municipio.toStringEliminatingSpaces();
    }

    public String getComuna()
    {
        return comuna.toStringEliminatingSpaces();
    }

    // metodos setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setNome(String novoNome)
    {
        nome = new StringBufferModelo(novoNome, 50);
    }

    public void setTipoDocumento(String novoTipoDocumento)
    {
        tipoDocumento = new StringBufferModelo(novoTipoDocumento, 50);
    }
        
    public void setNumeroDocumento(String novoNumeroDocumento)
    {
        numeroDocumento = new StringBufferModelo(novoNumeroDocumento, 20);
    }

    public void setDataNascimento(String data)
    {
        dataNascimento = new DataModelo(data);
    }

    public void setGenero(String novoGenero)
    {
        genero = new  StringBufferModelo(novoGenero, 10);
    }

    public void setTelefone(String novoTelefone)
    {
        telefone = new StringBufferModelo(novoTelefone, 10);
    }

    public void setEmail(String novoEmail)
    {
        email = new StringBufferModelo(novoEmail, 50);
    }

    public void setNacionalidade(String novaNacionalidade)
    {
        nacionalidade = new StringBufferModelo(novaNacionalidade, 20);
    }

    public void setProvincia(String novaProvincia)
    {
        provincia = new StringBufferModelo(novaProvincia, 20);
    }

    public void setMunicipio(String novoMunicipio)
    {
        municipio = new StringBufferModelo(novoMunicipio, 20);
    }

    public void setComuna(String novaComuna)
    {
        comuna = new StringBufferModelo(novaComuna, 20);
    }

    // // metodo toString
     public String toString()
     {
         String dados = "Dados do Formando Modelo\n\n";
         dados += "Id: " + getId() + "\n";
         dados += "Nome: " + getNome() + "\n";
         dados += "Tipo de Documento: " + getTipoDocumento() + "\n";
         dados += "Numero do Documento:" + getNumeroDocumento() + "\n";
         dados += "Telefone: " + getTelefone() + "\n";
         dados += "Email: " + getEmail() + "\n";
         dados += "Genero: " + getGenero() + "\n";
         dados += "Nacionalidade: " + getNacionalidade() + "\n";
         dados += "Provincia: " + getProvincia() + "\n";
         dados += "Municipio: " + getMunicipio() + "\n";
         dados += "Comuna: " + getComuna() + "\n";
         dados += "Data de Nascimento: " + getDataNascimento() + "\n";
         return dados;
     }


    //calcular o sizeof
    public long sizeof()
    {
        try 
        {
            // a soma dos bytes das strings com o id e a data
            return 270 * 2 + 4 + 12;                        
        }
        catch (Exception e) 
        {
            return 0;
        }
    }

    //metodo para escrever no ficheiro
    public void write(RandomAccessFile stream)
    {
        try 
        {
            stream.writeInt(id);
            nome.write(stream);
            tipoDocumento.write(stream);
            numeroDocumento.write(stream);
            provincia.write(stream);
            municipio.write(stream);
            comuna.write(stream);
            telefone.write(stream);
            email.write(stream);
            genero.write(stream);
            nacionalidade.write(stream);
            dataNascimento.write(stream);
        } 
        
        catch (Exception e)      
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao escrever no ficheiro!");
        }
    }

    public void read(RandomAccessFile stream)
    {
        try 
        {
            id = stream.readInt();
            nome.read(stream);
            tipoDocumento.read(stream);
            numeroDocumento.read(stream);
            provincia.read(stream);
            municipio.read(stream);
            comuna.read(stream);
            telefone.read(stream);
            email.read(stream);
            genero.read(stream);
            nacionalidade.read(stream);
            dataNascimento.read(stream);
        } 
        
        catch (Exception e)      
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ler o ficheiro!");
        }
    }

    public void salvar()
    {
        FormandoFile file = new FormandoFile();
        file.salvarDados(this);
    }
}
