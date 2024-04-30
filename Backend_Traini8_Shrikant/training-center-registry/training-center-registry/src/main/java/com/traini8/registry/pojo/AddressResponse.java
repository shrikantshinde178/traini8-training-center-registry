package com.traini8.registry.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressResponse {

	private String detailedAddress;

	private String city;

	private String state;

	private String pincode;

}
