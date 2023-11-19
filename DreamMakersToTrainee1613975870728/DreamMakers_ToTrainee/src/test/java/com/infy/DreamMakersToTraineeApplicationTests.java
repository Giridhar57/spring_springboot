package com.infy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.DirectorDTO;
import com.infy.dto.MovieDTO;
import com.infy.exception.DreamMakersException;
import com.infy.service.MovieService;

@SpringBootTest
class DreamMakersToTraineeApplicationTests {
	
	@Mock
	MovieService movieService;
	
	@Test
	void testValidInput() {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieId("M1001");
		movieDTO.setMovieName("Avengers");
		movieDTO.setReleasedIn(LocalDate.of(1990, 05, 24));
		movieDTO.setLanguage("English");
		movieDTO.setRevenueInDollars(1990);

		DirectorDTO directorDTO = new DirectorDTO();
		directorDTO.setDirectorId("D101");
		directorDTO.setDirectorName("Chris Columbus");
		directorDTO.setBornIn(1958);
		movieDTO.setDirector(directorDTO);
		
		String id ="";
		try {
			id= movieService.addMovie(movieDTO);
		} catch (DreamMakersException e) {
			id=e.getMessage();
		}
		Assertions.assertEquals("M1001",id);
	}
	
	@Test
	void testInvalidInput() {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieId("M1001");
		movieDTO.setMovieName("");
		movieDTO.setReleasedIn(LocalDate.of(1990, 05, 24));
		movieDTO.setLanguage("English");
		movieDTO.setRevenueInDollars(1990);

		DirectorDTO directorDTO = new DirectorDTO();
		directorDTO.setDirectorId("D101");
		directorDTO.setDirectorName("Chris Columbus");
		directorDTO.setBornIn(1958);
		movieDTO.setDirector(directorDTO);
		
		String id ="";
		try {
			id= movieService.addMovie(movieDTO);
		} catch (DreamMakersException e) {
			id=e.getMessage();
		}
		Assertions.assertEquals("M1001",id);
	}

}
