package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ValueLabel implements Serializable {
	private String value;
	private String label;
}
