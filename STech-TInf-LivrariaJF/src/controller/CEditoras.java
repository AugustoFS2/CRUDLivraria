/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author jairb
 */
public class CEditoras {

    ArrayList<Editora> editora = new ArrayList<>();
    int idEdit = 1;

    public void mokEditoras() {
        Editora ed = new Editora();
        ed.setIdEditora(this.addIdEdit());
        ed.setNomeEditora("Senac");
        ed.setEndereco("Venancio Aires");
        ed.setTelefone("51 44223322");
        ed.setGerente("Visotto");
        this.addEditora(ed);
        Editora ed2 = new Editora();
        ed2.setIdEditora(this.addIdEdit());
        ed2.setNomeEditora("Abril");
        ed2.setEndereco("São Paulo");
        ed2.setTelefone("11 33443344");
        ed2.setGerente("Abreu");
        this.addEditora(ed2);
    }

    public int addIdEdit() {
        return this.idEdit++;
    }

    public void addEditora(Editora e) {
        this.editora.add(e);
    }

    public ArrayList<Editora> getEditora() {
        return editora;
    }

    public Boolean verificaEditora(int idEditora) {
        Boolean verEditora = false;
        for (Editora ed : editora) {
            if (ed.getIdEditora() == idEditora) {
                verEditora = true;
                System.out.println("Editora: " + ed.getNomeEditora());
            }
        }
        return verEditora;
    }
    
    public String getNomeEditora(int idEditora) {
        String nome = "";
        for (Editora ed : editora) {
            if (ed.getIdEditora() == idEditora) {
                nome = ed.getNomeEditora();
                System.out.println("Editora: " + ed.getNomeEditora());
            }
        }
        return nome;
    }

    public int getIdEditora(String nome) {
        int idEditora = 0;
        for (Editora ed : editora) {
            if (ed.getNomeEditora().equals(nome)) {
                idEditora = ed.getIdEditora();
                System.out.println("Editora: " + ed.getNomeEditora());
            }
        }
        return idEditora;
    }
}
