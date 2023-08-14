package com.example.zoostorestorage.api.base;

public interface OperationProcessor<Input, Response> {

    Response process(Input input);
}
