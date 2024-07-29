package az.edu.turing.az.springboot05jpa.service;

import az.edu.turing.az.springboot05jpa.exception.ProfileNotFoundException;
import az.edu.turing.az.springboot05jpa.model.Profile;
import az.edu.turing.az.springboot05jpa.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public Profile createProfile(Profile profile) {
        return repository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return repository.findAll();
    }

    public Profile getProfileById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProfileNotFoundException(id));
    }

    public void deleteAllProfiles() {
        repository.deleteAll();
    }

    public void deleteProfileById(Long id) {
        if (!repository.existsById(id)) {
            throw new ProfileNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile profile = getProfileById(id);
        profile.setName(profileDetails.getName());
        profile.setEmail(profileDetails.getEmail());
        profile.setPhone(profileDetails.getPhone());
        return repository.save(profile);
    }

    public long getProfileCount() {
        return repository.count();
    }

    public Profile updateProfilePhoto(Long id, String photoUrl) {
        Profile profile = getProfileById(id);
        profile.setPhotoUrl(photoUrl);
        return repository.save(profile);
    }
}
