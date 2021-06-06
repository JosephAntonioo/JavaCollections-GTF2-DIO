package com.set;

import java.util.*;

public class MainSet {
    public static void main(String[] args) {
        //System.out.println("hello java");
        //conhecendoMetodosSet();
        //ordenacaoDeElementos();
        exerciciosMap1();
    }



    public static void conhecendoMetodosSet(){
        System.out.println("Crie um conjunto e adicione as notas");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

        System.out.println("Confira se a nota 5.0 existe");
        System.out.println(notas.contains(5.0));

        System.out.println("Exiba a menor e a maior nota");
        System.out.println(Collections.min(notas));
        System.out.println(Collections.max(notas));

        System.out.println("Exiba a soma dos valores");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("Exiba a média das notas");
        System.out.println(soma/ notas.size());

        System.out.println("Remova a nota 0");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }

        System.out.println("Exiba toas as notas na ordem que foram informadas");
        Set<Double> notas1 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas1);

        System.out.println("Exiba todas as notas na ordem crescente");
        Set<Double> notas2 = new TreeSet<>(notas1);
        System.out.println(notas2);

        System.out.println("Apague todo o conjunto");
        notas.clear();
        System.out.println(notas.isEmpty());
        System.out.println(notas1.isEmpty());
        System.out.println(notas2.isEmpty());

    }

    public static void ordenacaoDeElementos(){
        /*
        Dados sobre minhas series favoritas
         serie1 = nome: the office, genero:comedia, tempoEpisodio: 21
         serie1 = nome: supernatural, genero:aventura, tempoEpisodio: 43
         serie1 = nome: house, genero:drama, tempoEpisodio: 44
        */

        System.out.println("Ordem aleatoria");
        Set<Serie> minhasSeries = new HashSet(){{
            add(new Serie("The Office", "Comedia", 21));
            add(new Serie("Supernatural", "Aventura", 43));
            add(new Serie("House", "Drama", 44));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - " +
                serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem de inserção");
        Set<Serie> minhasSeries1 = new LinkedHashSet(){{
            add(new Serie("The Office", "Comedia", 21));
            add(new Serie("Supernatural", "Aventura", 43));
            add(new Serie("House", "Drama", 44));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.getNome() + " - " +
                serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem natural (tempo episodio)");
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - " +
                serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem Nome/Genero/TempoEpisodio");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries4.addAll(minhasSeries);

        for (Serie serie: minhasSeries4) System.out.println(serie.getNome() + " - " +
                serie.getGenero() + " - " + serie.getTempoEpisodio());
    }

    private static void exerciciosMap1() {
        /*
        * Crie ym conjunto contendo cores do arco-iris ok
        * Exiba todas as cores uma abaixo da outra ok
        * Quantidade de cores ok
        * exiba as cores em ordem alfabetica ok
        * exiba as cores na ordem inversa da que foi informada ok
        * exiba as cores comecam com a letra v
        * remova todas as cores q nao comecam com a letra v
        * limpe o conjunto
        * confira se o conjunto esta vazio
        */
        Set<Cor> cores = new HashSet(){{
            add(new Cor("Vermelho"));
            add(new Cor("Laranja"));
            add(new Cor("Amarelo"));
            add(new Cor("Verde"));
            add(new Cor("Azul"));
            add(new Cor("Anil"));
            add(new Cor("Violeta"));
        }};
        System.out.println("Exiba as cores uma abaixo da outra");
        for (Cor cor: cores) System.out.println(cor.getCores());
        
        System.out.println("Exiba as cores em ordem alfabética");
        Set<Cor> coresArcoIris = new TreeSet<>(cores);
        for (Cor coresArco: coresArcoIris) System.out.println(coresArco.getCores());

        System.out.println("Quantidade de cores");
        System.out.println(coresArcoIris.size());

        System.out.println("Exiba as cores na ordem inversa da que foi informada");

        Set<Cor> coresArcoIris1 = new LinkedHashSet(){{
            add(new Cor("Vermelho"));
            add(new Cor("Laranja"));
            add(new Cor("Amarelo"));
            add(new Cor("Verde"));
            add(new Cor("Azul"));
            add(new Cor("Anil"));
            add(new Cor("Violeta"));
        }};
        List<String> coresList = new ArrayList<>();
        for (Cor cor: coresArcoIris1) coresList.add(cor.getCores());
        for(int i = coresList.size(); i > 0; i--){
            System.out.println(coresList.get(i - 1).toString());
        }

        System.out.println("Exiba as cores que começam com V");
        for(int j = 0; j < coresList.size(); j++){
            String a = coresList.get(j).substring(0,1);
            if(a.equals("V")) System.out.println(coresList.get(j));
        }
        System.out.println("Exclua as cores que nao começam com V");
        for(int j = 0; j < coresList.size(); j++){
            String a = coresList.get(j).substring(0,1);
            if(!a.equals("V")) coresArcoIris.remove(new Cor(coresList.get(j)));
        }
        for (Cor coresArco: coresArcoIris) System.out.println(coresArco.getCores());

        coresArcoIris1.clear();
        System.out.println(coresArcoIris1.isEmpty());



    }

}
class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio =  Integer.compare(this.getTempoEpisodio(), serie.tempoEpisodio);
        if(tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }
}

class Cor implements Comparable<Cor>{
    //precisava?claramente nao, but bola pra frente
    private String cores;

    public Cor(String cores) {
        this.cores = cores;
    }

    public String getCores() {
        return cores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor cor = (Cor) o;
        return Objects.equals(cores, cor.cores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cores);
    }

    @Override
    public int compareTo(Cor cor) {
        int cores = this.getCores().compareTo(cor.getCores());
        if(cores != 0) return cores;
        return this.getCores().compareTo(cor.getCores());
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if(nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}


