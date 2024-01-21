package stepsDefinition;


public class URLBase {

    String urlBase = "https://restful-booker.herokuapp.com/";
    String urlBooking = urlBase + "booking/";
    public static Integer statusCode;

    public String getUrlBase() {
        return urlBase;
    }

    public String getUrlBooking(String id) {
        String urlConId = urlBooking + id;
        return urlConId;
    }
}
