package com.example.template.controller;

import static org.jsoup.parser.Parser.unescapeEntities;

public class unescape {
    public static String unescapeUntilNoHtmlEntityFound(final String value){
        String unescaped = unescapeEntities(value, true);
        System.out.println(unescaped);
        if ( !unescaped.equals(value) ) return unescapeUntilNoHtmlEntityFound(unescaped);
        else                            return unescaped;
    }
    public static void main(String[] args) {
        System.out.println(unescapeUntilNoHtmlEntityFound("<script>asd</script>"));
        String value="<script>alert('binatest')</script>";
        value=value.replace("<","");
        value=value.replace(">","");
        value=value.replace("&","");
        value=value.replace("//","");
        value=value.replace("$.","");
        value=value.replace("$(","");
        System.out.println(value);

    }

}
