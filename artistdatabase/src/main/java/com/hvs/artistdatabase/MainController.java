package com.hvs.artistdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="/artistdatabase")
public class MainController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ArtistRepository artistRepository;

    @PostMapping(path = "/artist") // Map ONLY POST Requests
    public void addNewArtist (
            @RequestBody Artist artist
    ) {
        // @ResponseBody means the returned String is the response, not a view name
        artistRepository.save(artist);
    }

    @GetMapping(path="/artist/all")
    public @ResponseBody Iterable<Artist> getAllArtists() {
        // This returns a JSON or XML with the users
        return artistRepository.findAll();
    }

    @DeleteMapping(path="/artist")
    public void deleteAll() {
        artistRepository.deleteAll();
    }

}