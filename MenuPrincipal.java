/*
--------------------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: MenuPrincipal.java
Data: 20.05.2024
---------------------------------------------------
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;

public class MenuPrincipal extends JFrame implements ActionListener
{
    private JMenuBar menuBar;
    
    private JMenu ficheiroMenu, operacoesMenu, ajudaMenu, tabelasMenu, listagensMenu;
    private JMenuItem  nacionalidadeItem, provinciaItem, municipioItem, comunaItem, 
    cursoItem, formadorItem, metodoPagamentoItem, tipoDeDocumentoItem;
    private JMenuItem listarFormandoItem, pesquisarFormandoItem;
    
    private JMenuItem registarInscricaoItem, registarSaidaItem;
    private JMenuItem novoFormandoItem, editarFormandoItem, eliminarFormandoItem, sairItem;

    public MenuPrincipal(String user)
    {
        super("Menu Principal | User" +user);

        instanciarObjectos();
        setJMenuBar(menuBar);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void instanciarObjectos()
    {
        menuBar = new JMenuBar();
        
        ficheiroMenu = new JMenu("Ficheiro");
        ficheiroMenu.setMnemonic('F');
        listagensMenu = new JMenu("Listagem/Pesquisa");
        listagensMenu.setMnemonic('L');
        operacoesMenu = new JMenu("Operacoes");
        operacoesMenu.setMnemonic('O');
        tabelasMenu = new JMenu("Tabelas");
        tabelasMenu.setMnemonic('T');
        ajudaMenu = new JMenu("Ajuda");
        ajudaMenu.setMnemonic('A');

        // instanciando as operacoes principais do sistema
        ficheiroMenu = new JMenu("Ficheiro");
        operacoesMenu = new JMenu("Operacoes");
        ajudaMenu = new JMenu("Ajuda");
        tabelasMenu = new JMenu("Tabelas");

        // instanciando os atributos do formando
        novoFormandoItem = new JMenuItem("Novo Formando");
        novoFormandoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        editarFormandoItem = new JMenuItem("Editar Formando");
        eliminarFormandoItem = new JMenuItem("Eliminar Formando");
        sairItem = new JMenuItem("Sair");
        sairItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        // adicionando os itens do ficheiro ao menu
        ficheiroMenu.add(novoFormandoItem);
        ficheiroMenu.add(eliminarFormandoItem);
        ficheiroMenu.add(editarFormandoItem);
        ficheiroMenu.addSeparator();
        ficheiroMenu.add(sairItem);
        
        // adicionando os menus na tela principal
        menuBar.add(ficheiroMenu);
        menuBar.add(operacoesMenu);
        menuBar.add(listagensMenu);
        menuBar.add(tabelasMenu);
        menuBar.add(ajudaMenu);

        //adiconando itens da tabela
        nacionalidadeItem = new JMenuItem("Nacionalidade");
        provinciaItem = new JMenuItem("Provincia");
        municipioItem = new JMenuItem("Municipio");
        comunaItem = new JMenuItem("Comuna");
        formadorItem = new JMenuItem("Formador");
        cursoItem = new JMenuItem("Curso");
        metodoPagamentoItem = new JMenuItem("Metodo de Pagamento");
        tipoDeDocumentoItem = new JMenuItem("Tipo de Documento");

        tabelasMenu.add(nacionalidadeItem);
        tabelasMenu.add(provinciaItem);
        tabelasMenu.add(municipioItem);
        tabelasMenu.add(comunaItem);
        tabelasMenu.add(formadorItem);
        tabelasMenu.add(cursoItem);
        tabelasMenu.add(metodoPagamentoItem);
        tabelasMenu.add(tipoDeDocumentoItem);

        // adicionando iten do menu operacoes
        registarInscricaoItem = new JMenuItem("Nova Inscricao");
        registarSaidaItem = new JMenuItem("Registar Saida");

        operacoesMenu.add(registarInscricaoItem);
        operacoesMenu.add(registarSaidaItem);

        
        //itens do menu listar
        listagensMenu.add(listarFormandoItem = new JMenuItem("Listar Formandos"));
        listagensMenu.addSeparator();
        listagensMenu.add(pesquisarFormandoItem = new JMenuItem("Pesquisar Formandos"));


        // adicionando eventos listeners
        novoFormandoItem.addActionListener(this);
        sairItem.addActionListener(this);
        nacionalidadeItem.addActionListener(this);
        listarFormandoItem.addActionListener(this); 
        provinciaItem.addActionListener(this);
        comunaItem.addActionListener(this);
        cursoItem.addActionListener(this);
        metodoPagamentoItem.addActionListener(this);
        formadorItem.addActionListener(this);
        tipoDeDocumentoItem.addActionListener(this);
        pesquisarFormandoItem.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        // criando eventos de clic
        if(event.getSource() == novoFormandoItem)
            new FormandoVisao();
        
        if(event.getSource() == listarFormandoItem)
            FormandoFile.listarFormandos();
        if(event.getSource() == pesquisarFormandoItem)
            new PesquisarFormando();
            if(event.getSource() == nacionalidadeItem)
                Tabela2.editarNovosItems("Nacionalidade.tab", "Nova Nacionalidade");
        
            if(event.getSource() == provinciaItem)
                Tabela2.editarNovosItems("Provincia.tab","Nova Provincia");

            if(event.getSource() == municipioItem)
                Tabela3_2.editarNovosItems("Provincia.tab", "Municipio.tab", "Provincia", "Municipio", "Novo Municipio");
        
            if(event.getSource() == comunaItem)
            Tabela3_3.editarNovosItems("Provincia.tab", "Municipio.tab", "Comunas.tab", "Provincias", "Municipios", "Comunas", "Nova Comuna");
        
            if(event.getSource() == cursoItem)
                Tabela2.editarNovosItems("Curso.tab", "Novo Curso");
        
            if(event.getSource() == formadorItem)
                Tabela2.editarNovosItems("Formador.tab", "Novo Formador");
        
            if(event.getSource() == metodoPagamentoItem)
                Tabela2.editarNovosItems("MetodoPagamento.tab","Novo Metodo de Pagamento");
            
                if(event.getSource() == tipoDeDocumentoItem)
                    Tabela2.editarNovosItems("TipoDeDocumento.tab", "Novo Documento");
                else if(event.getSource() == sairItem)
            dispose();
    }

    public static void main(String args[])
    {
        Vector_Tabelas.inic();
        new MenuPrincipal();
    }
}