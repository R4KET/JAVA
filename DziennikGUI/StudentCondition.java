public enum StudentCondition {
    Refurb {
        @Override
        public String toString() {
            return "Odrabiajacy";
        }
    },
    Sick {
        @Override
        public String toString() {
            return "Chory";
        }
    },
    Absent {
        @Override
        public String toString() {
            return "Nieobecny";
        }
    };

    public static StudentCondition fromString(String name) {
        if (name.equals(StudentCondition.Refurb.toString())) {
            return Refurb;
        }
        if (name.equals(StudentCondition.Sick.toString())) {
            return Sick;
        }
        return Absent;
    }
}