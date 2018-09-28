package com.radio.search_fm;


import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.models.Repository;
import com.radio.search_fm.presenter.PresenterArtistDetail;
import com.radio.search_fm.views.ViewArtistDetail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class PresenterArtistDetailUnitTest {
    PresenterArtistDetail presenterArtistDetail;
    static Artist artist;

    @BeforeClass
    public static void setupTest() {
        artist = new Artist();

        artist.setName("Test artist");
    }

    @Test
    public void getArtistInfo_With1Artist_Found() {
        Repository<Artist> artistRepository = Mockito.mock(Repository.class);
        ViewArtistDetail viewArtistDetail = Mockito.mock(ViewArtistDetail.class);

        Mockito.doAnswer(invocation -> null).when(artistRepository).querySingle(Mockito.anyMap(), Mockito.any());
        presenterArtistDetail = new PresenterArtistDetail(viewArtistDetail, artistRepository);

        presenterArtistDetail.getArtistInfo("Test artist", Mockito.mock(Repository.QueryResultSingle.class));
        ArgumentCaptor<Map<String, String>> criteriaCaptor = ArgumentCaptor.forClass(Map.class);
        Mockito.verify(artistRepository, Mockito.times(1)).querySingle(criteriaCaptor.capture(), Mockito.any());

        Map<String, String> expectedCriteria = criteriaCaptor.getValue();
        assertEquals(true, expectedCriteria.containsKey(ArtistRepository.ARTIST_NAME));
    }
}
