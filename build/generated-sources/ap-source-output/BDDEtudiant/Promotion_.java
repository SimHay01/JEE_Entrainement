package BDDEtudiant;

import BDDEtudiant.Etudiant;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-20T16:44:04")
@StaticMetamodel(Promotion.class)
public class Promotion_ { 

    public static volatile SingularAttribute<Promotion, String> nomPromo;
    public static volatile SingularAttribute<Promotion, String> filiere;
    public static volatile SingularAttribute<Promotion, Integer> idPromo;
    public static volatile CollectionAttribute<Promotion, Etudiant> etudiantCollection;

}