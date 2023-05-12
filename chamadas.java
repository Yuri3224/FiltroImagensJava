//jpanels, jframe e chamada de mtodos
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.io.File;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;

public class chamadas extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	File arquivo;
	private static final long serialVersionUID = 1L;
	private static final int larguraFinal = 640;
	private static final int alturaFinal = 640;
	public BufferedImage image = null;
	
	//metodo binarizacao
	
	
	static JTabbedPane tab = new JTabbedPane();
	public static void dimensoesJFrame(JFrame frame) {
		
		frame.setTitle("Photosop Caseiro");
		frame.setSize(larguraFinal,alturaFinal);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}
	static BufferedImage encaixarImagem(JLabel label, BufferedImage image) {

        int novaLargura = label.getWidth();
        int novaAltura = label.getHeight();

        if (novaLargura < 1 || novaAltura < 1) {
            return null;
        }

        BufferedImage imageTamanho = new BufferedImage(novaLargura, novaAltura, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imageTamanho.createGraphics();
        g.drawImage(image, 0, 0, novaLargura, novaAltura, null);
        g.dispose();
        label.setIcon(new ImageIcon(imageTamanho));
        return imageTamanho;
    }
	
	public void kernelsAndPanels() throws IOException {

		JFrame frame = new JFrame();
		
		JLabel labelOrigianal = new JLabel();
		JPanel panelOriginal = new JPanel();
		Border blackline = BorderFactory.createTitledBorder("Imagem original, sem edição");
		panelOriginal.setLayout(null);
		panelOriginal.setBorder(blackline);
		JButton escolher = new JButton("Escolher imagem");
		tab.add("Original", panelOriginal);
		panelOriginal.add(escolher);
		escolher.setBounds(230,25,150,30);
		labelOrigianal.setBounds(40,60,540,480);
		panelOriginal.add(labelOrigianal);
		
		
		
		
		escolher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelOriginal.removeAll();
				JFileChooser arquivo = new JFileChooser();
				arquivo.setDialogTitle("Escolha uma imagem");
				arquivo.setCurrentDirectory(new File(System.getProperty("user.home"),"Pictures"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Escolha a Imagem para aplicar os filtros", "png","jpg","jpeg","gif");
				arquivo.addChoosableFileFilter(filter);
				int res = arquivo.showSaveDialog(null);
				if(res == JFileChooser.APPROVE_OPTION) {
					File f = arquivo.getSelectedFile();
					arquivo.updateUI();
					
					try {
						image = ImageIO.read(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					encaixarImagem(labelOrigianal,image);
					System.out.println("Carregando...");
					
					
					
					

					double[] gauss3x3 = {0.0625, 0.125, 0.0625,
										0.125, 0.25, 0.125,
										0.0625, 0.125, 0.0625};
					
					int[] horin3x3 = {-1,-2,-1
					      	  		,0,0,0,
					      	  		1,2,1};
					
					int[] vert3x3 = {-1,0,1,
									-2,0,2,
									-1,0,1};
					
					int[] west3x3 = {-1,1,-1,
									 1,-2,-1,
									 1,1,-1};
		
					int[] laplace3x3 = {0,-1,0,
									   -1,4,-1,
									    0,-1,0};
					
					BufferedImage filtroGauss = metodos.saidaGauss(image, gauss3x3);

					BufferedImage filtroNeg = metodos.saidaNeg(image);
					BufferedImage filtroHorizon = metodos.saidaHorizon(image, horin3x3);
					BufferedImage filtroVert = metodos.saidaVert(image, vert3x3);
					BufferedImage filtroWest = metodos.saidaWest(image, west3x3);
					BufferedImage filtroLaplace = metodos.saidaLaplace(image, laplace3x3);
					panelOriginal.add(labelOrigianal);
					panelOriginal.setVisible(true);
					
					JPanel panelMediaMenu = new JPanel();
					Border bordaMediaMenu = BorderFactory.createTitledBorder("Digite o valor do kernel: ");
					panelMediaMenu.setBorder(bordaMediaMenu);
					panelMediaMenu.setLayout(null);
					JLabel labelMedia = new JLabel();
					JPanel panelMedia = new JPanel();
					panelMedia.setBounds(40,60,540,480);
					JTextField TextFMedia = new JTextField(3);
					TextFMedia.setBounds(340,15,40,40);
					JButton buttonMedia = new JButton("Kernel");
					buttonMedia.setBounds(200,15,120,40);
					panelMediaMenu.add(TextFMedia);
					TextFMedia.setText("1");
					panelMediaMenu.add(buttonMedia);
					panelMediaMenu.add(panelMedia);
					panelMedia.add(labelMedia);
					int kernel = Integer.parseInt(TextFMedia.getText());
					BufferedImage filtroMedia = metodos.saidaMedia(image, kernel);
					labelMedia.setBounds(40,60,540,480);
					encaixarImagem(labelMedia, filtroMedia);
					panelMedia.removeAll();
					panelMedia.add(labelMedia);
					panelMedia.updateUI();	
					buttonMedia.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							int kernel = Integer.parseInt(TextFMedia.getText());
							BufferedImage filtroMedia = metodos.saidaMedia(image, kernel);
							labelMedia.setBounds(40,60,540,480);
							encaixarImagem(labelMedia, filtroMedia);
							panelMedia.removeAll();
							panelMedia.add(labelMedia);
							panelMedia.updateUI();	
						}
						
					});
					
					JPanel panelMedianaMenu = new JPanel();
					Border bordaMedianaMenu = BorderFactory.createTitledBorder("Digite o valor do kernel: ");
					panelMedianaMenu.setBorder(bordaMedianaMenu);
					panelMedianaMenu.setLayout(null);
					JLabel labelMediana = new JLabel();
					JPanel panelMediana = new JPanel();
					panelMediana.setBounds(40,60,540,480);
					JTextField TextFMediana = new JTextField(3);
					TextFMediana.setBounds(340,15,40,40);
					JButton buttonMediana = new JButton("Kernel");
					buttonMediana.setBounds(200,15,120,40);
					panelMedianaMenu.add(TextFMediana);
					TextFMediana.setText("4");
					panelMedianaMenu.add(buttonMediana);
					panelMedianaMenu.add(panelMediana);
					panelMediana.add(labelMediana);
					
					int kernel1 = Integer.parseInt(TextFMediana.getText());
					BufferedImage filtroMediana = metodos.saidaMediana(image, kernel1);
					labelMediana.setBounds(40,60,540,480);
					encaixarImagem(labelMediana, filtroMediana);
					panelMediana.removeAll();
					panelMediana.add(labelMediana);
					panelMediana.updateUI();
					
					buttonMediana.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							int kernel = Integer.parseInt(TextFMediana.getText());
							BufferedImage filtroMediana = metodos.saidaMediana(image, kernel);
							labelMediana.setBounds(40,60,540,480);
							encaixarImagem(labelMediana, filtroMediana);
							panelMediana.removeAll();
							panelMediana.add(labelMediana);
							panelMediana.updateUI();
							
						}
						
					});
					
					JPanel panelBinaMenu = new JPanel();
					Border bordaBinaMenu = BorderFactory.createTitledBorder("Digite o valor da limiar: ");
					panelBinaMenu.setBorder(bordaBinaMenu);
					panelBinaMenu.setLayout(null);
					JLabel labelBina = new JLabel();
					JPanel panelBina = new JPanel();
					panelBina.setBounds(40,60,540,480);
					JTextField TextFBina = new JTextField(3);
					TextFBina.setBounds(340,15,40,40);
					JButton buttonBina = new JButton("Limiar");
					buttonBina.setBounds(200,15,120,40);
					panelBinaMenu.add(TextFBina);
					TextFBina.setText("50");
					panelBinaMenu.add(buttonBina);
					panelBinaMenu.add(panelBina);
					panelBina.add(labelBina);
		
					
					buttonBina.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							int limiar = Integer.parseInt(TextFBina.getText());
							BufferedImage filtroBina = metodos.saidaBina(image, limiar);
							labelBina.setBounds(40,60,540,480);
							encaixarImagem(labelBina, filtroBina);
							panelBina.removeAll();
							panelBina.add(labelBina);
							panelBina.updateUI();	
						}
						
					});
					
					
					
					JLabel labelGaussian = new JLabel();
					Border bordaGaussian = BorderFactory.createTitledBorder("Gaussian");
					labelGaussian.setBorder(bordaGaussian);
					labelGaussian.setBounds(40,60,540,480);
					encaixarImagem(labelGaussian, filtroGauss);
					JPanel panelGaussian = new JPanel();
					panelGaussian.add(labelGaussian);



			
					
				
					
					JLabel labelNeg = new JLabel();
					Border bordaNeg = BorderFactory.createTitledBorder("Negativo");
					labelNeg.setBorder(bordaNeg);
					labelNeg.setBounds(40,60,540,480);
					encaixarImagem(labelNeg, filtroNeg);
					JPanel panelNeg = new JPanel();
					panelNeg.add(labelNeg);
					
					JLabel labelHorinz = new JLabel();
					Border bordaHorin = BorderFactory.createTitledBorder("Horinzontal");
					labelHorinz.setBorder(bordaHorin);
					labelHorinz.setBounds(40,60,540,480);
					encaixarImagem(labelHorinz, filtroHorizon);
					JPanel panelHorinz = new JPanel();
					panelHorinz.add(labelHorinz);
					
					JLabel labelVert = new JLabel();
					Border bordaVert= BorderFactory.createTitledBorder("Vertical");
					labelVert.setBorder(bordaVert);
					labelVert.setBounds(40,60,540,480);
					encaixarImagem(labelVert, filtroVert);
					JPanel panelVert = new JPanel();
					panelVert.add(labelVert);
					
					JLabel labelWest = new JLabel();
					Border bordaWest= BorderFactory.createTitledBorder("WestLines");
					labelWest.setBorder(bordaWest);
					labelWest.setBounds(40,60,540,480);
					encaixarImagem(labelWest, filtroWest);
					JPanel panelWest = new JPanel();
					panelWest.add(labelWest);
					
					JLabel labelLaplace = new JLabel();
					Border bordaLaplace= BorderFactory.createTitledBorder("Laplaciano");
					labelLaplace.setBorder(bordaLaplace);
					labelLaplace.setBounds(40,60,540,480);
					encaixarImagem(labelLaplace, filtroLaplace);
					JPanel panelLaplace = new JPanel();
					panelLaplace.add(labelLaplace);
			
					
					tab.add("Negativo",panelNeg);
					tab.add("Gaussiano", panelGaussian);
					tab.add("filtro horinzontal", panelHorinz);
					tab.add("filtro vertical", panelVert);
					tab.add("filtro west", panelWest);
					tab.add("filtro Laplace", panelLaplace);
					tab.add("fitro gaussiano", panelGaussian);
					tab.add("filtro mdia", panelMediaMenu);
					tab.add("filtro mediana", panelMedianaMenu);
					tab.add("filtro binarizar", panelBinaMenu);

				}
					
			}
		});
		
		
		frame.getContentPane().add(tab, BorderLayout.CENTER);
		dimensoesJFrame(frame);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
} 
