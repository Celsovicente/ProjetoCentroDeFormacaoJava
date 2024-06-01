import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 

public class MenuPrincipal extends JFrame 
{
    private JMenuBar menuBar;
    private JMenu ficheiroMenu, operacoesMenu, tabelaMenu, ajudaMenu;
    private JMenuItem novoFormandoItem, eliminarFromandoItem, atualizarFormandoItem, sairItem;
    private JMenuItem formadorItem, cursoItem, nacionalidadeItem, provinciaMoradaItem, municipioMoradaItem, comunaMoradaItem;
    private JMenuItem sobreAppItem, sobreAutorItem;

    public MenuPrincipal()
    {
        super("Menu Principal");
        
        instanciarObjetos();

        setSize(800, 600);

        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
        
        setVisible(true);
    }

    public void instanciarObjetos()
    {
        menuBar = new JMenuBar();
        ficheiroMenu = new JMenu("Ficheiro");
        ficheiroMenu.setMnemonic('F');

        ajudaMenu = new JMenu("Ajuda");
        ajudaMenu.setMnemonic('A');

        tabelaMenu = new JMenu("Tabelas");
        tabelaMenu.setMnemonic('T');

        operacoesMenu = new JMenu("Operacoes");
        operacoesMenu.setMnemonic('O');

        //instanciando os objetos dos formandos
        novoFormandoItem = new JMenuItem("Novo Formando");
        novoFormandoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));        
        eliminarFromandoItem = new JMenuItem("Eliminar Formando");
        atualizarFormandoItem = new JMenuItem("Atualizar Formando");
        sairItem = new JMenuItem("Sair");

        //Itens do menu ficheiro
        ficheiroMenu.add(novoFormandoItem);
        ficheiroMenu.add(atualizarFormandoItem);
        ficheiroMenu.add(eliminarFromandoItem);
        ficheiroMenu.addSeparator();
        ficheiroMenu.add(sairItem);
        
        //Itens das Tabelas
        nacionalidadeItem = new JMenuItem("Nacionalidade");
        provinciaMoradaItem = new JMenuItem("Provincia");     
        municipioMoradaItem = new JMenuItem("Municipio");   
        comunaMoradaItem = new JMenuItem("Comuna");
        formadorItem = new JMenuItem("Formador");
        cursoItem = new JMenuItem("Curso");

        //Adicionando as tabelas no Menu
        tabelaMenu.add(nacionalidadeItem);
        tabelaMenu.add(provinciaMoradaItem);
        tabelaMenu.add(municipioMoradaItem);
        tabelaMenu.add(comunaMoradaItem);
        tabelaMenu.add(formadorItem);
        tabelaMenu.add(cursoItem);

        //Tabelas do Menu Ajuda
        sobreAppItem = new JMenuItem("Sobre a Aplicacao");
        sobreAutorItem = new JMenuItem("Sobre o Autor");

        ajudaMenu.add(sobreAppItem);
        ajudaMenu.add(sobreAutorItem);

        // Adcionando os menus na tela
        menuBar.add(ficheiroMenu);
		menuBar.add(operacoesMenu);
		menuBar.add(tabelaMenu);
		menuBar.add(ajudaMenu);
    }

    public void ationPerformed(ActionEvent event)
    {

    }

    public static void main(String args[])
    {
        new MenuPrincipal();
    }
}