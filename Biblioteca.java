import java.util.*;

public class Biblioteca {
    public static void main(String[] args) {
        // Lista da biblioteca, fila de espera e histórico (mantidos)
        LinkedList<Livro> biblioteca = new LinkedList<>();
        Queue<String> filaDeEspera = new LinkedList<>();
        Stack<Livro> historicoNavegacao = new Stack<>();

        // Criando livros
        Livro l1 = new Livro("A Culpa é das Estrelas", "John Green", 2012);
        Livro l2 = new Livro("Todo Esse Tempo", "MikkyDaughtry", 2020);
        Livro l3 = new Livro("Feitos de Sol", "Vinícius Grossos", 2019);
        Livro l4 = new Livro("Os Sete Maridos de Evelyn Hugo", "Taylor Jenkins", 2021);
        Livro l5 = new Livro("Por Lugares Incríveis", "Jennifer Niven", 2019);
        Livro l6 = new Livro("Minha Versão de Você", "Christina Lauren", 2017);        

        // Criando grafo com recomendações
        Map<Livro, Set<Livro>> grafo = new HashMap<>();

        grafo.put(l1, Set.of(l2, l5));
        grafo.put(l2, Set.of(l1, l5));
        grafo.put(l3, Set.of(l4, l6));
        grafo.put(l4, Set.of(l3, l6));
        grafo.put(l5, Set.of(l1, l2));
        grafo.put(l6, Set.of(l2, l3));


        // Simulando navegação do usuário
        historicoNavegacao.push(l3);

        // Recomendações com base no último livro lido
        Livro ultimoLido = historicoNavegacao.peek();
        Set<Livro> recomendados = grafo.get(ultimoLido);

        System.out.println("Último livro lido: " + ultimoLido);
        System.out.println("Recomendações com base nesse livro:");
        for (Livro livro : recomendados) {
            System.out.println("- " + livro);
        }
    }
}