package com.evilinsult.android;

/**
 * Created by Nariman-laptop on 1/4/2017.
 */

public class Languages  {

    public String getLang(String language){
        String lang="en";
        switch (language.trim()){
            case "English":lang="en";
                break;
            case "Spanish":lang="es";
                break;
            case "Chinese":lang="zh";
                break;
            case "Hindi":lang="hi";
                break;
            case "Arabic":lang="ar";
                break;
            case "Portuguese":lang="pt";
                break;
            case "Bengali":lang="bn";
                break;
            case "Russian":lang="ru";
                break;
            case "Japanese":lang="ja";
                break;
            case "Javanese":lang="jv";
                break;
            case "Swahili":lang="sw";
                break;
            case "German":lang="de";
                break;
            case "Korean":lang="ko";
                break;
            case "French":lang="fr";
                break;
            case "Telugu":lang="te";
                break;
            case "Marathi":lang="mr";
                break;
            case "Turkish":lang="tr";
                break;
            case "Tamil":lang="ta";
                break;
            case "Vietnamese":lang="vi";
                break;
            case "Urdu":lang="ur";
                break;
            case "Greek":lang="el";
                break;
            case "Italian":lang="it";
                break;
            case "Czech":lang="cs";
                break;
            case "Latin":lang="la";
                break;
            default:lang="en";
                break;

        }
        return lang;
    }
}
