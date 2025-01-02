package com.max.garnet.dto;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PendingUserDTO {
    private Long connectionId;
    private String nickname;
    private String situation;
    private String affiliatedHeadquarters;
    private String affiliatedBranch;
    private String affiliatedDistributor;
    private String affiliatedStore;
    private Timestamp registrationDate;
    private String phoneNumber;
    private Boolean approvalStatus;
    private String detailsUrl;
}
