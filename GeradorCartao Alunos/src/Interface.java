import java.awt.Dimension;
import java.awt.EventQueue;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.GridLayout;


import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;


public class Interface {

	private JFrame frmGeradorCartaoRespostas;
	private JTextField tf_Turma;
	private JTextField loadtf_Turma;
	static GerarCartao gerarCartao;
	private JTextField tf_Nq;
	static String escola = "";
	
	JPanel[] Questoes1 = new JPanel[50];
	JPanel Header1 = new JPanel();
	private JRadioButton[] rb1 = new JRadioButton[50*5];
	JLabel[] lbNumero1 = new JLabel[50];
	ButtonGroup[] bg1 = new ButtonGroup[50];
	JComboBox[] cb1 = new JComboBox[50];
			
	
	JPanel[] Questoes2 = new JPanel[50];
	JPanel Header2 = new JPanel();
	private JRadioButton[] rb2 = new JRadioButton[50*5];
	JLabel[] lbNumero2 = new JLabel[50];
	ButtonGroup[] bg2 = new ButtonGroup[50];
	JComboBox[] cb2 = new JComboBox[50];
	

	JPanel[] Questoes3 = new JPanel[50];
	JPanel Header3 = new JPanel();
	private JRadioButton[] rb3 = new JRadioButton[50*5];
	JLabel[] lbNumero3 = new JLabel[50];
	ButtonGroup[] bg3 = new ButtonGroup[50];
	JComboBox[] cb3 = new JComboBox[50];
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmGeradorCartaoRespostas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeradorCartaoRespostas = new JFrame();
		frmGeradorCartaoRespostas.setTitle("Gerador Cartao Respostas");
	
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		   frmGeradorCartaoRespostas.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight()-250);
		
		frmGeradorCartaoRespostas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeradorCartaoRespostas.getContentPane().setLayout(null);
		
		
		
		
		
		
	/////
			/*
			 * Rotina para gerar os 50 itens necessarios para o cartao resposta
			 * Cada rotina leva um grupo com o seu nome. Todos os elementos sao colocados dentro do panel rolante Questoes1
			 */
			
		
		
		
		
		
		/*
		 * Inicio grupo 1
		 */
		
		JPanel container1 = new JPanel();
		frmGeradorCartaoRespostas.getContentPane().add(container1);
		container1.setLayout(new GridLayout(50, 1, 0, 0));
		JLabel lblABC1 = new JLabel("         A    B     C     C'    D   Mat\u00E9ria");
		lblABC1.setBounds(0, 0, 250, 10);
		
		
		
		JPanel[] Questoes1 = new JPanel[50];
		JPanel Header1 = new JPanel();
		final JRadioButton[] rb1 = new JRadioButton[50*5];
		JLabel[] lbNumero1 = new JLabel[50];
		final ButtonGroup[] bg1 = new ButtonGroup[50];
		final JComboBox[] cb1 = new JComboBox[50];
		JScrollPane scrollPane1 = new JScrollPane(container1);
		JLabel lvlvazio1[] = new JLabel[50];
		
		
		frmGeradorCartaoRespostas.getContentPane().add(Header1);
		
		Header1.setLayout(null);
		Header1.add(lblABC1);
		for(int i=0;i<50;i++)
		{
		
		Questoes1[i] = new JPanel();
		
		if(i< 9)
			lbNumero1[i]= new JLabel("00"+(i+1));
		else
				lbNumero1[i]= new JLabel("0"+(i+1));
			
		
		bg1[i] = new ButtonGroup();
		cb1[i] = new JComboBox();
		
		container1.add(Questoes1[i]);
		Questoes1[i].setLayout(new BoxLayout(Questoes1[i], BoxLayout.X_AXIS));
		Questoes1[i].add(lbNumero1[i]);
		
		for(int j =0; j<5;j++)
		{
			if(j==0)
			rb1[i*5+j] = new JRadioButton("",true);
			else
			rb1[i*5+j] = new JRadioButton("");
			Questoes1[i].add(rb1[i*5+j]);
		}
		
		
		for(int j=0; j<5; j++)
		{
			bg1[i].add(rb1[i*5+j]);
		}
		
		cb1[i].setModel(new DefaultComboBoxModel(new String[] {"INGLÊS","ESPANHOL"	,"LITERATURA","GRAMÁTICA","HISTÓRIA","GEOGRAFIA","FILOSOFIA","SOCIOLOGIA","ARTES","MÚSICA","ED. FÍSICA","ALGEBRA","DESENHO GEO","QUÍMICA","BIOLOGIA","FÍSICA","CIÊNCIAS"}));
		
				
		Questoes1[i].add(cb1[i]);
		lvlvazio1[i] =new JLabel("   ");
		Questoes1[i].add(lvlvazio1[i]);
		}
				
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		Header1.setBounds(280,40-2,350, 10); // adicionado ao Frame
		scrollPane1.setBounds(280, 50, 300, 400);
		frmGeradorCartaoRespostas.getContentPane().add(scrollPane1);

		/*
		 * Inicio grupo 2
		 */
	
				
		JPanel container2 = new JPanel();
		frmGeradorCartaoRespostas.getContentPane().add(container2);
		container2.setLayout(new GridLayout(50, 1, 0, 0));
		JLabel lblABC2 = new JLabel("         A    B     C     C'    D   Mat\u00E9ria");
		lblABC2.setBounds(0, 0, 250, 10);
		
		
		
		JPanel[] Questoes2 = new JPanel[50];
		JPanel Header2 = new JPanel();
		final JRadioButton[] rb2 = new JRadioButton[50*5];
		JLabel[] lbNumero2 = new JLabel[50];
		final ButtonGroup[] bg2 = new ButtonGroup[50];
		final JComboBox[] cb2 = new JComboBox[50];
		JScrollPane scrollPane2 = new JScrollPane(container2);
		JLabel lvlvazio2[] = new JLabel[50];
		
		frmGeradorCartaoRespostas.getContentPane().add(Header2);
		
		Header2.setLayout(null);
		Header2.add(lblABC2);
		for(int i=0;i<50;i++)
		{
		
		Questoes2[i] = new JPanel();
		
		
			if(i<49)
				lbNumero2[i]= new JLabel("0"+(i+1 +50));
			else
				lbNumero2[i]= new JLabel(""+(i+1+50));
		
		bg2[i] = new ButtonGroup();
		cb2[i] = new JComboBox();
		
		container2.add(Questoes2[i]);
		Questoes2[i].setLayout(new BoxLayout(Questoes2[i], BoxLayout.X_AXIS));
		Questoes2[i].add(lbNumero2[i]);
		
		for(int j =0; j<5;j++)
		{
			if(j==0)
			rb2[i*5+j] = new JRadioButton("",true);
			else
			rb2[i*5+j] = new JRadioButton("");
			Questoes2[i].add(rb2[i*5+j]);
		}
		
		
		for(int j=0; j<5; j++)
		{
			bg2[i].add(rb2[i*5+j]);
		}
		
		cb2[i].setModel(new DefaultComboBoxModel(new String[] {"INGLÊS","ESPANHOL"	,"LITERATURA","GRAMÁTICA","HISTÓRIA","GEOGRAFIA","FILOSOFIA","SOCIOLOGIA","ARTES","MÚSICA","ED. FÍSICA","ALGEBRA","DESENHO GEO","QUÍMICA","BIOLOGIA","FÍSICA","CIÊNCIAS"}));
		
		
		Questoes2[i].add(cb2[i]);
		lvlvazio2[i] =new JLabel("   ");
		Questoes2[i].add(lvlvazio2[i]);
		}
				
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		Header2.setBounds(630,40-2,350, 10); // adicionado ao Frame
		scrollPane2.setBounds(630, 50, 300, 400);
		frmGeradorCartaoRespostas.getContentPane().add(scrollPane2);
		
		
		/*
		 * Inicio grupo 3
		 */
	
				
		JPanel container3 = new JPanel();
		frmGeradorCartaoRespostas.getContentPane().add(container3);
		container3.setLayout(new GridLayout(50, 1, 0, 0));
		JLabel lblABC3 = new JLabel("         A    B     C     C'    D   Mat\u00E9ria");
		lblABC3.setBounds(0, 0, 250, 10);
		
		
		
		JPanel[] Questoes3 = new JPanel[50];
		JPanel Header3 = new JPanel();
		final JRadioButton[] rb3 = new JRadioButton[50*5];
		JLabel[] lbNumero3 = new JLabel[50];
		final ButtonGroup[] bg3 = new ButtonGroup[50];
		final JComboBox[] cb3 = new JComboBox[50];
		JScrollPane scrollPane3 = new JScrollPane(container3);
		JLabel lvlvazio3[] = new JLabel[50];
		
		frmGeradorCartaoRespostas.getContentPane().add(Header3);
		
		Header3.setLayout(null);
		Header3.add(lblABC3);
		for(int i=0;i<50;i++)
		{
		
		Questoes3[i] = new JPanel();
		
	
		lbNumero3[i]= new JLabel(""+(i+1 +100));
		
		
		bg3[i] = new ButtonGroup();
		cb3[i] = new JComboBox();
		
		container3.add(Questoes3[i]);
		Questoes3[i].setLayout(new BoxLayout(Questoes3[i], BoxLayout.X_AXIS));
		Questoes3[i].add(lbNumero3[i]);
		
		for(int j =0; j<5;j++)
		{
			if(j==0)
			rb3[i*5+j] = new JRadioButton("",true);
			else
			rb3[i*5+j] = new JRadioButton("");
			Questoes3[i].add(rb3[i*5+j]);
		}
		
		
		for(int j=0; j<5; j++)
		{
			bg3[i].add(rb3[i*5+j]);
		}
		
		cb3[i].setModel(new DefaultComboBoxModel(new String[] {"INGLÊS","ESPANHOL"	,"LITERATURA","GRAMÁTICA","HISTÓRIA","GEOGRAFIA","FILOSOFIA","SOCIOLOGIA","ARTES","MÚSICA","ED. FÍSICA","ALGEBRA","DESENHO GEO","QUÍMICA","BIOLOGIA","FÍSICA","CIÊNCIAS"}));
		
		
		Questoes3[i].add(cb3[i]);
		lvlvazio3[i] =new JLabel("   ");
		Questoes3[i].add(lvlvazio3[i]);
		}
				
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		Header3.setBounds(980,40-2,350, 10); // adicionado ao Frame
		scrollPane3.setBounds(980, 50, 300, 400);
		frmGeradorCartaoRespostas.getContentPane().add(scrollPane3);
		
		
		
		
		
		
		/* FINAL GERAR PANELS AUTOMATICAMENTE*/
		/* INICIO PANEL À ESQUERDA COM AS INFORMACOES DO CABECALHO E LOAD SCREEN*/
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 260, 400);
		panel.setLayout(null);
		frmGeradorCartaoRespostas.getContentPane().add(panel);
		
		JLabel lblSrie = new JLabel("Turma");
		lblSrie.setBounds(5, 200, 41, 14);
		panel.add(lblSrie);
		
		JLabel lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(75, 200, 36, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bimestre");
		lblNewLabel_1.setBounds(135, 200, 55, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano");
		lblNewLabel_2.setBounds(200, 200, 36, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("n\u00BA d\u00EDgitos Matr\u00EDcula");
		lblNewLabel_3.setBounds(5, 260, 123, 14);
		panel.add(lblNewLabel_3);
		
		tf_Turma = new JTextField();
		tf_Turma.setBounds(4, 220, 41, 20);
		tf_Turma.setText("Turma");
		tf_Turma.setToolTipText("1EM, 2EM, 3EM, 9EFA, 9EFB, 8EFA ....");
		tf_Turma.setColumns(10);		
		panel.add(tf_Turma);

		
		
		final JComboBox cb_Tipo = new JComboBox();
		cb_Tipo.setBounds(76, 220, 35, 20);
		cb_Tipo.setModel(new DefaultComboBoxModel(new String[] {"I", "V", "S"}));
		cb_Tipo.setToolTipText("Selecione o tipo da prova I: Interdisciplinar, S: Simulado");
		cb_Tipo.setMaximumRowCount(3);
		panel.add(cb_Tipo);
		
		final JComboBox cb_Bimestre = new JComboBox();
		cb_Bimestre.setBounds(136, 220, 36, 20);
		cb_Bimestre.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cb_Bimestre.setToolTipText("Selecione o Bimestre 1,2,3 ou 4");
		cb_Bimestre.setMaximumRowCount(4);
		panel.add(cb_Bimestre);
		
		final JComboBox cb_Ano = new JComboBox();
		cb_Ano.setBounds(197, 220, 58, 20);
		cb_Ano.setModel(new DefaultComboBoxModel(new String[] {"2019","2020"}));
		cb_Ano.setToolTipText("Selecione o ano 2018, 2019,2020");
		cb_Ano.setMaximumRowCount(3);
		panel.add(cb_Ano);
		
		final JComboBox cb_nMatricula = new JComboBox();
		cb_nMatricula.setBounds(120, 260, 41, 20);
		cb_nMatricula.setModel(new DefaultComboBoxModel(new String[] {"7", "8", "9"}));
		cb_nMatricula.setToolTipText("Selecione o numero de digitos na matr\u00EDcula da escola");
		cb_nMatricula.setMaximumRowCount(4);
		panel.add(cb_nMatricula);
		
		JButton btnGerarCartao = new JButton("Gerar Cartao");
		btnGerarCartao.setBounds(50, 290, 130, 23);
		panel.add(btnGerarCartao);
		
		JLabel label = new JLabel("_");
		label.setBounds(55, 200, 11, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("_");
		label_1.setBounds(121, 200, 11, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("_");
		label_2.setBounds(185, 200, 11, 14);
		panel.add(label_2);
		
		// Parte LOAD antiga BASE
		
		JLabel loadlblSrie = new JLabel("Turma");
		loadlblSrie.setBounds(5, 50, 41, 14);
		panel.add(loadlblSrie);
		
		JLabel loadlblNewLabel = new JLabel("Tipo");
		loadlblNewLabel.setBounds(75, 50, 36, 14);
		panel.add(loadlblNewLabel);
		
		JLabel loadlblNewLabel_1 = new JLabel("Bimestre");
		loadlblNewLabel_1.setBounds(135, 50, 55, 14);
		panel.add(loadlblNewLabel_1);
		
		JLabel loadlblNewLabel_2 = new JLabel("Ano");
		loadlblNewLabel_2.setBounds(200, 50, 36, 14);
		panel.add(loadlblNewLabel_2);
		
		
		loadtf_Turma = new JTextField();
		loadtf_Turma.setBounds(4, 70, 41, 20);
		loadtf_Turma.setText("Turma");
		loadtf_Turma.setToolTipText("1EM, 2EM, 3EM, 9EFA, 9EFB, 8EFA ....");
		loadtf_Turma.setColumns(10);		
		panel.add(loadtf_Turma);

		
		
		final JComboBox loadcb_Tipo = new JComboBox();
		loadcb_Tipo.setBounds(76, 70, 35, 20);
		loadcb_Tipo.setModel(new DefaultComboBoxModel(new String[] {"I", "V", "S"}));
		loadcb_Tipo.setToolTipText("Selecione o tipo da prova I: Interdisciplinar, S: Simulado");
		loadcb_Tipo.setMaximumRowCount(3);
		panel.add(loadcb_Tipo);
		
		final JComboBox loadcb_Bimestre = new JComboBox();
		loadcb_Bimestre.setBounds(136, 70, 36, 20);
		loadcb_Bimestre.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		loadcb_Bimestre.setToolTipText("Selecione o Bimestre 1,2,3 ou 4");
		loadcb_Bimestre.setMaximumRowCount(4);
		panel.add(loadcb_Bimestre);
		
		final JComboBox loadcb_Ano = new JComboBox();
		loadcb_Ano.setBounds(197, 70, 58, 20);
		loadcb_Ano.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019"}));
		loadcb_Ano.setToolTipText("Selecione o ano 2018, 2019");
		loadcb_Ano.setMaximumRowCount(3);
		panel.add(loadcb_Ano);
		
		
		JButton loadbtnCarregarCartao = new JButton("Carregar Cartao");
		loadbtnCarregarCartao.setBounds(50, 100, 130, 23);
		panel.add(loadbtnCarregarCartao);
		
		JLabel loadlabel = new JLabel("_");
		loadlabel.setBounds(55, 50, 11, 14);
		panel.add(loadlabel);
		
		JLabel loadlabel_1 = new JLabel("_");
		loadlabel_1.setBounds(121, 50, 11, 14);
		panel.add(loadlabel_1);
		
		JLabel loadlabel_2 = new JLabel("_");
		loadlabel_2.setBounds(185, 50, 11, 14);
		panel.add(loadlabel_2);
		
		JLabel lblNumeroQuestoes = new JLabel("N\u00FAmero Questoes");
		lblNumeroQuestoes.setBounds(5, 152, 130, 14);
		panel.add(lblNumeroQuestoes);
		
		tf_Nq = new JTextField();		
		tf_Nq.setToolTipText("Defina Numero de questoes da prova");
		tf_Nq.setText("nQ");
		tf_Nq.setBounds(110, 146, 50, 20);
		panel.add(tf_Nq);
		tf_Nq.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(170, 145, 90, 23);
		panel.add(btnAtualizar);
	
		
		
		
		
		
		
	
		tf_Turma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tf_Turma.setText("");
			}
		});
		
		
		loadtf_Turma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				loadtf_Turma.setText("");
			}
		});
		
		tf_Nq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tf_Nq.setText("");
			}
		});
		
		
		
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int nq= Integer.parseInt(tf_Nq.getText());
				// habilita todos os checkbox e radiobuttons
				
				for(int i =0; i<50;i++)
				{
					cb1[i].setEnabled(true);
					cb2[i].setEnabled(true);
					cb3[i].setEnabled(true);
					for(int j=0;j<5;j++)
					{
						rb1[i*5 +j].setEnabled(true);
						rb2[i*5 +j].setEnabled(true);
						rb3[i*5 +j].setEnabled(true);
					}
				}
				
				int diferenca =150 -nq;
				for (int i=0;i<diferenca;i++)
					{
					
					if((i+nq)<50)
					{
						cb1[i +nq].setEnabled(false);
						for(int j=0;j<5;j++)
						rb1[(i+nq)*5+j].setEnabled(false);
						
					}
					else
						if(( i+nq) <100)
						{
							cb2[i + nq-50].setEnabled(false);
							for(int j=0;j<5;j++)
								rb2[(i+nq -50)*5+j].setEnabled(false);
						}	
						else
						{
							cb3[i + nq-100].setEnabled(false);
							for(int j=0;j<5;j++)
								rb3[(i+nq -100)*5+j].setEnabled(false);
						}
					}
				
			}
		});
	
		btnGerarCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String[] sequencia= new String[6];
				sequencia[0] = tf_Turma.getText();
				sequencia[1] = cb_Tipo.getSelectedItem().toString();
				sequencia[2] = cb_Bimestre.getSelectedItem().toString();
				sequencia[3] = cb_Ano.getSelectedItem().toString();
				sequencia[4] = "0";
				sequencia[5] = cb_nMatricula.getSelectedItem().toString();
				GerarTxtIstrucaoCabecalho(sequencia);
				
				String char0="";
		    	String char1="";
		    	String char2="";
		    	
		    	
				String nome = sequencia[0] +"_"+sequencia[1] +"_"+sequencia[2] +"_"+sequencia[3]; 
				
				
				int nq = Integer.parseInt(tf_Nq.getText());
				String[] linha = new String[nq];
				
				for(int i=0;i<nq;i++)
				{
					char0 =""+(i+1);
					// faz a leitura do grupo 1 0->50
					if(i<50) {
					for  (int j=0;j<5;j++)
						if( rb1[i*5+j].isSelected())
					char1 =""+(j+1);
					char2 =""+cb1[i].getSelectedIndex();
					}
					// faz a leitura do grupo 2 50->100
					if((i>=50 )&&(i<100)) {
						for  (int j=0;j<5;j++)
							if( rb2[(i-50)*5+j].isSelected())
						char1 =""+(j+1);
						char2 =""+cb2[i-50].getSelectedIndex();
					}
					// faz a leitura do grupo 3 100->150
					if(i>=100) {
						for  (int j=0;j<5;j++)
							if( rb3[(i-100)*5+j].isSelected())
						char1 =""+(j+1);
						char2 =""+cb3[i-100].getSelectedIndex();
					}
					
					linha[i]= char0 + "\t" + char1 + "\t" + char2;
				}
				
				
				GerarTxtBase(nome,linha);
				GerarTxtBaseCorretor(nome,linha);
				gerarCartao= new GerarCartao(nome);
				
			}
		});
		
		loadbtnCarregarCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String[] sequencia= new String[6];
				sequencia[0] = loadtf_Turma.getText();
				sequencia[1] = loadcb_Tipo.getSelectedItem().toString();
				sequencia[2] = loadcb_Bimestre.getSelectedItem().toString();
				sequencia[3] = loadcb_Ano.getSelectedItem().toString();
						    	
				String nome = sequencia[0] +"_"+sequencia[1] +"_"+sequencia[2] +"_"+sequencia[3]; 
				
					
		    	GerarCartao GerarCartao = new GerarCartao();
		    	int[] sequenciaBaseTipo = GerarCartao.LerBaseGabarito(nome);
		    	int[] sequenciaBaseMaterias = GerarCartao.LerBaseGabaritoMaterias(nome);
		    	int nq = sequenciaBaseTipo.length;
		    	tf_Nq.setText(""+nq);
		    	
				for(int i=0;i<nq;i++)
				{
					if(i<50)
					{
					for(int j=0;j<5;j++)
						if(j==sequenciaBaseTipo[i]-1)
							rb1[i*5 +j].setSelected(true);
					cb1[i].setSelectedIndex(sequenciaBaseMaterias[i]);
					}
					if((i>=50) && (i<100))
					{
					for(int j=0;j<5;j++)
						if(j==sequenciaBaseTipo[i]-1)
							rb2[(i-50)*5 +j].setSelected(true);
					cb2[i-50].setSelectedIndex(sequenciaBaseMaterias[i]);
					}
					if(i>=100)
					{
					for(int j=0;j<5;j++)
						if(j==sequenciaBaseTipo[i]-1)
							rb3[(i-100)*5 +j].setSelected(true);
					cb3[i-100].setSelectedIndex(sequenciaBaseMaterias[i]);
					}
										
				}
				
				
				
				
				/*
				 * desabilitar checkbox e radio buttons que nao serao utilizados na formacao da base
				 */
				
				// habilita todos os checkbox e radiobuttons
				
				for(int i =0; i<50;i++)
				{
					cb1[i].setEnabled(true);
					cb2[i].setEnabled(true);
					cb3[i].setEnabled(true);
					for(int j=0;j<5;j++)
					{
						rb1[i*5 +j].setEnabled(true);
						rb2[i*5 +j].setEnabled(true);
						rb3[i*5 +j].setEnabled(true);
					}
				}
				// habilita somente o que for ser utilizado
				int diferenca =150 -nq;
				for (int i=0;i<diferenca;i++)
					{
					
					if((i+nq)<50)
					{
						cb1[i +nq].setEnabled(false);
						for(int j=0;j<5;j++)
						rb1[(i+nq)*5+j].setEnabled(false);
						
					}
					else
						if(( i+nq) <100)
						{
							cb2[i + nq-50].setEnabled(false);
							for(int j=0;j<5;j++)
								rb2[(i+nq -50)*5+j].setEnabled(false);
						}	
						else
						{
							cb3[i + nq-100].setEnabled(false);
							for(int j=0;j<5;j++)
								rb3[(i+nq -100)*5+j].setEnabled(false);
						}
					}
							
			}
		});
	}
	
	   
	
	public void GerarTxtIstrucaoCabecalho(String[] sequencia) 
    {
    
		
		/* --------------------
		 * Essa funcao tem objetivo de escrever um arquivo chamado "InstrucaoCabecalho.txt" 
		 *seguindo o padrao 
		 *
		 *SERIE - > 1EM, 2EM , 9EFA, 9EFB....
		 *Tipo -> I (Interdisciplinar), V( Verificacao), S (simulado)
		 *bimestre -> 1,2,3,4
		 *ano -> 2018, 2019
		 *nulo*
		 *Numero de digitos matricula -> 6,7,8,9
		 *
		 * ----------------- 
		*/
		
    	PrintWriter pWriter ;
    	FileWriter destino;
    	String linha0 = sequencia[0];
    	String linha1 = sequencia[1];
    	String linha2 = sequencia[2];
    	String linha3 = sequencia[3];
    	String linha4 = sequencia[4];
    	String linha5 = sequencia[5];
		try {
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			destino = new FileWriter(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/InstrucaoCabecalho.txt");
		   	pWriter = new PrintWriter(destino);
		   	
			
			pWriter.println(linha0);
			pWriter.println(linha1);
			pWriter.println(linha2);
			pWriter.println(linha3);
			pWriter.println(linha4);
			pWriter.println(linha5);
			
			pWriter.close();
    	   }
		 catch (IOException e) {
				e.printStackTrace();
			}
    }
	
	public void GerarTxtBase(String nome, String[] linha0) 
    {
    
		
		/* --------------------
		 * Essa funcao tem objetivo de escrever os arquivos da base 
		 *seguindo o padrao 
		 *
		 *numero questoes
		 *questao tipo materia
		 *questao tipo materia
		 *questao tipo materia
		 *
		 * ----------------- 
		*/
		
    	PrintWriter pWriter ;
    	FileWriter destino;
    	int nq =linha0.length;
    	
		try {
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			destino = new FileWriter(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Bases/"+nome+".txt");
		   	pWriter = new PrintWriter(destino);
		   	pWriter.println(nq);
			for(int i=0;i<nq;i++)
			{
				pWriter.println(linha0[i]);
			}
			
			
			pWriter.close();
    	   }
		 catch (IOException e) {
				e.printStackTrace();
			}
    }
	
	
	public void GerarTxtBaseCorretor(String nome, String[] linha0) 
    {
    
		
		/* --------------------
		 * Essa funcao tem objetivo de escrever os arquivos da base 
		 *seguindo o padrao 
		 *
		 *numero questoes
		 *questao tipo materia
		 *questao tipo materia
		 *questao tipo materia
		 *
		 * ----------------- 
		*/
		
    	PrintWriter pWriter ;
    	FileWriter destino;
    	int nq =linha0.length;
    	
		try {
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			destino = new FileWriter(enderecoDrop+"/Dropbox/Corretor" + escola +"/Main/Bases/"+nome+".txt");
		   	pWriter = new PrintWriter(destino);
		   	pWriter.println(nq);
			for(int i=0;i<nq;i++)
			{
				pWriter.println(linha0[i]);
			}
			
			
			pWriter.close();
    	   }
		 catch (IOException e) {
				e.printStackTrace();
			}
    }
	
}
