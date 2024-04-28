package io.example.common.model.model;

import org.springframework.format.annotation.NumberFormat;

public class FormatObj {

    @NumberFormat(pattern = "#.##")
    private Double d1 = 123.45678;
    private Integer i1 = 12345;
}
