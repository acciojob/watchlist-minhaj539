package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovieToDb(movie);
    }
    public String addDirector(Director director){
        return movieRepository.addDirectorToDb(director);
    }

    public String addPair(String name,String dirName) {
        return movieRepository.addPairToDb(name,dirName);
    }
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesList(String dirName){
        return movieRepository.getMoviesList(dirName);
    }

    public List<String> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public String deleteDir(String dirName) {
        return movieRepository.deleteDirFromDb(dirName);
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectorsFromDb();
    }
}
