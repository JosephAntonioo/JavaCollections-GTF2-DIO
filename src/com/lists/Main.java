package com.lists;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Aulas de Lists, Conhecendo os metodos Lists parte 1 e 2
        //listp1p2();
        //Aulas de Lists, Ordenação de elesmentos em uma coleção List parte 1 e 2
        //ordenacaoElementos();
        //Exercicios Propostos List
        //exerciciosList1();
        exerciciosList2();

    }
    public static void listp1p2() {
        //Dada uma lista com 7 notas de um aluno {7, 8.5, 9.3, 5, 7, 0, 3.5}

        System.out.println("Crie uma lista e adicione as sete notas");
        List<Double> notas = new ArrayList<>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.5);
        System.out.println("Descubra a posição da nota 5");
        System.out.println(notas.indexOf(5d));
        System.out.println("Adicione a nota 8 na posição 4");
        notas.add(4, 8d);
        System.out.println(notas);
        System.out.println("Substitua a nota 5 por 6");
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);
        System.out.println("Confira se a nota 5 está na lista");
        System.out.println(notas.contains(5d));
        System.out.println("Exiba todas as notas na ordem que foram informadas");
        for (Double nota : notas) System.out.println(nota);
        System.out.println("Exiba a terceira nota adicionada");
        System.out.println(notas.get(2));
        System.out.println("Exiba a menor nota");
        System.out.println(Collections.min(notas));
        System.out.println("Exiba a maior nota");
        System.out.println(Collections.max(notas));
        System.out.println("Exiba a soma dos valores");
        Iterator<Double> iterator = notas.iterator();
        Double somaNotas = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            somaNotas += next;
        }
        System.out.println(somaNotas);
        System.out.println("Exiba a media das notas");
        System.out.println(somaNotas / notas.size());
        System.out.println("Remova a nota zero");
        notas.remove(0d);
        System.out.println(notas);
        System.out.println("Remova a nota na posição zero");
        notas.remove(0);
        System.out.println(notas);
        System.out.println("Remova as notas menores que 7 e exiba a lista");
        notas.removeIf(nota -> nota < 7);
        System.out.println(notas);
        System.out.println("Apague toda a lista");
        Iterator<Double> iterator3 = notas.iterator();
        notas.clear();
        System.out.println(notas);
        System.out.println("Confira se a lista está vazia");
        System.out.println(notas.isEmpty());
    }

    public static void ordenacaoElementos(){
        /*
        Dados as seguintes informaçoes sobre seus gatos, crie uma liste e ordene
        esta lista exibindo
        nome - idade - cor
        gato 1 = nome: Adamastor, idade = 11, cor: cinza
        gato 2 = nome: Wagner, idade = 13, cor: amarelo
        gato 3 = nome: Dwight, idade = 14, cor: preto
        */
        List<Gato> meusGatos = new ArrayList(){{
            add(new Gato("Adamastor", 11, "Cinza"));
            add(new Gato("Wagner", 13, "Amarelo"));
            add(new Gato("Dwight", 14, "Preto"));
        }};
        System.out.println("Exiba na ordem de inserção");
        System.out.println(meusGatos);

        System.out.println("Exiba em ordem aleatória");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Ordem natural (Nome)");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Ordem idade");
        //Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("Ordem cor");
        Collections.sort(meusGatos, new ComparatorCor());
        //meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("Ordem Nome/Cor/Idade");
        //Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }

    public static void exerciciosList1() throws IOException {
        /*Temperatura média dos 6 primeiros meses do ano armazena em list
          media semestral
          todas as temperaturas acima da media e qual mes aconteceu*/
        Scanner entrada = new Scanner(System.in);
        System.out.println("Temperatura de Janeiro");
        Double jan = entrada.nextDouble();
        System.out.println("Temperatura de Fevereiro");
        Double fev = entrada.nextDouble();
        System.out.println("Temperatura de Março");
        Double mar = entrada.nextDouble();
        System.out.println("Temperatura de Abril");
        Double abr = entrada.nextDouble();
        System.out.println("Temperatura de Maio");
        Double mai = entrada.nextDouble();
        System.out.println("Temperatura de Junho");
        Double jun = entrada.nextDouble();
        List<MesTemp> mesTempList = new ArrayList(){{
            add(new MesTemp("Janeiro", jan));
            add(new MesTemp("Fevereiro", fev));
            add(new MesTemp("Março", mar));
            add(new MesTemp("Abril", abr));
            add(new MesTemp("Maio", mai));
            add(new MesTemp("Junho", jun));
        }};
        Iterator<MesTemp> mesTempIterator = mesTempList.iterator();
        Double somaTemp = 0d;
        while(mesTempIterator.hasNext()){
            Double temp = mesTempIterator.next().getTemp();
            somaTemp += temp;
        }
        Double mediaSemestre = somaTemp / mesTempList.size();

        for(int i = 0; i < mesTempList.size(); i++){
            if(mesTempList.get(i).getTemp() > mediaSemestre){
                System.out.println(mesTempList.get(i).getMes() + " - " + mesTempList.get(i).getTemp());
            }
        }
    }

    public static void exerciciosList2(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Responda apenas com S para sim e N para não");
        Perguntas perguntas = new Perguntas();
        System.out.println(perguntas.getPergunta1());
        String r1 = entrada.next();
        perguntas.setResposta1(r1);

        System.out.println(perguntas.getPergunta2());
        String r2 = entrada.next();
        perguntas.setResposta2(r2);

        System.out.println(perguntas.getPergunta3());
        String r3 = entrada.next();
        perguntas.setResposta3(r3);

        System.out.println(perguntas.getPergunta4());
        String r4 = entrada.next();
        perguntas.setResposta4(r4);

        System.out.println(perguntas.getPergunta5());
        String r5 = entrada.next();
        perguntas.setResposta5(r5);

        List<Perguntas> perguntasList = new ArrayList<>();
        perguntasList.add(perguntas);
        Iterator<Perguntas> perguntasIterator = perguntasList.iterator();
        int positivas = 0;
        while(perguntasIterator.hasNext()){
            Perguntas resposta = perguntasIterator.next();
            if(resposta.getResposta1().equals("S")) {
                positivas += 1;
            }
            if(resposta.getResposta2().equals("S")){
                positivas += 1;
            }
            if(resposta.getResposta3().equals("S")){
                positivas += 1;
            }
            if(resposta.getResposta4().equals("S")){
                positivas += 1;
            }
            if(resposta.getResposta5().equals("S")){
                positivas += 1;
            }
        }
        switch (positivas) {
            case 0:
            case 1:
                System.out.println("Inocente");
                break;
            case 2:
                System.out.println("Considerado suspeito");
                break;
            case 3:
            case 4:
                System.out.println("Cumplice");
                break;
            case 5:
                System.out.println("Assasina");
                break;
        }


    }
}

