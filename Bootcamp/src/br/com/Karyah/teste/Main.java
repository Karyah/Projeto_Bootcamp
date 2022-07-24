package br.com.Karyah.teste;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


import br.com.Karyah.model.*;

public class Main {
	
	public static void main(String[] args){
		
		Dev dev = new Dev();
		Scanner ent = new Scanner(System.in);

		boolean menu = false;
		int op = 0;
		
		do {
			do{
				System.out.println("Bem vindo ao Site da Karyah!\nO que deseja fazer, Dev? 1.Cadastrar 2.Logar");
				
				try {
					op=ent.nextInt();
				}catch(InputMismatchException IME) {
					System.out.println("Você tem que escrever um número.");
				}
				
			}while(!(op==1||op==2));
			
			
			while(op==1) {
					System.out.println("\n----Cadastro----");
					System.out.println("Digite seu nome: ");
					String nomeDev = ent.next();

					System.out.println("Digite sua senha(Apenas números):");
					int senhaDev = ent.nextInt();
					
					System.out.println("Digite seu cpf: ");
					String cpfDev = ent.next();
	
					dev.cadastrar(nomeDev, senhaDev, cpfDev);
					
					System.out.println("Você deseja: \n 1-Logar \n 2-Ir para o menu principal \n 3- Sair do site");
						int redirecionar = ent.nextInt();
						
						switch(redirecionar) {
						case 1:
							op=2;
							break;
						case 2:
							op=4;
							break;
						case 3:
							op=5;
							break;
						}
				}
				
			
				while(op==2) {
					int cont = 0;
					while(cont <3) {
						System.out.println("\n----Login----");
						System.out.println("Digite seu nome:");
						String nomeLoginDev = ent.next();
						System.out.println("Digite sua senha:");
						int senhaLoginDev = ent.nextInt();
						
						if(dev.getNome().equals(nomeLoginDev)&&dev.getSenha()==senhaLoginDev) {
							System.out.println("Você foi logado com sucesso e será redirecionado a pagina do site");
							op=3;
							break;
						
						}else {
						System.out.println("Você errou seu usuário ou senha.");
							cont+=1;
						}
					}
					if(cont>=3) {
						System.out.println("Poxa, você errou sua senha mais de três vezes. Tente novamente mais tarde.");
						op=5;
					}
				}
					
				while(op==3) {
					System.out.println("\n----Bootcamps----");
					
					Curso curso1 = new Curso();
					curso1.setTitulo("Conceitos Básicos Java");
					curso1.setDescricao("Este curso ensina a linguagem de programação Java e seus conceitos básicos.");
					curso1.setCargaHoraria(15);
					
					Curso curso2 = new Curso();
					curso2.setTitulo("Programação Orientada a Objetos");
					curso2.setDescricao("Este curso ensina como criar projetos usando a orientação a objetos, e seus mais"
							+ "amplos conceitos.");
					curso2.setCargaHoraria(10);
					
					Curso curso3 = new Curso();
					curso3.setTitulo("Estrutura e estilização de Sites");
					curso3.setDescricao("Neste curso aprenderemos a criar a interface de um site a partir "
							+ "de fundamentos de HTML, CSS e JS.");
					curso3.setCargaHoraria(30);
					
					Mentoria mentoria1 = new Mentoria();
					mentoria1.setTitulo("Mentoria sobre HTML e CSS");
					mentoria1.setDescricao("Praticando os conhecimentos em HTML e CSS | Solucionamos dúvidas!");
					mentoria1.setData(LocalDate.now());
					
					Mentoria mentoria2 = new Mentoria();
					mentoria2.setTitulo("Tratando Exceptions");
					mentoria2.setDescricao("Ensinando como tratar exceptions em java");
					mentoria2.setData(LocalDate.now());
										
					Bootcamp bootcampJava = new Bootcamp();
					bootcampJava.setNome("Intensivo de Java");
					bootcampJava.setDescricao("Diversos conteúdos sobre Java");
					bootcampJava.getConteudos().add(curso1);
					bootcampJava.getConteudos().add(curso2);
					bootcampJava.getConteudos().add(mentoria2);
					
					Bootcamp bootcampFrontEnd = new Bootcamp();
					bootcampFrontEnd.setNome("Bootcamp Front-End");
					bootcampFrontEnd.setDescricao("Aprendendo Front-End: Usando HTML, CSS e JS");
					bootcampFrontEnd.getConteudos().add(curso3);
					bootcampFrontEnd.getConteudos().add(mentoria1);
					
					
					Map<String, String> mostrarBootcamps = new LinkedHashMap<>() {{
						put("1",bootcampJava.getNome().toString());
						put("2",bootcampFrontEnd.getNome().toString());
					}};
					
					System.out.println("Nossos Bootcamps:\n" + mostrarBootcamps + "\nVocê deseja se inscrever para algum?\\n1-Sim. 2-Não");
						
					int respostaBootcamp = ent.nextInt();
					
					if(respostaBootcamp==1) {
						System.out.println("Digite o número do bootcamp no qual você quer se inscrever:");
						
						int escolhaBootcamp = ent.nextInt(); 
						
						if(escolhaBootcamp==1) {
							dev.inscreverBootcamp(bootcampJava);
							System.out.println("Você deseja: \n 1-Checar Dados do Bootcamp \n 2-Ir para o menu principal \n 3- Sair do site");
							int redirecionar = ent.nextInt();
							
							switch(redirecionar) {
							case 1:
								op=6;
								break;
							case 2:
								op=4;
								break;
							case 3:
								op=5;
								break;
							}
								
						}else if(escolhaBootcamp==2) {
							dev.inscreverBootcamp(bootcampFrontEnd);
							System.out.println("Você deseja: \n 1-Checar Dados do Bootcamp \n 2-Ir para o menu principal \n 3- Sair do site");
							int redirecionar = ent.nextInt();
							
							switch(redirecionar) {
							case 1:
								op=6;
								break;
							case 2:
								op=4;
								break;
							case 3:
								op=5;
								break;
							}
								
						}else {
							System.err.println("Não existe nenhum Bootcamp com esse número.");
							op=4;
							break;
						}
						
					}else {
						System.out.println("Você deseja: \n 1-Checar Dados de algum Bootcamp \n 2-Ir para o menu principal \n 3- Sair do site");
						int redirecionar = ent.nextInt();
						
						switch(redirecionar) {
						case 1:
							op=6;
							break;
						case 2:
							op=4;
							break;
						case 3:
							op=5;
							break;
						}
					}
				}
				
				while(op==6) {
					System.out.println("\n----Checagem de Conteúdos----");
					dev.progredir(); 
					System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos().toString());
					System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos().toString());
					System.out.println("XP: " + dev.calcularTotalXp());
					System.out.println("Você deseja: 1-Ir para o menu principal \n2 - Sair do site");
					int redirecionar = ent.nextInt();
					
					switch(redirecionar) {
					case 1:
						op=4;
						break;
					case 2:
						op=5;
						break;
					}
				}
				
				
				
				while(op==4) {
					menu=true;
					break;
				}
				
				while(op==5) {
					System.out.println("Obrigada por acessar nosso bootcamp!!");
					menu=false;
					break;
				}
				
				

		}while(menu==true);
		ent.close();
	
	}
	
}

 /*@author: Karyah*
  *(>_<)*/


