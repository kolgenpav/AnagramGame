package com.toy.anagrams.lib;

/**
 * Class with arrays of unscrambled and scrambled words and the game logic method implantation.
 */
final class StaticWordLibrary implements AbstractWordLibrary {

    /**
     * Array with unscrambled words.
     */
    private static final String[] WORD_LIST = {
            "abstraction",
            "ambiguous",
            "arithmetic",
            "backslash",
            "bitmap",
            "circumstance",
            "combination",
            "consequently",
            "consortium",
            "decrementing",
            "dependency",
            "disambiguate",
            "dynamic",
            "encapsulation",
            "equivalent",
            "expression",
            "facilitate",
            "fragment",
            "hexadecimal",
            "implementation",
            "indistinguishable",
            "inheritance",
            "internet",
            "java",
            "localization",
            "microprocessor",
            "navigation",
            "optimization",
            "parameter",
            "patrick",
            "pickle",
            "polymorphic",
            "rigorously",
            "simultaneously",
            "specification",
            "structure",
            "lexical",
            "likewise",
            "management",
            "manipulate",
            "mathematics",
            "hotjava",
            "vertex",
            "unsigned",
            "traditional"};

    /**
     * Array with scrambled words.
     */
    private static final String[] SCRAMBLED_WORD_LIST = {
            "batsartcoin",
            "maibuguos",
            "ratimhteci",
            "abkclssha",
            "ibmtpa",
            "iccrmutsnaec",
            "ocbmnitaoni",
            "ocsnqeeutnyl",
            "ocsnroitmu",
            "edrcmeneitgn",
            "edepdnneyc",
            "idasbmgiauet",
            "ydanicm",
            "neacsplutaoni",
            "qeiuaveltn",
            "xerpseisno",
            "aficilatet",
            "rfgaemtn",
            "ehaxedicalm",
            "milpmeneatitno",
            "niidtsniugsiahleb",
            "niehiratcen",
            "nietnret",
            "ajav",
            "olacilazitno",
            "imrcpoorecssro",
            "anivagitno",
            "poitimazitno",
            "aparemert",
            "aprtcki",
            "ipkcel",
            "opylomprich",
            "irogorsuyl",
            "isumtlnaoesuyl",
            "psceficitaoni",
            "tsurtcreu",
            "elixalc",
            "ilekiwse",
            "amanegemtn",
            "aminupalet",
            "amhtmetacsi",
            "ohjtvaa",
            "evtrxe",
            "nuisngde",
            "rtdatioialn"
    };

    /**
     * Instance of the StaticWordLibrary class.
     */
    static final AbstractWordLibrary DEFAULT = new StaticWordLibrary();

    private StaticWordLibrary() {
    }

    public String getWord(final int idx) {
        return WORD_LIST[idx];
    }

    public String getScrambledWord(final int idx) {
        return SCRAMBLED_WORD_LIST[idx];
    }

    public int getSize() {
        return WORD_LIST.length;
    }

    public boolean isCorrect(final int idx, final String userGuess) {
        if (!userGuess.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Guess must contain only letters");
        }
        return userGuess.equals(getWord(idx));
    }
}
