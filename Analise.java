/*------------------------------------
Tema: Gestão de um Centro de Formação Profissional
Nome: Celso Vicente
Numero: 33019
Ficheiro: CentroFormacao.java
Data: 20.05.2024
--------------------------------------*/

/*
1. Objectivo
Este projecto tem o objectivo de registar a inscrição de alunos, acompanhar 
o progresso dos cursos e gerir os pagamentos dentro de um centro de formação profissional.

2. Visao [Interfaces Graficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipal
- FormandoVisao
- InscricaoVisao
- PagamentoVisao

3. Entidades Fortes e Seus Atributos (Modelo)
- FormandoModelo
    int id
    String nome
    String tipoDocumento
    String numeroDocumento
    String dataNascimento
    String nacionalidade
    String provincia
    String municipio
    String comuna
    String genero
    String telefone
    String email

- InscricaoModelo
    int id
    FormandoModelo aluno
    CursoModelo curso
    String dataInscricao
    String dataInicioCurso
    String nomeFormador
    String telefoneFormador

- PagamentoModelo
    int id
    InscricaoModelo inscricao
    double valor
    String dataPagamento
    String metodoPagamento
  
4. Ficheiro
- AlunoFile.dat
- InscricaoFile.dat
- PagamentoFile.dat

5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- Formadores.tab
- Cursos.tab
- MetodosPagamento.tab
- Nacionalidades.tab
- Municipio.tab
- Comuna.tab
- TipoDocumento.tab

6 Listagem Geral
listagem por id
listagem por Curso

7. Diversos
7.1 - Implementação: Java Swing
7.2 - IDE: Notepad++
*/ 