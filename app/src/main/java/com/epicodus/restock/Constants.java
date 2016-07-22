package com.epicodus.restock;

public class Constants {
    public static final String YELP_CONSUMER_KEY = BuildConfig.YELP_CONSUMER_KEY;
    public static final String YELP_CONSUMER_SECRET = BuildConfig.YELP_CONSUMER_SECRET;
    public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
    public static final String YELP_TOKEN_SECRET = BuildConfig.YELP_TOKEN_SECRET;

    public static final String YELP_BASE_URL = "https://api.yelp.com/v2/search?term=food+cart";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";

    public static final String LOCATION_FIX = "portland";

    public static final String FIREBASE_CHILD_USERS = "users";
    public static final String FIREBASE_CHILD_FOODTRUCKS = "foodtrucks";
    public static final String FIREBASE_CHILD_IEMS = "items";

    public static final String PARCEL_FOODTRUCKS = "foodtrucks";

}
