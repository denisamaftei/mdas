package com.mdas.demo.service;

import com.mdas.demo.model.AnimalModel;
import com.mdas.demo.repository.AnimalRepository;
import com.mdas.demo.service.dto.AnimalDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;


@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @Mock
    private AnimalRepository repository;

    private AnimalService animalService;

    private final AnimalModel mock = getMockAnimal();

    @BeforeEach
    public void init(){
        animalService = new AnimalService(repository);
    }


    @Test
    public void should_add_animal(){
        Mockito.when(repository.save(mock)).thenReturn(mock);
        AnimalDTO dto = animalService.addAnimal(mock);

        Assertions.assertThat(dto).isNotNull();
        Assertions.assertThat(dto.getLocation()).isEqualTo(mock.getLocation());
        Assertions.assertThat(dto.getNume()).isEqualTo(mock.getNume());
        Assertions.assertThat(dto.getTip()).isEqualTo(mock.getTip());
        Assertions.assertThat(dto.getVarsta()).isEqualTo(mock.getVarsta());
        Assertions.assertThat(dto.getRasa()).isEqualTo(mock.getRasa());
        Assertions.assertThat(dto.getPostTime()).isEqualTo(mock.getPostTime());
    }

    @Test
    public void should_delete_animal_by_id(){

        animalService.deleteAnimal(mock.getId());
        Mockito.when(repository.findById(mock.getId())).thenReturn(Optional.empty());
        Assertions.assertThat(animalService.retrieveAnimal(mock.getId())).isNull();
    }

    @Test
    public void should_retrieve_animal_by_id(){
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(mock));

        AnimalDTO dto = animalService.retrieveAnimal(mock.getId());

        Assertions.assertThat(dto).isNotNull();
    }

    @Test
    public void should_retrieve_all_animals(){
        Mockito.when(repository.findAll()).thenReturn(aMockListOfAnimals());
        List<AnimalDTO> dtoList = animalService.retrieveAllAnimals();

        Assertions.assertThat(dtoList).hasSize(3);
    }

    private Iterable<AnimalModel> aMockListOfAnimals() {
        return Arrays.asList(getMockAnimal(),getMockAnimal(),getMockAnimal());
    }

    private AnimalModel getMockAnimal(){
        return new AnimalModel(1L,"Nume","Prenume","tip",12,"Locatie", LocalDateTime.now());
    }

}