package com.sevak.registration.util;

import java.util.regex.Pattern;

public class Validation {
    public static String valid(String name, String surName, String email, int age, String password){

        if(!name.matches("^[A-Z][A-Z,a-z]{3,20}"))
            return "Անունը սխալ է մուտքագրված";
        if(!surName.matches("^[A-Z][A-Z,a-z]{3,30}"))
            return "Ազգանունը սխալ է մուտքագրված";
        if(!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"))
            return "Էլ․ հասցեն սխալ է մուտքագրված";
        if(age>100||age<18)
            return "Տարիքը սխալ է մուտքագրված";
        if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,20}$"))
            return "Գաղտնաբառը պետք է պարունակի թիվ, մեծատառ, փոքռատառ, հատւկ նշան(!@#$%^&+=) և 8-ից ավել նիշ";

        return "ok";
    }
}
