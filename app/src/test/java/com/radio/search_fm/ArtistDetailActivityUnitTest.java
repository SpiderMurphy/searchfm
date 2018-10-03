package com.radio.search_fm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ArtistDetailActivityUnitTest {
    ArtistDetailActivity artistDetailActivity;

    @Test
    public void onCreate_Test_Pass() {
        artistDetailActivity = Robolectric.buildActivity(ArtistDetailActivity.class).create().get();

    }


}
