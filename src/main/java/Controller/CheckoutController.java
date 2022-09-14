package Controller;

import static spark.Spark.*;
import Model.TechItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckoutController {
// https://www.baeldung.com/spark-framework-rest-api
// http://sparkjava.com/documentation

    public static void main(String[] args) {
        get("/", (req, res) -> "Hello MyTech using SPARK");
    }

}
