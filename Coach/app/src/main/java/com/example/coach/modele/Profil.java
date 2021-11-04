package com.example.coach.modele;

public class Profil {
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe; // 0 homme et 1 femme
    private float img;
    private String message;

    private static final Integer minFemme = 15; // maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer minHomme = 10; // maigre si en dessous
    private static final Integer maxHomme = 25; // gros si au dessus

    /**
     *
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }





    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    /**
     *
     */
    private void calculIMG(){
        float tailleEnMetres = (float)(this.taille) / 100;
        if (this.sexe == 0){          // cas femme
            //int S=0;
            this.img = (float)((1.2 * this.poids / (tailleEnMetres* tailleEnMetres)) + (0.23 * this.age) - (10.83 * 0) - 5.4) ;

        }
        else{                   // cas homme
            //int S=1;
            this.img = (float)((1.2 * this.poids / (tailleEnMetres* tailleEnMetres)) + (0.23 * this.age) - (10.83 * 1) - 5.4) ;
        }
    }

    /**
     *
     */
    private void resultIMG(){
        if(this.sexe == 0){          // cas femme
            if (this.img < minFemme){
                this.message = "trop faible";
            }
            else if (this.img <maxFemme){
                this.message = "normal";
            }
            else{
                this.message = "trop élevé";
            }
        }
        else{                   // cas homme
            if (this.img < minHomme){
                this.message = "trop faible";
            }
            else if (this.img <maxHomme){
                this.message = "normal";
            }
            else{
                this.message = "trop élevé";
            }
        }
    }

}