class Gato implements Comparable<Gato> {
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        /*
        quando o retorno for 0, o obj comparado tem o parametro passado igual ao proximo obj
        quando o retorno for 1, o obj comparando é maior que o obj q esta sendo comparado
        quando o retorno for -1, o obj comparando é menor que o obj q esta sendo comparado
        */
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements  Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        //Se os nomes forem diferentes sera ordenado por nome
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if(nome != 0) return nome;

        //Se os nomes forem iguais, será ordenado por cor
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor != 0) return  cor;
        //Se as cores forem iguais e os nomes tambem, será ordenado pela idade
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class MesTemp{
    private String mes;
    private Double temp;

    public MesTemp(String mes, Double temp) {
        this.mes = mes;
        this.temp = temp;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "{" +
                "mes='" + mes + '\'' +
                ", temp=" + temp +
                '}';
    }
}

class Perguntas{
    private String pergunta1 = "Telefonou para a vítima?";
    private String resposta1;
    private String pergunta2 = "Esteve no local do crime?";
    private String resposta2;
    private String pergunta3 = "Mora perto da vítima?";
    private String resposta3;
    private String pergunta4 = "Devia para a vítima?";
    private String resposta4;
    private String pergunta5 = "Já trabalhou com a vítima?";
    private String resposta5;

    public Perguntas(String resposta1, String resposta2, String resposta3, String resposta4, String resposta5) {
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.resposta5 = resposta5;
    }

    public Perguntas() {

    }

    public Perguntas(String s) {
    }


    public String getPergunta1() {
        return pergunta1;
    }

    public String getResposta1() {
        return resposta1;
    }

    public String getPergunta2() {
        return pergunta2;
    }

    public String getResposta2() {
        return resposta2;
    }

    public String getPergunta3() {
        return pergunta3;
    }

    public String getResposta3() {
        return resposta3;
    }

    public String getPergunta4() {
        return pergunta4;
    }

    public String getResposta4() {
        return resposta4;
    }

    public String getPergunta5() {
        return pergunta5;
    }

    public String getResposta5() {
        return resposta5;
    }


    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1.toUpperCase();
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2.toUpperCase();
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3.toUpperCase();
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4.toUpperCase();
    }

    public void setResposta5(String resposta5) {
        this.resposta5 = resposta5.toUpperCase();
    }

    @Override
    public String toString() {
        return "Perguntas{" +
                ", pergunta1='" + pergunta1 + '\'' +
                ", resposta1='" + resposta1 + '\'' +
                ", pergunta2='" + pergunta2 + '\'' +
                ", resposta2='" + resposta2 + '\'' +
                ", pergunta3='" + pergunta3 + '\'' +
                ", resposta3='" + resposta3 + '\'' +
                ", pergunta4='" + pergunta4 + '\'' +
                ", resposta4='" + resposta4 + '\'' +
                ", pergunta5='" + pergunta5 + '\'' +
                ", resposta5='" + resposta5 + '\'' +
                '}';
    }
}