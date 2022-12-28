package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb=new HashMap<>();
     HashMap<String,Director> directorDb=new HashMap<>();

    HashMap<String, List<String>> pair=new HashMap<>();
    public String addDirectorToDb(Director director){
        String name=director.getName();
        directorDb.put(name,director);
        return "Director added";
    }
    public String addMovieToDb(Movie movie){
        String name=movie.getName();
        movieDb.put(name,movie);
        return "Movie added";
    }

    public String addPairToDb(String name,String dirName) {
        if(movieDb.containsKey(name)&&directorDb.containsKey(dirName)){
            if(!pair.containsKey(dirName)){
                List<String> l=new ArrayList<>();
                l.add(name);
                pair.put(dirName,l);
            }
            else{
                List<String> l=pair.get(dirName);
                l.add(name);
                pair.put(dirName,l);
            }
            return "added pair";
        }
        return "does not exist";
    }
    public Movie getMovieByName(String name){
        if(movieDb.containsKey(name)){
            return movieDb.get(name);
        }
        return null;
    }
    public Director getDirectorByName(String name){
        if(directorDb.containsKey(name)) {
            return directorDb.get(name);
        }
        return null;
    }
    public List<String> getMoviesList(String dirName){
        if(pair.containsKey(dirName)){
            return pair.get(dirName);
        }
        return null;
    }

    public List<String> getAllMovies() {
        List<String> l=new ArrayList<>();
        for(String name:movieDb.keySet()){
            l.add(name);
        }
        return l;
    }

    public String deleteDirFromDb(String dirName) {
        if(directorDb.containsKey(dirName)){
           if(pair.containsKey(dirName)) {
               List<String> movies = pair.get(dirName);
               for (String movie : movies) {
                   if (movieDb.containsKey(movie)) {
                       movieDb.remove(movie);

                   }
               }
               directorDb.remove(dirName);
               pair.remove(dirName);
               return "movies removed sucessfully";
           }
           }
           return "director does not exist";
    }

    public String deleteAllDirectorsFromDb() {
       for(String dirName:directorDb.keySet()){
           if(pair.containsKey(dirName)){
               List<String> movies=pair.get(dirName);
               for(String movie:movies){
                   if(movieDb.containsKey(movie)){
                       movieDb.remove(movie);
                   }
               }

           }
           pair.clear();
           directorDb.clear();
           return "all directors cleared";
       }
       pair.clear();
       directorDb.clear();
       return "no movies to remove";
    }
}
