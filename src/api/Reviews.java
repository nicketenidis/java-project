package api;

/**
 * Κλάση που αναπαρίστα μία αξιολόγηση ενός χρήστη
 */

public class Reviews {

    private String review;

    /**
     * Κατασκευαστής / Constructor
     * @param review η αξιολόγηση του χρήστη έως 500 χαρακτήρες
     */

    public Reviews (String review){
        this.review = review;
    }
    /**
     * @return την αξιολόγηση του χρήστη
     */

    public String getReview(){
        return review;
    }
}
