package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

  //add movie
    @PostMapping("/add_Movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie){
        String msg=movieService.addMovie(movie);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }
    //add director
    @PostMapping("/add_Director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director){
        String msg= movieService.addDirector(director);
        return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
    }

    //pairing movie & director
    @PutMapping("pairing")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name") String name,@RequestParam("dirName") String dirName){
        String msg=movieService.addPair(name,dirName);
        return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
    }

    //get movie by name
    @GetMapping("/get_movie_by_name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name")String name){
       Movie movie=movieService.getMovieByName(name);
       return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
    }

    //get director by director name
    @GetMapping("/get_director_by_name")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name")String name){
        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.ACCEPTED);
    }
   //get list of movies by director name
    @GetMapping("get_list_of_movie_by_director_name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam("dirName")String dirName){
        List<String> ans=new ArrayList<>();
        ans=movieService.getMoviesList(dirName);
        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
    @GetMapping("get_all_movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movieList=movieService.getAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("delete_director_and_its_movies")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("dirName")String dirName){
        String res=movieService.deleteDir(dirName);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("delete_all_directors_and_their_movies")
    public ResponseEntity<String> deleteAllDirectors(){
        String res=movieService.deleteAllDirectors();
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }





    //get director name by movie name
    @GetMapping("/get_director_by_movie_name")
    public ResponseEntity<String> getDirectorByMovie(@RequestParam("movie_name") String movie_name){
        String response=movieService.getDirectorByMovieName(movie_name);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
