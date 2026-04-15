package com.se.sewebservice;

import com.se.sewebservice.calculator.*;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/shapetool";

    // Circle
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CircleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circle(@RequestPayload CircleAreaRequest request) {
        CircleAreaResponse response = new CircleAreaResponse();

        double r = request.getRadius();
        if (r < 0) throw new RuntimeException("Radius cannot be negative");

        response.setArea(Math.PI * r * r);
        return response;
    }

    // Square
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SquareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse square(@RequestPayload SquareAreaRequest request) {
        SquareAreaResponse response = new SquareAreaResponse();

        double s = request.getSide();
        if (s < 0) throw new RuntimeException("Side cannot be negative");

        response.setArea(s * s);
        return response;
    }

    // Rectangle
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangle(@RequestPayload RectangleAreaRequest request) {
        RectangleAreaResponse response = new RectangleAreaResponse();

        double l = request.getLength();
        double w = request.getWidth();

        if (l < 0 || w < 0) throw new RuntimeException("Invalid input");

        response.setArea(l * w);
        return response;
    }

    // Parallelogram
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ParallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogram(@RequestPayload ParallelogramAreaRequest request) {
        ParallelogramAreaResponse response = new ParallelogramAreaResponse();

        double b = request.getBase();
        double h = request.getHeight();

        if (b < 0 || h < 0) throw new RuntimeException("Invalid input");

        response.setArea(b * h);
        return response;
    }

    // Triangle
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TriangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangle(@RequestPayload TriangleAreaRequest request) {
        TriangleAreaResponse response = new TriangleAreaResponse();

        double b = request.getBase();
        double h = request.getHeight();

        if (b < 0 || h < 0) throw new RuntimeException("Invalid input");

        response.setArea(0.5 * b * h);
        return response;
    }
}