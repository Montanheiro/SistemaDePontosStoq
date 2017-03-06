package model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author lucas
 */
public class Token {
    
    public String Gerate(String issuer, String subject, int hours) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        
        //Hours to milliseconds
        long ttlMillis = hours * 3600000;
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Parameters.TOKENKEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setIssuedAt(now)
                                    .setSubject(subject)
                                    .setIssuer(issuer)
                                    .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
        long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
    
    //Sample method to validate and read the JWT
    public boolean Verify(String jwt, String type) throws Exception {
        
        try{
            Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Parameters.TOKENKEY))
                .parseClaimsJws(jwt).getBody();
            
            return claims.getIssuer().equals(type);
            
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException 
                | UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
