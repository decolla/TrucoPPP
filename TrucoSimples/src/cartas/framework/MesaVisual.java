package cartas.framework;

import javax.swing.*;
import java.awt.*;

// classe abstrata que serve de base para as mesas específicas
public abstract class MesaVisual extends JFrame implements JogoListener {

    protected JogoBase jogo;


    // campo onde as cartas são jogadas
    protected JPanel campo;
    // lugares onde as mãos dos jogadores ficarão
    protected JPanel areaNorte;
    protected JPanel areaSul;
    protected JPanel areaLeste;
    protected JPanel areaOeste;

    public MesaVisual(JogoBase jogo, String titulo){
        // qual jogo foi escolhido
        this.jogo = jogo;

        // configuração inicial da janela
        this.setTitle(titulo);
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());



        // campo onde as cartas serão jogadas
        campo = new JPanel();
        campo.setBackground(new Color(40, 100, 60));
        this.add(campo, BorderLayout.CENTER);



        // local do jogador norte
        areaNorte = new JPanel();
        JScrollPane scrollNorte = new JScrollPane(areaNorte);
        scrollNorte.setBorder(null);
        areaNorte.setBackground(Color.darkGray);
        areaNorte.setPreferredSize(new Dimension(1000, 200));
        this.add(scrollNorte, BorderLayout.NORTH);



        // local do jogador sul
        areaSul = new JPanel();
        JScrollPane scrollSul = new JScrollPane(areaSul);
        scrollSul.setBorder(null);
        areaSul.setBackground(Color.darkGray);
        areaSul.setPreferredSize(new Dimension(1000, 200));
        this.add(scrollSul, BorderLayout.SOUTH);



        // local do jogador leste
        areaLeste = new JPanel();
        JScrollPane scrollLeste = new JScrollPane(areaLeste);
        scrollLeste.setBorder(null);
        areaLeste.setBackground(Color.darkGray);
        areaLeste.setPreferredSize(new Dimension(200, 800));
        this.add(scrollLeste, BorderLayout.EAST);



        // local do jogador oeste
        areaOeste = new JPanel();
        JScrollPane scrollOeste = new JScrollPane(areaOeste);
        scrollOeste.setBorder(null);
        areaOeste.setPreferredSize(new Dimension(200, 800));
        areaOeste.setBackground(Color.darkGray);
        this.add(scrollOeste, BorderLayout.WEST);



        // adiciona a instância da classe como listener do jogo
        this.jogo.adicionarListener(this);
    }

    @Override
    // sempre que uma ação ocorrer, a tela será atualizada
   public void onEstadoAlterado(){
        atualizarTela();
    }

    @Override

    public void onMensagem(String mensagem){
        JOptionPane.showMessageDialog(this,mensagem);
    }

    @Override
    public void onJogoTerminado(String mensagemVitoria){
        JOptionPane.showMessageDialog(this,"Fim de jogo! " + mensagemVitoria);

    }

    // obriga as subclasses a implementarem a atualização específica do visual
    protected abstract void atualizarTela();

}

