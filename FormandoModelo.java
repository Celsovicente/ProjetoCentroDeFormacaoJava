import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import SwingComponents.DataModelo;
import SwingComponents.StringBufferModelo;
import Calendario.*;

public class FormandoModelo 
{
    int id;
    StringBufferModelo nome, tipoDocumento, numeroDocumento, provincia, municipio, comuna;
    StringBufferModelo telefone, email, genero, nacionalidade;
    DataModelo dataNascimento;

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
        telefone = new StringBufferModelo("", 15);
        email = new StringBufferModelo("", 30);
        genero = new StringBufferModelo("", 10);
        nacionalidade = new StringBufferModelo("", 20);
        dataNascimento = new DataModelo();
    }

    //Construtor com parametros
    public FormandoModelo(int id, String nome, String tipoDocumento, String numeroDocumento, String dataNascimento,
    String genero, String telefone, String email, String nacionalidade, String provincia, String municipio, String comuna)
    {
        this.id = id;
        this.nome = new StringBufferModelo(nome, 50);
        this.tipoDocumento = new StringBufferModelo(tipoDocumento, 50);
        this.numeroDocumento = new StringBufferModelo(numeroDocumento, 20);
        this.provincia = new StringBufferModelo(provincia, 20);
        this.municipio = new StringBufferModelo(municipio, 20);
        this.comuna = new StringBufferModelo(comuna, 20);
        this.telefone = new StringBufferModelo(telefone, 15);
        this.email = new StringBufferModelo(email, 30);
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

    public void setNome(String nome)
    {
        this.nome = new StringBufferModelo(nome, 50);
    }

    public void setTipoDocumento(String tipoDocumento)
    {
        this.tipoDocumento = new StringBufferModelo(tipoDocumento, 50);
    }
        
    public void setNumeroDocumento(String numeroDocumento)
    {
        this.numeroDocumento = new StringBufferModelo(numeroDocumento, 20);
    }

    public void setDataNascimento(String data)
    {
        dataNascimento = new DataModelo(data);
    }

    public void setGenero(String genero)
    {
        this.genero = new  StringBufferModelo(genero, 10);
    }

    public void setTelefone(String telefone)
    {
        this.telefone = new StringBufferModelo(telefone, 15);
    }

    public void setEmail(String email)
    {
        this.email = new StringBufferModelo(email, 30);
    }

    public void setNacionalidade(String nacionalidade)
    {
        this.nacionalidade = new StringBufferModelo(nacionalidade, 20);
    }

    public void setProvincia(String provincia)
    {
          this.provincia = new StringBufferModelo(provincia, 20);
    }

    public void setMunicipio(String municipio)
    {
        this.municipio = new StringBufferModelo(municipio, 20);
    }

    public void setComuna(String comuna)
    {
        this.comuna = new StringBufferModelo(comuna, 20);
    }
    

    // metodo toString
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
}
