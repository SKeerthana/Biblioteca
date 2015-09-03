package com.thoughtworks.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class BibliotecaTest {

    @Test
    public void shouldCallStartFunctionOnlyOnce() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        biblioteca.start();
        Mockito.verify(biblioteca, times(1)).start();
    }

}
