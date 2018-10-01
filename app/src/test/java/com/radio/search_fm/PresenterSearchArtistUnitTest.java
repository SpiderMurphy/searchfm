package com.radio.search_fm;

import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.models.Repository;
import com.radio.search_fm.presenter.PresenterSearchArtist;
import com.radio.search_fm.views.ViewSearchActivity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

public class PresenterSearchArtistUnitTest {
    PresenterSearchArtist presenterSearchArtist;
    static Artist artist;

    @BeforeClass
    public static void setupTestData() {
        artist = new Artist();

        artist.setName("Test artist");
    }

    @Test
    public void searchArtistByName_WithTestArtist_Found() {
        Repository<Artist> artistRepository = Mockito.mock(Repository.class);
        ViewSearchActivity viewSearchActivity = Mockito.mock(ViewSearchActivity.class);

        presenterSearchArtist = new PresenterSearchArtist(viewSearchActivity, artistRepository);

        presenterSearchArtist.searchArtistByName("Test artist");
        ArgumentCaptor<Map<String, String>> criteriaCaptor = ArgumentCaptor.forClass(Map.class);
        Mockito.verify(artistRepository, Mockito.times(1)).query(criteriaCaptor.capture(), Mockito.any());

        Map<String, String> expectedCriteria = criteriaCaptor.getValue();
        assertEquals(true, expectedCriteria.containsKey(ArtistRepository.ARTIST_NAME));
    }
}
