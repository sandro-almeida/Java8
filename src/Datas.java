import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Datas {

	public static void main(String[] args) {
		// Data de hoje
		LocalDate hoje = LocalDate.now();
		System.out.println("Hoje=[" + hoje + "]");
		
		// Cálculo de dias para o reveillon	
		LocalDate reveillon = LocalDate.of(2019, Month.DECEMBER, 31);
		Period period = Period.between(hoje ,reveillon);
		System.out.println("Dias para o reveillon=[" + hoje.until(reveillon, ChronoUnit.DAYS) + "]");
		System.out.println("Dias para o reveillon=[" + ChronoUnit.DAYS.between(hoje, reveillon) + "]");
		System.out.println("Hoje mais 1 ano=[" + hoje.plusYears(1) + "]");
		
		// Formatando datas
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Data de hoje formatada=[" + hoje.format(formatador) + "]");
		
		// Hora, minutos e segundos
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //HH para formato 24h
		System.out.println("Data e hora atual formatada=[" + agora.format(formatadorComHoras) + "]");

	}

}
