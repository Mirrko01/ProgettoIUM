package com.example.visitcagliari;

import java.util.List;

public class DirectionsResponse {
    public List<Route> routes;

    public static class Route {
        public List<Leg> legs;

        public static class Leg {
            public List<Step> steps;

            public static class Step {
                public String html_instructions;
            }
        }
    }
}
