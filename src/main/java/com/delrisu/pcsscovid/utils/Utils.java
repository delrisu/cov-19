package com.delrisu.pcsscovid.utils;

import com.delrisu.pcsscovid.model.latest.Country;
import com.delrisu.pcsscovid.model.CountryData;
import com.delrisu.pcsscovid.model.latest.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static com.delrisu.pcsscovid.utils.Utils.Constants.COUNTRIES;
import static com.delrisu.pcsscovid.utils.Utils.Constants.COUNTRIES_LINKS;

public class Utils {

    public static class Constants {

        static public final String POLAND_LINK = "/3Po6TV7wTht4vIEid";
        static public final String LITHUANIA_LINK = "/xhGDb8VTqjtm1AQL6";
        static public final String SLOVENIA_LINK = "/603AyvQ8QjyqmnZx6";
        static public final String PALESTINE_LINK = "/SbribCOVf2wgR868y";
        static public final String ITALY_LINK = "/UFpnR8mukiu0TSrb4";

        static public final String POLAND = "poland";
        static public final String LITHUANIA = "lithuania";
        static public final String SLOVENIA = "slovenia";
        static public final String PALESTINE = "palestine";
        static public final String ITALY = "italy";

        static public final String[] COUNTRIES = {POLAND, LITHUANIA, SLOVENIA, PALESTINE, ITALY};

        static public final String[] COUNTRIES_LINKS = {POLAND_LINK, LITHUANIA_LINK, SLOVENIA_LINK,
                PALESTINE_LINK, ITALY_LINK};

    }

    static public String getCountryLink(String country) {
        return COUNTRIES_LINKS[Arrays.asList(COUNTRIES).indexOf(country)];
    }

    static public Class<?> getCountryClass(String country) {
        switch (country) {
            case Constants.SLOVENIA:
                return Slovenia.class;
            case Constants.POLAND:
                return Poland.class;
            case Constants.LITHUANIA:
                return Lithuania.class;
            case Constants.PALESTINE:
                return Palestine.class;
            case Constants.ITALY:
                return Italy.class;
            default:
                throw new NoSuchElementException();
        }
    }

    public static CountryData getCountryData(String countryName, Country country) {
        CountryData countryData = new CountryData();
        countryData.setCountry(countryName);
        switch (countryName) {
            case Constants.SLOVENIA:
                countryData.setAllCases(((Slovenia) country).getInfectedCases());
                countryData.setNewCases(((Slovenia) country).getDailyInfected());
                break;
            case Constants.POLAND:
                countryData.setAllCases(((Poland) country).getInfected());
                countryData.setNewCases(((Poland) country).getDailyInfected());
                break;
            case Constants.LITHUANIA:
                countryData.setAllCases(((Lithuania) country).getInfected());
                countryData.setNewCases(((Lithuania) country).getNewCases());
                break;
            case Constants.PALESTINE:
                countryData.setAllCases(((Palestine) country).getInfected());
                countryData.setNewCases(((Palestine) country).getNewCases());
                break;
            case Constants.ITALY:
                countryData.setAllCases(((Italy) country).getTotalCases());
                countryData.setNewCases(((Italy) country).getNewPositive());
                break;
            default:
                throw new NoSuchElementException();
        }
        return countryData;
    }

}
