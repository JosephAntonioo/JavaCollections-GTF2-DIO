package com.map;

import java.sql.Struct;
import java.util.*;
public class MainMap {
    public static void main(String[] args) {
        //System.out.println("hello java");
        //conhecendoMetodosMap();
        //ordenacaoMap();
    }

    public static void conhecendoMetodosMap(){
        System.out.println("Crie um dicionario que relaciona os modelos e seus respectivos consumos");
        Map<String, Double> carrosPopulares = new HashMap<String, Double>(){{
        put("gol", 14.4);
        put("uno", 15.6);
        put("mobi", 16.1);
        put("hb20", 14.5);
        put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o cunsumo do gol por 15,2 km/l");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares.toString());

        System.out.println("Confira se o modelo tuckson está no dicionario");
        System.out.println(carrosPopulares.containsKey("tuckson"));

        System.out.println("Exiba o consumo do uno");
        System.out.println(carrosPopulares.get("uno"));

        System.out.println("Exiba os modelos");
        System.out.println(carrosPopulares.keySet());

        System.out.println("Exiba os consumos");
        System.out.println(carrosPopulares.values());

        System.out.println("Exiba o modelo mais economico e seu consumo");
        Double consumoEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloEficiente = "";
        for(Map.Entry<String, Double>  entry:  entries){
            if(entry.getValue().equals(consumoEficiente)) {
                modeloEficiente = entry.getKey();
                System.out.println(modeloEficiente + " " + consumoEficiente);
            }
        }

        System.out.println("Exiba o modelo menos economico e seu consumo");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for(Map.Entry<String, Double>  entry :carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println(modeloMenosEficiente + " " + consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }

        System.out.println("Exiba a média dos consumos deste dicionario de carros");
        System.out.println(soma/carrosPopulares.size());

        System.out.println("Remova os modelos com o consumo igual a 15.6km/l");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
            }
        System.out.println(carrosPopulares.toString());

        System.out.println("Exbia todos os modelos na ordem em que foram informados");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<String, Double>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Exiba o dicionario ordenado pelo modelo");
        Map<String, Double> carrosPopulares2 = new TreeMap<String, Double>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o dicionario de carros");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionario está vazio");
        System.out.println(carrosPopulares.isEmpty());
        }

        public static void ordenacaoMap(){

            System.out.println("Ordem aleatoria");
            Map<String, Livro> meusLivros = new HashMap<String, Livro>(){{
                put("Stephen Hawking", new Livro("Uma breve história do tempo", 256));
                put("Charles", new Livro("O poder do hábito", 408));
                put("Harari", new Livro("21 lições para o século 21", 432));
            }};
            for(Map.Entry<String, Livro> livro : meusLivros.entrySet()) System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

            System.out.println("Ordem de inserção");

            Map<String, Livro> meusLivros1 = new LinkedHashMap<String, Livro>(){{
                put("Stephen Hawking", new Livro("Uma breve história do tempo", 256));
                put("Charles", new Livro("O poder do hábito", 408));
                put("Harari", new Livro("21 lições para o século 21", 432));
            }};
            for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()) System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

            System.out.println("Ordem alfabetica dos autores");
            Map<String, Livro> meusLivros2 = new TreeMap<String, Livro>(meusLivros1);
            for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()) System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

            System.out.println("Ordem alfabetica dos livros");
            Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<Map.Entry<String, Livro>>(new ComparatorNome());
            meusLivros3.addAll(meusLivros.entrySet());
            for(Map.Entry<String, Livro> livro : meusLivros3) System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

            System.out.println("Ordene por numero de paginas");
            Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<Map.Entry<String, Livro>>(new ComparatorPagina());
            meusLivros4.addAll(meusLivros.entrySet());
            for(Map.Entry<String, Livro> livro : meusLivros4) System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());


        }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}
class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}

