package ru.netology;

import lombok.RequiredArgsConstructor;
import lombok.Value;


@RequiredArgsConstructor
@Value

public class UserData {
    String city;
    String fullName;
    String phoneNumber;
}
