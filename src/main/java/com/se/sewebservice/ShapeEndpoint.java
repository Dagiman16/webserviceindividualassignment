package com.se.sewebservice;

import com.se.sewebservice.calculator.*;
import org.springframework.ws.server.endpoint.annotation.*;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFaults;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.SoapFaultException;

@Endpoint
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/shapetool";

    private void validatePositive(double value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be greater than zero");
        }
    }

    // Circle
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CircleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circle(@RequestPayload CircleAreaRequest request) {
        validatePositive(request.getRadius(), "radius");
        CircleAreaResponse response = new CircleAreaResponse();
        response.setArea(Math.PI * request.getRadius() * request.getRadius());
        return response;
    }

    // Square
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SquareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse square(@RequestPayload SquareAreaRequest request) {
        validatePositive(request.getSide(), "side");
        SquareAreaResponse response = new SquareAreaResponse();
        response.setArea(request.getSide() * request.getSide());
        return response;
    }

    // Rectangle
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangle(@RequestPayload RectangleAreaRequest request) {
        validatePositive(request.getLength(), "length");
        validatePositive(request.getWidth(), "width");
        RectangleAreaResponse response = new RectangleAreaResponse();
        response.setArea(request.getLength() * request.getWidth());
        return response;
    }

    // Parallelogram
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ParallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogram(@RequestPayload ParallelogramAreaRequest request) {
        validatePositive(request.getBase(), "base");
        validatePositive(request.getHeight(), "height");
        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        response.setArea(request.getBase() * request.getHeight());
        return response;
    }

    // Triangle
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TriangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangle(@RequestPayload TriangleAreaRequest request) {
        validatePositive(request.getBase(), "base");
        validatePositive(request.getHeight(), "height");
        TriangleAreaResponse response = new TriangleAreaResponse();
        response.setArea(0.5 * request.getBase() * request.getHeight());
        return response;
    }
}
