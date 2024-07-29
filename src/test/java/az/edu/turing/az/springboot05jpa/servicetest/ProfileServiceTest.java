package az.edu.turing.az.springboot05jpa.servicetest;

import az.edu.turing.az.springboot05jpa.exception.ProfileNotFoundException;
import az.edu.turing.az.springboot05jpa.model.Profile;
import az.edu.turing.az.springboot05jpa.repository.ProfileRepository;
import az.edu.turing.az.springboot05jpa.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProfileServiceTest {

    @InjectMocks
    private ProfileService service;

    @Mock
    private ProfileRepository repository;

    public ProfileServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProfileById_ProfileExists() {
        Profile profile = new Profile();
        profile.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(profile));

        Profile result = service.getProfileById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetProfileById_ProfileDoesNotExist() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ProfileNotFoundException.class, () -> {
            service.getProfileById(1L);
        });
    }

}
