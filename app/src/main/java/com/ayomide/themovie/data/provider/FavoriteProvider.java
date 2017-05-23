package com.ayomide.themovie.data.provider;

import android.net.Uri;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.InexactContentUri;
import net.simonvt.schematic.annotation.TableEndpoint;




@ContentProvider(authority = FavoriteProvider.AUTHORITY, database = FavoriteDatabase.class)
public class FavoriteProvider {

    public static final String AUTHORITY = "com.zeeice.themovie.Data.FavoriteProvider";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    interface Path {
        String FAVORITES = "favorites";
    }

    private static Uri buildUri(String... paths) {
        Uri.Builder builder = BASE_CONTENT_URI.buildUpon();
        for (String path : paths) {
            builder.appendPath(path);
        }
        return builder.build();
    }

    @TableEndpoint(table = FavoriteDatabase.FAVORITES)
    public static class Favorites {

        @ContentUri(
                path = Path.FAVORITES,
                type = "vnd.android.cursor.dir/favorite")
        public static final Uri CONTENT_URI = buildUri(Path.FAVORITES);

        @InexactContentUri(
                name = "FAVORITE_ID",
                path = Path.FAVORITES + "/#",
                type = "vnd.android.cursor.item/favorite",
                whereColumn = FavoriteColumns._ID,
                pathSegment = 1)
        public static Uri withId(long id) {
            return buildUri(Path.FAVORITES, String.valueOf(id));
        }
    }
}
