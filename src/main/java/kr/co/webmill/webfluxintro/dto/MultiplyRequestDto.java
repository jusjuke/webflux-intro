package kr.co.webmill.webfluxintro.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MultiplyRequestDto {
    private int first;
    private int second;
}
