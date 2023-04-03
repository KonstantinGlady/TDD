package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class WordSelectionFailureTest {

    @Mock
    private WordRepository wordRepository;
    @Mock
    private RandomNumber random;

    @Test
    void reportsWordNotFound() {
        doThrow(new WordRepositoryException())
                .when(wordRepository).fetchWordByNumber(anyInt());

        var selection = new WordSelection(wordRepository, random);
        assertThatExceptionOfType(WordSelectionException.class)
                .isThrownBy(() -> selection.chooseRandomWord());
    }
}
