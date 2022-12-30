package api;

/**Κλάση Property που αναπαριστά ένα κατάλυμα. Για ένα κατάλυμα μασ ενδιαφέρουν επίσης το όνομα, ο τύπος, η τοποθεσία και μια μικρή περιγραφή
 */

public class Property {
    private String name,type,location,descr;

    /** Κατασκευαστής
     *
     * @param name το όνομα του καταλύματος
     * @param type τύπος του καταλύματος(Διαμέρισμα, Δωμάτιο Ξενοδοχείου, Μεζονέτα)
     * @param location η τοποθεσία του καταλύματος
     * @param descr περιγραφή καταλύματος
     */

    public Property(String name,String type,String location,String descr) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.descr = descr;
    }

    /**
     * @return το όνομα του καταλύματος
     */

    public String getName() {
        return name;
    }
    /**
     * @return τον τύπο του καταλύματος
     */

    public String getType() {
        return type;
    }
    /**
     * @return την τοποθεσία του καταλύματος
     */

    public String getLocation() {
        return location;
    }
    /**
     * @return την περιγραφή του καταλύματος
     */

    public String getDescr() {
        return descr;
    }

}
