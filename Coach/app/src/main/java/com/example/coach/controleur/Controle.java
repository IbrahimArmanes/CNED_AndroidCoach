package com.example.coach.controleur;

import com.example.coach.modele.Profil;

public final class Controle {
    private static Controle instance ;
    private static Profil profil ;
    private Controle() {
        super();
    }

    /**
     *
     * @return
     */
    public static final Controle getInstance(){
        if (Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * Création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme, 0 pour femme
     */
    public void creerProfil(Integer poids,Integer taille,Integer age,Integer sexe){
        profil = new Profil(poids, taille, age, sexe);

    }

    /**
     *
     * @return
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        return profil.getMessage();
    }
}
