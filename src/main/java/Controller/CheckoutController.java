package Controller;

import static spark.Spark.*;

public class CheckoutController {
// https://www.baeldung.com/spark-framework-rest-api
// http://sparkjava.com/documentation

    public static void main(String[] args) {
        get("/", (req, res) -> "Hello MyTech using SPARK");
    }

}
