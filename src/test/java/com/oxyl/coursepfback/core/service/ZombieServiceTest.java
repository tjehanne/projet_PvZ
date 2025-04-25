package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.repository.ZombieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZombieServiceTest {

    @Mock
    private ZombieRepository zombieRepository;

    private TestZombieService zombieService;

    private static final String DEFAULT_ZOMBIE_IMAGE = "images/zombie/default.png";

    @BeforeEach
    void setUp() {
        zombieService = new TestZombieService(zombieRepository);
    }

    @Test
    void shouldFindAllZombies() {
        // Given
        List<ZombieModel> expectedZombies = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "zombie2.png", 1)
        );
        when(zombieRepository.findAll()).thenReturn(expectedZombies);

        // When
        List<ZombieModel> actualZombies = zombieService.findAllZombies();

        // Then
        assertEquals(expectedZombies, actualZombies);
        verify(zombieRepository).findAll();
    }

    @Test
    void shouldFindZombieById() {
        // Given
        Integer zombieId = 1;
        ZombieModel expectedZombie = new ZombieModel(zombieId, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1);
        when(zombieRepository.findById(zombieId)).thenReturn(expectedZombie);

        // When
        ZombieModel actualZombie = zombieService.findZombieById(zombieId);

        // Then
        assertEquals(expectedZombie, actualZombie);
        verify(zombieRepository).findById(zombieId);
    }

    @Test
    void shouldFindZombiesByMapId() {
        // Given
        Integer mapId = 1;
        List<ZombieModel> expectedZombies = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", mapId),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "zombie2.png", mapId)
        );
        when(zombieRepository.findByMapId(mapId)).thenReturn(expectedZombies);

        // When
        List<ZombieModel> actualZombies = zombieService.findZombiesByMapId(mapId);

        // Then
        assertEquals(expectedZombies, actualZombies);
        verify(zombieRepository).findByMapId(mapId);
    }

    @Test
    void shouldCreateZombieWithValidImage() {
        // Given
        ZombieModel zombie = new ZombieModel(null, "Zombie1", 100, 1.0, 20, 0.5, "images/zombie/zombie1.png", 1);

        // When
        zombieService.create(zombie);

        // Then
        verify(zombieRepository).create(zombie);
        assertEquals("images/zombie/zombie1.png", zombie.getChemin_image());
    }

    @Test
    void shouldCreateZombieWithDefaultImageWhenImagePathIsNull() {
        // Given
        ZombieModel zombie = new ZombieModel(null, "Zombie1", 100, 1.0, 20, 0.5, null, 1);

        // When
        zombieService.create(zombie);

        // Then
        verify(zombieRepository).create(zombie);
        assertEquals(DEFAULT_ZOMBIE_IMAGE, zombie.getChemin_image());
    }

    @Test
    void shouldCreateZombieWithDefaultImageWhenImagePathIsEmpty() {
        // Given
        ZombieModel zombie = new ZombieModel(null, "Zombie1", 100, 1.0, 20, 0.5, "", 1);

        // When
        zombieService.create(zombie);

        // Then
        verify(zombieRepository).create(zombie);
        assertEquals(DEFAULT_ZOMBIE_IMAGE, zombie.getChemin_image());
    }

    @Test
    void shouldUpdateZombieWithValidImage() {
        // Given
        ZombieModel zombie = new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "images/zombie/zombie1.png", 1);

        // When
        zombieService.update(zombie);

        // Then
        verify(zombieRepository).update(zombie);
        assertEquals("images/zombie/zombie1.png", zombie.getChemin_image());
    }

    @Test
    void shouldUpdateZombieWithDefaultImageWhenImagePathIsInvalid() {
        // Given
        ZombieModel zombie = new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "invalid/path.png", 1);

        // When
        zombieService.update(zombie);

        // Then
        verify(zombieRepository).update(zombie);
        assertEquals(DEFAULT_ZOMBIE_IMAGE, zombie.getChemin_image());
    }

    @Test
    void shouldDeleteZombie() {
        // Given
        Integer zombieId = 1;

        // When
        zombieService.delete(zombieId);

        // Then
        verify(zombieRepository).delete(zombieId);
    }
}

class TestZombieService extends ZombieService {
    public TestZombieService(ZombieRepository zombieRepository) {
        super(zombieRepository);
    }

    @Override
    protected boolean isValidImagePath(String imagePath) {
        return imagePath != null && !imagePath.isEmpty() && imagePath.startsWith("images/zombie/");
    }
} 