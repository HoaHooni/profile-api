package com.example.demo.model.dto;

import com.example.demo.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
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

    private List<SocialDto> addSocials;

    private List<SocialDto> updateSocials;

    private List<SocialDto> deleteSocials;

    public static UserDto convertToDto(UserEntity entity) {
        if (entity == null)
            return null;

        return UserDto.builder().name(entity.getName()).description(entity.getDescription()).image(entity.getImage())
                .id(entity.getId()).bio(entity.getBio()).contactMessage(entity.getContactMessage())
                .email(entity.getEmail()).phone(entity.getPhone()).github(entity.getGithub())
                .project(entity.getProject()).facebook(entity.getFacebook()).linkedin(entity.getLinkedin())
                .website(entity.getWebsite()).socials(SocialDto.convertToDtos(entity.getSocials()))
                .socials(SocialDto.convertToDtos(entity.getSocials()))
                .address(new UserDto().new Address(entity.getStreet(), entity.getCity(), entity.getCountry()))
                .createAt(entity.getCreateAt()).updateAt(entity.getUpateAt()).createBy(entity.getCreateBy()).updateBy(entity.getUpdateBy()).build();
    }

    public static List<UserDto> convertToDtos(List<UserEntity> userEntities) {
        if (userEntities == null || userEntities.size() == 0)
            return null;
        return userEntities.stream().map(UserDto::convertToDto).collect(Collectors.toList());
    }

    public static UserEntity convertToEntity(UserDto userDto) {
        if (userDto == null)
            return null;

        return UserEntity.builder().name(userDto.getName()).description(userDto.getDescription())
                .image(userDto.getImage()).id(userDto.getId()).bio(userDto.getBio())
                .contactMessage(userDto.getContactMessage()).email(userDto.getEmail()).phone(userDto.getPhone())
                .github(userDto.getGithub()).project(userDto.getProject()).facebook(userDto.getFacebook())
                .linkedin(userDto.getLinkedin()).website(userDto.getWebsite()).street(userDto.getAddress().getStreet())
                .city(userDto.getAddress().getCity()).country(userDto.getAddress().getCountry()).build();
    }

    public static List<UserEntity> convertToEntities(List<UserDto> userDtos) {
        if (userDtos == null || userDtos.size() == 0)
            return null;
        return userDtos.stream().map(UserDto::convertToEntity).collect(Collectors.toList());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Address {
        private String street;

        private String city;

        private String country;

    }

}
