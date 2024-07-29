package az.edu.turing.az.springboot05jpa.controller;

import az.edu.turing.az.springboot05jpa.model.Profile;
import az.edu.turing.az.springboot05jpa.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(service.createProfile(profile));
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(service.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProfileById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllProfiles() {
        service.deleteAllProfiles();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable Long id) {
        service.deleteProfileById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return ResponseEntity.ok(service.updateProfile(id, profile));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getProfileCount() {
        return ResponseEntity.ok(service.getProfileCount());
    }

    @PatchMapping("/{id}/photo")
    public ResponseEntity<Profile> updateProfilePhoto(@PathVariable Long id, @RequestBody String photoUrl) {
        return ResponseEntity.ok(service.updateProfilePhoto(id, photoUrl));
    }
}
