package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class UserDto extends BaseDto<Long> {

	private String name;

	private String description;

	private String image;

	private String bio;

	private String contactMessage;

	private String email;

	private String phone;

	private String github;

	private String project;

	private String facebook;

	private String linkedin;

	private Address address;

	private String website;

	private List<SocialDto> socials;


	public static UserDto convertToDto(UserEntity entity) {
		if (entity == null)
			return null;
		
		UserDto userDto = UserDto.builder().name(entity.getName()).description(entity.getDescription()).image(entity.getImage())
				.id(entity.getId()).bio(entity.getBio()).contactMessage(entity.getContactMessage())
				.email(entity.getEmail()).phone(entity.getPhone()).github(entity.getGithub())
				.project(entity.getProject()).facebook(entity.getFacebook()).linkedin(entity.getLinkedin())
				.website(entity.getWebsite()).socials(SocialDto.convertToDtos(entity.getSocials())).build();
		Address a = new Address().makeAddress(entity.getStreet(), entity.getCity(), entity.getCountry());
		userDto.setAddress(new Address(entity.getStreet(), entity.getCity(), entity.getCountry()));
		 return userDto;
	}

	@Data
	@NoArgsConstructor
	public class Address {
		private String street;

		private String city;

		private String country;

		public Address(String street, String city, String country) {

			this.street = street;
			this.city = city;
			this.country = country;
		}
		
		public Address makeAddress(String street, String city, String country) {
			return new Address(street, city, country);
		}
		
	}

}
