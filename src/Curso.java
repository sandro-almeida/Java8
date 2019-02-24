import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Curso {
	
	private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Usando Stream para filtrar uma coleção
		System.out.println("\nUsando Stream para filtrar cursos:");
		//cursos.stream().filter(c -> c.getAlunos() > 50).forEach(System.out::println);
		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getNome()));

		//Transformando um Stream Curso em um Stream String
		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		System.out.println("\nTransformando um Stream Curso em um Stream String:");
		nomes.forEach(System.out::println);
		
		//Cria um Stream<Integer> com a quantidade de alunos dos cursos e em seguida imprime todos eles
		System.out.println("\nQuantidade de alunos dos cursos:");
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);
		
		//Para pegar o primeiro elemento de um stream filtrado
		System.out.println("\nPrimeiro elemento de um stream filtrado:");
		 Optional<Curso> optionalCurso = cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		//Cálculo da quantidade média de alunos nos cursos
		System.out.println("\nQuantidade média de alunos nos cursos:");
		 OptionalDouble optionalDouble = cursos.stream().mapToInt(c -> c.getAlunos()).average();

		 optionalDouble.ifPresent(opt -> System.out.println(opt));
		 
		//Transformando um Stream<Curso> filtrado em uma List<Curso>
		System.out.println("\nTransformando um Stream<Curso> filtrado em uma List<Curso>:");
		List<Curso> collectCurso = cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .collect(Collectors.toList());
		 
		 collectCurso.forEach(c -> System.out.println(c.getNome()));
	}

}
