import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastrarAlunos extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JTextField nome, email, telefone, curso;
    JLabel escreverNome, escreverEmail, escreverTelefone, escreverCurso, titulo;
    JPanel painel, painelTitulo, painelNome, painelEmail, painelTelefone, painelCursos, painelBotao;
    JButton btnCadastrar, btnVisualizar;
    JComboBox cursosCB;

    CadastrarAlunos() {

        super("Cadastro de alunos FMD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] cursos = {"---Informe seu curso---", "Administração",
                "Agronomia", "Arquitetura e Urbanismo", "Ciências contábeis", "Direito",
                "Engenharia Civil", "Engenharia de Produção", "Medicina Veterinária", "Sistemas de Informação"};
        cursosCB = new JComboBox(cursos);
        cursosCB.setPreferredSize(new Dimension(450, 50));

        painel = new JPanel(new GridLayout(6, 1));
        Font font = new Font("Comic Sans Ms", Font.BOLD, 20);
        Font font1 = new Font("Comic Sans Ms", Font.BOLD, 18);
        Font font2 = new Font("Gabriola", Font.BOLD, 15);

        painelTitulo = new JPanel();
        painelNome = new JPanel();
        painelEmail = new JPanel();
        painelTelefone = new JPanel();
        painelCursos = new JPanel();

        titulo = new JLabel("Informe seus dados");
        escreverNome = new JLabel("Nome");
        escreverEmail = new JLabel("Email");
        escreverTelefone = new JLabel("Telefone");
        escreverCurso = new JLabel("Curso");

        Color corGeral = new Color(0, 103, 146);
        titulo.setForeground(corGeral);
        titulo.setFont(font);

        nome = new JTextField();
        nome.setPreferredSize(new Dimension(450, 50));
        email = new JTextField();
        email.setPreferredSize(new Dimension(450, 50));
        telefone = new JTextField();
        telefone.setPreferredSize(new Dimension(450, 50));
        curso = new JTextField();

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setForeground(Color.white);
        btnCadastrar.setBackground(corGeral);
        btnCadastrar.setFont(font1);
        btnCadastrar.setPreferredSize(new Dimension(140, 40));

        btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setForeground(Color.white);
        btnVisualizar.setBackground(corGeral);
        btnVisualizar.setFont(font1);
        btnVisualizar.setPreferredSize(new Dimension(140, 40));

        btnCadastrar.addActionListener(this);
        btnVisualizar.addActionListener(this);

        painelTitulo.add(titulo);

        painelNome.add(escreverNome);
        painelNome.add(nome);
        escreverNome.setForeground(corGeral);
        nome.setFont(font2);
        escreverNome.setFont(font1);

        painelEmail.add(escreverEmail);
        painelEmail.add(email);
        escreverEmail.setForeground(corGeral);
        email.setFont(font2);
        escreverEmail.setFont(font1);

        painelTelefone.add(escreverTelefone);
        painelTelefone.add(telefone);
        escreverTelefone.setForeground(corGeral);
        telefone.setFont(font2);
        escreverTelefone.setFont(font1);

        painelCursos.add(escreverCurso);
        painelCursos.add(cursosCB);
        escreverCurso.setForeground(corGeral);
        escreverCurso.setFont(font1);
        cursosCB.setBackground(Color.white);
        cursosCB.setFont(font1);

        painelBotao = new JPanel(new FlowLayout());
        painelBotao.add(btnCadastrar, JButton.CENTER);
        painelBotao.add(btnVisualizar);

        painelTitulo.setBackground(Color.white);
        painelNome.setBackground(Color.white);
        painelEmail.setBackground(Color.white);
        painelTelefone.setBackground(Color.white);
        painelCursos.setBackground(Color.white);
        painelBotao.setBackground(Color.white);


        painel.add(painelTitulo);
        painel.add(painelNome);
        painel.add(painelEmail);
        painel.add(painelTelefone);
        painel.add(painelCursos);
        painel.add(painelBotao);

        add(painel);

        setResizable(false);
        setSize(700, 700);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        CadastrarAlunos abre = new CadastrarAlunos();
        abre.setVisible(true);

    }
    public CadastrarAlunos getCadastro() {
        CadastrarAlunos cadastra = new CadastrarAlunos();
        cadastra.setNomes(nome.getText());
        cadastra.setTelefones(Integer.parseInt(telefone.getText()));
        cadastra.setEmails(email.getText());
        cadastra.setCursos(cursosCB.getSelectedItem());
        return cadastra;
    }

    public ArrayList<CadastrarAlunos> getLista() {
        CadastrarAlunos cadastro = getCadastro();
        ArrayList<CadastrarAlunos> lista = new ArrayList<>();
        lista.add(cadastro);
        return lista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btnCadastrar)) {
            getCadastro();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } else if (ae.getSource().equals(btnVisualizar)) {
            System.out.println(getLista());
            JOptionPane.showMessageDialog(null, getLista());
        }

    }
    private String nomes;
    private int telefones;
    private Object cursos;
    private String emails;


    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public int getTelefones() {
        return telefones;
    }

    public void setTelefones(int telefones) {
        this.telefones = telefones;
    }

    public Object getCursos() {
        return cursos;
    }

    public void setCursos(Object cursos) {
        this.cursos = cursos;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Cadastro: \n" +
                "Curso: " + cursos + "\n " +
                "Nome: " + nomes + "\n " +
                "Telefone: " + telefones + "\n " +
                "Email: " + emails + "\n\n";
    }
}
