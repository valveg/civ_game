package view;
/**
 * This is an enum class that represents all the
 * Civilizations that the user may chose from
 */
public enum CivEnum {

    ANCIENT_EGYPT {
        @Override
        public String toString() {
            return "Ancient Egypt";
        }
    },
    QIN_DYNASTY {
        @Override
        public String toString() {
            return "Qin Dynasty";
        }
    },
    ROMAN_EMPIRE {
        @Override
        public String toString() {
            return "Roman Empire";
        }
    },
    PERSIAN_EMPIRE {
        @Override
        public String toString() {
            return "Persian Empire";
        }
    },
    INCAN_EMPIRE {
        @Override
        public String toString() {
            return "Incan Empire";
        }
    },
    MONGOL_EMPIRE {
        @Override
        public String toString() {
            return "Mongol Empire";
        }
    }

}