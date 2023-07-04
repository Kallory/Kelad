package springGame.Kelad;

import java.util.Random;

public class NameGenerator {
    private static String[] syllables = {
            "blo", "cru", "dwi", "fro", "gli", "hwo", "jik", "klon", "mnu", "pre",
            "quo", "rhi", "slo", "tri", "upo", "vwe", "xoo", "yip", "zwo",
            "ai", "ei", "oi", "au", "eu", "ou", "ie", "ae", "oe", "ua", "ia", "eo",
            "a", "e", "i", "o", "u",
            "ba", "be", "bi", "bo", "bu",
            "da", "de", "di", "do", "du",
            "ga", "ge", "gi", "go", "gu",
            "ka", "ke", "ki", "ko", "ku",
            "la", "le", "li", "lo", "lu",
            "ma", "me", "mi", "mo", "mu",
            "na", "ne", "ni", "no", "nu",
            "pa", "pe", "pi", "po", "pu",
            "ra", "re", "ri", "ro", "ru",
            "sa", "se", "si", "so", "su",
            "ta", "te", "ti", "to", "tu",
            "va", "ve", "vi", "vo", "vu",
            "za", "ze", "zi", "zo", "zu",
            "sta", "sto", "ste", "stu", "stra",
            "ble", "bra", "bri", "bro", "bru",
            "gle", "gla", "gli", "glo", "glu",
            "tre", "tra", "tri", "tro", "tru",
            "ple", "pla", "pli", "plo", "plu",
            "dre", "dra", "dri", "dro", "dru",
            "quo", "qua", "que", "qui", "quu",
            "bre", "bra", "bri", "bro", "bru",
            "spra", "spri", "spro", "spru", "spry",
            "stru", "stra", "stri", "stro", "stry",
            "blan", "blin", "blon", "blun", "blyn",
            "cran", "crin", "cron", "crun", "cryn",
            "dran", "drin", "dron", "drun", "dryn",
            "fran", "frin", "fron", "frun", "fryn",
            "gran", "grin", "gron", "grun", "gryn",
            "pran", "prin", "pron", "prun", "pryn",
            "stan", "stin", "ston", "stun", "styn",
            "tran", "trin", "tron", "trun", "tryn",
            "blanc", "blinc", "blonc", "blunc", "blync",
            "cranc", "crinc", "cronc", "crunc", "crync",
            "dranc", "drinc", "dronc", "drunc", "drync",
            "franc", "frinc", "fronc", "frunc", "frync",
            "granc", "grinc", "gronc", "grunc", "grync",
            "pranc", "princ", "pronc", "prunc", "prync",
            "stanc", "stinc", "stonc", "stunc", "stync",
            "tranc", "trinc", "tronc", "trunc", "trync"
    };
   private static Random random = new Random();

    public static String generateRandomName() {
        int syllableCount = 2 + random.nextInt(3);  // 2 to 4 syllables

        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < syllableCount; i++) {
            nameBuilder.append(syllables[random.nextInt(syllables.length)]);
        }

        // Capitalize first letter
        String name = nameBuilder.toString();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}