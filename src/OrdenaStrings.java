import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		Collections.sort(palavras);
		System.out.println(palavras);

		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		// Collections.sort(palavras, comparador);
		palavras.sort(comparador);
		System.out.println(palavras);

		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
		
		//Exemplo de uso de expressões lambda, que fazem o mesmo que o código acima
		System.out.println("\nLambda:");
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.forEach(s -> System.out.println(s));
		
		//Exemplo de uso do Comparator.comparing com lambda
		System.out.println("\nComparator.comparing:");
		palavras.add("Oi");
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.forEach(s -> System.out.println(s));
		
		//Exemplo de uso do Comparator.comparing com method reference
		System.out.println("\nComparator.comparing:");
		palavras.add("Olá");
		palavras.sort(Comparator.comparing(String::length));
		palavras.forEach(s -> System.out.println(s));

		//Exemplo de alteração da forma de comparação
		System.out.println("\nComparator.comparing:");
		palavras.add("Ah... VOILÁ!!!");
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		palavras.forEach(System.out::println);

	}

}

/*
 * Classe para ordenar palavras em uma ordem diferente (ex: por tamanho)
 */
class ComparadorDeStringPorTamanho implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}

/*
 * Classe consumidora de Strings. Neste caso, ela imprime cada String que recebe.
 */
class ConsumidorDeString implements Consumer<String> {
	public void accept(String s) {
		System.out.println(s);
	}
}
