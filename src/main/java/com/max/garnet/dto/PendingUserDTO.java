package com.max.garnet.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PendingUserDTO {
    private Long connectionId;
    private String nickname;
    private String situation;
    private String affiliatedHeadquarters;
    private String affiliatedBranch;
    private String affiliatedDistributor;
    private String affiliatedStore;
    private LocalDateTime registrationDate;
    private String phoneNumber;
    private Boolean approval;
    private String detailsUrl;
}
