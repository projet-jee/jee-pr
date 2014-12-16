package bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.User;



public class ConnectionForm{
	private static final String CHAMP_EMAIL  = "mail";
    private static final String CHAMP_PASS   = "password";
    private static final String USER   = "username";
    private static final String AGE   = "age";

    
    
    
    public String VUE   = "";
    private String resultat;
    
    private Map<String, String> erreurs= new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    
    
    
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    
    public User connecterUtilisateur( HttpServletRequest request ) {
    	
    	
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        User utilisateur = new User();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        
        
        utilisateur.setMail( email );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setPassword( motDePasse );

        
        
        
        
        
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
            VUE="/WEB-INF/home.jsp";
        } else {
            resultat = "Échec de la connexion.";
            VUE="/WEB-INF/conx.jsp";
        }

        
        
        
        
        /*retourne l'utilisateur */
        return utilisateur;
    }

}
