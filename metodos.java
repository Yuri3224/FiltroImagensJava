//source dos metodos
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class metodos {

	public static BufferedImage saidaGauss(BufferedImage image, double[] kernel) {
		// TODO Auto-generated method stub
		int altura = image.getHeight();
		int largura = image.getWidth();
		int tamVizinhanca = (int) Math.sqrt(kernel.length);
		int ref = tamVizinhanca/2;
		BufferedImage saidaGauss = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < largura - ref; coluna++) {
				
				double soma = 0;
				int contador = 0;
			
				for(int linha1 = -ref; linha1 <= ref; linha1++) {
					for(int coluna1 = -ref; coluna1 <= ref; coluna1++) {
						Color cores = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int vermelho = cores.getRed();
						soma +=(double)vermelho*kernel[contador];
						contador++;
					}
					
				}
				
				Color valorGauss = new Color((int)soma,(int)soma,(int)soma);
				saidaGauss.setRGB(coluna,linha,valorGauss.getRGB());
			}
		}
		
		return saidaGauss;
		
	};
	
	public static BufferedImage saidaHorizon (BufferedImage image, int[] kernelHorizontal) {
		int altura = image.getHeight();
		int largura = image.getWidth();
		int tamVizinhanca = (int) Math.sqrt(kernelHorizontal.length);
		int ref = tamVizinhanca/2;
		BufferedImage saidaHorizon = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < largura - ref; coluna++) {
				
				double soma = 0;
				int contador = 0;
			
				for(int linha1 = -ref; linha1 <= ref; linha1++) {
					for(int coluna1 = -ref; coluna1 <= ref; coluna1++) {
						Color cores = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int vermelho = cores.getRed();
						soma +=(int)vermelho*kernelHorizontal[contador];
						contador++;
					}
					
				}
				
				if(soma > 255) {
					soma = 255;
				}
				if(soma < 0) {
					soma = 0;
				}
				Color valorHorinzon = new Color((int)soma,(int)soma,(int)soma);
				saidaHorizon.setRGB(coluna,linha,valorHorinzon.getRGB());
			}
		}
		
		return saidaHorizon;
	}
	
	//M�todo VERTICAL
	public static BufferedImage saidaVert (BufferedImage image, int[] kernelVert) {
		int altura = image.getHeight();
		int largura = image.getWidth();
		int tamVizinhanca = (int) Math.sqrt(kernelVert.length);
		int ref = tamVizinhanca/2;
		BufferedImage saidaVert = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < largura - ref; coluna++) {
				
				double soma = 0;
				int contador = 0;
			
				for(int linha1 = -ref; linha1 <= ref; linha1++) {
					for(int coluna1 = -ref; coluna1 <= ref; coluna1++) {
						Color cores = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int vermelho = cores.getRed();
						soma +=(int)vermelho*kernelVert[contador];
						contador++;
					}
					
				}
				
				if(soma > 255) {
					soma = 255;
				}
				if(soma < 0) {
					soma = 0;
				}
				Color valorHorinzon = new Color((int)soma,(int)soma,(int)soma);
				saidaVert.setRGB(coluna,linha,valorHorinzon.getRGB());
			}
		}
		
		return saidaVert;
	}
	
	//M�todo LINHAS OESTE
	public static BufferedImage saidaWest (BufferedImage image, int[] kernelWest) {
		int altura = image.getHeight();
		int largura = image.getWidth();
		int tamVizinhanca = (int) Math.sqrt(kernelWest.length);
		int ref = tamVizinhanca/2;
		BufferedImage saidaWest = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < largura - ref; coluna++) {
				
				double soma = 0;
				int contador = 0;
				
				for(int linha1 = -ref; linha1 <= ref; linha1++) {
					for(int coluna1 = -ref; coluna1 <= ref; coluna1++) {
						Color cores = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int vermelho = cores.getRed();
						soma +=(int)vermelho*kernelWest[contador];
						contador++;
					}
					
				}
				
				if(soma > 255) {
					soma = 255;
				}
				if(soma < 0) {
					soma = 0;
				}
				Color valorHorinzon = new Color((int)soma,(int)soma,(int)soma);
				saidaWest.setRGB(coluna,linha,valorHorinzon.getRGB());
			}
		}
		
		return saidaWest;
	}
	
	//M�todoo LAPLACE
	public static BufferedImage saidaLaplace (BufferedImage image, int[] kernelLaplace) {
		int altura = image.getHeight();
		int largura = image.getWidth();
		int tamVizinhanca = (int) Math.sqrt(kernelLaplace.length);
		int ref = tamVizinhanca/2;
		BufferedImage saidaLaplace = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < largura - ref; coluna++) {
				
				double soma = 0;
				int contador = 0;
				
				for(int linha1 = -ref; linha1 <= ref; linha1++) {
					for(int coluna1 = -ref; coluna1 <= ref; coluna1++) {
						Color cores = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int vermelho = cores.getRed();
						soma +=(int)vermelho*kernelLaplace[contador];
						contador++;
					}
					
				}
				
				if(soma > 255) {
					soma = 255;
				}
				if(soma < 0) {
					soma = 0;
				}
				Color valorlaplace = new Color((int)soma,(int)soma,(int)soma);
				saidaLaplace.setRGB(coluna,linha,valorlaplace.getRGB());
			}
		}
		
		return saidaLaplace;
	}
	
	public static BufferedImage saidaMedia (BufferedImage image, int kernel) {
		int altura = image.getHeight();
		int largura = image.getWidth();
		int ref = (kernel/2);
		BufferedImage saidaMedia = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < largura - ref; coluna++) {
			int soma = 0;	
				for(int linha1 = -ref; linha1 < ref; linha1++) {
					for(int coluna1 = -ref; coluna1 < ref; coluna1++) {
						Color cores = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int vermelho = cores.getRed();
						soma +=vermelho;
					}
					
				}
				
				int media = (soma / (kernel*kernel));
				Color valorMediado = new Color(media,media,media);
				saidaMedia.setRGB(coluna,linha,valorMediado.getRGB());
			}
		}
		
		return saidaMedia;
	}
	//
	
	
	
	//M�todo usando a MEDIANA
	public static BufferedImage saidaMediana (BufferedImage image, int kernel) {
		int altura = image.getHeight();
		int largura = image.getWidth();
		int ref = (kernel/2);
		BufferedImage saidaMediana =  new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for(int linha = ref; linha < altura - ref; linha++) {
			for(int coluna = ref; coluna < altura - ref; coluna++) {
				
                int[] pixel = new int[kernel*kernel];
                int cont = 0;
				
				for(int linha1 = -ref; linha1 < ref; linha1++) {
					for(int coluna1 = -ref; coluna1 < ref; coluna1++) {
						Color cor = new Color(image.getRGB(coluna + linha1, linha + coluna1));
						int red = cor.getRed();
						pixel[cont] = red;
						cont++;
						
					}
				}
				   Arrays.sort(pixel);
	                
	                int indiceMediana = kernel*kernel/2;
	                int mediana = pixel[indiceMediana];
	                Color novaCor = new Color(mediana,mediana,mediana);
	                saidaMediana.setRGB(coluna,linha,novaCor.getRGB());
			}
		}
		
		return saidaMediana;
	}
	
	//metodo binarizacao
	 public static BufferedImage saidaBina (BufferedImage image, int limiar) {
		 int altura = image.getHeight();
		 int largura = image.getWidth();
		 BufferedImage saidaBina = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		 for (int lin = 0; lin < altura; lin++) {
			 	for (int col = 0; col < largura; col++) {
			 		int rgb = image.getRGB(col, lin);
			 		Color cor = new Color(rgb);
			 		int red = cor.getRed();
			 		int green = cor.getGreen();
			 		int blue = cor.getBlue();
			 		int media = (red+green+blue)/3;
			 		int calculo = calcularLimiar(media, limiar);
			 		Color azulApenas = new Color(calculo, calculo, calculo);
			 		saidaBina.setRGB(col, lin, azulApenas.getRGB());
				 }
		}
		 
		 return saidaBina;
	 }
		public static int calcularLimiar (int atual, int limiar) {
			if (atual <= limiar)
				atual = 0;
			else if(atual > limiar)
				atual = 255;
			return atual;
		}	
		
		//filtro negativo
		public static BufferedImage saidaNeg (BufferedImage image) {
			 int altura = image.getHeight();
			 int largura = image.getWidth();
			 BufferedImage negativeFilter = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			 
			 for (int lin = 0; lin < altura; lin++) {
				 	for (int col = 0; col < largura; col++) {
				 		int rgb = image.getRGB(col, lin);
				 		Color cor = new Color(rgb);
				 		int red = cor.getRed();
				 		int green = cor.getGreen();
				 		int blue = cor.getBlue();
				 		Color azulApenas = new Color(255 - red, 255 - green, 255 - blue);
				 		negativeFilter.setRGB(col, lin, azulApenas.getRGB());
					 }
			}	 
			 return negativeFilter;
		}	
		
	

	
	
}