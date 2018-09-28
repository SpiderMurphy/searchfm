package com.radio.search_fm;

import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.presenter.PresenterArtistList;
import com.radio.search_fm.views.ViewArtistAdapter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PresenterArtistListUnitTest {
    PresenterArtistList presenterArtistList;
    static List<Artist> artistList;
    static Artist artist;

    @BeforeClass
    public static void setupTestData() {
        artist = new Artist();
        artist.setName("Test artist");
    }

    @Before
    public void setupPresenter() {
        artistList = new ArrayList<>();
        artistList.add(artist);
        presenterArtistList = new PresenterArtistList(artistList);
    }

    @Test
    public void getCount_With1Item_ReturnValue() {
        assertEquals(1, presenterArtistList.getCount());
    }

    @Test
    public void clear_With1Item_Cleared() {
        presenterArtistList.clear();
        assertEquals(0, presenterArtistList.getCount());
    }

    @Test
    public void addArtist_With1ItemAlreadyIn_Added() {
        List<Artist> additionalAristsList = new ArrayList<>();
        Artist additionalArtist = new Artist();

        additionalArtist.setName("Test artist 2");

        additionalAristsList.add(additionalArtist);
        presenterArtistList.addArtists(additionalAristsList);

        assertEquals(2, presenterArtistList.getCount());
    }

    @Test
    public void bindViewHolder_TestArgument_TestArtist() {
        ViewArtistAdapter viewArtistAdapter = Mockito.mock(ViewArtistAdapter.class);
        ArgumentCaptor<Artist> artistArgumentCaptor = ArgumentCaptor.forClass(Artist.class);

        presenterArtistList.bindViewHolder(viewArtistAdapter, 0);
        Mockito.verify(viewArtistAdapter).bindItem(artistArgumentCaptor.capture());

        Artist exceptedArtist = artistArgumentCaptor.getValue();
        assertEquals("Test artist", exceptedArtist.getName());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getArtist_With0Item_Exception() {
        presenterArtistList = new PresenterArtistList();
        presenterArtistList.getArtist(0);
    }
}
