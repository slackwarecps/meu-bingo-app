package br.com.fabioalvaro.apicartelas;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fabioalvaro.apicartelas.entidades.Cartela;
import br.com.fabioalvaro.apicartelas.repository.CartelaRepository;
import br.com.fabioalvaro.apicartelas.service.CartelaService;

@SpringBootTest
public class CartelaServiceTest {

    @Mock
    private CartelaRepository cartelaRepository;

    @InjectMocks
    private CartelaService cartelaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCartelas() {
        Cartela cartela1 = new Cartela();
        Cartela cartela2 = new Cartela();
        List<Cartela> cartelas = Arrays.asList(cartela1, cartela2);

        when(cartelaRepository.findAll()).thenReturn(cartelas);

        List<Cartela> result = cartelaService.getAllCartelas();
        assertEquals(2, result.size());
        verify(cartelaRepository, times(1)).findAll();
    }

    @Test
    public void testGetCartelaById() {
        Cartela cartela = new Cartela();
        cartela.setId(1L);

        when(cartelaRepository.findById(1L)).thenReturn(Optional.of(cartela));

        Optional<Cartela> result = cartelaService.getCartelaById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(cartelaRepository, times(1)).findById(1L);
    }

    @Test
    public void testSalvarCartela() {
        Cartela cartela = new Cartela();
        cartela.setId(1L);

        when(cartelaRepository.save(cartela)).thenReturn(cartela);

        Cartela result = cartelaService.salvarCartela(cartela);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(cartelaRepository, times(1)).save(cartela);
    }

    @Test
    public void testDeletarCartela() {
        Long id = 1L;

        doNothing().when(cartelaRepository).deleteById(id);

        cartelaService.deletarCartela(id);
        verify(cartelaRepository, times(1)).deleteById(id);
    }
}