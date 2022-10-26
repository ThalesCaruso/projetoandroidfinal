package com.example.projetoandroidfinal.view.UML.uniritter.presenter;

public class PerfilPresenter implements PresenterContract.presenterPerfil{
    private final String tagLog = "PerfilPresenter";

    private PresenterContract.view view;
    public PerfilPresenter(PresenterContract.view view) { this.view = view; }

}
