package com.infy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.MovieDTO;
import com.infy.exception.DreamMakersException;
import com.infy.repository.MovieRepository;
import com.infy.validator.Validator;

@Service(value = "movieService")
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public String addMovie(MovieDTO movieDTO) throws DreamMakersException {
		try {
			Validator.validate(movieDTO);
			return movieRepository.addMovie(movieDTO);
		}catch(DreamMakersException e) {
			throw e;
		}
	}

	public List<MovieDTO> getMovies(String directorName) throws DreamMakersException {
		List<MovieDTO> result=new ArrayList<>();
		for(MovieDTO movie:movieRepository.getAllMovies()) {
			if(movie.getDirector().getDirectorName().equals(directorName)) {
				result.add(movie);
			}
		}
		if(result.isEmpty()) {
			throw new DreamMakersException("Service.MOVIE_NOT_FOUND");
		}
		return result;
	}
}
